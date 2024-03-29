package com.example.aptoide.data


import com.example.aptoide.data.responses.AppListResponseDto
import retrofit2.Response
import retrofit2.http.GET
interface AptoideApi {

    @GET("api/6/bulkRequest/api_list/listApps")
    suspend fun getAppList() : AppListResponseDto

    //http://ws2.aptoide.com/api/6/bulkRequest/api_list/listApps
}