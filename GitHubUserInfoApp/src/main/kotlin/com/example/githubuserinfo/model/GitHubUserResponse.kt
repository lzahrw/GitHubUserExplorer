package com.example.githubuserinfo.model

import com.google.gson.annotations.SerializedName

data class GitHubUserResponse(
    @SerializedName("login") val login: String,
    @SerializedName("followers") val followers: Int,
    @SerializedName("following") val following: Int,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("repos_url") val reposUrl: String
)
