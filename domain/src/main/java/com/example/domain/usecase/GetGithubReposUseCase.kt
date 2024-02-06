package com.example.domain.usecase

import com.example.domain.model.GithubRepo
import com.example.domain.repository.GithubRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class GetGithubReposUseCase(private val githubRepository: GithubRepository) {

    operator fun invoke(
        owner: String,
        scope: CoroutineScope,
        onResult: (List<GithubRepo>) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                githubRepository.getRepos(owner)
            }
            onResult(deferred.await())
        }
    }
}