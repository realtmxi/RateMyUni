package ReviewSystem;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;

/** An abstract Review object that creates and edits reviews and their associated information.
 *
 */
public abstract class Review implements Serializable {

    private final String type;

    public LocalDateTime timestamp;
    private final String reviewer;
    private String university;

    public String ID;
    protected int upvotes;
    protected int downvotes;

    private final HashMap<String, String> review = new HashMap<>();


    /**
     * The constructor for the Review initialized with a collection of categories and ratings for the review,
     * a reviewer, and the Review type.
     * @param reviewCollection a HashMap of String categories and String values for information on the Review and rating categories.
     * @param reviewer the username of the user making this review.
     * @param type the Review type of child classes.
     */
    public Review(HashMap<String, String> reviewCollection, String reviewer,String type){
        review.putAll(reviewCollection);
        this.timestamp = LocalDateTime.now();
        this.reviewer = reviewer;
        this.type = type;
        upvotes = 0;
        downvotes = 0;
    }

    /**
     * Sets the Review's ID.
     * @param ID the String ID to set.
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Retrieves the Overall Rating for the Review.
     * @return a String of the Overall Rating.
     */
    public String getOverallRating(){
        return review.get("Overall Rating");
    }

    public void setOverallRating(String rating){
        //this changes overallRating
        review.put("Overall Rating", rating);
    }

    /** Retrieves the comment made by a user in their Review.
     *
     * @return a String of the comment made.
     */
    public String getComment(){
        return review.get("Comment");
    }

    public void setComment(String comment) {
        //allows user to edit their comment
        review.put("Comment",comment);
    }

    /**
     * Retrieves the username of the reviewer.
     * @return A String of the reviewer's username.
     */
    public String getReviewer(){
        return reviewer;
    }

    /**
     * Gets the timestamp of when the Review was made.
     * @return a date and time for the review creation.
     */
    public LocalDateTime getTimestamp(){
        return timestamp;
    }

    /**
     * Retrieves the ID of the Review.
     * @return a String of the Review's ID.
     */
    public String getID(){
        return ID;
    }

    /**
     * Allows a user to upvote a review.
     */
    public void upVote(){
        upvotes++;
    }

    /**
     * Removes an upvote.
     */
    public void undoUpvote(){
        upvotes--;
    }

    /**
     * Allows a user to downvote a Review.
     */
    public void downVote(){
        this.downvotes++;
    }

    /**
     * Removes a downvote.
     */
    public void undoDownvote(){
        downvotes--;
    }


    /**
     * Retrieves the total number of upvotes a Review has.
     * @return the number of upvotes held by this review.
     */
    public int getUpvotes(){
        return this.upvotes;
    }
    /**
     * Retrieves the total number of downvotes a Review has.
     * @return the number of downvotes held by this review.
     */
    public int getDownvotes(){
        return this.downvotes;
    }

    /**
     * Gets the Review type of children classes.
     * @return a String of the Review type.
     */
    public String getType(){return type;}

    /**
     * Gets a Review object.
     * @return a HashMap of String categories and their String information or rating values.
     */
    public HashMap<String,String> getReview(){
        return review;
    }

    /**
     * Allows a user to edit their review, including information related to the reviewable profile.
     * @param category the category to be edited.
     * @param newRating the new rating or information to be placed.
     */
    public void editReview(String category, String newRating){
        getReview().put(category, newRating);

    }

}

