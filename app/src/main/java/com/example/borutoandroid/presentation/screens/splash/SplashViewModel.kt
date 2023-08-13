package com.example.borutoandroid.presentation.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.borutoandroid.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    private val _onBoardingStateFlow : MutableStateFlow<Boolean> = MutableStateFlow(false)
    val onBoardingStateCompleted : StateFlow<Boolean> = _onBoardingStateFlow

    init {
        viewModelScope.launch(Dispatchers.IO){
            _onBoardingStateFlow.value =
                useCases.readOnBoardingUseCase().stateIn(viewModelScope).value
        }
    }


}