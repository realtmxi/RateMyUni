package ControllerPresenter;


import ControllerPresenter.Dictionaries.*;
import ReviewSystem.CourseSystem.*;
import ReviewSystem.DormSystem.*;
import ReviewSystem.MainManager;
import ReviewSystem.ProfessorSystem.*;
import ReviewSystem.Review;
import ReviewSystem.UniversitySystem.UniversityManager;
import Sorters.*;
import Sorters.SortByVotesComparator;
import UserProfileSystem.ProfileSystem.*;
import UserProfileSystem.UserSystem.*;



import java.util.HashMap;
import java.util.Comparator;
import java.util.Scanner;

/**
 * AppController manages the interactions between user commands and directing related Managers to create, manipulate or create data accordingly.
 * The AppController more specifically stores and delegates other Controllers to complete the directive calls to the Managers and responds to the user with calls to the relevant Presenters.
 */
public class AppController {

    private final User currentUser;

    private final UIPresenter rp;
    private final ProfileController pc;
    private final UserController uc;
    private final UserOptionController oc = new UserOptionController();
    private final ReviewController rc;
    private final UserManager um;
    private final ProfessorReviewManager pm;
    private final CourseReviewManager cm;
    private final DormReviewManager dm;
    private final ProfileManager fm;
    private final UniversityManager unim;
    private final PromptDictionary pd;
    private final PrintFormatter pf;


    /**
     * Initializes the AppController with provided MainManager, a user and a dictionary for responding interactions with the user.
     * @param mainManager a serialized main manager to create and delegate tasks relevant to ReviewManagers, a ProfileManager,
     * a UniversityManager, and a UserManager, as well as initializes relevant required controllers: UserController, Presenter,
     * ReviewController, ProfileController, and PrintFormatter.
     * @param currentUser the current user running the program.
     * @param pd the PromptDictionary with the user's preferred language to interact with the user's commands and corresponding program results.
     */
    public AppController(MainManager mainManager, User currentUser, PromptDictionary pd){
        this.um = mainManager.getUserManager();
        this.cm = mainManager.getCourseReviewManager();
        this.pm = mainManager.getProfessorReviewManager();
        this.dm = mainManager.getDormReviewManager();
        this.unim= mainManager.getUniversityManager();
        this.currentUser = currentUser;
        this.fm = um.getProfileManager();
        this.pd = pd;
        uc = new UserController(pd);
        rp = new UIPresenter(pd);
        rc = new ReviewController(currentUser,um,fm,pm,cm,dm,rp,unim);
        pc = new ProfileController(rp);
        pf = new PrintFormatter(pd);

    }

    /**
     * The main function in AppController that allows the user to run the program by providing them with prompts until they are ready to log out.
     */
    public void run(){
        boolean keepBrowsing = true;
        while (keepBrowsing){
            mainMenuPrompt();
            rp.AskQuitPrompt();
            Scanner s = new Scanner(System.in);
            String ans = s.nextLine();
            if (ans.equalsIgnoreCase("q")){
                keepBrowsing = false;

            }
        }
        uc.logOut(um,currentUser);

    }


    /**
     * Provides the user with options to browse reviewable profiles and their reviews, view and edit their own profile, sort reviews in a particular order,
     * and leave, edit or delete their own reviews and vote on all reviews available.
     */
    public void mainMenuPrompt(){

        rp.ReviewOrBrowsePrompt();
        Scanner s = new Scanner(System.in);
        String ans = s.nextLine();
        switch (ans) {
            case ("1"):
                displayProfessors();
                break;
            case ("2"):
                displayCourses();
                break;
            case ("3"):
                displayDorms();
                break;
            case ("4"):
                leaveProfReview();
                break;
            case ("5"):
                leaveCourseReview();
                break;
            case ("6"):
                leaveDormReview();
                break;
            case ("7"):
                chooseProfPrompt();
                break;
            case ("8"):
                chooseCoursePrompt();
                break;
            case ("9"):
                chooseDormPrompt();
                break;
            case ("10"):
                rc.deleteReview();
                break;
            case ("11"):
                rc.editReview();
            case ("12"):
                pc.viewUserProfile(currentUser, um, fm, cm, pm, dm);
                break;
            case ("13"):
                pc.editUserProfile(currentUser, um, fm);
                break;
            case ("14"):
                VotePrompt("upvote");
                break;
            case ("15"):
                VotePrompt("downvote");
                break;
            case ("16"):
                oc.UserOptionsDisplay(rp, uc, um, currentUser);
                break;
            case ("17"):
                displayAllUniversity();
                break;
            case ("18"):
                displayAllProfessorOrDormOrCourseInCertainUni();
                break;
            case("19"):
                Comparator<Review> comparator = sorterPrompt();
                sortAndDisplayByComparator(comparator);
                break;
            default:
                break;
        }
    }


