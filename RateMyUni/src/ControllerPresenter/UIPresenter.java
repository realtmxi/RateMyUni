package ControllerPresenter;

import ControllerPresenter.Dictionaries.*;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * The presenter class responsible for printing prompts and feedback messages for all controllers (except for LogInController)
 */
public class UIPresenter extends Presenter {


    /**
     * Initializes a user interaction Presenter to interact with user commands with program responses.
     * @param pd a dictionary with the appropriate responses in the user's preferred language.
     */
    public UIPresenter(PromptDictionary pd){
        super(pd);
    }


    /**
     * Provides a main menu that allows a user to browse or leave reviews.
     */
    public void ReviewOrBrowsePrompt(){
        System.out.println(pd.getMenu(PromptDictionary.Menu.MainMenu));
    }

    /**
     * Prompts the user to quit and logout when they desire.
     */
    public void AskQuitPrompt(){
        System.out.println(pd.getLogInPrompt(PromptDictionary.LogInPrompts.AskQuit));
    }

    /**
     * Provides the user with their login options and other user account related options (ban, make admin, track history).
     * @param cmd the selected command prompt number associated with the user's command.
     */
    public void userOptionController(int cmd){
        switch(cmd){
            case 1:
                System.out.println(pd.getMenu(PromptDictionary.Menu.UserOptionsMenu));
                break;
            case 2:
                System.out.println(pd.getUserOptionPrompt(PromptDictionary.userOptionPrompts.AskBanName));
                break;
            case 3:
                System.out.println(pd.getUserOptionPrompt(PromptDictionary.userOptionPrompts.AskBanTime));
                break;
            case 4:
                System.out.println(pd.getUserOptionPrompt(PromptDictionary.userOptionPrompts.BanSuccess));
                break;
            case 5:
                System.out.println(pd.getUserOptionPrompt(PromptDictionary.userOptionPrompts.AlreadyBanned));
                break;
            case 6:
                System.out.println(pd.getUserOptionPrompt(PromptDictionary.userOptionPrompts.BanFailed));
                break;
            case 7:
                System.out.println(pd.getUserOptionPrompt(PromptDictionary.userOptionPrompts.AskAdminName));
                break;
            case 8:
                System.out.println(pd.getUserOptionPrompt(PromptDictionary.userOptionPrompts.CreateAdminFailed));
                break;
            case 9:
                System.out.println(pd.getUserOptionPrompt(PromptDictionary.userOptionPrompts.UserAlreadyAdmin));
                break;
            case 10:
                System.out.println(pd.getUserOptionPrompt(PromptDictionary.userOptionPrompts.AskDeleteName));
                break;
            case 11:
                System.out.println(pd.getUserOptionPrompt(PromptDictionary.userOptionPrompts.DeleteUserFailed));
                break;
            case 12:
                System.out.println(pd.getUserOptionPrompt(PromptDictionary.userOptionPrompts.DeleteAlreadyAdmin));
                break;
            case 13:
                System.out.println(pd.getUserOptionPrompt(PromptDictionary.userOptionPrompts.DeleteUserSuccess));
                break;
            case 14:
                System.out.println(pd.getUserOptionPrompt(PromptDictionary.userOptionPrompts.CreateAdminSuccess));
            default:
                break;
        }
    }


