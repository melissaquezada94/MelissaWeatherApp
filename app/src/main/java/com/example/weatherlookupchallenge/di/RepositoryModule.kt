package com.example.weatherlookupchallenge.di

import com.example.weatherlookupchallenge.data.repository.RepositoryImpl
import com.example.weatherlookupchallenge.domain.RepositoryForecast
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindRepositoryForecast(repositoryImpl: RepositoryImpl): RepositoryForecast
}