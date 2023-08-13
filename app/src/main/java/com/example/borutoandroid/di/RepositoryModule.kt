package com.example.borutoandroid.di

import android.content.Context
import com.example.borutoandroid.domain.repository.DataStoreOperations
import com.example.borutoandroid.data.repository.DataStoreOperationsImpl
import com.example.borutoandroid.data.repository.Repository
import com.example.borutoandroid.domain.use_cases.UseCases
import com.example.borutoandroid.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.example.borutoandroid.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun providePreferenceDataStore(
        @ApplicationContext context: Context
    ): DataStoreOperations {
        return DataStoreOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository)
        )
    }

}