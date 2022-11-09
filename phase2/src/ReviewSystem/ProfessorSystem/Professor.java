package ReviewSystem.ProfessorSystem;
import java.io.Serializable;


/**
 * The Professor class is an entity for the RateMyUni domain. It is the basis for the Professor profile and should contain
 * all the relevant information about the Professor and the associated average attributes for a Professor profile to be reviewed.
 */
public class Professor implements Serializable {
    private final String professorName;
    private final String department;
    private final String university;
    private Float avgOverallRating;
    private Float averageDifficulty;
    private Float averageClarity;
    private Float averageEngagement;
    private Float averageAttendance;
    private Float averageTextbook;


    /**
     * Initializes a new Professor object with their identification information.
     * @param pName the Professor's first and last name.
     * @param dep the department this Professor is associated with.
     * @param university the name of the University this professor is associated with.
     */
    public Professor(String pName, String dep, String university){
        this.professorName = pName;
        this.department = dep;
        this.university = university;
    }


    

    /**
     * Gets the Professor's Name.
     * @return a String of the Professor's name.
     */
    public String getProfessorName(){
        return this.professorName;
    }

    /**
     * Gets the professor's department name.
     * @return the String of the Professor's department name.
     */
    public String getDepartment(){
        return this.department;
    }

    /**
     * Gets the professor's associated university name.
     * @return a String of the university name.
     */
    public String getUniversity(){
        return this.university;
    }

    /**
     * Sets the Professor's average Overall Rating from reviews associated with this Professor's reviewable profile.
     * @param avgOverallRating the new average Overall Rating.
     */
    public void setAvgOverallRating(Float avgOverallRating) {
        this.avgOverallRating = avgOverallRating;
    }

    /**
     * Gets the average level of Difficulty rating from reviews associated with this Professor's reviewable profile.
     * @return a float of the average rating.
     */
    public Float getAverageDifficulty() {
        return averageDifficulty;
    }

    /**
     * Sets the Professor's average level of Difficulty rating  from reviews associated with this Professor's reviewable profile.
     * @param averageDifficulty the new average Overall Rating.
     */
    public void setAverageDifficulty(Float averageDifficulty) {
        this.averageDifficulty = averageDifficulty;
    }

    /**
     * Gets the average level of Clarity rating from reviews associated with this Professor's reviewable profile.
     * @return a float of the average rating.
     */
    public Float getAverageClarity() {
        return averageClarity;
    }

    /**
     * Sets the Professor's average level of Clarity rating from reviews associated with this Professor's reviewable profile.
     * @param averageClarity the new average Clarity rating.
     */
    public void setAverageClarity(Float averageClarity) {
        this.averageClarity = averageClarity;
    }

    /**
     * Gets the average level of Engagement rating from reviews associated with this Professor's reviewable profile.
     * @return a float of the average rating.
     */
    public Float getAverageEngagement() {
        return averageEngagement;
    }

    /**
     * Sets the Professor's average level of Engagement rating from reviews associated with this Professor's reviewable profile.
     * @param averageEngagement the new average Engagement rating.
     */
    public void setAverageEngagement(Float averageEngagement) {
        this.averageEngagement = averageEngagement;
    }

    /**
     * Gets the average Attendance necessary rating from reviews associated with this Professor's reviewable profile.
     * @return a float of the average rating.
     */
    public Float getAverageAttendance() {
        return averageAttendance;
    }

    /**
     * Sets the Professor's average Attendance necessary rating from reviews associated with this Professor's reviewable profile.
     * @param averageAttendance the new average Attendance rating.
     */
    public void setAverageAttendance(Float averageAttendance) {
        this.averageAttendance = averageAttendance;
    }

    /**
     * Gets the average Overall Rating from reviews associated with this Professor's reviewable profile.
     * @return a float of the average rating.
     */
    public Float getAvgOverallRating() {
        return this.avgOverallRating;
    }

    /**
     * A representation of this reviewable Professor profile.
     * @return a String representation of the professor profile.
     */
    @Override
    public String toString(){
        return String.format("===[Professor Profile]===\nProfessor Name: %s\nUniversity: %s\nDepartment: %s\n===[Average Ratings]===\n" +
                        "Average Overall Rating: %s\nAverage level of difficulty: %s\nAverage level of clarity: " +
                        "%s\nAverage level of engagement: %s\nAttendance Necessary: %s%% agree\nTextbook Necessary: %s%% agree\n", professorName,
                university,department,avgOverallRating,averageDifficulty, averageClarity,averageEngagement, averageAttendance,averageTextbook);
    }

    /**
     * Sets the Professor's average Textbook necessary rating from reviews associated with this Professor's reviewable profile.
     * @param avgTextbook the new average Textbook rating.
     */
    public void setAverageTextbook(float avgTextbook) {
        this.averageTextbook = avgTextbook;
    }

    /**
     * Gets the average Textbook necessary rating from reviews associated with this Professor's reviewable profile.
     * @return a float of the average rating.
     */
    public Float getAverageTextbook(){return averageTextbook;}


}
