package ReviewSystem.CourseSystem;

import java.io.Serializable;

/** A reviewable course in a university with ratings on its attributable aspects.
 *
 */
public class Course implements Serializable {
    private String university;
    private String courseCode;
    private String department;
    private Float avgTheoretical;
    private Float avgApplicable;
    private Float avgInclusive;
    private Float averageOverallRating;
    private Float averageDifficulty;
    private Float averageWorkload;
    private Float avgParticipation;



    /** The constructor for object phase1.Course to be reviewed.
     *
     * @param courseCode is the Course Code given by the university.
     * @param department indicates which department is associated with this course.
     * @param university the university associated with this course.
     */
    public Course(String courseCode, String department, String university){

        this.courseCode = courseCode;
        this.department = department;
        this.university = university;

    }

    /**
     * Gets the course's associated university name.
     * @return A string of the university name.
     */
    public String getUniversity() {
        return university;
    }

    /**
     * Sets the name of the university associated with this course.
     * @param university a String of the university name.
     */
    public void setUniversity(String university) {
        this.university = university;
    }

    /**
     * Gets the Course Code associated with this course.
     * @return A String of the course code.
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Sets the Course Code associated with this course.
     * @param courseCode a String of the course code.
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Gets the name of the department associated with this course.
     * @return A String of the department name.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the name of the department associated with this course.
     * @param department a String of the department name.
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * A representation of this reviewable Course profile.
     * @return a String representation of the course profile.
     */
    @Override
    public String toString(){
        return String.format("===[Course Profile]===\nCourse Code: %s\nUniversity: %s\nDepartment: %s\n===[Average Ratings]===\n" +
                        "Average Overall Rating: %s\nAverage Difficulty: %s\nAverage Workload: %s\nTheoretical: %s%% agree\n" +
                        "Applicable: %s%% agree\nInclusive: %s%% agree\n",
                courseCode,university,department,averageOverallRating,
                averageDifficulty,averageWorkload,avgTheoretical,avgApplicable,avgInclusive);
    }

    /**
     * Sets the Course's average Overall Rating from reviews associated with this Course's reviewable profile.
     * @param avgRating the new average Overall Rating.
     */
    public void setAvgOverallRating(Float avgRating){
        this.averageOverallRating = avgRating;
    }

    /**
     * Gets the average Overall Rating from reviews associated with this Course's reviewable profile.
     * @return a float of the average rating.
     */
    public Float getAvgOverallRating() {
        return this.averageOverallRating;
    }

    /**
     * Gets the Course's average level of Theoretical rating from reviews associated with this Course's reviewable profile.
     * @return a float of the average rating.
     */
    public Float getAvgTheoretical() {
        return avgTheoretical;
    }

    /**
     * Gets the Course's average level of Applicable rating from reviews associated with this Course's reviewable profile.
     * @return a float of the average rating.
     */
    public Float getAvgApplicable() {
        return avgApplicable;
    }

    /**
     * Gets the Course's average level of Inclusive rating from reviews associated with this Course's reviewable profile.
     * @return a float of the average rating.
     */
    public Float getAvgInclusive() {
        return avgInclusive;
    }

    /**
     * Gets the Course's average level of Difficulty rating from reviews associated with this Course's reviewable profile.
     * @return a float of the average rating.
     */
    public Float getAverageDifficulty() {
        return averageDifficulty;
    }

    /**
     * Gets the Course's average level of Workload rating from reviews associated with this Course's reviewable profile.
     * @return a float of the average rating.
     */
    public Float getAverageWorkload() {
        return averageWorkload;
    }

    /**
     * Sets the Course's average level of Theoretical rating from reviews associated with this Course's reviewable profile.
     * @param avgTheoretical the new average theoretical rating.
     */
    public void setAvgTheoretical(Float avgTheoretical) {
        this.avgTheoretical = avgTheoretical;
    }

    /**
     * Sets the Course's average level of Applicable rating from reviews associated with this Course's reviewable profile.
     * @param avgApplicable the new average applicable rating.
     */
    public void setAvgApplicable(Float avgApplicable) {
        this.avgApplicable = avgApplicable;
    }

    /**
     * Sets the Course's average level of Inclusive rating from reviews associated with this Course's reviewable profile.
     * @param avgInclusive the new average inclusive rating.
     */
    public void setAvgInclusive(Float avgInclusive) {
        this.avgInclusive = avgInclusive;
    }

    /**
     * Sets the Course's average level of Difficulty rating from reviews associated with this Course's reviewable profile.
     * @param averageDifficulty the new average difficulty rating.
     */
    public void setAverageDifficulty(Float averageDifficulty) {
        this.averageDifficulty = averageDifficulty;
    }

    /**
     * Sets the Course's average level of Workload rating from reviews associated with this Course's reviewable profile.
     * @param averageWorkload the new average workload rating.
     */
    public void setAverageWorkload(Float averageWorkload) {
        this.averageWorkload = averageWorkload;
    }

    public void setAvgParticipation(Float avgParticipation) {
        this.avgParticipation = avgParticipation;
    }
}
