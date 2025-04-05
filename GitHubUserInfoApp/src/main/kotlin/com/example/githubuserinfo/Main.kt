package com.example.githubuserinfo

import com.example.githubuserinfo.cache.UserCache
import com.example.githubuserinfo.network.GitHubService
import com.example.githubuserinfo.ui.Menu
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun main() {
    // Initialize Retrofit with GitHub API base URL and Gson converter
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Create an instance of the GitHub service interface
    val gitHubService = retrofit.create(GitHubService::class.java)

    // Initialize the in-memory cache
    val userCache = UserCache()

    // Start the menu-driven interface, passing in the service and cache
    Menu(gitHubService, userCache).start()
}
