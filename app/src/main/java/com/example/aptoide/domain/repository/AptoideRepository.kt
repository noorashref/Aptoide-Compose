package com.example.aptoide.domain.repository

import com.example.aptoide.data.remote.dto.AppListResponse
import com.example.aptoide.data.responses.AppListResponseDto
import com.example.aptoide.data.responses.AppListResponses


interface AptoideRepository {
        suspend fun getAppList() :  AppListResponseDto

}