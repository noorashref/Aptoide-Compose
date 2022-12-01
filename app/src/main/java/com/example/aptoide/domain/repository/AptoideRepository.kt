package com.example.aptoide.domain.repository

import com.example.aptoide.data.remote.dto.AppListResponse
import com.example.aptoide.data.responses.AppListResponseDto


interface AptoideRepository {

        suspend fun getAppList() :  AppListResponseDto

}