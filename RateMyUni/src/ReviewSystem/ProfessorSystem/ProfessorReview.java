package ReviewSystem.ProfessorSystem;

import java.time.LocalDateTime;
import java.util.HashMap;
import ReviewSystem.Review;

/**
 * The ProfessorReview class is a type of Review for Professor profiles in the RateMyUni domain. All reviews should store
 * the University name, Professor's Name, the Course Code of the course this student took with them, a comment and ratings between 1-5 for all its rating categories or true or false categories..
 */
public class ProfessorReview extends Review{

    /**
     * The ProfessorReview constructor initializes a new instance of a ProfessorReview. It should be provided with the professor name, review ratings and comment in a Hashmap with a String key and String value and the reviewer's username
     * as arguments. Arguments will be taken directly from user inputs.
     * @param reviewer the username for the user leaving this review.
     * @param review is a Hashmap<String, String> that takes in the user's input of ratings listed in the Class file which includes:
     * Difficulty, Clarity, Engagement and Overall Rating, and true or false options for Attendance and Textbook categories, as well as
     * The University name associated with this particular professor, Comment and the profName and the Course Code of the course taken with this professor.
     */
    public ProfessorReview(String reviewer, HashMap<String, String> review)
    {
        super(review, reviewer,"ProfReview");
    }

    public String getID() {
        return super.getID();
    }

    /** A getter for the Course Code associated with the Professor for this review. This refers to the super variable in the Review abstract class.
     *
     * @return a String of the ProfessorReview's Course Code.
     */
    public String getCourseName(){
        return getReview().get("Course Code");
    }

    /** A getter for the Level of Difficulty for the associated Professor. This refers to the super variable in the Review abstract class.
     *
     * @return a String of the ProfessorReview's Level of Difficulty rating.
     */
    public String getDifficulty() {
        return getReview().get("Difficulty");
    }

    /** A getter for the Level of Clarity for the associated Professor. This refers to the super variable in the Review abstract class.
     *
     * @return a String of the ProfessorReview's Level of Clarity rating.
     */
    public String getClarity() {
        return getReview().get("Clarity");
    }

    /** A getter for the associated Professor's first and last name. This refers to the super variable in the Review abstract class.
     *
     * @return a String of the ProfessorReview's name.
     */
    public String getProfName() {
        return getReview().get("profName");
    }

    /** A getter for the associated Professor's Level of Engagement. This refers to the super variable in the Review abstract class.
     *
     * @return a String of the ProfessorReview's Level of Engagement rating.
     */
    public String getEngagement() {
        return getReview().get("Engagement");
    }

    /** A getter for the associated Professor's Attendance necessity for this course. This refers to the super variable in the Review abstract class.
     *
     * @return a String of the ProfessorReview's Attendance necessary true or false rating.
     */
    public String getAttendance(){
        return getReview().get("Attendance");
    }

    /** A getter for whether a Textbook was necessary for this course. This refers to the super variable in the Review abstract class.
     *
     * @return a String of the ProfessorReview's Textbook necessary true or false rating.
     */
    public String getTextbook(){
        return getReview().get("Textbook");
    }

    /** A getter for the timestamp of when the review was made. This refers to the super variable in the Review abstract class.
     *
     * @return a String of the ProfessorReview's timestamp.
     */
    @Override
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /** A representation for the ProfessorReview.
     * @return a String representation of this ProfessorReview.
     */
    @Override
    public String toString() {
        return String.format("===[This Review was left by %s at %s]===\n ReviewID: %s\n Professor Name: %s\n Course Name: %s\n Overall Rating: %s\n Comment: %s\n Difficulty: %s\n " +
                        "Clarity: %s\n Engagement: %s\n Attendance Necessary: %s\n Textbook Necessary: %s\n===[upvotes: %s, downvotes:%s]===\n",
                this.getReviewer(),this.getTimestamp().toString(),super.ID,getProfName(),getCourseName(),getOverallRating(),
                super.getComment(), getDifficulty(),getClarity(),getEngagement(),getAttendance(),getTextbook(),getUpvotes(),getDownvotes());
    }
}
