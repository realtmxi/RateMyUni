package ControllerPresenter;


import ReviewSystem.DormSystem.*;
import ReviewSystem.CourseSystem.*;
import ReviewSystem.ProfessorSystem.*;
import ReviewSystem.*;
import ReviewSystem.UniversitySystem.UniversityManager;
import UserProfileSystem.ProfileSystem.*;
import UserProfileSystem.UserSystem.*;
import ControllerPresenter.Dictionaries.*;

/**
 * A controller class that is responsible for taking user input in review-related features such as edit, upvote/downvote,
 * and delete review.
 */
public class ReviewController {

    private final UIPresenter rp;
    private final User currentUser;
    private final ProfileManager fm;

    private final ProfessorReviewManager pm;
    private final CourseReviewManager cm;
    private final DormReviewManager dm;
    private final UserManager um;
    private final UniversityManager unim;

    private final PromptDictionary pd;


    /**
     * Initializing a ReviewController object.
     *
     * @param currentUser the user that is currently logged in
     * @param um UserManager
     * @param fm ProfileManager
     * @param pm ProfessorReviewManager
     * @param cm CourseReviewManager
     * @param dm DormReviewManager
     * @param rp UIPresenter
     */
    public ReviewController(User currentUser, UserManager um, ProfileManager fm, ProfessorReviewManager pm, CourseReviewManager cm, DormReviewManager dm, UIPresenter rp, UniversityManager unim) {
        this.currentUser = currentUser;
        this.fm = fm;
        this.cm = cm;
        this.pm = pm;
        this.dm = dm;
        this.um = um;
        this.rp = rp;
        this.pd = rp.getPromptDictionary();
        this.unim =unim;

    }

    /**
     * phase1.User could upvote, downvote the reviewing.
     * If user has already upvoted/downvoted this review, then it can't be upvote again.
     * phase1.User could undo the upvote/downvote and downvote/upvote it conversely.
     *
     * @param rm      reviewManager
     * @param ID      a review of the id
     * @param voteDir decide to upvote or downvote the review
     */
    public void voteReview(ReviewManager rm, String ID, String voteDir) {
        Profile p = um.getUserProfile(currentUser);
        if (voteDir.equals("upvote")) {
            if (fm.getUpvotedReviews(p).contains(ID)) {
                //if user has already upvoted this review, then it can't upvote again
                rp.reviewController(4);
                return;
            }
            boolean result = rm.upvote(ID);
            if (result) {
                rp.reviewController(3);
                if (fm.getDownvotedReviews(p).contains(ID)) {
                    //undo the downvote if we decide to upvote this review
                    rm.undoDownvote(ID);
                }
                fm.updateUpvotedReviews(p, ID);
            } else {
                rp.reviewController(7);

            }
        } else if (voteDir.equals("downvote")) {
            if (fm.getDownvotedReviews(p).contains(ID)) {
                //if user has already downvoted this review, then it can't downvote again
                rp.reviewController(6);
                return;
            }
            boolean result = rm.downvote(ID);
            if (result) {
                rp.reviewController(5);
                if (fm.getUpvotedReviews(p).contains(ID)) {
                    //undo the upvote if we decide to upvote this review
                    rm.undoUpvote(ID);
                }
                fm.updateDownvotedReviews(p, ID);
            } else {
                rp.reviewController(8);

            }
        }
    }


    /**
     * Delete the review(professor review, course review or dormitory review).
     */
    public void deleteReview() {
        String username = um.getUserName(currentUser);
        Profile p = um.getUserProfile(currentUser);
        rp.getPromptDictionary().getMainPrompt(PromptDictionary.mainPrompts.GiveReviewIDList);
        fm.displayReviewIDsForDelete(username);
        String ID = rp.askForString(rp.getPromptDictionary().getMainPrompt(PromptDictionary.mainPrompts.AskReviewID));
        if (fm.getReviewsLeftIDs(p).contains(ID) || um.checkUserIsAdmin(currentUser)) {
            if (ID.contains("PR")) {
                ProfessorReview r = pm.getReviewByID(ID);
                if (r != null) {
                    String uniName = pm.getUniName(ID);
                    Professor prof = unim.getProfessorInCertainUniByName(uniName,r.getProfName());
                    pm.deleteReview(ID,prof);
                    fm.deleteFromProfileReviews(currentUser.getUserName(), r);
                }
                displayDeleteResult(r != null);

            } else if (ID.contains("CR")) {
                CourseReview r = cm.getReviewByID(ID);
                if (r != null) {
                    String uniName = cm.getUniName(ID);
                    Course course = unim.getCourseInCertainUniByName(uniName,r.getCourseCode());
                    cm.deleteReview(ID, course);
                    fm.deleteFromProfileReviews(currentUser.getUserName(), r);
                }
                displayDeleteResult(r != null);

            } else if (ID.contains("DR")) {
                DormReview r = dm.getReviewByID(ID);
                if (r != null) {
                    String uniName = dm.getUniName(ID);
                    Dorm dorm = unim.getDormInCertainUniByName(uniName,r.getDormName());
                    dm.deleteReview(ID, dorm);
                    fm.deleteFromProfileReviews(currentUser.getUserName(), r);
                }
                displayDeleteResult(r != null);
            } else {
                rp.reviewController(2);
            }


        } else {
            rp.reviewController(2);
        }
    }

