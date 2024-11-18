package com.app.abc.di

import com.app.abc.data.repository.NewsRepository
import com.app.abc.data.repository.NewsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun providesNewsRepository(newsRepository:NewsRepositoryImpl) : NewsRepository

}