package com.priesniakov.featureapod.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.priesniakov.core.network.Resource
import com.priesniakov.data.model.Astronomy
import com.priesniakov.domain.usecase.GetApodUseCase
import com.priesniakov.domain.usecase.UpdateApodUseCase
import com.priesniakov.featureapod.state.ApodState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ApodViewModel @Inject constructor(
    private val getApodUseCase: GetApodUseCase,
    private val updateApodUseCase: UpdateApodUseCase

) : ViewModel() {
    private val _state = mutableStateOf(ApodState())
    val state: State<ApodState> = _state

    fun getAstronomyData() = getApodUseCase().onEach { updateUiState(it) }.launchIn(viewModelScope)

    fun updateAstronomyData() =
        updateApodUseCase().onEach { updateUiState(it) }.launchIn(viewModelScope)

    private fun updateUiState(result: Resource<List<Astronomy>>) {
        _state.value = when (result) {
            Resource.Loading -> ApodState(isLoading = true)
            is Resource.Error -> ApodState(error = result.message)
            is Resource.Success -> ApodState(data = result.data)
            Resource.Idle -> ApodState()
        }
    }
}