package com.example.aptoide.domain.use_case


import com.example.aptoide.data.responses.AppListResponses
import com.example.aptoide.domain.repository.AptoideRepository
import com.example.aptoide.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

private const val TAG = "AptoideUseCase"

class AptoideUseCase @Inject constructor(
    private val repository: AptoideRepository
) {

    operator fun invoke(): Flow<Resource<List<AppListResponses>>> = flow {
        try {
            emit(Resource.Loading())
            val appList =
                repository.getAppList().responses.listApps.datasets.all.data.list.map { it }
            //Log.d(TAG, "aaaaaaaaaaa: ${appList.size} ")
            emit(Resource.Success(appList))
        } catch (e: HttpException) {
            emit(
                Resource.Error<List<AppListResponses>>(
                    e.localizedMessage ?: "An unexpected error occured"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<List<AppListResponses>>("Couldn't reach server. Check your internet connection."))
        }
    }
}