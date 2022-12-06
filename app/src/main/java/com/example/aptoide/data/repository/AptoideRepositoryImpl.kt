package com.example.aptoide.data.repository

import com.example.aptoide.data.AptoideApi
import com.example.aptoide.data.remote.dto.AppListResponse
import com.example.aptoide.data.responses.AppListResponseDto
import com.example.aptoide.data.responses.AppListResponses
import com.example.aptoide.domain.repository.AptoideRepository
import retrofit2.Response
import javax.inject.Inject

class AptoideRepositoryImpl @Inject constructor(
    private val api: AptoideApi
) : AptoideRepository {


    override suspend fun getAppList():   AppListResponseDto {
        return api.getAppList()
    }

}