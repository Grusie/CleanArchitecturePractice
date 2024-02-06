package com.example.cleanarchitecturepractice.di

import com.example.data.source.GithubRemoteSource
import com.example.data.source.GithubRemoteSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Singleton
    @Provides
    fun providesGithubRemoteSource(source: GithubRemoteSourceImpl): GithubRemoteSource {
        return source
    }
}