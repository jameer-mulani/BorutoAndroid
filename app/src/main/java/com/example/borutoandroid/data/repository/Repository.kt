package com.example.borutoandroid.data.repository

import com.example.borutoandroid.domain.repository.DataStoreOperations
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Application Repository
 */
class Repository @Inject constructor(private val dataStoreOperations: DataStoreOperations) {

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStoreOperations.setOnBoardingState(completed = completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStoreOperations.getOnboardingState()
    }

}