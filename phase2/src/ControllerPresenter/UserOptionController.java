package ControllerPresenter;

import UserProfileSystem.UserSystem.User;
import UserProfileSystem.UserSystem.UserManager;

public class UserOptionController {
    /**
     * The Display interface of user option menu.
     *
     * @param p    UIPresenter
     * @param uc   UserController
     * @param um   UserManager
     * @param user User
     */
    public void UserOptionsDisplay(UIPresenter p, UserController uc, UserManager um, User user) {
        boolean backToMain = false;
        boolean isAdmin = um.checkUserIsAdmin(user);
        while (!backToMain) {
            p.userOptionController(1);
            String choice = p.getStringChoice();
            if (choice.equals("1")) {
                System.out.println(um.getUserHistory(user));
            } else if (choice.equals("5")) {
                backToMain = true;
            } else if (isAdmin && choice.equals("2")) {
                p.userOptionController(2);
                String toBan = p.getStringChoice();
                User userToBan = um.getUser(toBan);
                if (userToBan != null && !um.checkUserIsAdmin(userToBan)) {
                    p.userOptionController(3);
                    long duration = p.getLongChoice();
                    boolean result = um.banUser(userToBan, duration);
                    if (result) {
                        p.userOptionController(4);
                    } else {
                        p.userOptionController(5);
                    }
                } else {
                    p.userOptionController(6);
                }
            } else if (isAdmin && choice.equals("3")) {
                p.userOptionController(7);
                String toMakeAdmin = p.getStringChoice();
                User userToMakeAdmin = um.getUser(toMakeAdmin);
                if (userToMakeAdmin != null && !um.checkUserIsAdmin(userToMakeAdmin)) {
                    um.makeUserAdmin(userToMakeAdmin);
                    p.userOptionController(14);
                } else if (userToMakeAdmin == null) {
                    p.userOptionController(8);
                } else if (userToMakeAdmin.isAdmin()) {
                    p.userOptionController(9);
                }
            } else if (isAdmin && choice.equals("4")) {
                p.userOptionController(10);
                String toDelete = p.getStringChoice();
                User userToDelete = um.getUser(toDelete);
                if (toDelete != null && !um.checkUserIsAdmin(userToDelete)) {
                    um.deleteUser(toDelete);
                    p.userOptionController(13);
                } else if (toDelete == null) {
                    p.userOptionController(11);
                } else if (uc.CheckAdminStatus(um, toDelete)) {
                    p.userOptionController(12);
                }
            } else {
                p.invalidChoice();
            }

        }
    }
}
