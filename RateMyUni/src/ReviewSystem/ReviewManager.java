package ReviewSystem;



import java.io.Serializable;
import java.util.Comparator;

public abstract class ReviewManager implements Serializable {


    /**
     * Gets a particular review by using their ID.
     * @param ID the Review's given ID upon construction.
     * @return the Review associated with the Review ID.
     */
    public abstract Review getReviewByID(String ID);

    /**
     * Allows a user to upvote a review.
     * @param ID ID of the Review to find the review to upvote.
     * @return true or false whether the upvote was successful. An upvote is only successful if the review exists.
     */
    public abstract boolean upvote(String ID);

    /**
     * Allows a user to downvote a review.
     * @param ID ID of the Review to find the review to downvote.
     * @return true or false whether the downvote was successful. An downvote is only successful if the review exists.
     */
    public abstract boolean downvote(String ID);

    /**
     * Gets the university name associated with the Review object.
     * @param ID the String of the review's ID to find the review and retrieve required information.
     * @return a String of the university name associated with the Review object.
     */
    public String getUniName(String ID){
        return getReviewByID(ID).getReview().get("University");
    }


    /**
     * Gets the IDs of all the Reviews made.
     */
    public abstract void getAllIDs();

    /**
     * A sorter to compare and reorganize Review objects in a reviewable profile.
     * @param comparator the desired ordered display of reorganized Review objects.
     */
    public abstract void sort(Comparator<Review> comparator);

    /**
     * Removes an upvote.
     * @param ID the review ID to retrieve the Review.
     */
    public void undoUpvote(String ID) {
        //note, this method is ONLY called when we are sure a review of this ID exists
        getReviewByID(ID).undoUpvote();
    }

    /**
     * Removes a downvote.
     * @param ID the reviewID to retrieve the Review.
     */
    public void undoDownvote(String ID) {
        //note, this method is ONLY called when we are sure a review of this ID exists
        getReviewByID(ID).undoDownvote();
    }

    /**
     * Allows a user to edit their Comment in a Review.
     * @param ID the review ID to retrieve the Review.
     * @param newComment the new comment to be placed.
     */
    public void editComment(String ID, String newComment){
        Review r = getReviewByID(ID);
        r.editReview("Comment", newComment);
    }

}


