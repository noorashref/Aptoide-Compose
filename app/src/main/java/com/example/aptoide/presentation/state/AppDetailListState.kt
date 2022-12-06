package com.example.aptoide.presentation.state

import com.example.aptoide.data.responses.AppListResponses
import com.example.aptoide.domain.model.AppListModel

data class AppDetailListState(
    val isLoading: Boolean = false,
    val appListing: AppListResponses? = null,
    val error: String = ""
)
