package com.example.borutoandroid.domain.use_cases

import com.example.borutoandroid.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.example.borutoandroid.domain.use_cases.save_onboarding.SaveOnBoardingUseCase

/**
 * What is Use case?
 * - Use case is an of interaction of user with the application
 *
 * Application wide Use cases container.
 *
 */
data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase
)
