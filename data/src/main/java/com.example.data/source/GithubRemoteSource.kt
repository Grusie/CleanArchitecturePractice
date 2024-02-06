package com.example.data.source

import com.example.data.model.GithubRepoRes
import com.example.data.service.GithubService
import javax.inject.Inject

interface GithubRemoteSource {
    suspend fun getRepos(owner: String): List<GithubRepoRes>
}

class GithubRemoteSourceImpl @Inject constructor(
    private val githubService: GithubService
) : GithubRemoteSource {

    override suspend fun getRepos(owner: String): List<GithubRepoRes> {
        return githubService.getRepos(owner)
    }
}