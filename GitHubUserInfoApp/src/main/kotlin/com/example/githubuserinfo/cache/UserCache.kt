package com.example.githubuserinfo.cache

import com.example.githubuserinfo.model.GitHubUser

class UserCache {
    private val cache: MutableMap<String, GitHubUser> = mutableMapOf()

    fun addUser(user: GitHubUser) {
        cache[user.username] = user
    }

    fun getUser(username: String): GitHubUser? {
        return cache[username]
    }

    fun getAllUsers(): List<GitHubUser> {
        return cache.values.toList()
    }

    fun searchUser(username: String): GitHubUser? {
        return cache[username]
    }

    fun searchRepository(repoName: String): Map<String, List<String>> {
        val result = mutableMapOf<String, List<String>>()
        for (user in cache.values) {
            val matchingRepos = user.repositories.filter {
                it.name.contains(repoName, ignoreCase = true)
            }
            if (matchingRepos.isNotEmpty()) {
                result[user.username] = matchingRepos.map { it.name }
            }
        }
        return result
    }
}
