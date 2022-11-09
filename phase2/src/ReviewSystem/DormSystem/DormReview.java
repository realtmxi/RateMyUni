package ReviewSystem.DormSystem;

import ReviewSystem.Review;

import java.util.HashMap;

/** The DormReview class is a type of Review for Dorm profiles in the RateMyUni domain. All DormReviews should store
 * the University's name, Dorm's name, a comment, and ratings between 1-5 for its rating categories or true or false.
 */
public class DormReview extends Review{
    private static final long serialVersionUID = -6053102965025116945L;

    /**
     * The DormReview constructor initializes a new instance of a DormReview. It should be provided the dorm name, review ratings and comment in a Hashmap with a String key and String value and the reviewer's username
     * as arguments. Arguments will be taken directly from user inputs.
     * @param reviewer the username for the user leaving this review.
     * @param dormReview a Hashmap<String, String> that takes in the user's input of ratings listed in the Class file which should include:
     * Cleanliness, Social Level, Soundproof, RA rating, Food, Convenience, WiFi, and the Overall Rating, as well as a
     * Comment, the Residence Name, and the University name associated with this dorm.
     */
    public DormReview(String reviewer, HashMap<String, String> dormReview)
    {
        super(dormReview, reviewer, "DormReview");
    }

    /** A getter for the Dorm Name associated with this Dorm. This refers to the super variable in the Review abstract class.
     *
     * @return a String of the DormReview's Dorm Name.
     */
    public String getDormName() {
        return getReview().get("Residence Name");
    }

    /** A getter for the level of Cleanliness in the associated Dorm. This refers to the super variable in the Review abstract class.
     *
     * @return a String of the DormReview's level of Cleanliness rating.
     */
    public String getCleanliness() {
        return getReview().get("Cleanliness");
    }

    /** A getter for the Social Level associated with this Dorm. This refers to the super variable in the Review abstract class.
     *
     * @return a String of the DormReview's Social Level rating.
     */
    public String getSocialLevel() {
        return getReview().get("Social Level");
    }

    /** A getter for the Soundproof level associated with this Dorm. This refers to the super variable in the Review abstract class.
     *
     * @return a String of the DormReview's level of Soundproof rating.
     */
    public String getSoundProof() {
        return getReview().get("Soundproof");
    }

    /** A getter for the WiFi level associated with this Dorm. This refers to the super variable in the Review abstract class.
     *
     * @return a String of the DormReview's level of WiFi rating.
     */
    public String getWifi() {
        return getReview().get("WiFi");
    }

    /** A getter for the RA rating associated with this Dorm. This refers to the super variable in the Review abstract class.
     *
     * @return a String of the DormReview's level of RA rating.
     */
    public String getRatingRA() {
        return getReview().get("RA");
    }

    /** A getter for the level of Food rating associated with this Dorm. This refers to the super variable in the Review abstract class.
     *
     * @return a String of the DormReview's Food level rating.
     */
    public String getFood() {
        return getReview().get("Food");
    }

    /** A getter for the level of Convenience associated with this Dorm. This refers to the super variable in the Review abstract class.
     *
     * @return a String of the DormReview's Convenience rating.
     */
    public String getConvenience() {
        return getReview().get("Convenience");
    }

    /** A representation for the DormReview.
     * @return a String representation of this DormReview.
     */
    @Override
    public String toString() {
        return String.format("===[This Review was left by %s at %s]===\n ReviewID: %s\n Dorm Name: %s\n Overall Rating: %s\n Comment: %s\n Cleanliness: %s\n Social Level: %s\n " +
                        "Soundproof: %s\n RA: %s\n Food: %s\n Convenience: " +
                        "%s\n WiFi: %s\n===[upvotes: %s, downvotes:%s]===\n", getReviewer(),getTimestamp(),super.getID(),getDormName(),
                this.getOverallRating(),this.getComment(), getCleanliness(),getSocialLevel(),getSoundProof(),getRatingRA(),
                getFood(),getConvenience(),getWifi(),getUpvotes(),getDownvotes());
    }

}