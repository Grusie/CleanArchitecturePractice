package com.example.domain.repository

import com.example.domain.model.GithubRepo

interface GithubRepository {
    suspend fun getRepos(owner: String): List<GithubRepo>
}