package com.example.aptoide.data.responses


import com.google.gson.annotations.SerializedName

data class Datasets(
    @SerializedName("all")
    val all: All
)