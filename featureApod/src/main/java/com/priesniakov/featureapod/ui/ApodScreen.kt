package com.priesniakov.featureapod.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.priesniakov.featureapod.viewmodel.ApodViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ApodComposableScreen(
    viewModel: ApodViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = STATIC_KEY) {
        viewModel.getAstronomyData()
    }
    val state by viewModel.state
    var isRefreshing by remember { mutableStateOf(true) }

    val pullRefreshState =
        rememberPullRefreshState(isRefreshing, { viewModel.updateAstronomyData() })
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding()
            .pullRefresh(pullRefreshState)
            .verticalScroll(rememberScrollState())
    ) {
        if (state.isLoaded) {
            AsyncImage(
                contentDescription = "",
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(state.data.firstOrNull()?.astronomyImage)
                    .build(),
                modifier = Modifier.size(64.dp),
                imageLoader = ImageLoader.Builder(LocalContext.current).build()
            )
        }

        PullRefreshIndicator(
            refreshing = viewModel.state.value.isLoading,
            state = pullRefreshState,
            modifier = Modifier.align(Alignment.TopCenter),
            backgroundColor = if (viewModel.state.value.isLoading) Color.Red else Color.Green,
        )
    }
    if (state.error.isNotEmpty()) ShowError(error = state.error)
    isRefreshing = state.isLoading
}

@Composable
fun ShowError(error: String?) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text(
            text = error ?: "Unknown Error",
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
    }
}

private const val STATIC_KEY = "STATIC_KEY"