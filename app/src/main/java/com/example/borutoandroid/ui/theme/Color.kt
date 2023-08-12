package com.example.todoappstefan2023.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700   = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val LightGray = Color(0xFFFCFCFC)
val MediumGray = Color(0xFF9C9C9C)
val DarkGray = Color(0xFF141414)

val highPriorityColor = Color(0xFF85092C)
val lowPriorityColor = Color(0xF34BDD3A)
val mediumPriorityColor = Color(0xFFFFC300)
val nonePriorityColor = Color(0xFF2F352E)

val Colors.topAppBarContentColor: Color
    @Composable
    get() = if (isLight) Color.White else LightGray

val Colors.topAppBarBackgroundColor: Color
    @Composable
    get() = if (isLight) Purple500 else Color.Black

val Colors.fabBackgroundColor : Color
    @Composable
    get() = if (isLight) Teal200 else Purple700

val Colors.todoItemBackgroundColor : Color
    @Composable
    get() = if (isLight) Color.White else Color.DarkGray

val Colors.todoTitleColor : Color
    @Composable
    get() = if (isLight) Color.DarkGray else LightGray


val Colors.todoDescColor : Color
    @Composable
    get() = if (isLight) DarkGray else LightGray