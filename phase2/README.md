# RateMyUni
Welcome to our University rating system which is an extension of https://www.ratemyprofessors.com/

## What is RateMyUni?

Student enjoy the services provided by the website RateMyProfessor as they are able to write and browse reviews related to a Professor written by students before them.  The reviews include data points which helps some students select their Professors every year.  This platform is not affiliated with any university in general and is a forum created by students, for students.

Using the same rating system and ideology from RateMyProfessor we created RateMyUni which has reviews for Dorms, Courses, and Professors in multiple universities. The user has the option to briefly browse between reviewable profiles made in a particular university, or they can also view a single reviewable profile's reviews at a time.  A User can read a review or create a reviewable profile to be able to write, edit and delete their own reviews, and upvote or downvote existing reviews.  A User can create their own profile, view their information and reviews they have written by viewing their own profile, as well as edit their own account information.

## Running the Program

### What you will need:
To run the program you will need to mark the 'phase2/src' folder as Sources Root. Then you will need to import JDK11 for running the program.
You are now ready to go to 'phase2/src/Phase2Main' and then click the green "resume" button at the top right of your screen to run the program.

Once the program runs, a new Phase2Saver.ser file will save to your local copy. This file will be read and be written into with any new users, Reviewable Profiles and reviews you make while logged in.
You will be given the option to log in or create a new user account. A default admin will be available upon running the program with the following login information:

    username: defaultAdmin
    password: protected_password
The default admin has all the permissions and features of a regular user, with extra permissions to ban, delete or make another user an admin (refer to 'phase0/README.md' for instructions on User Menu Options), and delete their own and others' reviews.

If you choose to create a new user account, you will be prompted to provide a new username and password which will automatically log you in and provide you with a main menu.
Here, you can select between:

* Browsing all Reviewable profiles (input 1-3)
* Leaving a review for an individual Reviewable Profile (input 4-6)
* Viewing all reviews for an individual Reviewable Profile (input 7-9)
* Delete an existing review made by you -- or as an admin, all existing reviews (input 10)
* Edit a previous review you left (input 11)
* View your profile and reviews made by you, as well as a list of reviews you have upvoted (input 12)
* Edit your profile (input 13)
* Upvote a review (input 14)
* Downvote a review (input 15)
* Access User Menu Options (track history and admin permissions) (input 16)
* Browse all university's name in this App (input 17)
* Browse all Professors or Courses or Dorms in certain University (input 18)
* Sort reviews (input 19)

Each of these will either display a list of the request information or provide further prompts to access specific information you require to view. Follow the instructions exactly when typing out input - for instance, please only type in true or false if a prompt asks you to choose from true/false.

### How to navigate through the code:

#### If you're looking for Main:
* Go to the Phase2Main class in the src folder.
* You will be able to use our program by running this class. Have fun!

#### If you're looking for Gateways:
* Go to the Gateway package in the src folder: you will find the MainGateway class and interface.

#### If you're looking for Controllers and Presenters:
* Go to the ControllerPresenter package in the src folder: you will find all the controllers and presenters we have.
* Note: Inside the same folder, you will find another folder which is called, Dictionaries. In the Dictionaries folder, we will find the dictionary classes that we use to keep all of our prompts.

#### If you're looking for Managers and Systems:
* Go to the ReviewSystem package in the src folder: you will find all the System folders and MainManager, Review, and ReviewManager.
* Inside this folder, there are 4 different System folders, namely: ProfessorSystem, CourseSystem, DormSystem, and UniversitySystem.
* Each of the System folder contains three classes (except for UniversitySystem: only two): Object, ObjectReview, and ObjectManager. Note: There's no UniversityReview class.

#### If you're looking for ways of sorting we have:
* Go to the Sorters package in the src folder: you will the two ways of sorting reviews we implemented. 
* First way: we sort by overall rating. 
* Second way: we sort by vote.

#### If you're looking for User Profile System:
* Go to the UserProfileSystem package in the src folder: you will find two System folders: ProfileSystem and UserSystem.
* Each of the two System folders contain two classes: Object and ObjectManager.

### What you will need for testing:
Mark the src folder in the phase2 folder as "Sources Root" and the test folder in the phase2 folder as "Test Sources Root." Then, you need to add the "JUnit4" to classpath (this is easy to do by going to any test classes and right-clicking on @Test and @DisplayName and importing the necessary libraries).


## How It Works
When each reviewable profile (Professor, Course, Dorm) are created, they are stored in their corresponding university. Review entities (ProfessorReview, CourseReview, DormReview) are separate from the reviewable profiles. The reviewable entities and Review entities are created and stored together in the respective ReviewManagers where they are commanded by the controller to create profiles or reviews, and add them to the Reviewable Profile's page. All commands and inputs from the user regarding the Reviewable Profile or Review are relayed to these Managers.

## Patterns Implemented
Three design patterns make up the essence and structure of our program: the Facade, Dependency Injection.
### The Facade Pattern:
We formed six UseCase classes (each named as a "ReviewManager," UserManager, UniversityManager, or ProfileManager). To run the work of Phase 2, we implemented a MainManager that stores an instance each of these managers as attributes and in turn,
these Managers handle the data manipulating calls, constructions and data-reading and writing. This facade also benefits our Gateway Read-Writer as it reads the entire MainManager to serialize and deserialize.

