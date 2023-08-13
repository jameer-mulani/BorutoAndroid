package com.example.borutoandroid.presentation.screens.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.example.borutoandroid.R
import com.example.borutoandroid.domain.model.OnBoardingPage
import com.example.borutoandroid.ui.theme.EXTRA_LARGE_PADDING
import com.example.borutoandroid.ui.theme.LARGE_PADDING
import com.example.borutoandroid.ui.theme.PAGER_INDICATOR_SIZE
import com.example.borutoandroid.ui.theme.PAGER_INDICATOR_SPACING
import com.example.borutoandroid.util.Constants
import com.example.todoappstefan2023.ui.theme.buttonBackgroundColor
import com.example.todoappstefan2023.ui.theme.descriptionColor
import com.example.todoappstefan2023.ui.theme.onBoardingScreenBackgroundColor
import com.example.todoappstefan2023.ui.theme.pagerIndicatorActiveColor
import com.example.todoappstefan2023.ui.theme.pagerIndicatorInActiveColor
import com.example.todoappstefan2023.ui.theme.titleColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(navHostController: NavHostController) {

    val pages = listOf(OnBoardingPage.First, OnBoardingPage.Second, OnBoardingPage.Third)

    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.onBoardingScreenBackgroundColor)
    ) {

        HorizontalPager(
            modifier = Modifier.weight(8f),
            count = Constants.ONBOARDING_PAGE_COUNT, state = pagerState
        ) { pageIndex ->
            OnBoardingPagerScreen(onBoardingPage = pages[pageIndex])
        }

        HorizontalPagerIndicator(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            pagerState = pagerState,
            activeColor = MaterialTheme.colors.pagerIndicatorActiveColor,
            inactiveColor = MaterialTheme.colors.pagerIndicatorInActiveColor,
            spacing = PAGER_INDICATOR_SPACING,
            indicatorHeight = PAGER_INDICATOR_SIZE,
            indicatorWidth = PAGER_INDICATOR_SIZE
        )

        FinishButton(
            modifier = Modifier.weight(1f), pagerState = pagerState
        ) {

        }

    }
}

@Composable
fun OnBoardingPagerScreen(onBoardingPage: OnBoardingPage) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.6f),
            painter = painterResource(id = onBoardingPage.imageRes),
            contentDescription = stringResource(R.string.onboarding_image)
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = onBoardingPage.titleRes),
            style = TextStyle(
                color = MaterialTheme.colors.titleColor,
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.h4.fontSize,
                textAlign = TextAlign.Center
            )
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = EXTRA_LARGE_PADDING)
                .padding(top = LARGE_PADDING),
            text = stringResource(id = onBoardingPage.descRes), style = TextStyle(
                color = MaterialTheme.colors.descriptionColor,
                fontWeight = FontWeight.Medium,
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                textAlign = TextAlign.Center
            )
        )
    }

}

@OptIn(ExperimentalPagerApi::class, ExperimentalAnimationApi::class)
@Composable
fun FinishButton(
    modifier: Modifier,
    pagerState: PagerState,
    onClick: () -> Unit
) {

    Row(
        modifier = modifier.padding(horizontal = EXTRA_LARGE_PADDING),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == Constants.ONBOARDING_PAGE_COUNT - 1
        ) {
            Button(onClick = onClick, colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.buttonBackgroundColor,
                contentColor = Color.White,
            )) {
                Text(text = stringResource(R.string.finish))
            }
        }
    }


}