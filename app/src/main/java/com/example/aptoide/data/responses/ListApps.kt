package com.example.aptoide.data.responses


import com.google.gson.annotations.SerializedName

data class ListApps(
    @SerializedName("datasets")
    val datasets: Datasets,
    @SerializedName("info")
    val info: InfoX
)