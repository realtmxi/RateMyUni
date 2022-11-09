package ControllerPresenter;

import ControllerPresenter.Dictionaries.PromptDictionary;
import UserProfileSystem.UserSystem.*;

/**
 * Managers the user commands to log in to the RateMyUni domain.
 */
public class LogInController {

    private final LogInPresenter p;
    private final UserController uc;


    public LogInController(PromptDictionary pd){
        p = new LogInPresenter(pd);
        uc = new UserController(pd);
    }
    /**
     * Running the LogInCreateAccountDisplay.
     * @param um a private UserManger initialized in phase1.LogInController class
     * @return LogInCreateAccountDisplay()
     */
    public User run(UserManager um){
        return LogInCreateAccountDisplay(p, uc, um); //returns the user created

    }

    /**
     * Display a UI interface about LogInCreateAccount
     * @param p phase1.LogInPresenter to present messages
     * @param uc a private phase1.UserController initialized in phase1.LogInController class
     * @param um a private phase1.UserManager initialized in phase1.LogInController class
     * @return phase1.User
     */
    public static User LogInCreateAccountDisplay(LogInPresenter p, UserController uc, UserManager um) {
        User user = null;
        while (user == null) {
            p.logInController(2);
            String choice = p.getStringChoice();
            if (choice.equals("1")) {
                user = UserLogIn(p, uc, um);
            }
            else if (choice.equals("2")){
                user = CreateUser(p, uc, um);
            }
            else {p.invalidChoice();}
        }
        return user;
    }


    /**
     * Display the UserLogIn UI interface.
     * @param p phase1.LogInPresenter to present messages
     * @param uc a private phase1.UserController initialized in phase1.LogInController class
     * @param um a private phase1.UserManager initialized in phase1.LogInController class
     * @return phase1.UserController.logIn
     */

    public static User UserLogIn (LogInPresenter p, UserController uc, UserManager um){
        p.logIn(5);
        String username = p.getStringChoice();
        p.logIn(6);
        String password = p.getStringChoice();
        return uc.logIn(um, username, password);

    }

    /**
     * Display the choice of UI when trying to create a user.
     * @param p phase1.LogInPresenter to present messages
     * @param uc a private phase1.UserController initialized in phase1.LogInController class
     * @param um a private phase1.UserManager initialized in phase1.LogInController class
     * @return the return value of userController.createAccount(um, username, password)
     */
    public static User CreateUser (LogInPresenter p, UserController uc, UserManager um){
        p.signUp(3);
        String username = p.getStringChoice();
        p.signUp(4);
        String password = p.getStringChoice();
        return uc.createAccount(um, username, password);
    }

}



