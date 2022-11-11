package ReviewSystem.UniversitySystem;
import ReviewSystem.CourseSystem.Course;
import ReviewSystem.ProfessorSystem.Professor;
import ReviewSystem.DormSystem.Dorm;

import java.io.Serializable;
import java.util.HashMap;

/**
 * A university to hold all the related professors, courses, and dorms associated with it.
 */
public class University implements Serializable {
    /**
     * The University class is an entity for the RateMyUni domain. ir contain all professor and droms and course in this university
     * therefore university store the professor, dorm and course entities.
     */

    private final String universityName;
    private final HashMap<String,Professor> professors;
    private final HashMap<String,Dorm> dorms;
    private final HashMap<String,Course> courses;

    /**
     * Initializes the university with their name and empty hashmaps for professor, dorms and courses.
     * @param name the university name
     */
    public University(String name){
        universityName = name;
        professors = new HashMap<>();
        dorms = new HashMap<>();
        courses = new HashMap<>();
    }

    /**
     * Gets the university name.
     * @return A String of the university name.
     */
    public String getUniversityName(){
        return universityName;
    }

    /**
     * Gets courses associated with this university.
     * @return A map of courses associated with this university.
     */
    public HashMap<String,Course> getCourses() {
        return courses;
    }

    /**
     * Gets dorms associated with this university.
     * @return A map of dorms associated with this university.
     */
    public HashMap<String,Dorm> getDorms(){
        return dorms;
    }

    /**
     * Gets professors associated with this university.
     * @return A map of professors associated with this university.
     */
    public HashMap<String,Professor> getProfessors(){
        return professors;
    }

    /**
     * Gets a particular professor in a university.
     * @param professorName the professor's name.
     * @return A particular professor associated with this university.
     */
    public Professor getCertainProfessor(String professorName){
        if(professors.containsKey(professorName)){
            return professors.get(professorName);
        }
        for(String name: professors.keySet()){
            if(professorName.equalsIgnoreCase(name)){
                return professors.get(name);
            }
        }
        return null;
    }

    /**
     * Gets a particular course in a university.
     * @param courseCode the course code of the course.
     * @return A particular course associated with this university.
     */
    public Course getCertainCourse(String courseCode){
        if(courses.containsKey(courseCode)){
            return courses.get(courseCode);
        }
        for(String name: courses.keySet()){
            if(courseCode.equalsIgnoreCase(name)){
                return courses.get(name);
            }
        }
        return null;
    }

    /**
     * Gets a particular dorm in a university.
     * @return A particular dorm associated with this university.
     */
    public Dorm getCertainDorm(String dormName){
        if(dorms.containsKey(dormName)){
            return dorms.get(dormName);
        }
        for(String name: dorms.keySet()){
            if(dormName.equalsIgnoreCase(name)){
                return dorms.get(name);
            }
        }
        return null;
    }

    /**
     * Checks whether this university contains a particular professor
     * @param professorName the Professor's name.
     * @return whether the professor exists in the system.
     */
    public boolean whetherContainProfessor(String professorName){
        if(professors.containsKey(professorName)){
            return true;
        }
        else {
            for (String name : professors.keySet()){
                if (name.equalsIgnoreCase(professorName)){
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Checks whether this university contains a particular dorm.
     * @param dormName the residence name.
     * @return whether the dorm exists in the system.
     */
    public boolean whetherContainDorm(String dormName){
        if(dorms.containsKey(dormName)){
            return true;
        }
        else {
            for (String name : dorms.keySet()){
                if (name.equalsIgnoreCase(dormName)){
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Checks whether this university contains a particular course
     * @param courseCode the course code attached to the course.
     * @return whether the course exists in the system.
     */
    public boolean whetherContainCourse(String courseCode){
        if(courses.containsKey(courseCode)){
            return true;
        }
        else {
            for (String name : courses.keySet()){
                if (name.equalsIgnoreCase(courseCode)){
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * adds a new course to the university.
     * @param newCourse the Course object.
     */
    public void addCourse(Course newCourse){
        courses.put(newCourse.getCourseCode(), newCourse);
    }

    /**
     * adds a new to professor the university.
     * @param newProfessor the Course object.
     */
    public void addProfessor(Professor newProfessor){
        professors.put(newProfessor.getProfessorName(),newProfessor);
    }


    /**
     * adds a new dorm to the university.
     * @param newDorm the Course object.
     */
    public void addDorm(Dorm newDorm){
        dorms.put(newDorm.getResidenceName(),newDorm);
    }

}