    /**
     * A helper method for prompts to ask for a String to input into further arguments for program use.
     * @param arg the desired attribute that prompts a user input.
     * @return the user's response to the prompt.
     */
    public String askForString(String arg){
        System.out.printf(arg);
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    /**
     * A helper method for prompts to ask for an integer to input into further arguments for program use.
     * @param arg the desired attribute that prompts a user input.
     * @return the user's response to the prompt.
     */
    public int askForInt(String arg){
        System.out.printf(arg);
        Scanner s = new Scanner(System.in);
        int val;
        try{
            val = s.nextInt();
        }
        catch (InputMismatchException e){
            val = askForInt(arg);
        }
        while (val>5 || val<1){
            System.out.printf(pd.getMainPrompt(PromptDictionary.mainPrompts.IntegerOutOfRange));
            val = askForInt(arg);
        }
        return val;
    }

    /**
     * A helper method for prompts to ask for a Boolean to input into further arguments for program use.
     * @param arg the desired attribute that prompts a user input.
     * @return the user's response to the prompt.
     */
    public boolean askForBool(String arg){
        System.out.printf(arg);
        Scanner sc = new Scanner(System.in);
        Boolean s = null;
        try{
            s = sc.nextBoolean();
        }
        catch (InputMismatchException e){
            System.out.println(pd.getMainPrompt(PromptDictionary.mainPrompts.NonBooleanMismatch));
            s = askForBool(arg);
            
        }
        return s;

    }

    /**
     * Review controller responses to the user's command for a review. Options can include
     * deletion, upvoting, downvoting, and editing the review.
     * @param choice the review data manipulation command choice.
     */
    public void reviewController(int choice){
        switch(choice){
            case(1):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.DeleteSuccess));
                break;
            case(2):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.DeleteFailed));
                break;
            case(3):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.UpvoteSuccess));
                break;
            case(4):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.UpvoteExists));
                break;
            case(5):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.DownvoteSuccess));
                break;
            case(6):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.DownvoteExists));
                break;
            case(7):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.UpvoteNonExistentReview));
                break;
            case(8):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.DownvoteNonExistentReview));
                break;
            case(9):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.ChangeCommentSuccess));
                break;
            case(10):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.ChangeORSuccess));
                break;
            case(11):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.ChangeAttendance));
                break;
            case(12):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.ChangeClarityLvl));
                break;
            case(13):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.ChangeCleanLvl));
                break;
            case(14):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.ChangeConven));
                break;
            case(15):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.ChangeCourseName));
                break;
            case(16):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.ChangeCourseCode));
                break;
            case(17):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.ChangeDiffLvl));
                break;
            case(18):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.ChangeProfName));
                break;
            case(19):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.ChangeIsApp));
                break;
            case(20):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.ChangeIsIncl));
                break;
            case(21):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.ChangeIsPart));
                break;
            case(22):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.ChangeIsTheo));
                break;
            case(23):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.ChangeRA));
                break;
            case(24):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.ChangeFood));
                break;
            case(25):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.ChangeWifi));
                break;
            case(26):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.ChangeDormName));
                break;
            case(27):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.ChangeEngLvl));
                break;
            case(28):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.ChangeSocialLvl));
                break;
            case(29):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.ChangeSoundLvl));
                break;
            case(30):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.ChangeTxtbook));
                break;
            case(31):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.ChangeWorkloadLvl));
                break;
            case(32):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.EditReviewSuccess));
                break;
            case(33):
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.EditReviewFailed));
                break;

        }

    }

    /**
     * ProfileController responses for the user's command to browse or edit their profile.
     * @param choice the user's command choice prompted from the menu provided to them.
     */
    public void profileController(int choice){
        switch(choice){
            case(1):
                System.out.println(pd.getMainPrompt(PromptDictionary.mainPrompts.ChangeNameSuccess));
                break;
            case(2):
                System.out.println(pd.getMainPrompt(PromptDictionary.mainPrompts.NewNameExists));
                break;
            case(3):
                System.out.println(pd.getMainPrompt(PromptDictionary.mainPrompts.ChangeEmailSuccess));
                break;
            case(4):
                System.out.println(pd.getMainPrompt(PromptDictionary.mainPrompts.ChangeYearSuccess));
                break;

        }
    }

    /**
     * A general message for browse prompts.
     * @param arg the particular browsing category desired by the user.
     */
    public void displayMessage(String arg) {
        switch(arg) {
            case "universities":
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.BrowseUniversities));
                break;
            case "professors":
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.BrowseProfReview));
                break;
            case "dorms":
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.BrowseDormReview));
                break;
            case "courses":
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.BrowseCourseReview));
                break;

        }

    }

    /**
     * Displays a message to prompt users to browse for different review types.
     * @param arg the user's command choice from the given command prompt.
     */
    public void displayMessageDifferentTypeEntity(String arg) {
        switch(arg) {
            case "1":
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.BrowseProfReviewInUni));
                break;
            case "2":
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.BrowseDormReviewInUni));
                break;
            case "3":
                System.out.println(pd.getReviewPrompt(PromptDictionary.reviewPrompts.BrowseCourseReviewInUni));
                break;

        }

    }

    /**
     * Provides a prompt dictionary in the desired language to respond with user commands.
     * @return a PromptDictionary in a preferred language with appropriate responses.
     */
    public PromptDictionary getPromptDictionary(){
        return pd;
    }
}
