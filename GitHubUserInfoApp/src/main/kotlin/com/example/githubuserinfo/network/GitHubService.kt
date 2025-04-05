package com.example.githubuserinfo.network

import com.example.githubuserinfo.model.GitHubUserResponse
import com.example.githubuserinfo.model.Repository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("users/{username}")
    fun getUser(@Path("username") username: String): Call<GitHubUserResponse>

    @GET("users/{username}/repos")
    fun getRepos(@Path("username") username: String): Call<List<Repository>>
}
