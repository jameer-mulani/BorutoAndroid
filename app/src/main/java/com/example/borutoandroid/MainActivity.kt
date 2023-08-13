package com.example.borutoandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.borutoandroid.ui.theme.BorutoAndroidTheme

class MainActivity : ComponentActivity() {


    private lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BorutoAndroidTheme {
                navHostController = rememberNavController()


            }
        }
    }
}

