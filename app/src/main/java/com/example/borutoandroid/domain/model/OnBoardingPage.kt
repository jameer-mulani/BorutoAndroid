package com.example.borutoandroid.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.borutoandroid.R

sealed class OnBoardingPage(
    @DrawableRes
    val imageRes: Int,
    @StringRes
    val titleRes: Int,
    @StringRes
    val descRes: Int
) {

    object First : OnBoardingPage(
        R.drawable.greetings,
        R.string.onboarding_greetings,
        R.string.onboarding_greeting_desc
    )

    object Second : OnBoardingPage(
        R.drawable.explore,
        R.string.onboarding_explore,
        R.string.onboarding_explore_desc
    )

    object Third : OnBoardingPage(
        R.drawable.power,
        R.string.onboarding_power,
        R.string.onboarding_power_desc
    )

}
