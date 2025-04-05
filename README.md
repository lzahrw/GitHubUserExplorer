# GitHubUserInfoApp

A terminal-based Kotlin application to fetch and display GitHub user information using GitHub's REST API. It utilizes Retrofit for networking, Gson for JSON parsing, and includes in-memory caching to minimize duplicate API calls.

## 🚀 Features

- **Fetch GitHub User Details**  
  Retrieve username, followers, following, account creation date, and public repositories.

- **In-Memory Caching**  
  Prevents redundant API requests by storing previously retrieved user data.

- **Search Functionality**  
  - Search cached users by username.  
  - Search all cached repositories by name.

- **Modular Design**  
  Organized into models, networking, caching, and UI components for better scalability and maintainability.

---

## 📁 Project Structure

```
GitHubUserInfoApp/
├── build.gradle.kts
├── settings.gradle.kts
└── src/
    └── main/
        └── kotlin/
            └── com/example/githubuserinfo/
                ├── Main.kt
                ├── cache/
                │   └── UserCache.kt
                ├── model/
                │   ├── GitHubUser.kt
                │   ├── GitHubUserResponse.kt
                │   └── Repository.kt
                ├── network/
                │   └── GitHubService.kt
                └── ui/
                    └── Menu.kt
```

---

## ⚙️ Requirements

- JDK 8 or higher  
- Kotlin 1.8.0 or higher  
- Gradle  
- Internet connection (for API access)

---

## 🛠️ Installation & Setup

1. **Clone the repository**  
   ```bash
   git clone https://github.com/yourusername/GitHubUserInfoApp.git
   cd GitHubUserInfoApp
   ```

2. **Build the project**  
   ```bash
   ./gradlew build
   ```

3. **Run the application**  
   ```bash
   ./gradlew run
   ```

---

## 📋 Usage

Once the application is running, you'll see a menu like:

```
--- GitHub User Information ---
1. Retrieve user information by username
2. Display cached users
3. Search user by username
4. Search repository by name
5. Exit
```

Use the number keys to navigate through the options and interact with the app.

---

## ✅ Testing

### Manual Testing

Run the app and:

- Check that user info is fetched and cached  
- Confirm that search features work as expected  
- Verify error handling for invalid input or network issues  

---

## 🤝 Contributing

Contributions are welcome! If you'd like to fix a bug, suggest an improvement, or add a feature:

- Fork the repository
- Create a new branch
- Submit a pull request

For major changes, please open an issue first to discuss what you’d like to change.

---


