package com.example.borutoandroid.presentation.screens.home

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.example.borutoandroid.R
import com.example.todoappstefan2023.ui.theme.topAppBarBackgroundColor
import com.example.todoappstefan2023.ui.theme.topAppBarContentColor

@Composable
fun HomeTopAppBar(
    onSearchClicked: () -> Unit
) {

    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.onboarding_explore), style = TextStyle(
                    color = MaterialTheme.colors.topAppBarContentColor,
                )
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            IconButton(onClick = onSearchClicked) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search_icon)
                )
            }
        }
    )


}