# GitHubUserInfoApp

GitHubUserInfoApp is a Kotlin-based terminal application that retrieves GitHub user information using GitHub's REST API. The app leverages Retrofit for HTTP networking and Gson for JSON deserialization. It features an in-memory cache to avoid duplicate API calls and provides a menu-driven interface for interacting with the data.

## Features

- **Retrieve User Information:**  
  Fetch user details (username, number of followers, number of following, account creation date, and list of public repositories) from GitHub.

- **In-Memory Caching:**  
  Cache user data to prevent repeated API calls for the same user.

- **Search Functionality:**  
  - Search for a user by username within the cached data.
  - Search for a repository by name across all cached users.

- **Modular & Extensible Design:**  
  Structured with separate modules (data models, networking, caching, and UI) to ensure scalability and ease of maintenance.

## Project Structure

GitHubUserInfoApp/ ├── build.gradle.kts // Gradle build file with dependencies ├── settings.gradle.kts // Gradle settings file └── src/ └── main/ └── kotlin/ └── com/ └── example/ └── githubuserinfo/ ├── Main.kt // Application entry point ├── cache/ │ └── UserCache.kt // In-memory cache implementation ├── model/ │ ├── GitHubUser.kt // Combined user data model (user details + repos) │ ├── GitHubUserResponse.kt // Data class for GitHub API user response │ └── Repository.kt // Data class for repository details ├── network/ │ └── GitHubService.kt // Retrofit interface for GitHub API endpoints └── ui/ └── Menu.kt // Menu-driven interface handling user input/output

markdown
Copy

## Requirements

- **Java Development Kit (JDK):** Version 8 or later
- **Kotlin:** Version 1.8.0 or later
- **Gradle:** For building and running the project
- **Internet Connection:** Required for making API calls to GitHub

## Installation & Setup

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/yourusername/GitHubUserInfoApp.git
   cd GitHubUserInfoApp
Build the Project:

Use Gradle to build the project:

bash
Copy
./gradlew build
Run the Application:

Launch the application with:

bash
Copy
./gradlew run
Usage
When you run the application, you'll see a menu similar to the following:

markdown
Copy
--- GitHub User Information ---
1. Retrieve user information by username
2. Display the list of users in memory
3. Search by username among users in memory
4. Search by repository name among data in memory
5. Exit
Enter your choice:
Sample Interaction
1. Retrieve User Information
User Input:

yaml
Copy
Enter your choice: 1
Enter GitHub username: octocat
Expected Output:

yaml
Copy
Fetching user information...
Username: octocat
Followers: 3900
Following: 9
Account Created: 2011-01-25T18:44:36Z
Repositories:
  - Spoon-Knife
  - Hello-World
  - octocat.github.io
2. Display Cached Users
User Input:

yaml
Copy
Enter your choice: 2
Expected Output:

yaml
Copy
Cached Users:
Username: octocat
Followers: 3900
Following: 9
Account Created: 2011-01-25T18:44:36Z
Repositories:
  - Spoon-Knife
  - Hello-World
  - octocat.github.io
3. Search by Username
User Input:

yaml
Copy
Enter your choice: 3
Enter username to search: octocat
Expected Output:

yaml
Copy
Username: octocat
Followers: 3900
Following: 9
Account Created: 2011-01-25T18:44:36Z
Repositories:
  - Spoon-Knife
  - Hello-World
  - octocat.github.io
4. Search by Repository Name
User Input:

pgsql
Copy
Enter your choice: 4
Enter repository name to search: Spoon
Expected Output:

sql
Copy
Repositories matching 'Spoon':
User: octocat
  - Spoon-Knife
5. Exit the Application
User Input:

yaml
Copy
Enter your choice: 5
Expected Output:

nginx
Copy
Exiting program. Goodbye!
Testing
Automated Testing
Unit Tests & Integration Tests:
To run tests, execute:

bash
Copy
./gradlew test
Tests cover:

In-memory cache functionality

Retrofit network calls (using MockWebServer)

Integration of network and caching components

Manual Testing
Follow the Usage section above to interact with the application in your terminal.

Validate that:

User information is correctly fetched and displayed.

The cache stores user data to avoid duplicate API calls.

Search operations return the expected results.

The application gracefully handles errors (e.g., invalid usernames).

Contributing
Contributions are welcome! If you have suggestions, bug fixes, or new features, please open an issue or submit a pull request. For major changes, please discuss them via an issue first.
