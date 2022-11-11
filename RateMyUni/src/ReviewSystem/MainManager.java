package ReviewSystem;

import ReviewSystem.CourseSystem.CourseReviewManager;
import ReviewSystem.DormSystem.DormReviewManager;
import ReviewSystem.ProfessorSystem.ProfessorReviewManager;
import ReviewSystem.UniversitySystem.UniversityManager;
import UserProfileSystem.UserSystem.UserManager;

import java.io.Serializable;

public class MainManager implements Serializable {

    private CourseReviewManager courseReviewManager;
    private DormReviewManager dormReviewManager;
    private ProfessorReviewManager professorReviewManager;

    private UserManager userManager;

    private UniversityManager universityManager;
    public MainManager(){
        courseReviewManager = new CourseReviewManager();
        dormReviewManager = new DormReviewManager();
        professorReviewManager = new ProfessorReviewManager();
        userManager = new UserManager();

        universityManager = new UniversityManager();
    }

    public CourseReviewManager getCourseReviewManager() {
        return courseReviewManager;
    }


    public DormReviewManager getDormReviewManager() {
        return dormReviewManager;
    }


    public ProfessorReviewManager getProfessorReviewManager() {
        return professorReviewManager;
    }


    public UserManager getUserManager() {
        return userManager;
    }


    public UniversityManager getUniversityManager(){
        return universityManager;
    }


}
