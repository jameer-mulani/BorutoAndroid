package com.example.borutoandroid.domain.use_cases.save_onboarding

import com.example.borutoandroid.data.repository.Repository

class SaveOnBoardingUseCase(private val repository: Repository) {
    suspend operator fun invoke(completed : Boolean){
        repository.saveOnBoardingState(completed = completed)
    }

}