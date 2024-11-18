package com.app.abc.presentation.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.abc.R


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CarouselWithIndicator(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    pagerContent: @Composable (Int) -> Unit
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Carousel(pagerState, pagerContent)
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dp_10)))
        PageIndicator(pagerState.pageCount, pagerState.currentPage)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Carousel(pagerState: PagerState, pagerContent: @Composable (Int) -> Unit) {
    HorizontalPager(state = pagerState) {
        pagerContent(it)
    }
}

@Composable
fun PageIndicator(pageCount: Int, currentPage: Int, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(vertical = dimensionResource(R.dimen.dp_10))
    ) {
        repeat(pageCount) {
            IndicatorDots(isSelected = it == currentPage, modifier = modifier)
        }
    }
}

@Composable
fun IndicatorDots(isSelected: Boolean, modifier: Modifier = Modifier) {
    val size = animateDpAsState(
        targetValue = if (isSelected) dimensionResource(id = R.dimen.dp_12) else dimensionResource(
            id = R.dimen.dp_10
        ),
        label = "Indicator Animation"
    )
    Box(
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.dp_2))
            .size(size.value)
            .clip(CircleShape)
            .background(
                if (isSelected) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.secondary.copy(
                    alpha = 0.3F
                )
            )
    )
}

@Preview
@Composable
private fun SelectedIndicatorPreview() {
    IndicatorDots(true)
}

@Preview
@Composable
private fun UnSelectedIndicatorPreview() {
    IndicatorDots(false)
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewPageIndicator() {
    PageIndicator(
        pageCount = 4,
        currentPage = 2
    )
}