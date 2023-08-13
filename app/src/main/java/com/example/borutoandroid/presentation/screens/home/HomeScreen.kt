package com.example.borutoandroid.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun HomeScreen() {

    Scaffold(
        topBar = {
            HomeTopAppBar(onSearchClicked = {})
        }
    ) {
    }

}