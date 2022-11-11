package ControllerPresenter;//import phase1.Presenter;


import ControllerPresenter.Dictionaries.PromptDictionary;

/**
 * Manages the presentation of the log in commands and user interactions along with the LogInController.
 */
public class LogInPresenter extends Presenter {


    /**
     * Initializes a LogInPresenter that prints out log-in/sign-up related prompts in the chosen language
     * @param pd the appropriate PromptDictionary (English or Chinese)
     */
    public LogInPresenter(PromptDictionary pd){
        super(pd);
    }


    /**
     * Log-in related prompts
     * @param cmd an integer representing the desired log-in prompt to be printed
     */
    public void logIn(int cmd){
        switch (cmd) {
            case 1:
                System.out.println((pd.getLogInPrompt(PromptDictionary.LogInPrompts.LogInSuccess)));
                break;
            case 2:
                System.out.println((pd.getLogInPrompt(PromptDictionary.LogInPrompts.UserNameOrPasswordIncorrect)));
                break;
            case 3:
                System.out.println((pd.getLogInPrompt(PromptDictionary.LogInPrompts.UserBanned)));
                break;
            case 4:
                System.out.println(pd.getLogInPrompt(PromptDictionary.LogInPrompts.UserAlreadyLoggedIn));
                break;
            case 5:
                System.out.println(pd.getLogInPrompt(PromptDictionary.LogInPrompts.GetUsername));
                break;
            case 6:
                System.out.println(pd.getLogInPrompt(PromptDictionary.LogInPrompts.GetPassword));
                break;
            case 7:
                System.out.println(pd.getLogInPrompt(PromptDictionary.LogInPrompts.UserNotExists));
                break;
            default:
                break;
        }
    }


    /**
     * Sign-up related prompts
     * @param cmd an integer representing the desired sign-up related prompt to be printed
     */
    public void signUp(int cmd){
        switch(cmd){
            case 1:
                //sign up successful
                System.out.println(pd.getLogInPrompt(PromptDictionary.LogInPrompts.SignUpSuccessful));
                break;
            case 2:
                //sign up failed, user already exists
                System.out.println(pd.getLogInPrompt(PromptDictionary.LogInPrompts.UserExists));
                break;
            case 3://get username for sign up
                System.out.println(pd.getLogInPrompt(PromptDictionary.LogInPrompts.GetUsernameSignUp));
                break;
            case 4://get password for sign up
                System.out.println(pd.getLogInPrompt(PromptDictionary.LogInPrompts.GetPasswordSignUp));
                break;
            default:
                break;
        }
    }

    /**
     * Prints out other prompts needed by the LogInController when asking user inputs
     * @param cmd an integer representing the desired LogInController-related prompt to be printed
     */
    public void logInController(int cmd) {
        switch (cmd) {
            case 1:
                System.out.println(pd.getLogInPrompt(PromptDictionary.LogInPrompts.AskQuit));
                break;
            case 2:
                System.out.println(pd.getLogInPrompt(PromptDictionary.LogInPrompts.AskLogInOrCreateAccount));
                break;
        }
    }

    /**
     * Prints out the log-out successful message to user end
     */
    public void logOutSuccessful(){
        System.out.println(pd.getLogInPrompt(PromptDictionary.LogInPrompts.LogOutSuccess));
    }


}
