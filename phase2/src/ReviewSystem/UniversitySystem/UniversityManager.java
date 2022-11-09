package ReviewSystem.UniversitySystem;
import ReviewSystem.CourseSystem.*;
import ReviewSystem.DormSystem.*;
import ReviewSystem.ProfessorSystem.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.io.Serializable;

public class UniversityManager implements Serializable{
    /**
     * The UniversityManage class is an UseCase for the RateMyUni domain. ir contain all universities in RateMyUni domain
     * it will help program to check whether a reviewable entities already be created in certain university, it helps to
     * avoid the same name problem in different university.
     */

    private final HashMap<String,University> universities;

    public UniversityManager(){
        universities = new HashMap<>();
    }


    public HashMap<String,University> getUniversities() {
        return universities;
    }


    /**
     * @param UniversityName is a university's name
     * this help to check whether UniversityManager have certain university and
     * this method is case-insensitive
     */
    public boolean whetherHaveUniversity (String UniversityName){

        for (String name : universities.keySet()) {
            if (name.equalsIgnoreCase(UniversityName)) {
                return true;
            }
        }
        return false;


    }

    /**
     * @param universityName is a university's name, we want to create
     * this function help to create a university with name(case-insensitive)  and add this university in our universityManager
     * and before creat we will check whether our universityManger Have this university
     */
    public void createUniversityWithName(String universityName){
        if (!whetherHaveUniversity(universityName)){
            University newUni = new University(universityName);
            universities.put(universityName, newUni);
        }
    }

    /**
     * @param universityName is a university's name, we want to find
     * this function help to find a university by name(case-insensitive)this function will return
     * a University entity with this name
     * if UniversityManager do not have this university it will return Null
     */

    public University getCertainUniversityByName(String universityName){
        if(universities.containsKey(universityName)){
            return universities.get(universityName);
        }
        for (String name: universities.keySet()){
            if(name.equalsIgnoreCase(universityName)){
                return universities.get(name);
            }
        }
        return null;
    }

    /**
     * @param universityName is a university's name, we want to find
     * this function help to get all professors in a university by University's name(case-insensitive)this function will return
     * a HashMap map professor's name and corresponding Professor's entity
     * if UniversityManager do not have this university it will return Null
     */

    public HashMap<String, Professor> getProfessorsInUniversity(String universityName){

        if(universities.containsKey(universityName)){
            return universities.get(universityName).getProfessors();
        }
        for (String name: universities.keySet()){
            if(name.equalsIgnoreCase(universityName)){
                return universities.get(name).getProfessors();
            }
        }
        return null;
    }
    /**
     * @param universityName is a university's name, we want to find
     * this function help to get all Courses in a university by university's name(case-insensitive)this function will return
     * a HashMap map Course 's name and corresponding Course's entity
     * if UniversityManager do not have this university it will return Null
     */

    public HashMap<String, Course> getCourseInUniversity(String universityName){
        if(universities.containsKey(universityName)){
            return universities.get(universityName).getCourses();
        }
        for (String name: universities.keySet()){
            if(name.equalsIgnoreCase(universityName)){
                return universities.get(name).getCourses();
            }
        }
        return null;
    }

    /**
     * @param universityName is a university's name, we want to find
     * this function help to get all Dormitories in a university by University's name(case-insensitive)this function will return
     * a HashMap map Dorm's name and corresponding Dorm's entity
     * if UniversityManager do not have this university it will return Null
     */

    public HashMap<String,Dorm> getDormsInUniversity(String universityName){

        if(universities.containsKey(universityName)){
            return universities.get(universityName).getDorms();
        }
        for (String name: universities.keySet()){
            if(name.equalsIgnoreCase(universityName)){
                return universities.get(name).getDorms();
            }
        }
        return null;
    }
    /**
     * @param universityName is a university's name, we want to find
     * @param professorName is a professor's name we want to get
     * this function help to get a professor in a university by university's name(case-insensitive) and professor's name(case-insensitive)
     * this function will return an  entity, Professor.
     * if UniversityManager do not have this university or this university do not have this Professor it will return Null
     */
    public Professor getProfessorInCertainUniByName(String universityName, String professorName){
        University uni = getCertainUniversityByName(universityName);
        if(uni!=null){
            return uni.getCertainProfessor(professorName);
        }
        return null;
    }

    /**
     * @param universityName is a university's name, we want to find
     * @param courseCode is a course's code we want to get
     * this function help to get a Course in a university by university's name(case-insensitive) and Course's name(case-insensitive)
     * this function will return an  entity, Course.
     * if UniversityManager do not have this university or this university do not have this Course it will return Null
     */
    public Course getCourseInCertainUniByName(String universityName, String courseCode){
        University uni = getCertainUniversityByName(universityName);
        if(uni!=null){
            return uni.getCertainCourse(courseCode);
        }
        return null;
    }

