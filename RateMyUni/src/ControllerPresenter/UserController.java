package ControllerPresenter;

import ControllerPresenter.Dictionaries.*;
import UserProfileSystem.UserSystem.User;
import UserProfileSystem.UserSystem.UserManager;

import java.time.LocalDateTime;
import java.util.Optional;


public class UserController {

    public LogInPresenter presenter;

    public UserController(PromptDictionary pd) {
        this.presenter = new LogInPresenter(pd);
    }

    /**
     * If successfully create a user account, adding the user to history, the user would automatically log in.
     * Otherwise, the presenter would tell you log in instead of sign up and return null.
     *
     * @param userManager
     * @param username
     * @param password
     * @return If the user never sign up, return the username of the sign up user; otherwise, return null.
     */
    public User createAccount(UserManager userManager, String username, String password) {
        if (userManager.addUser(username, password)) {
            presenter.signUp(1);
            userManager.addToHistory(userManager.getUser(username));
            userManager.changeUserStatus(userManager.getUser(username));
            //automatically logs the user in
            return userManager.getUser(username);
        } else {
            presenter.signUp(2);
            return null;
        }
    }


    /**
     * Log in the user by the given username and password. If the username and password are both
     * correct, and the user is not banned or already logged in, the user would log in successfully.
     * Otherwise, presenter would leave messages respectively.
     *
     * @param um       phase1.UserManager
     * @param username
     * @param password
     * @return If the user successfully log in or already log in, return the username.
     * Otherwise, return null.
     */
    public User logIn(UserManager um, String username, String password) {
        if (um.checkLogInInfo(username, password)) {
            // username and password are correct inputs
            User found_user = um.getUser(username);
            Optional<LocalDateTime> banned_time = found_user.getBanEndTime();
            if (banned_time.isEmpty()) {
                if (!um.checkUserOnline(found_user)) {
                    um.changeUserStatus(found_user);
                    um.addToHistory(found_user);
                    this.presenter.logIn(1);

                } else {
                    this.presenter.logIn(4);
                }
                return found_user;
            } else {
                this.presenter.logIn(3);
                return null;
            }
        } else {
            // username and password is wrong
            this.presenter.logIn(2);
            return null;
        }
    }

    /**
     * Log out the user.
     *
     * @param userManager
     * @param user
     */
    public void logOut(UserManager userManager, User user) {
        userManager.changeUserStatus(user);
        presenter.logOutSuccessful();
    }

    /**
     * check whether the user is an admin.
     *
     * @param userManager
     * @param username
     * @return true if the user is an admin user; otherwise, return false
     */
    public boolean CheckAdminStatus(UserManager userManager, String username) {
        return userManager.getUser(username).isAdmin();
    }
}
