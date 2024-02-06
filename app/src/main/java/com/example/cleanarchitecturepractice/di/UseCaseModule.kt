package com.example.cleanarchitecturepractice.di

import com.example.domain.repository.GithubRepository
import com.example.domain.usecase.GetGithubReposUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun providesGetGithubReposUseCase(repository: GithubRepository) : GetGithubReposUseCase {
        return GetGithubReposUseCase(repository)
    }
}