    /**
     * @param universityName is a university's name, we want to find
     * @param dormName is a dorm's name we want to get
     * this function help to get a Dorm in a university by university's name(case-insensitive) and Dorm's name(case-insensitive)
     * this function will return an  entity, Dorm.
     * if UniversityManager do not have this university or this university do not have this Dorm it will return Null
     */
    public Dorm getDormInCertainUniByName(String universityName, String dormName){
        University uni = getCertainUniversityByName(universityName);
        if(uni!=null){
            return uni.getCertainDorm(dormName);
        }

        return null;
    }

    /**
     *
     * this function return all university's name as a set of string in this UniversityManger
     */
    public Set<String> getAllUniversityName(){
        return universities.keySet();
    }

    /**
     * @param universityName is a university's name, we want to find
     * @param newProfessor is entity, Professor, we want to add in to certain university
     * this function will add newProfessor to certain university by the university name(case-insensitive).
     * this function will be use in app controller, in app controller before use this method it will make sure University Manger have this method
     */
    public void addProfessorInCertainUni (String universityName, Professor newProfessor) {
        getCertainUniversityByName(universityName).addProfessor(newProfessor);
    }

    /**
     * @param universityName is a university's name, we want to find
     * @param course is entity, Course, we want to add in to certain university
     * this function will add course to certain university by the university name(case-insensitive).
     * this function will be use in app controller, in app controller before use this method it will make sure University Manger have this method
     */
    public void addCourseInCertainUni (String universityName, Course course) {
        getCertainUniversityByName(universityName).addCourse(course);
    }
    /**
     * @param universityName is a university's name, we want to find
     * @param dorm is entity, Dorm, we want to add in to certain university
     * this function will add dorm to certain university by the university name(case-insensitive).
     * this function will be use in app controller, in app controller before use this method it will make sure University Manger have this method
     */
    public void addDormInCertainUni (String universityName, Dorm dorm) {
        getCertainUniversityByName(universityName).addDorm(dorm);
    }

    /**
     * @param universityName is a university's name, we want to find
     * @param professorName is a professor's name we want to get
     * this function help to know whether a professor in a university by university's name(case-insensitive) and professor's name(case-insensitive)
     * this function will return a boolean value
     * this function will be use in app controller, in app controller before use this method it will make sure University Manger have this method
     */
    public boolean whetherCertainUniHaveProfessor(String universityName, String professorName){
        return getCertainUniversityByName(universityName).whetherContainProfessor(professorName);
    }

    /**
     * @param universityName is a university's name, we want to find
     * @param courseCode is a course's name we want to get
     * this function help to know whether a Course in a university by university's name(case-insensitive) and course's code (case-insensitive)
     * this function will return a boolean value
     * this function will be use in app controller, in app controller before use this method it will make sure University Manger have this method
     */
    public boolean whetherCertainUniHaveCourse(String universityName, String courseCode){
        return getCertainUniversityByName(universityName).whetherContainCourse(courseCode);

    }

    /**
     * @param universityName is a university's name, we want to find
     * @param dormName is a dorm's name we want to get
     * this function help to know whether a Dorm in a university by university's name(case-insensitive) and dorm's name(case-insensitive)
     * this function will return a boolean value
     * this function will be use in app controller, in app controller before use this method it will make sure University Manger have this method
     */
    public boolean whetherCertainUniHaveDorm(String universityName, String dormName){
        return getCertainUniversityByName(universityName).whetherContainDorm(dormName);
    }


    /**
     * @param uniName is a university's name, we want to find
     * this function get all Professor entities in a university by university's name(case-insensitive)
     * this function will return a ArrayList having Professor
     * this function will be use in app controller, in app controller before use this method it will make sure University Manger have this method
     */
    public ArrayList<Professor> getAllProfessorInCertainUni(String uniName){
        return new ArrayList<>(getProfessorsInUniversity(uniName).values());
    }

    /**
     * @param uniName is a university's name, we want to find
     * this function get all Dorm entities in a university by university's name(case-insensitive)
     * this function will return a ArrayList having Dorm
     * this function will be use in app controller, in app controller before use this method it will make sure University Manger have this method
     */
    public ArrayList<Dorm> getAllDormInCertainUni(String uniName){
        return new ArrayList<>(getDormsInUniversity(uniName).values());
    }

    /**
     * @param uniName is a university's name, we want to find
     * this function get all Course entities in a university by university's name(case-insensitive)
     * this function will return a ArrayList having Course
     * this function will be use in app controller, in app controller before use this method it will make sure University Manger have this method
     */
    public ArrayList<Course> getAllCourseInCertainUni(String uniName){
        return new ArrayList<>(getCourseInUniversity(uniName).values());
    }

}
