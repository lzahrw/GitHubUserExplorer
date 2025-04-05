# GitHubUserExplorer

Sample Manual Test Transcript

Session Start
--------------------------
--- GitHub User Information ---
1. Retrieve user information by username
2. Display the list of users in memory
3. Search by username among users in memory
4. Search by repository name among data in memory
5. Exit
Enter your choice: 1

User Input:
Selects Option 1 to retrieve a GitHub user's details.

--------------------------
Enter GitHub username: octocat

Simulated API Response & Output:
--------------------------
Fetching user information...
User details:
Username: octocat
Followers: 3900
Following: 9
Account Created: 2011-01-25T18:44:36Z
Repositories:
  - Spoon-Knife
  - Hello-World
  - octocat.github.io

Note: The above numbers and repository names are example values. Actual values depend on the GitHub API response.

Displaying Cached Users
--------------------------
After the user is added to the in‑memory cache, the menu is shown again:

--- GitHub User Information ---
1. Retrieve user information by username
2. Display the list of users in memory
3. Search by username among users in memory
4. Search by repository name among data in memory
5. Exit
Enter your choice: 2

User Input:
Selects Option 2 to display the list of cached users.

Expected Output:
--------------------------
Cached Users:
Username: octocat
Followers: 3900
Following: 9
Account Created: 2011-01-25T18:44:36Z
Repositories:
  - Spoon-Knife
  - Hello-World
  - octocat.github.io

Searching by Username in Cache
--------------------------
Next, the user chooses to search for a user by username:

--- GitHub User Information ---
1. Retrieve user information by username
2. Display the list of users in memory
3. Search by username among users in memory
4. Search by repository name among data in memory
5. Exit
Enter your choice: 3

User Input:
When prompted, the user types:

Enter username to search: octocat

Expected Output:
--------------------------
User details:
Username: octocat
Followers: 3900
Following: 9
Account Created: 2011-01-25T18:44:36Z
Repositories:
  - Spoon-Knife
  - Hello-World
  - octocat.github.io

Searching by Repository Name
--------------------------
The user now wants to search for a repository across the cached users:

--- GitHub User Information ---
1. Retrieve user information by username
2. Display the list of users in memory
3. Search by username among users in memory
4. Search by repository name among data in memory
5. Exit
Enter your choice: 4

User Input:
When prompted for the repository name, the user enters:

Enter repository name to search: Spoon

Expected Output:
--------------------------
Repositories matching 'Spoon':
User: octocat
  - Spoon-Knife

Exiting the Program
--------------------------
Finally, the user chooses to exit:

--- GitHub User Information ---
1. Retrieve user information by username
2. Display the list of users in memory
3. Search by username among users in memory
4. Search by repository name among data in memory
5. Exit
Enter your choice: 5

Expected Output:
--------------------------
Exiting program. Goodbye!

Summary
--------------------------
Option 1: Retrieves a GitHub user’s data from the API and caches it.
Option 2: Displays all cached user data.
Option 3: Searches for a specific user in the cache.
Option 4: Searches for repositories containing a given string in the cache.
Option 5: Exits the program.

This transcript demonstrates the expected input and output for each menu option during a manual test session. Adjust the sample values as needed based on the real API responses and any changes you make to the program.
