package ControllerPresenter;


import ControllerPresenter.Dictionaries.*;
import ReviewSystem.CourseSystem.*;
import ReviewSystem.DormSystem.*;
import ReviewSystem.ProfessorSystem.*;
import UserProfileSystem.UserSystem.*;
import UserProfileSystem.ProfileSystem.*;
import ReviewSystem.*;


/**
 * A Controller class that takes user input for profile-related features such as view and edit profile
 */
public class ProfileController {

    UIPresenter ui;
    PromptDictionary pd;
    PrintFormatter pf;
    public ProfileController(UIPresenter ui){
        this.ui = ui;
        this.pd = ui.getPromptDictionary();
        pf = new PrintFormatter(pd);
    }

    /**
     * Viewing the user profile(graduating year, email, upvoted reviews)
     * and reviews of the user.
     * @param u the User who would like to view
     * @param um UserManager
     * @param fm ProfileManager
     */

    public void viewUserProfile(User u, UserManager um, ProfileManager fm, CourseReviewManager cm, ProfessorReviewManager pm, DormReviewManager dm){
        Profile p = fm.findProfileByName(um.getUserName(u));
        pf.printProfile(p,fm);


        for (Review r: fm.getReviewsLeft(p)){
            if (r.getID().contains("CR")) {
                pf.printCourseReview((CourseReview) r, cm);
            }
            else if (r.getID().contains("PR")){
                pf.printProfReview((ProfessorReview) r, pm);
                }
            else if (r.getID().contains("DR")){
                pf.printDormReview((DormReview) r, dm);
            }


        }

    }

    /**
     * asks whether the user wants to edit each attribute one at a time, if they do, then reset those attributes.
     * Otherwise, do nothing.
     * @param u the user that would like to edit
     * @param um UserManger
     * @param fm ProfileManager
     */
    public void editUserProfile(User u, UserManager um, ProfileManager fm){
        boolean notSelected = true;
        while (notSelected){
            String choice = ui.askForString(pd.getMenu(PromptDictionary.Menu.EditProfileMenu));
            switch (choice){
                case "1":
                    String newYear = ui.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewYear));
                    fm.editYear(um.getUserName(u),newYear);
                    ui.profileController(4);
                    break;
                case "2":
                    String newEmail = ui.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewEmail));
                    fm.editEmail(um.getUserName(u),newEmail);
                    ui.profileController(3);
                    break;
                case "3":
                    String newName = ui.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewName));
                    if (!um.checkIfNameExists(newName)) {
                        fm.editName(um.getUserName(u), newName);
                        um.changeName(u, newName);
                        ui.profileController(1);
                    }
                    else{
                        ui.profileController(2);

                    }
                    break;
                case "4":
                    notSelected = false;
                    break;
                default:
                    break;
            }
        }




    }

}




