package com.example.githubuserinfo.model

import com.google.gson.annotations.SerializedName

data class Repository(
    @SerializedName("name") val name: String
)
