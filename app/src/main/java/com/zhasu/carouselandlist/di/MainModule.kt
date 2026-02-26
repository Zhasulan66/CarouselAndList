package com.zhasu.carouselandlist.di

import com.zhasu.carouselandlist.data.repository.FruitRepositoryImpl
import com.zhasu.carouselandlist.domain.repository.FruitRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    fun provideFruitRepository(): FruitRepository {
        return FruitRepositoryImpl()
    }
}