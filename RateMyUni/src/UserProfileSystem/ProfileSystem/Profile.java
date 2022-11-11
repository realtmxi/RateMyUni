package UserProfileSystem.ProfileSystem;

import ReviewSystem.CourseSystem.CourseReview;
import ReviewSystem.ProfessorSystem.ProfessorReview;
import ReviewSystem.DormSystem.DormReview;
import ReviewSystem.Review;

import java.io.Serializable;
import java.util.ArrayList;

/** Every user in RateMyUni has a profile that will consist of their name,
 * graduating year, email address, an optional list of their POSts for other users to see,
 * and a list for all the reviews they have left on a particular object.
 */
public class Profile implements Serializable {
    private static final long serialVersionUID = -2099500382658191034L;
    String username;
    String year;
    String email;

    ArrayList<Review> reviewsLeft;
    ArrayList<String> upvotedReviews;
    ArrayList<String> downvotedReviews;
    private boolean admin;


    public Profile(String name, String year, String email){
        this.username = name;
        this.year = year;
        this.email = email;
        this.reviewsLeft = new ArrayList<>();
        this.upvotedReviews = new ArrayList<>();
        this.downvotedReviews = new ArrayList<>();
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getUsername() {
        return username;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    protected ArrayList<Review> getReviewsLeft(){return reviewsLeft;}

    protected ArrayList<String> getReviewsLeftIDs(){
        ArrayList<String> listIDs = new ArrayList<>();
        for (Review r: reviewsLeft){
            listIDs.add(r.getID());
        }
        return listIDs;
    }

    protected void addToReviewsLeft(Review r){
        reviewsLeft.add(r);
    }


    protected void deleteFromReviewsLeft(Review r){
        reviewsLeft.remove(r);
    }

//    @Override
//    public String toString(){
//        return String.format("This is the profile of <%s>\n Graduating year: %s\n Email: %s\n Upvoted Reviews: %s\n", username,year,
//                email,upvotedReviews.toString());
//    }

    public void printReviews(){
        for (Review r : reviewsLeft){
            System.out.println(r);
        }
    }

    public void addToUpvotedReviews(String ID){
        upvotedReviews.add(ID);
    }

    public void addToDownvotedReviews(String ID){downvotedReviews.add(ID);}

    public void removeFromUpvotedReviews(String ID){upvotedReviews.remove(ID);}

    public void removeFromDownvotedReviews(String ID){downvotedReviews.remove(ID);}

    public void printReviewIDs() {
        for (Review r : reviewsLeft) {
            switch (r.getType()) {
                case "ProfReview":
                    ProfessorReview pr = (ProfessorReview) r;
                    System.out.println(pr.getID() + ": " + pr.getProfName());
                    break;
                case "CourseReview":
                    CourseReview cr = (CourseReview) r;
                    System.out.println(cr.getID() + ": " + cr.getCourseCode());
                    break;
                case "DormReview":
                    DormReview dr = (DormReview) r;
                    System.out.println(dr.getID() + ": " + dr.getDormName());
                    break;
            }
        }
    }

    public ArrayList<String> getUpvotedReviews() {
        return upvotedReviews;
    }

    public ArrayList<String> getDownvotedReviews() {
        return downvotedReviews;
    }
}