    private void displayDeleteResult(boolean b) {
        if (b){
            rp.reviewController(1);
        }
        else{
            rp.reviewController(2);
        }
    }

    /**
     * display the result of the operations about the review.
     * If true displays that "Review successfully deleted!"
     * Otherwise, displaying that "You either don't have access to delete this review or review doesn't exist."
     *
     * @param res true/false
     */
    private void displayEditResult(boolean res) {
        if (res) {
            rp.reviewController(32);
        } else {
            rp.reviewController(33);
        }
    }

    /**
     * Allows users to choose a Review they have left and edit any review category of this review
     */
    public void editReview() {
        String username = um.getUserName(currentUser);
        Profile p = um.getUserProfile(currentUser);
        rp.getPromptDictionary().getMainPrompt(PromptDictionary.mainPrompts.GiveReviewIDList);
        fm.displayReviewIDsForEdit(username);
        String ID = rp.askForString(rp.getPromptDictionary().getMainPrompt(PromptDictionary.mainPrompts.AskReviewID));
        if (fm.getReviewsLeftIDs(p).contains(ID)) {
            if (ID.contains("PR")) {
                ProfessorReview r = pm.getReviewByID(ID);
                if (r!=null) {
                    boolean editing = true;
                    while (editing) {
                        String c = rp.askForString(pd.getMenu(PromptDictionary.Menu.EditProfReviewMenu));
                        editing = editProfHelper(c, r, pm, ID);

                    }
                }
                displayEditResult(r != null);

            } else if (ID.contains("CR")) {
                CourseReview r = cm.getReviewByID(ID);
                if (r != null) {
                    boolean editing = true;
                    while (editing) {
                        String c = rp.askForString(pd.getMenu(PromptDictionary.Menu.EditCourseReviewMenu));
                        editing = editCourseHelper(c, r, cm, ID);
                    }
                }
                displayEditResult(r != null);

            } else if (ID.contains("DR")) {
                DormReview r = dm.getReviewByID(ID);

                if (r != null) {
                    boolean editing = true;
                    while (editing) {
                        String c = rp.askForString(pd.getMenu(PromptDictionary.Menu.EditDormReviewMenu));
                        editing = editDormHelper(c, r, dm, ID);
                    }
                }
                displayEditResult(r != null);
            } else {
                rp.reviewController(33);
            }

        }
        else{
            rp.reviewController(33);
        }
    }


