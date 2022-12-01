package com.example.aptoide.presentation.state

import com.example.aptoide.data.responses.AppListResponses
import com.example.aptoide.domain.model.AppListModel

data class AppListState(
    val isLoading: Boolean = false,
    val appListing: List<AppListResponses> = emptyList(),
    val error: String = ""
)
