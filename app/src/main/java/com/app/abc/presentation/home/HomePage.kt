package com.app.abc.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.abc.R
import com.app.abc.presentation.HomeViewModel
import com.app.abc.presentation.components.CarouselWithIndicator
import com.app.abc.presentation.home.components.CarouselItem
import com.app.abc.presentation.home.components.NewsArticleItem
import com.app.abc.presentation.home.components.NoItemFound
import com.app.abc.presentation.home.components.SearchBox


@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomePage(viewModel: HomeViewModel = hiltViewModel()) {

    val searchQuery by viewModel.searchQuery.collectAsState()
    val newList by viewModel.newsList.collectAsState()
    val carouselData = viewModel.getCarouselData
    val charAnalysis by viewModel.charAnalysis.collectAsState()
    val showBottomSheet by viewModel.bottomSheetState.collectAsState()

    val pagerState = rememberPagerState { carouselData.size }
    val bottomSheetState = rememberModalBottomSheetState()

    val focusManager = LocalFocusManager.current


    LaunchedEffect(key1 = pagerState.currentPage, key2 = pagerState.pageCount) {
        focusManager.clearFocus()
        viewModel.carouselChanged(pagerState.currentPage)
    }

    Scaffold(
        topBar = {
                 TopAppBar(title = {
                     Text(
                         text = stringResource(id = R.string.app_name),
                         fontWeight = FontWeight.SemiBold,
                         fontSize = 24.sp,
                         textAlign = TextAlign.Center, modifier = Modifier
                             .fillMaxWidth()
                             .padding(vertical = 10.dp)
                     )
                 })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                            viewModel.getAnalysisOccurrence()
                            viewModel.bottomSheetState(true)
                          },
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.onSecondary
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_circle_up_24),
                    contentDescription = stringResource(id = R.string.analysis)
                )
            }
        }) { inset ->
        LazyColumn(
            modifier = Modifier
                .padding(inset)
                .padding(top = dimensionResource(id = R.dimen.dp_10))
                .fillMaxSize()
        ) {
            item {
                CarouselWithIndicator(pagerState = pagerState) { index ->
                    CarouselItem(
                        resource = carouselData[index].imageRes,
                        description = carouselData[index].name
                    )
                }
            }
            stickyHeader {
                SearchBox(modifier = Modifier
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(
                        horizontal = dimensionResource(id = R.dimen.dp_20),
                        vertical = dimensionResource(id = R.dimen.dp_10),
                    ),
                    value = searchQuery,
                    onValueChange = viewModel::onQueryChanged,
                    onSearch = {
                        focusManager.clearFocus()
                        viewModel.onQueryChanged(searchQuery)
                    })
            }
            //TODO keys
            itemsIndexed(newList?.articles ?: emptyList(),
                key = {_,k->
                    k.title
                }) { _, item ->
                NewsArticleItem(
                    modifier = Modifier
                        .padding(
                            start = dimensionResource(id = R.dimen.dp_20),
                            end = dimensionResource(id = R.dimen.dp_20),
                            top = dimensionResource(id = R.dimen.dp_5)
                        )
                        .fillMaxWidth(),
                    data = item
                )
            }
            item {
                if (newList?.articles.isNullOrEmpty()) {
                    NoItemFound(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                vertical = dimensionResource(
                                    id = R.dimen.dp_30
                                ),
                            )
                    )
                }
            }
        }
    }
    if (showBottomSheet) {
        AnalysisBottomSheet(
            data = charAnalysis,
            bottomSheetState = bottomSheetState,
            onDismiss = {
                viewModel.bottomSheetState(false)
            },
        )
    }
}