    /**
     * Displays all university names in the system.
     */
    public void displayAllUniversity(){
        rp.displayMessage("universities");
        System.out.println(unim.getAllUniversityName());
    }

    /**
     * Displays all reviewable profiles in a particular desired university.
     */
    public void  displayAllProfessorOrDormOrCourseInCertainUni(){
        String uniName = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.WhichUni));
        if(!unim.whetherHaveUniversity(uniName)){
            universityNotFoundPrompt();
        }
        else {
            String type = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.WhichType));
            switch (type) {
                case ("1"):
                    rp.displayMessageDifferentTypeEntity("1");
                    for (Professor p: unim.getAllProfessorInCertainUni(uniName))
                        pf.printProf(p,pm);
                    break;
                case ("2"):
                    rp.displayMessageDifferentTypeEntity("2");
                    for (Dorm d: unim.getAllDormInCertainUni(uniName))
                        pf.printDorm(d, dm);
                    break;
                case ("3"):
                    rp.displayMessageDifferentTypeEntity("3");
                    for (Course c: unim.getAllCourseInCertainUni(uniName))
                        pf.printCourse(c, cm);
                    break;
                    }
            }
        }


    /**
     * Displays all Professor reviewable profiles.
     */
    public void displayProfessors() {
        rp.displayMessage("professors");
        for (Professor p : pm.getAllProfReviews().keySet()) {
            pf.printProf(p,pm);
        }
    }

    /**
     * Displays all Course reviewable profiles.
     */
    public void displayCourses() {
        rp.displayMessage("courses");
        for (Course c : cm.getAllCourseReviews().keySet()) {
            pf.printCourse(c,cm);
        }
    }

    /**
     * Displays all Dorm reviewable profiles.
     */
    public void displayDorms(){
        rp.displayMessage("dorms");
        for (Dorm d: dm.getAllDormReviews().keySet()){
            pf.printDorm(d,dm);
        }

    }


    /**
     * Allows a user to choose a particular Professor to browse or review.
     */
    public void chooseProfPrompt() {
        String uniName = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.WhichUniProf));
        if(unim.whetherHaveUniversity(uniName)) {
            String profName = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.WhichProf));
            if(unim.whetherCertainUniHaveProfessor(uniName,profName)){
                Professor Pro = unim.getProfessorInCertainUniByName(uniName,profName);
                for (ProfessorReview pr: pm.getListOfReviews(Pro)){
                    pf.printProfReview(pr, pm);
                }
            }
            else {
                profNotFoundPrompt();
            }
        }
        else {
            universityNotFoundPrompt();
        }
    }

    /**
     * Allows a user to choose a particular Course to browse or review.
     */
    public void chooseCoursePrompt() {
        String uniName = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.WhichUniCourse));
        if(unim.whetherHaveUniversity(uniName)) {
            String courseName = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.WhichCourse));
            if(unim.whetherCertainUniHaveCourse(uniName,courseName)){
                Course c = unim.getCourseInCertainUniByName(uniName,courseName);
                for (CourseReview cr: cm.getListOfReviews(c)){
                    pf.printCourseReview(cr, cm);
                }
            }
            else {
                courseNotFoundPrompt();
            }
        }
        else {
            universityNotFoundPrompt();
        }
    }

    /**
     * Allows a user to choose a particular Dorm to browse or review.
     */
    public void chooseDormPrompt(){
        String uniName = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.WhichUniDorm));
        if(unim.whetherHaveUniversity(uniName)) {
            String dormName = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.WhichDorm));
            if(unim.whetherCertainUniHaveDorm(uniName,dormName)){
                Dorm d = unim.getDormInCertainUniByName(uniName,dormName);
                for (DormReview dr: dm.getListOfReviews(d)){
                    pf.printDormReview(dr,dm);
                }
            }
            else {
                dormNotFoundPrompt();
            }
        }
        else {
            universityNotFoundPrompt();
        }
    }

    /**
     * Prompts a user to add a university if the university name they entered is not found in the system.
     */
    public void universityNotFoundPrompt(){
        String ans = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.UniNonExistent));
        if (ans.equals("1")){
            createUniProfile();
        }
    }

    /**
     * Prompts a user to add a dorm profile if the residence name they entered is not found in the system.
     */
    public void dormNotFoundPrompt(){
        String ans = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.DormNonExistent));
        if (ans.equals("1")){
            createDormProfile();
        }
    }

    /**
     * Prompts a user to add a professor profile if the professor name they entered is not found in the system.
     */
    public void profNotFoundPrompt(){
        String ans = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.ProfNonExistent));
        if (ans.equals("1")){
            createProfProfile();
        }
    }

    /**
     * Prompts a user to add a course profile if the course code they entered is not found in the system.
     */
    public void courseNotFoundPrompt(){
        String ans = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.CourseNonExistent));
        if (ans.equals("1")){
            createCourseProfile();
        }
    }

    /**
     * Allows a user to leave a ProfessorReview for a particular professor.
     */
    public void leaveProfReview(){
        String uniName = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.WhichUniProf));
        if(!unim.whetherHaveUniversity(uniName)){
            universityNotFoundPrompt();
            return;
        }
        String reviewer = um.getUserName(currentUser);
        HashMap<String,String> ratings = new HashMap<>();
        String profName = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.AskProfName));
        ratings.put("profName", profName);
        if (!unim.whetherCertainUniHaveProfessor(uniName, profName)) {
            profNotFoundPrompt();
            return;
        }
        Professor professor = unim.getProfessorInCertainUniByName(uniName, profName);
        ratings.put("Course Code", rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.AskProfCourse)));
        ratings.put("Overall Rating", String.valueOf(rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.AskOverallRating))));
        ratings.put("Comment", rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.AskForComment)));
        ratings.put("Difficulty", String.valueOf(rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.AskProfDifficulty))));
        ratings.put("Clarity", String.valueOf(rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.AskProfClarity))));
        ratings.put("Engagement", String.valueOf(rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.AskProfEngagement))));
        ratings.put("Attendance", String.valueOf(rp.askForBool(pd.getMainPrompt(PromptDictionary.mainPrompts.AskAttendance))));
        ratings.put("Textbook", String.valueOf(rp.askForBool(pd.getMainPrompt(PromptDictionary.mainPrompts.AskTextbook))));
        ratings.put("University",uniName);
        ProfessorReview pr = pm.addReview(ratings, reviewer, professor);
        fm.updateReviewsLeft(um.getUserProfile(currentUser), pr);
    }


    /**
     * Allows a user to leave a CourseReview for a particular course.
     */
    public void leaveCourseReview(){
        String uniName = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.WhichUniCourse));
        if(!unim.whetherHaveUniversity(uniName)){
            universityNotFoundPrompt();
            return;
        }
        String reviewer =  um.getUserName(currentUser);
        HashMap<String, String> review = new HashMap<>();
        String courseCode = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.AskCourseCode));
        review.put("Course Code", courseCode);
        if (!unim.whetherCertainUniHaveCourse(uniName,courseCode)){
            courseNotFoundPrompt();
            return;
        }
        Course c = unim.getCourseInCertainUniByName(uniName,courseCode);
        review.put("Overall Rating", String.valueOf(rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.AskOverallRating))));
        review.put("Comment", rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.AskForComment)));
        review.put("Difficulty", String.valueOf(rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.AskCourseDifficulty))));
        review.put("Workload", String.valueOf(rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.AskWorkload))));
        review.put("Participation", String.valueOf(rp.askForBool(pd.getMainPrompt(PromptDictionary.mainPrompts.AskParticipation))));
        review.put("Theoretical", String.valueOf(rp.askForBool(pd.getMainPrompt(PromptDictionary.mainPrompts.AskTheoretical))));
        review.put("Applicable", String.valueOf(rp.askForBool(pd.getMainPrompt(PromptDictionary.mainPrompts.AskApplied))));
        review.put("Inclusive", String.valueOf(rp.askForBool(pd.getMainPrompt(PromptDictionary.mainPrompts.AskInclusive))));
        review.put("University",uniName);
        CourseReview cr = cm.addReview(review, reviewer,c);
        fm.updateReviewsLeft(um.getUserProfile(currentUser),cr);
    }

    /**
     * Allows a user to leave a DormReview for a particular dorm.
     */
    public void leaveDormReview(){
        String uniName = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.WhichUniDorm));
        if (!unim.whetherHaveUniversity(uniName)){
            universityNotFoundPrompt();
            return;
        }
        HashMap<String, String> dR = new HashMap<>();
        String dormName = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.AskDormName));
        String reviewer =  um.getUserName(currentUser);
        dR.put("Residence Name", dormName);
        if (!unim.whetherCertainUniHaveDorm(uniName,dormName)) {
            dormNotFoundPrompt();
            return;
        }
        Dorm d = unim.getDormInCertainUniByName(uniName,dormName);
        dR.put("Overall Rating", String.valueOf(rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.AskOverallRating))));
        dR.put("Comment", rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.AskForComment)));
        dR.put("Cleanliness", String.valueOf(rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.AskCleanliness))));
        dR.put("Social Level", String.valueOf(rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.AskSocialness))));
        dR.put("Soundproof", String.valueOf(rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.AskSoundproof))));
        dR.put("RA", String.valueOf(rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.AskRA))));
        dR.put("Food", String.valueOf(rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.AskFood))));
        dR.put("Convenience", String.valueOf(rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.AskConvenience))));
        dR.put("WiFi", String.valueOf(rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.AskWifi))));
        dR.put("University",uniName);
        DormReview dr = dm.addReview(dR, reviewer,d);
        fm.updateReviewsLeft(um.getUserProfile(currentUser),dr);
    }


    /**
     * Creates and initializes a new dorm profile with all its relevant information.
     */
    public void createDormProfile(){
        String res = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.CreateDormName));
        String floor = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.CreateDormFloor));
        String uni = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.CreateDormUni));
        if (!unim.whetherHaveUniversity(uni)){
            universityNotFoundPrompt();
        }
        else {
            if(!unim.whetherCertainUniHaveDorm(uni,res)) {
                Dorm NewDorm = dm.createDorm(res, floor, uni);
                unim.addDormInCertainUni(uni,NewDorm);
            }
        }

    }

    /**
     * Creates and initializes a new professor profile with all its relevant information.
     */
    public void createProfProfile() {
        String name = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.CreateProfName));
        String dep = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.CreateProfDep));
        String uni = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.CreateProfUni));
        if (!unim.whetherHaveUniversity(uni)) {
            universityNotFoundPrompt();
        } else {
            if (!unim.whetherCertainUniHaveProfessor(uni, name)) {
                Professor newPro = pm.createProfessor(name, dep, uni);
                unim.addProfessorInCertainUni(uni, newPro);
            }
        }
    }


    /**
     * Creates and initializes a new university system to store Professors, Dorms and Courses with all its relevant information.
     */
    public void createUniProfile(){
        String name = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.CreateUniName));
        if(!unim.whetherHaveUniversity(name)){
            unim.createUniversityWithName(name);
        }
    }

    /**
     * Creates and initializes a new course profile with all its relevant information.
     */
    public void createCourseProfile(){
        String c = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.CreateCourseCode));
        String d = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.CreateCourseDep));
        String u = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.CreateCourseUni));
        if (!unim.whetherHaveUniversity(u)){
            universityNotFoundPrompt();

        }
        else {
            if(!unim.whetherCertainUniHaveCourse(u,c)) {
                Course newCourse = cm.createCourse(c, d, u);
                unim.addCourseInCertainUni(u,newCourse);
            }
        }

    }

    /**
     * Allows a user to upvote or downvote a particular review of their choice. This provides the user with the available reviews to be voted.
     * @param voteDir A String based on the user's input of upvote or downvote command.
     */
    public void VotePrompt(String voteDir){
            displayAllReviewIDs();
            String ID = rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.AskReviewID));
            if (ID.contains("PR")){
                rc.voteReview(pm,ID,voteDir);
            }
            else if (ID.contains("CR")){
                rc.voteReview(cm,ID,voteDir);
            }
            else if (ID.contains("DR")){
                rc.voteReview(dm,ID,voteDir);
            }
            else {
                rp.invalidChoice();
            }
        }

    /**
     * Displays all review IDs of all the reviews made in the system for a user to select from.
      */
    public void displayAllReviewIDs(){
        System.out.println(pd.getMainPrompt(PromptDictionary.mainPrompts.DisplayAllReviewIDs));
        pm.getAllIDs();
        dm.getAllIDs();
        cm.getAllIDs();
    }

    /**
     * Sorts and displays reviews by the particular comparison view the user desires.
     * @param comparator the selected comparison algorithm desired by the user.
     */
    public void sortAndDisplayByComparator(Comparator<Review> comparator){
        int choice = Integer.parseInt(rp.askForString(pd.getMainPrompt(PromptDictionary.mainPrompts.WhichCategory)));
        switch (choice) {
            case (1) :
                cm.sort(comparator);
                for (CourseReview cr: cm.getListOfAllCourseReviews()){
                    pf.printCourseReview(cr, cm);
                }

                break;

            case (2) :
                dm.sort(comparator);
                for (DormReview dr: dm.getListOfAllDormReviews()){
                    pf.printDormReview(dr, dm);
                }

                break;

            case(3) :
                pm.sort(comparator);
                for (ProfessorReview pr: pm.getListOfAllProfReviews()){
                    pf.printProfReview(pr, pm);
                }

                break;

        }

    }

    /**
     * Prompts the user to select a comparison sorter to organize and display the reviews by the desired view.
     * @return the order of the reviews displayed desired by the user.
     */
    public Comparator<Review> sorterPrompt() {
        int choice = rp.askForInt(pd.getMainPrompt(PromptDictionary.mainPrompts.HowToSortReviews));
        Comparator<Review> comparator = null;
        {
            switch (choice) {
                case (1): {
                    comparator = new SortByOverallRatingComparator();
                    break;
                }
                case (2): {
                    comparator = new SortByVotesComparator();
                    break;
                }
            }
            return comparator;
        }


    }
}
