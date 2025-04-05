package com.example.githubuserinfo.ui

import com.example.githubuserinfo.cache.UserCache
import com.example.githubuserinfo.model.GitHubUser
import com.example.githubuserinfo.model.GitHubUserResponse
import com.example.githubuserinfo.network.GitHubService
import retrofit2.Call
import retrofit2.Response
import java.util.Scanner

class Menu(
    private val gitHubService: GitHubService,
    private val userCache: UserCache
) {
    private val scanner = Scanner(System.`in`)

    fun start() {
        var exit = false
        while (!exit) {
            println("\n--- GitHub User Information ---")
            println("1. Retrieve user information by username")
            println("2. Display the list of users in memory")
            println("3. Search by username among users in memory")
            println("4. Search by repository name among data in memory")
            println("5. Exit")
            print("Enter your choice: ")

            when (scanner.nextLine().trim()) {
                "1" -> retrieveUserInformation()
                "2" -> displayCachedUsers()
                "3" -> searchByUsername()
                "4" -> searchByRepository()
                "5" -> {
                    println("Exiting program. Goodbye!")
                    exit = true
                }
                else -> println("Invalid option. Please try again.")
            }
        }
    }

    private fun retrieveUserInformation() {
        print("Enter GitHub username: ")
        val username = scanner.nextLine().trim()

        // Check if user is already cached
        val cachedUser = userCache.getUser(username)
        if (cachedUser != null) {
            println("User found in cache:")
            printUser(cachedUser)
            return
        }

        try {
            // Fetch user details from GitHub API
            val userCall: Call<GitHubUserResponse> = gitHubService.getUser(username)
            val userResponse: Response<GitHubUserResponse> = userCall.execute()

            if (!userResponse.isSuccessful) {
                println("Error fetching user information: ${userResponse.code()} ${userResponse.message()}")
                return
            }

            val userData = userResponse.body()!!

            // Fetch repositories for the user
            val reposCall = gitHubService.getRepos(username)
            val reposResponse = reposCall.execute()
            if (!reposResponse.isSuccessful) {
                println("Error fetching repositories: ${reposResponse.code()} ${reposResponse.message()}")
                return
            }
            val repositories = reposResponse.body()!!

            // Combine the user data and repositories into a GitHubUser object
            val gitHubUser = GitHubUser(
                username = userData.login,
                followers = userData.followers,
                following = userData.following,
                createdAt = userData.createdAt,
                repositories = repositories
            )

            // Add to cache
            userCache.addUser(gitHubUser)
            printUser(gitHubUser)
        } catch (e: Exception) {
            println("An error occurred: ${e.message}")
        }
    }

    private fun displayCachedUsers() {
        val users = userCache.getAllUsers()
        if (users.isEmpty()) {
            println("No users in cache.")
        } else {
            println("Cached Users:")
            users.forEach {
                printUser(it)
            }
        }
    }

    private fun searchByUsername() {
        print("Enter username to search: ")
        val username = scanner.nextLine().trim()
        val user = userCache.searchUser(username)
        if (user != null) {
            printUser(user)
        } else {
            println("User not found in cache.")
        }
    }

    private fun searchByRepository() {
        print("Enter repository name to search: ")
        val repoName = scanner.nextLine().trim()
        val searchResults = userCache.searchRepository(repoName)
        if (searchResults.isEmpty()) {
            println("No repositories matching '$repoName' found in cache.")
        } else {
            println("Repositories matching '$repoName':")
            for ((username, repos) in searchResults) {
                println("User: $username")
                repos.forEach { repo ->
                    println("  - $repo")
                }
            }
        }
    }

    private fun printUser(user: GitHubUser) {
        println("\nUsername: ${user.username}")
        println("Followers: ${user.followers}")
        println("Following: ${user.following}")
        println("Account Created: ${user.createdAt}")
        println("Repositories:")
        if (user.repositories.isEmpty()) {
            println("  No public repositories found.")
        } else {
            user.repositories.forEach { println("  - ${it.name}") }
        }
    }
}
