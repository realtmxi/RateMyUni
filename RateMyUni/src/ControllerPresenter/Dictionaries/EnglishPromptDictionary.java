package ControllerPresenter.Dictionaries;

public class EnglishPromptDictionary extends PromptDictionary {

    public EnglishPromptDictionary(){
        super();
        initiateLogInPrompts();
        initiateMainPrompts();
        initiateMenus();
        initiateUserOptionPrompts();
        initiateReviewPrompts();
        initiateInfoPrompts();
    }

    private void initiateInfoPrompts() {
        infoPromptsMap.put(PromptDictionary.infoPrompts.profileInfo,"This is the profile of <%s>\n Graduating year: %s\n Email: %s\n Upvoted Reviews: %s\n");
        infoPromptsMap.put(PromptDictionary.infoPrompts.profInfo, "===[Professor Profile]===\nProfessor Name: %s\nUniversity: %s\nDepartment: %s\n===[Average Ratings]===\n" +
                "Average Overall Rating: %s\nAverage level of difficulty: %s\nAverage level of clarity: " +
                "%s\nAverage level of engagement: %s\nAttendance Necessary: %s%% agree\nTextbook Necessary: %s%% agree\n");
        infoPromptsMap.put(PromptDictionary.infoPrompts.profReviewInfo, "===[This Review was left by %s at %s]===\n ReviewID: %s\n Professor Name: %s\n Course Name: %s\n Overall Rating: %s\n Comment: %s\n Difficulty: %s\n " +
                "Clarity: %s\n Engagement: %s\n Attendance Necessary: %s\n Textbook Necessary: %s\n===[upvotes👍: %s, downvotes👎:%s]===\n");
        infoPromptsMap.put(PromptDictionary.infoPrompts.courseInfo, "===[Course Profile]===\nCourse Code: %s\nUniversity: %s\nDepartment: %s\n===[Average Ratings]===\n" +
                "Average Overall Rating: %s\nAverage Difficulty: %s\nAverage Workload: %s\nTheoretical: %s%% agree\n" +
                "Applicable: %s%% agree\nInclusive: %s%% agree\n");
        infoPromptsMap.put(PromptDictionary.infoPrompts.courseReviewInfo, "===[This Review was left by %s at %s]===\n ReviewID: %s\n Course Code: %s\n Overall Rating: %s\n Comment: %s\n " +
                "Difficulty: %s\n Workload: %s\n Participation Necessary: %s\n Theoretical: %s\n Applicable: %s\n Inclusive: %s\n===[upvotes👍: %s, downvotes👎:%s]===\n");
        infoPromptsMap.put(PromptDictionary.infoPrompts.dormInfo, "===[Dorm Profile]===\nResidence Name: %s\nUniversity: %s\nFloor Number: %s\n===[Average Ratings]===\n" +
                "Average Overall Rating: %s\nAverage Cleanliness Rating: %s\nAverage Social Level: " +
                "%s\nAverage Soundproof Rating: %s\nAverage RA rating: %s\n" +
                "Average Food Rating: %s\nAverage Convenience Level: %s\nAverage WiFi speed: %s\n");
        infoPromptsMap.put(PromptDictionary.infoPrompts.dormReviewInfo,"===[This Review was left by %s at %s]===\n ReviewID: %s\n Dorm Name: %s\n Overall Rating: %s\n Comment: %s\n Cleanliness: %s\n Social Level: %s\n " +
                "Soundproof: %s\n RA: %s\n Food: %s\n Convenience: " +
                "%s\n WiFi: %s\n===[upvotes👍: %s, downvotes👎:%s]===\n");
    }


