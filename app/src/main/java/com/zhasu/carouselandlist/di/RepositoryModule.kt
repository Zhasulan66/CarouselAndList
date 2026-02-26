package com.zhasu.carouselandlist.di

import com.zhasu.carouselandlist.data.repository.FruitRepositoryImpl
import com.zhasu.carouselandlist.domain.repository.FruitRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindNatureRepository(
        fruitRepositoryImpl: FruitRepositoryImpl
    ): FruitRepository
}