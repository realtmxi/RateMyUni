package ControllerPresenter.Dictionaries;

import java.util.HashMap;
/**
 * This is an abstract class that contains a dictionary attribute, which maps prompt name to actual prompts
 */
public abstract class PromptDictionary {

    HashMap<LogInPrompts,String> logInPromptsMap;
    HashMap<mainPrompts,String> mainPromptsMap;
    HashMap<Menu, String> MenusMap;
    HashMap<userOptionPrompts, String> userOptionPromptMap;
    HashMap<reviewPrompts, String> reviewPromptsMap;
    HashMap<infoPrompts, String> infoPromptsMap;


    public PromptDictionary(){
        logInPromptsMap = new HashMap<>();
        mainPromptsMap = new HashMap<>();
        MenusMap = new HashMap<>();
        userOptionPromptMap = new HashMap<>();
        reviewPromptsMap = new HashMap<>();
        infoPromptsMap = new HashMap<>();
    }



    public enum Menu{
        MainMenu,
        EditProfileMenu, UserOptionsMenu, EditProfReviewMenu, EditCourseReviewMenu, EditDormReviewMenu
    }

    public enum infoPrompts{
        courseInfo,courseReviewInfo,dormInfo,dormReviewInfo,profInfo,profReviewInfo,profileInfo
    }
    public enum LogInPrompts{
        AskLogInOrCreateAccount, LogInSuccess, UserExists, UserNameOrPasswordIncorrect, UserBanned, UserAlreadyLoggedIn, SignUpSuccessful, LogOutSuccess, GetUsername, GetPassword, GetUsernameSignUp, GetPasswordSignUp, AskQuit, UserNotExists, ForgetPassword
    }

    public enum mainPrompts{
        WhichProf, WhichDorm, WhichCourse,WhichType,WhichUniProf, WhichUniCourse, WhichUniDorm, ProfNonExistent, DormNonExistent, CourseNonExistent, AskOverallRating, AskForComment,
        AskProfName, AskProfCourse, AskProfDifficulty, AskProfEngagement, AskProfClarity, AskAttendance, AskTextbook,
        AskCourseCode, AskCourseDifficulty, AskWorkload, AskParticipation, AskTheoretical, AskApplied, AskInclusive,
        AskDormName,AskCleanliness,AskSocialness, AskSoundproof,AskRA,AskFood,AskConvenience,AskWifi,
        ChangeNameSuccess, NewNameExists, ChangeEmailSuccess,ChangeYearSuccess,

        AskReviewID,IntegerOutOfRange, GetNewName, GetNewYear, GetNewEmail, CreateDormName, CreateDormUni, CreateDormFloor, CreateCourseCode, CreateCourseUni, CreateCourseDep, CreateProfDep, CreateProfUni, CreateProfName, DisplayAllReviewIDs, WhichUni, GetNewComment, GetNewOverallrating, GetNewProfName, GetNewDiffLvl, GetNewCouseName, GetNewClarityLvl, GetNewEngLvl, GetNewAttendance, GetNewCourseCode, GetNewTxtbook, GetNewWorkloadLvl, GetNewTheo, NonBooleanMismatch, GetNewIncl, GetNewPart, GetNewDormName, GetNewCleanLvl, GetNewSocialLvl, GetNewSoundLvl, GetNewWifi, GetNewRA, GetNewConven, GetNewFood, UniNonExistent, CreateUniName,AskReviewIDDenied, GiveReviewIDList,
        EmptyReviewLists, HowToSortReviews, WhichCategory;
        public static mainPrompts GetNewApp;
    }

    public enum userOptionPrompts{
        AskBanName, AskBanTime, BanSuccess, BanFailed, AskAdminName, CreateAdminFailed, UserAlreadyAdmin, AskDeleteName, DeleteUserFailed, AlreadyBanned, DeleteUserSuccess, CreateAdminSuccess, InvalidChoice, DeleteAlreadyAdmin
    }

    public enum reviewPrompts{
        DeleteSuccess,DeleteFailed,UpvoteSuccess,DownvoteSuccess,UpvoteExists, UpvoteNonExistentReview, DownvoteNonExistentReview, BrowseProfReview, BrowseCourseReview, BrowseDormReview, DownvoteExists, BrowseUniversities, BrowseProfReviewInUni, BrowseDormReviewInUni, BrowseCourseReviewInUni, EditReviewSuccess, EditReviewFailed,
       ChangeCommentSuccess, ChangeORSuccess, ChangeProfName, ChangeCourseName, ChangeDiffLvl, ChangeClarityLvl, ChangeEngLvl, ChangeAttendance, ChangeTxtbook, ChangeCourseCode, ChangeWorkloadLvl, ChangeIsTheo, ChangeIsApp, ChangeIsIncl, ChangeIsPart, ChangeDormName, ChangeConven, ChangeSocialLvl, ChangeCleanLvl, ChangeSoundLvl, ChangeWifi, ChangeFood, ChangeRA,
    }



    public String getLogInPrompt(LogInPrompts lp){
        return logInPromptsMap.get(lp);
    }

    public String getMainPrompt(mainPrompts mp){
        return mainPromptsMap.get(mp);
    }

    public String getMenu(Menu m){ return MenusMap.get(m);}

    public String getUserOptionPrompt(userOptionPrompts up){return userOptionPromptMap.get(up);}

    public String getReviewPrompt(reviewPrompts rp){return reviewPromptsMap.get(rp);}

    public String getInfoPrompt(infoPrompts ip) {
        return infoPromptsMap.get(ip);
    }

}
