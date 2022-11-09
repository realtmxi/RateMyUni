package ReviewSystem.CourseSystem;
import ReviewSystem.Review;

import java.util.HashMap;

/** The CourseReview class is a type of Review for Course profiles in the RateMyUni domain. All CourseReviews should store
 * the University name, Course's code, a comment, and ratings between 1-5 and true or false.
 */
public class CourseReview extends Review {

    /**
     * The CourseReview constructor which initializes a CourseReview. It should have the course code, review ratings and comment in a Hashmap with a String key and String value and the reviewer's username
     * as arguments. Arguments will be taken directly from user inputs.
     * @param reviewer the username for the user leaving this review.
     * @param review is a Hashmap<String, String> that takes in the user's input of ratings listed in the Class file such as:
     * Difficulty, Workload, Participation, Inclusive, Theoretical, Applicable, and the Overall Rating, as well as a
     * Comment and the Course Code and the University's name associated with this course.
     */
    public CourseReview(String reviewer, HashMap<String, String> review)
    {
        super(review, reviewer, "CourseReview");
    }

    public String getID() {
        return super.ID;
    }

    /** A getter for the Course Code associated with this CourseReview. This refers to the super variable in the Review abstract class.
     *
     * @return a String of the CourseReview's Course Code.
     */

    public String getCourseCode() {
        return getReview().get("Course Code");
    }

    /** A getter for the level of Difficulty for associated Course. This refers to the super variable in the Review abstract class.
     *
     * @return a String of the CourseReview's Course Code
     */
    public String getDifficulty() {
        return getReview().get("Difficulty");
    }

    /** A getter for the Workload level for the associated Course. This refers to the super variable in the Review abstract class.
     *
     * @return a String of the CourseReview's Difficulty rating.
     */
    public String getWorkload() {
        return getReview().get("Workload");
    }

    /** A getter for whether Participation is necessary for the associated Course. This refers to the super variable in the Review abstract class.
     *
     * @return a String of the CourseReview's Workload rating.
     */
    public String getParticipation() {
        return getReview().get("Participation");
    }

    /** A getter for whether the associated Course is Applicable. This refers to the super variable in the Review abstract class.
     *
     * @return a String of the CourseReview's Applicable true or false rating.
     */
    public String isApplicable() {
        return getReview().get("Applicable");
    }

    /** A representation for the CourseReview.
     * @return a String representation of this CourseReview.
     */
    @Override
    public String toString(){
        return String.format("===[This Review was left by %s at %s]===\n ReviewID: %s\n Course Code: %s\n Overall Rating: %s\n Comment: %s\n " +
                        "Difficulty: %s\n Workload: %s\n Participation Necessary: %s\n Theoretical: %s\n Applicable: %s\n Inclusive: %s\n===[upvotes: %s, downvotes:%s]===\n"
                ,this.getReviewer(), this.getTimestamp(),getID(), getCourseCode(), getOverallRating(), this.getComment(), getDifficulty(),getWorkload()
                ,getParticipation(), isTheoretical(), isApplicable(), isInclusive(), getUpvotes(),getDownvotes());
    }

    /** A getter for whether the associated Course is Inclusive. This refers to the super variable in the Review abstract class.
     *
     * @return a String of the CourseReview's Inclusive true or false rating.
     */
    public String isInclusive() {
        return getReview().get("Inclusive");
    }

    /** A getter for whether the associated Course is Theoretical. This refers to the super variable in the Review abstract class.
     *
     * @return a String of the CourseReview's Theoretical true or false rating.
     */
    public String isTheoretical(){
        return getReview().get("Theoretical");
    }


}

