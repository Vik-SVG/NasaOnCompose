package com.priesniakov.featureapod.state

import com.priesniakov.data.model.Astronomy

data class ApodState(
    val isLoading: Boolean = false,
    val data: List<Astronomy> = emptyList(),
    val error: String = "",
    val isLoaded: Boolean = !isLoading && error.isBlank()
)