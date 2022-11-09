package ControllerPresenter;


import ReviewSystem.CourseSystem.*;
import ReviewSystem.DormSystem.*;
import ReviewSystem.ProfessorSystem.*;
import ControllerPresenter.Dictionaries.*;
import UserProfileSystem.ProfileSystem.*;


/**
 * This is a presenter-like class that formats how the reviewable profiles and user profile are being presented
 */
public class PrintFormatter {

    private PromptDictionary pd;


    /**
     * initializes a PrintFormatter that prints and formats prof/course/dorm and their reviews in a clean, organized format
     * @param pd the appropriate PromptDictionary
     */
    public PrintFormatter(PromptDictionary pd){
        this.pd = pd;
    }


    /**
     * formats profile information and prints it in a clean, organized way
     * @param p Profile to be printed
     * @param fm ProfileManager that stores the Profile
     */
    public void printProfile(Profile p, ProfileManager fm){
        System.out.println(String.format(pd.getInfoPrompt(PromptDictionary.infoPrompts.profileInfo), fm.getAttribute("name",p),fm.getAttribute("year",p),
                fm.getAttribute("email",p),fm.getAttribute("upvoted",p)));
    }

    /**
     * formats a course profile and prints it in a clean, organized way
     * @param c Course to be printed
     * @param cm CourseReviewManager that stores the course
     */
    public void printCourse(Course c, CourseReviewManager cm){
        System.out.println(String.format(pd.getInfoPrompt(PromptDictionary.infoPrompts.courseInfo),cm.getCourseAttribute("course code",c),cm.getCourseAttribute("university",c),cm.getCourseAttribute("department",c),
                cm.getCourseAttribute("overall",c), cm.getCourseAttribute("difficulty",c),cm.getCourseAttribute("workload",c),
                cm.getCourseAttribute("theory",c),cm.getCourseAttribute("applied",c),cm.getCourseAttribute("inclusive",c)));
    }


    /**
     * formats a course review and prints it in a clean, organized way
     * @param cr Course review to be printed
     * @param cm CourseReviewManager that stores the CourseReview
     */
    public void printCourseReview(CourseReview cr, CourseReviewManager cm){
        System.out.println(String.format(pd.getInfoPrompt(PromptDictionary.infoPrompts.courseReviewInfo),cm.getCourseReviewAttribute("reviewer",cr),
                cm.getCourseReviewAttribute("timestamp",cr),cm.getCourseReviewAttribute("ID",cr),
                cm.getCourseReviewAttribute("course code",cr),cm.getCourseReviewAttribute("overall",cr),cm.getCourseReviewAttribute("comment",cr),
                cm.getCourseReviewAttribute("difficulty",cr),cm.getCourseReviewAttribute("workload",cr),cm.getCourseReviewAttribute("participation",cr),
                cm.getCourseReviewAttribute("theoretical",cr),cm.getCourseReviewAttribute("applicable",cr),cm.getCourseReviewAttribute("inclusive",cr),
                cm.getCourseReviewAttribute("upvotes",cr),cm.getCourseReviewAttribute("downvotes",cr)));
    }


    /**
     * @param p Professor to be printed
     * @param pm ProfessorReviewManager that stores the Professor
     */
    public void printProf(Professor p, ProfessorReviewManager pm){
        System.out.println(String.format(pd.getInfoPrompt(PromptDictionary.infoPrompts.profInfo),pm.getProfAttribute("name",p),
                pm.getProfAttribute("university",p),pm.getProfAttribute("department",p),pm.getProfAttribute("overall",p),
                pm.getProfAttribute("difficulty",p),pm.getProfAttribute("clarity",p),pm.getProfAttribute("engagement",p),
                pm.getProfAttribute("attendance",p),pm.getProfAttribute("textbook",p)));
    }


    /**
     * @param pr ProfessorReview to be printed
     * @param pm ProfessorReviewManager that stores the ProfessorReview
     */
    public void printProfReview(ProfessorReview pr, ProfessorReviewManager pm){
        System.out.println(String.format(pd.getInfoPrompt(PromptDictionary.infoPrompts.profReviewInfo),pm.getProfReviewAttribute("reviewer",pr),
                pm.getProfReviewAttribute("timestamp",pr),pm.getProfReviewAttribute("ID",pr),pm.getProfReviewAttribute("name",pr),
                pm.getProfReviewAttribute("course",pr),pm.getProfReviewAttribute("overall",pr),pm.getProfReviewAttribute("comment",pr),
                pm.getProfReviewAttribute("difficulty",pr),pm.getProfReviewAttribute("clarity",pr),pm.getProfReviewAttribute("engagement",pr),
                pm.getProfReviewAttribute("attendance",pr),pm.getProfReviewAttribute("textbook",pr),pm.getProfReviewAttribute("upvotes",pr),pm.getProfReviewAttribute("downvotes",pr)));

    }

    /**
     * @param d Dorm to be printed
     * @param dm DormReviewManager that stores this Dorm
     */
    public void printDorm(Dorm d, DormReviewManager dm){
        System.out.println(String.format(pd.getInfoPrompt(PromptDictionary.infoPrompts.dormInfo),dm.getDormAttribute("name",d),dm.getDormAttribute("university",d),
                dm.getDormAttribute("floor",d),dm.getDormAttribute("overall",d),dm.getDormAttribute("cleanliness",d),dm.getDormAttribute("social",d),
                dm.getDormAttribute("sound",d),dm.getDormAttribute("RA",d),dm.getDormAttribute("food",d),dm.getDormAttribute("convenience",d),
                dm.getDormAttribute("wifi",d)));

    }

    /**
     * @param dr DormReview to be printed
     * @param dm DormReviewManager that stores this DormReview
     */
    public void printDormReview(DormReview dr, DormReviewManager dm){
        System.out.println(String.format(pd.getInfoPrompt(PromptDictionary.infoPrompts.dormReviewInfo),dm.getDormReviewAttribute("reviewer",dr),
                dm.getDormReviewAttribute("timestamp",dr),dm.getDormReviewAttribute("ID",dr),dm.getDormReviewAttribute("name",dr),
                dm.getDormReviewAttribute("overall",dr),dm.getDormReviewAttribute("comment",dr),dm.getDormReviewAttribute("cleanliness",dr),
                dm.getDormReviewAttribute("social",dr),dm.getDormReviewAttribute("sound",dr),dm.getDormReviewAttribute("RA",dr),
                dm.getDormReviewAttribute("food",dr),dm.getDormReviewAttribute("convenience",dr),dm.getDormReviewAttribute("wifi",dr),
                dm.getDormReviewAttribute("upvotes",dr),dm.getDormReviewAttribute("downvotes",dr)));

    }





}
