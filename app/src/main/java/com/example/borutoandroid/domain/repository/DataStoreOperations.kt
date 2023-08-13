package com.example.borutoandroid.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreOperations {

    suspend fun setOnBoardingState(completed : Boolean)

    fun getOnboardingState() : Flow<Boolean>

}