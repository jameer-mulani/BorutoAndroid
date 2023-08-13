package com.example.borutoandroid.domain.use_cases.read_onboarding

import com.example.borutoandroid.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(private val repository: Repository) {

    //operator fun so that we can directly call this with () syntax on class variable

     operator fun invoke() : Flow<Boolean>{
        return repository.readOnBoardingState()
    }

}