package com.example.githubuserinfo.model

data class GitHubUser(
    val username: String,
    val followers: Int,
    val following: Int,
    val createdAt: String,
    val repositories: List<Repository>
)
