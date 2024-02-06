package com.example.data

import com.example.data.source.GithubRemoteSource
import com.example.domain.model.GithubRepo
import com.example.domain.repository.GithubRepository
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val githubRemoteSource: GithubRemoteSource
) : GithubRepository {

    override suspend fun getRepos(owner: String): List<GithubRepo> {
        return githubRemoteSource.getRepos(owner)
    }
}