### The Dependency Injection:
The dependency injection was a key factor in our ability to form the Reviewable pages. Following Clean Architecture and with the usage of user inputs, we formed our entities' constructions from the ReviewManagers with user inputs as arguments for the command, passed in these objects as arguments for any following commands and saved the User running the program by calling the UserManager to save their information and pass it as arguments for other Managers to use. 

Another example of dependency injection is in our implementation of AppController, which serves as the text UI of the program. In order to perform functionalities such as track user history and edit profile, the AppController must keep track of the current user that is logged into the system. This was achieved by passing User object returned from LogInController into AppController. Notice that currentUser is treated like a variable, and the controller class never access any of its attributes or methods, thus preventing us from violating clean architecture.

### Strategy Pattern: NEW
We implemented sorting features that required a Strategy pattern for easier implementation of varying sorting algorithms. SortByOverallRatingComparator and sortByVoteComparator implement this pattern (for more information, see DesignDocument2).

## Current Developments, Limitations & What You Should Know
We have made progress from Phase 1 with:
- Structural changes to reduce parameter arguments for the Review entities (CourseReview, DormReview, ProfessorReview) construction. Rather than storing instance attributes of categories, all relevant information to the profile being reviewed and the associated rating categories are stored in a HashMap<String, String> in the parent abstract class Review. This has significantly improved the program's ability to extract code and responsibilities to the parent class, as well as avoiding unnecessary coupling. The ReviewManagers and Controller were adjusted to this change.
- We currently only have the information updating after every successful logout. Due to this, for information to be written back into the Phase2Saver.ser file, you must logout (press "q"). You can choose to do this when you have completed making any desired reviews, browsing Reviewable profiles and reviews, updating your profile, or upvoting and downvoting reviews. At this moment, we have handled all exceptions that would break the program; thus, the user should have no issues with maintaining their information before and after successful logout.
- Everything in the program is space-sensitive (i.e. if you make a reviewable professor profile with the name JohnSmith  and include an additional space at the end such as shown or no space between first and last names, to locate this professor, you will have to input the name exactly like so, with the spaces in those exact positions). Note the Review IDs, username, and password are not only space sensitive but also case-sensitive, so you must input them exactly when being asked.


### Improvements to be made:

#### Saving upon logout
- The current implementation of saving information upon successful logout is not ideal for a realistic program, and we intend to amend this situation with each significant command input by a user (see Future Features).
#### Sorters
- Users are now able to compare the Reviewable profile against other reviewable profiles based on overall rating and popularity (most to least upvotes). However, the sorting is based on all reviews made rather than for a particular reviewable profile in a particular university. Our current sorters provide a basis and beginning for our ideal vision.

## Improvements from Phase1
### Edit Review
- Users are now able to edit the previous reviews they wrote, they have the freedom to edit any attributes of the review.
### Switch Language
- Users are now able to choose a preferred language when they first enter the program. Currently, our program offers two languages: English and Chinese.
#### University
- Users are now able to browse all universities in the app, and for each university, user could browse the courses, professors, and dorms in that university.
### Multiple universities and identical name capacity
Users are now able to browse and review reviewable profiles from particular universities. This functionality provides the user a more efficient way of browsing to search for a particular professor from their desired university. The university entity has the assumption that there will not be more than one Professor, Course or Dorm with exactly the same name, course code or residence name.
### Refactoring & Extracting Codes & Packaging
Refactoring & extracting codes, and packaging  so that our current shared codes are in parent classes or interfaces.
- HashMap structure in child Review classes change to replace instance attributes as mentioned above.
- Removing hardcoded String values from user inputs and prompts in the AppController. This led to the addition of the PromptDictionary and capacity to include new language options to our menu.
- Packaging codes by related functionality (i.e. Professor, ProfessorReview and ProfessorReviewManager) to ensure each has proper package-protected access where it is required.
- Extracted code to abstract classes Review and ReviewManager from their child classes where able.
### Sort Reviews
- By Popularity: Users are now able to sort reviews of a reviewable profile by the most votes a review has (i.e. by popularity).
- By Overall Rating: Users are able to sort reviews of a reviewable profile by the highest overall ratings to lowest.

### Future Features & Implementations:
Some of these implementations are to improve the current program and its structure, others are features we desire to implement for users' enjoyment.
#### Saving with significant commands
As aforementioned, we believe that without doing this our program is lacking a more smooth user experience and envision the system saving upon every command for other users to see at one time, rather than upon one user's logout.
#### Sorters
- *More specifics to sort through a singular profile* in a singular university.

- Options to *sort in reverse* (i.e. lowest to highest) for sorters that allow it.
- *By similar reviewable profiles*: this function should allow for users to select particular attributes or information they would like to compare another reviewable of the same type.

  - For instance, some similarity sorters to implement:
    - a user could browse professors in the same department who have taught a particular course with select attributes to compare against;
    - a user could browse courses in the same year level and department with select attributes to compare against.
    - a user could browse dorms in the same university against select attributes they desire to compare.


#### GUI Implementation
RateMyUni can be converted into a GUI based laptop application instead of text.  This would greatly improve the user experience and efficiency of writing the reviews to make it more helpful for users to browse through the program.
RateMyUni can be converted into a GUI based laptop application instead of text.  This would greatly improve the efficiency of writing the reviews and well and make it more helpful for users to read reviews.

#### Email Verification
Users could register account by verifying email, and improve the security when user forget their password and to reset that.