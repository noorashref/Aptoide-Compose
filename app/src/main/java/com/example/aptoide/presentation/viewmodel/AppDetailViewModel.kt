package com.example.aptoide.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aptoide.domain.use_case.AptoideUseCase
import com.example.aptoide.presentation.state.AppListState
import com.example.aptoide.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AppDetailViewModel @Inject constructor(
    private val appListUseCase: AptoideUseCase
) : ViewModel() {


    private val _state = mutableStateOf(AppListState())
    val state: State<AppListState> = _state

    init {
        getAppList()
    }

    private fun getAppList() {
        appListUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = AppListState(appListing = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = AppListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = AppListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)

    }
}