    private void initiateReviewPrompts() {
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.DeleteSuccess, "Review successfully deleted!\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.DeleteFailed, "You either don't have access to delete this review or review doesn't exist.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.UpvoteSuccess, "Successfully upvoted review!\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.UpvoteNonExistentReview, "Upvote failed because this review doesn't exist.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.UpvoteExists, "Upvote failed because you have already upvoted this review.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.DownvoteSuccess, "Successfully downvoted review!\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.DownvoteNonExistentReview, "Downvote failed because this review doesn't exist.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.DownvoteExists, "Downvote failed because you have already downvoted this review.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.BrowseProfReview, ">>>Here is a list of all professor that have been reviewed:\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.BrowseCourseReview, ">>>Here is a list of all courses that have been reviewed:\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.BrowseDormReview, ">>>Here is a list of all dorms that have been reviewed:\n");
        //ToDo: code the following part in ChinesePromptDictionary
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeCommentSuccess, "Successfully updated the comment for the review.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeORSuccess, "Successfully updated the overall rating for the review.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeProfName, "Successfully updated the professor's name for the review. \n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeCourseName, "Successfully updated the course name for the review.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeDiffLvl, "Successfully updated the difficulty level for the review.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeClarityLvl, "Successfully updated the clarity level for the review. \n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeEngLvl, "Successfully updated the engagement level for the review.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeAttendance, "Successfully updated whether attendance is necessary for the review.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeTxtbook, "Successfully updated whether textbook is necessary for the review.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeCourseCode, "Successfully updated the course code for the review.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeWorkloadLvl, "Successfully updated the workload level for the review.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeIsTheo, "Successfully updated whether the course is theoretical for the review.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeIsApp, "Successfully updated whether the course is applicable for the review.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeIsIncl, "Successfully updated whether the course is inclusive for the review.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeIsPart, "Successfully updated whether participation is necessary for the review.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeDormName, "Successfully updated the dorm name for the review.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeCleanLvl, "Successfully updated the cleanliness level for the review.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeSocialLvl, "Successfully updated the social level for the review.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeSoundLvl, "Successfully updated the sound proof level for the review.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeRA, "Successfully updated the RA rating for the review.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeWifi, "Successfully updated the wifi level for the review.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeFood, "Successfully updated the food level for the review.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeConven, "Successfully updated the convenience level for the review.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.EditReviewSuccess, "Sucessfully edited review!\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.EditReviewFailed, "Edit review failed, you either don't have access to edit this review or review does not exist.\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.BrowseUniversities, ">>>Here is a list of all universities in this app:\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.BrowseProfReviewInUni, ">>>Here is a list of all professor that have been reviewed in this university:\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.BrowseDormReviewInUni, ">>>Here is a list of all dorms that have been reviewed in this university:\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.BrowseCourseReviewInUni, ">>>Here is a list of all courses that have been reviewed in this university:\n");

    }

    private void initiateUserOptionPrompts() {

        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.AskBanName, "Please enter the username of non-admin user that you want to ban.\n");
        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.AskBanTime, "Please enter an integer representing how many hours you want to ban the user for.\n");
        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.BanSuccess, "User was successfully banned!\n");
        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.AlreadyBanned, "Ban is invalid, since it is already banned.\n");
        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.BanFailed, "Ban user failed. Either user doesn't exist or is an admin.\n");
        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.AskAdminName,"Please enter the username of non-admin user that you want to make admin.\n");
        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.CreateAdminSuccess, "New admin was created!\n");
        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.CreateAdminFailed, "This user does not exist,create new admin failed.\n");
        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.UserAlreadyAdmin, "This user is already an admin!\n");
        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.AskDeleteName,"Please enter the username of non-admin user that you want to delete.\n");
        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.DeleteUserSuccess, "This user was successfully deleted!\n");
        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.DeleteUserFailed, "This user does not exist, delete user failed.\n");
        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.DeleteAlreadyAdmin, "This user is already an admin. You cannot delete an admin.\n");
        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.InvalidChoice, "This choice is invalid.\n");
    }

    private void initiateMenus() {
        MenusMap.put(PromptDictionary.Menu.MainMenu,"Welcome to the main interface of RateMyUni!Please choose what you would like to do:\n" +
                "1)Browse All Professor Profiles\n" +
                "2)Browse All Course Profiles\n" +
                "3)Browse All Dorm Profiles\n" +
                "4)Leave a Professor Review\n" +
                "5)Leave a Course Review\n" +
                "6)Leave a Dorm Review\n" +
                "7)Browse all reviews of a professor in certain university\n" +
                "8)Browse all reviews of a course in certain university\n" +
                "9)Browse all reviews of a dorm in certain university\n" +
                "10)Remove a previous review you left\n" +
                "11)Edit a previous review you left\n" +
                "12)View your profile on RateMyUni\n" +
                "13)Edit your profile on RateMyUni\n" +
                "14)Upvote a review\n" +
                "15)Downvote a review\n" +
                "16)Go to the User option menu of RateMyUni (track history, etc)\n"+
                "17)Browse all university's name in this App\n"+
                "18)Browse all Professors or Courses or Dorms in certain University\n"+
                "19)Sort reviews\n");

        MenusMap.put(PromptDictionary.Menu.UserOptionsMenu,"Welcome to the user option menu. You can now:\n" +
                "1) track history.\n" +
                "2) Ban non-admin user (Admin only)\n" +
                "3) Make non-admin user admin (Admin only)\n" +
                "4) Delete a non-admin user (Admin only)\n" +
                "5) Go back to main menu of RateMyUni\n");

        MenusMap.put(PromptDictionary.Menu.EditProfileMenu, "Please select the profile attribute you'd like to update:\n" +
                "1) Graduating Year\n2) Email\n3) Name\n4) Nevermind, go back to main menu.\n");

        //renumbered the attributes.
        MenusMap.put(PromptDictionary.Menu.EditProfReviewMenu, "Please select the review attribute you'd like to update:\n" +
                "1)course name\n" +
                "2)Level of difficulty\n" +
                "3)Level of clarity\n" +
                "4)Level of engagement\n" +
                "5)Is attendance necessary?\n" +
                "6)Is textbook necessary?\n" +
                "7)Overall rating\n" +
                "8)Comment \n" +
                "9)Go back to the main menu\n");

        MenusMap.put(PromptDictionary.Menu.EditCourseReviewMenu, "Please select the profile attribute you'd like to update:\n" +
                "1)Level of difficulty\n" +
                "2)Level of workload\n" +
                "3)Is participation needed?\n" +
                "4)Is it theoretical?\n" +
                "5)Is it applicable?\n" +
                "6)Is it inclusive?\n" +
                "7)Overall rating\n" +
                "8)Comment \n" +
                "9)Go back to the main menu\n");

        MenusMap.put(PromptDictionary.Menu.EditDormReviewMenu, "Please select the profile attribute you'd like to update:\n" +
                "1)Level of cleanliness\n" +
                "2)Social level\n" +
                "3)Level of sound proof\n" +
                "4)RA rating\n" +
                "5)Food rating\n" +
                "6)Convenience rating\n" +
                "7)Wifi rating\n" +
                "8)Overall rating\n" +
                "9)Comment \n" +
                "10)Go back to the main menu\n");
    }



    public void initiateLogInPrompts(){
        logInPromptsMap.put(PromptDictionary.LogInPrompts.AskLogInOrCreateAccount,"Welcome to the log in interface. Would you like to: \n 1) Log in\n 2) Create account\n " +
                "Please type 1 or 2.\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.AskQuit,"If you want to quit this program, please type q. Otherwise, type any other key to continue.\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.LogInSuccess,"Log in Successful!\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.UserExists,"User exists, log in instead of sign up.\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.UserNameOrPasswordIncorrect,"Username or password incorrect, please try again.\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.UserBanned,"User is banned so cannot log in.\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.UserAlreadyLoggedIn,"User already logged in!\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.SignUpSuccessful, "Sign up was successful! You are automatically logged-in.\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.LogOutSuccess, "Log out successful, see you next time! :)\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.GetUsername, "Enter username for Log in:\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.GetPassword, "Enter password for Log in:\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.GetUsernameSignUp, "Enter username for sign up:\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.GetPasswordSignUp, "Enter password for sign up:\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.ForgetPassword, "Forget original password， reset a new password\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.UserNotExists, "User does not exists, please sign up a new account\n");

    }

    public void initiateMainPrompts(){
        mainPromptsMap.put(PromptDictionary.mainPrompts.WhichProf,"Which professor's reviews would you like to browse? Please enter the prof's full name.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.WhichCourse,"Which course's reviews would you like to browse? Please enter the course code.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.WhichDorm,"Which dorm's reviews would you like to browse? Please enter the dorm's full name.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.WhichUni, "Which university's reviews would you like to browse? Please enter the university's full name.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.WhichUniProf,"Which university of the professor's reviews would you like to browse? Please enter the university's full name.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.WhichUniCourse,"Which university of the course's reviews would you like to browse? Please enter the university's full name.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.WhichUniDorm,"Which university of the dorm's reviews would you like to browse? Please enter the university's full name.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.WhichType, "Which type of reviewable entities would you like to browse?\n" +
                "1)professors\n2)dorms\n3)courses\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.UniNonExistent,"University not found, would you like to create this university?\n" +
                "1)Yes\n2)No I'm good\n");

        mainPromptsMap.put(PromptDictionary.mainPrompts.ProfNonExistent,"Professor not found, would you like to create a reviewable profile for this professor?\n" +
                "1)Yes\n2)No I'm good\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.CourseNonExistent,"Course not found, would you like to create a reviewable profile for this course?\n" +
                "1)Yes\n2)No I'm good\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.DormNonExistent,"Dorm not found, would you like to create a reviewable profile for this dorm?\n" +
                "1)Yes\n2)No I'm good\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskOverallRating, "Please give an overall rating from 1-5 for this reviewable profile.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskForComment, "Please leave a comment for this reviewable profile.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskProfName,"For this professor review, please enter the name of professor.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskProfCourse,"For this professor review, please enter the course code of the course that this professor taught you.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskProfDifficulty, "On a scale from 1-5, please enter the level of difficulty of taking this professor's course.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskProfClarity, "On a scale from 1-5, please enter this professor's level of clarity.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskProfEngagement, "On a scale from 1-5, please enter this professor's level of engagement.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskAttendance, "For this professor review, please enter whether attendance is required for this prof's courses (true or false only).\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskTextbook, "Please enter whether textbook is required for this professor's courses (true or false only).\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskCourseCode,"For this course review, enter the course code.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskCourseDifficulty, "On a scale from 1-5, please enter the difficulty of this course.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskWorkload, "On a scale from 1-5, please enter the workload of this course.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskParticipation, "Please enter whether participation is mandatory for this course (true or false only).\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskTheoretical, "Please enter whether this course is more theoretical (true or false only).\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskApplied, "Please enter whether this course is more applied (true or false only).\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskInclusive, "Please enter whether this course is inclusive (true or false only).\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskDormName, "For this dorm review, please enter the name of the residence you wish to review on.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskCleanliness, "On a scale from 1-5, please enter the cleanliness of this dorm.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskSocialness, "On a scale from 1-5, please enter the social level of this dorm.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskSoundproof, "On a scale from 1-5, please enter the quality of sound proof of this dorm.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskRA,"On a scale from 1-5, please rate the residence assistant (RA) of this dorm.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskFood, "On a scale from 1-5, please rate the quality of food at this dorm.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskConvenience, "On a scale from 1-5, please rate the convenience of this dorm.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskWifi, "On a scale from 1-5, please rate the wifi speed at this dorm.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskReviewID, "Please enter the reviewID of the review that you would like to access.\n");
        
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskReviewIDDenied, "Either the review you're looking for doesn't exist or it's other's review.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GiveReviewIDList, "Here are the list of IDs of reviews you can access:\n");

        mainPromptsMap.put(PromptDictionary.mainPrompts.IntegerOutOfRange, "Rating value out of range, please enter an integer between 1-5.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.NonBooleanMismatch, "Rating value type mismatch, please enter either true or false.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.ChangeNameSuccess, "Change name success!\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.NewNameExists, "Change name failed, this username already exists.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.ChangeEmailSuccess, "Change email success!\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.ChangeYearSuccess, "Change graduating year success!\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewName,"Please enter the updated value of your user name.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewYear,"Please enter your updated graduating year.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewEmail,"Please enter your updated university-affiliated email.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.CreateDormName, "Please enter name of the residence you want to add.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.CreateDormUni, "Please enter the university that the dorm belongs to.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.CreateDormFloor, "Please enter the floor number of the dorm you want to add.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.CreateCourseCode, "Please enter course code of the course you want to add.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.CreateCourseUni, "Please enter the  university at which the course you want to add is offered.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.CreateCourseDep, "Please enter the department of the course you want to add.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.CreateProfDep, "Please enter the department of the professor you want to add.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.CreateProfUni, "Please enter the university that is affiliated with the professor you want to add.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.CreateProfName, "Please enter the name of the professor you want to add.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.DisplayAllReviewIDs, "Here are all the review IDs available.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewComment,"Please enter the updated comment.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewOverallrating,"Please enter the updated overall rating.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewProfName,"Please enter the updated professor's name.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewCouseName,"Please enter the updated course name.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewDiffLvl,"Please enter the updated level of difficulty.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewClarityLvl,"Please enter the updated level of clarity\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewEngLvl,"Please enter the updated level of engagement.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewAttendance,"Please enter the updated necessity of attendance\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewTxtbook,"Please enter the updated necessity of textbook.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewCourseCode,"Please enter the updated course code.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewWorkloadLvl,"Please enter the updated level of workload.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewTheo,"Please enter the updated information of whether the course is theoretical.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewApp,"Please enter the updated information of whether the course is applicable.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewIncl,"Please enter the updated information of whether the course is inclusive.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewPart,"Please enter the updated necessity of participation.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewDormName,"Please enter the updated dorm name.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewCleanLvl,"Please enter the updated level of cleanliness.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewSocialLvl,"Please enter the updated level of social environment.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewSoundLvl,"Please enter the updated level of sound proof.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewRA,"Please enter the updated RA rating.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewWifi,"Please enter the updated level of speed of wifi.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewFood,"Please enter the updated level of tastiness of the food.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewConven,"Please enter the updated level of convenience.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.CreateUniName, "Please enter the name of the university you want to add.\n");

        mainPromptsMap.put(PromptDictionary.mainPrompts.EmptyReviewLists, "We don't any reviews currently, feel free to leave some");
        mainPromptsMap.put(PromptDictionary.mainPrompts.WhichCategory, "Which category do you like to see: \n 1. Course\n 2. Dorm \n 3. Professor:\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.HowToSortReviews, "How do you like to sort reviews: \n" +
                "1. By the overall rating of reviews \n2. By the popularity of reviews:\n") ;
    }



}