    /**
     * This method takes in the user's choice and edits the relevant review category for a DormReview
     * @param c the review category chosen by the user to edit
     * @param dr the dorm review to be edited
     * @param rm the DormReviewManager responsible for editing the review category
     * @param ID the ID of this DormReview
     * @return a boolean indicating whether the user still wants to edit more review categories
     */
    private boolean editDormHelper(String c, DormReview dr, DormReviewManager rm, String ID) {
        boolean editing = true;
        switch (c) {
            case "1":
                int newCleanLvl = rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewCleanLvl));
                rm.editRating("Cleanliness", String.valueOf(newCleanLvl), ID, dr, unim);
                rp.reviewController(13);
                break;
            case "2":
                int newSocialLvl = rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewSocialLvl));
                rm.editRating("Social Level", String.valueOf(newSocialLvl), ID, dr, unim);
                rp.reviewController(28);
                break;
            case "3":
                int newSoundLvl = rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewSoundLvl));
                rm.editRating("Soundproof", String.valueOf(newSoundLvl), ID, dr, unim);
                rp.reviewController(29);
                break;
            case "4":
                int newRArating = rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewRA));
                rm.editRating("RA", String.valueOf(newRArating), ID, dr, unim);

                rp.reviewController(23);
                break;
            case "5":
                int newFoodRating = rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewFood));
                rm.editRating("Food", String.valueOf(newFoodRating), ID, dr, unim);
                rp.reviewController(24);
                break;
            case "6":
                int newConvenLvl = rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewConven));
                rm.editRating("Convenience", String.valueOf(newConvenLvl), ID, dr, unim);
                rp.reviewController(14);
                break;
            case "7":
                int newWifiLvl = rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewWifi));
                rm.editRating("WiFi", String.valueOf(newWifiLvl), ID, dr, unim);
                rp.reviewController(25);
                break;
            case "8":
                int newOverallRating = rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewOverallrating));
                rm.editRating("Overall Rating", String.valueOf(newOverallRating), ID, dr, unim);
                rp.reviewController(10);
                break;
            case "9":
                String newComment = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewComment));
                rm.editComment(ID, newComment);
                rp.reviewController(9);
                break;
            case "10":
                editing = false;
                break;
            default:
                break;

        }
        return editing;
    }


    /**
     * This method takes in the user's choice and edits the relevant review category for a CourseReview
     * @param c the review category chosen by the user to edit
     * @param cr the course review to be edited
     * @param rm the CourseReviewManager responsible for editing the review category
     * @param ID the ID of this CourseReview
     * @return a boolean indicating whether the user wants to edit more review categories
     */
    private boolean editCourseHelper(String c, CourseReview cr, CourseReviewManager rm, String ID) {
        boolean editing = true;
            switch (c) {
                case "1":
                    int newDiffLvl = rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewDiffLvl));
                    rm.editRating("Difficulty", String.valueOf(newDiffLvl), ID, cr, unim);
                    rp.reviewController(17);
                    break;
                case "2":
                    int newWorkloadLvl = rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewDiffLvl));
                    rm.editRating("Workload", String.valueOf(newWorkloadLvl), ID, cr, unim);
                    rp.reviewController(31);
                    break;
                case "3":
                    boolean newPart = rp.askForBool(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewPart));
                    rm.editRating("Participation", String.valueOf(newPart), ID, cr, unim);
                    rp.reviewController(21);
                    break;
                case "4":
                    boolean newTheo = rp.askForBool(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewTheo));
                    rm.editRating("Theoretical", String.valueOf(newTheo), ID, cr, unim);
                    rp.reviewController(22);
                    break;
                case "5":
                    boolean newApp = rp.askForBool(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewApp));
                    rm.editRating("Applicable", String.valueOf(newApp), ID, cr, unim);
                    rp.reviewController(19);
                    break;
                case "6":
                    boolean newInclu = rp.askForBool(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewIncl));
                    rm.editRating("Inclusive", String.valueOf(newInclu), ID, cr, unim);
                    rp.reviewController(20);
                    break;
                case "7":
                    int newOverallrating = rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewOverallrating));
                    rm.editRating("Overall Rating", String.valueOf(newOverallrating), ID, cr, unim);
                    rp.reviewController(10);
                    break;
                case "8":
                    String newComment = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewComment));
                    rm.editComment(ID, newComment);
                    rp.reviewController(9);
                    break;
                case "9":
                    editing = false;
                    break;
                default:
                    break;


        }
        return editing;
    }

    /**
     * This method takes in the user's choice and edits the relevant review category for a ProfessorReview
     * @param c the review category chosen by the user to edit
     * @param pr the professor review to be edited
     * @param rm the ProfessorReviewManager responsible for editing the review category
     * @param ID the ID of this ProfessorReview
     * @return a boolean indicating whether the user still wants to edit more review categories
     */
    private boolean editProfHelper(String c, ProfessorReview pr, ProfessorReviewManager rm, String ID) {
            boolean retval = true;
            switch (c) {
                case "1":
                    String newCourseName = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewCouseName));
                    rm.editCourseName(pr, newCourseName);
                    rp.reviewController(15);
                    break;
                case "2":
                    int newDiffLvl = rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewDiffLvl));
                    rm.editRating("Difficulty", String.valueOf(newDiffLvl), ID, pr, unim);
                    rp.reviewController(17);
                    break;
                case "3":
                    int newClarityLvl = rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewClarityLvl));
                    rm.editRating("Clarity", String.valueOf(newClarityLvl), ID, pr, unim);
                    rp.reviewController(12);
                    break;
                case "4":
                    int newEngLvl = rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewEngLvl));
                    rm.editRating("Engagement", String.valueOf(newEngLvl), ID, pr, unim);
                    rp.reviewController(27);
                    break;
                case "5":
                    boolean newAttendance = rp.askForBool(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewAttendance));
                    rm.editRating("Attendance", String.valueOf(newAttendance), ID, pr, unim);
                    rp.reviewController(11);
                    break;
                case "6":
                    boolean newTextbook = rp.askForBool(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewTxtbook));
                    rm.editRating("Textbook", String.valueOf(newTextbook), ID, pr, unim);
                    rp.reviewController(30);
                    break;
                case "7":
                    int newOverallrating = rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewOverallrating));
                    rm.editRating("Overall Rating", String.valueOf(newOverallrating), ID, pr, unim);
                    rp.reviewController(10);
                    break;
                case "8":
                    String newComment = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.GetNewComment));
                    rm.editComment(ID, newComment);
                    rp.reviewController(9);
                    break;
                case "9":
                    retval = false;
                    break;
                default:
                    break;
            }
            return retval;

        }

}










