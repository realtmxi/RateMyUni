
package ReviewSystem.DormSystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import ReviewSystem.UniversitySystem.UniversityManager;
import ReviewSystem.ReviewManager;
import ReviewSystem.Review;

/**
 * The DormReviewManager handles the creation of Dorm and DormReviews objects to create and edit the reviewable dorm profile and create, edit or remove reviews.
 *
 */
public class DormReviewManager extends ReviewManager implements Serializable {
    //private static final long serialVersionUID = 2258146897208780738L;
    private final HashMap<Dorm, ArrayList<DormReview>> allDormsReviews = new HashMap<>();
    private final ArrayList<DormReview> listDormReviews = new ArrayList<>();
    private int reviewIDs;

    /**
     * Initializes a new instance of DormReviewManager with a new HashMap for all Dorms and their reviews,
     * a list of DormReviews, and sets the review IDs variable according to how many reviews there are in the list of DormReviews.
     */
    public DormReviewManager(){
        setReviewIDs();

    }

    /**
     * A sorter method for various sortBy methods to reorganize display of reviews according to the user's desire.
     * @param comparator the comparator being used to organize the list of Reviews for a particular Dorm.
     */
    @Override
    public void sort(Comparator<Review> comparator){
        listDormReviews.sort(comparator.reversed());
    }


    /**
     * Initializes an instance of Dorm.
     * @param resName the Dorm's Residence Name
     * @param floor which floor of this residence the reviewer is reviewing.
     * @param university the University where this Dorm is located.
     */
    public Dorm createDorm(String resName, String floor, String university) {
        Dorm d = new Dorm(resName, floor, university);
        allDormsReviews.put(d, new ArrayList<>());
        return d;
    }

//

    // add a review to a dorm in HashMap

    /**
     * Initializes a DormReview and attaches it in the HashMap to the Dorm being reviewed, and the list of all
     * DormReviews. The Dorm profile's new averages are updated with each review.
     * @param review A HashMap of String key rating categories and String values that can be parsed later to be Integer or Boolean.
     * The CourseReview should be instantiated with a University name, Residence Name, Comment, Overall Rating, Cleanliness, Social Level, Soundproof, RA rating, Food, Convenience, WiFi ratings.
     * @param reviewer The username of the user making this review.
     * @param d The corresponding Dorm to which the review is being added.
     * @return returns the created ProfessorReview
     */
    public DormReview addReview(HashMap<String, String> review, String reviewer, Dorm d) {
        DormReview r = new DormReview(reviewer, review);
        reviewIDs++;
        r.setID("DR" + reviewIDs);
        allDormsReviews.get(d).add(r);
        listDormReviews.add(r);
        updateAverageRatings(d);
        return r;
    }

    /** Deletes a review from a dorm profile using the resName name and the DormReview's ID.
     *
     * @param  d is the corresponding entity of Dorm
     * @param ID The ID of the DormReview they want to delete.
     */

    public void deleteReview(String ID, Dorm d){
        ArrayList<DormReview> newList = allDormsReviews.get(d);
        DormReview r = getReviewByID(ID);
        if (r!=null) {
            newList.remove(r);
            allDormsReviews.replace(d, allDormsReviews.get(d), newList);
            DormReview dr = getReviewByID(ID);
            listDormReviews.remove(dr);
            updateAverageRatings(d);
        }

    }

    /**
     * A helper method to calculate the new averages when a new review is made and attached to a Dorm.
     * @param d the dorm profile with new averages.
     * @return a HashMap with a String key for rating category names and Float value for the rating.
     */
    private HashMap<String, Float> calculateAverageRatings(Dorm d) { // gets average ratings of each rating domain
        float c = 0;
        float s = 0;
        float sP = 0;
        float rA = 0;
        float f = 0;
        float con = 0;
        float w = 0;
        float o = 0;
        for (DormReview avg : allDormsReviews.get(d)) {
            c += Float.parseFloat(avg.getCleanliness());
            s += Float.parseFloat(avg.getSocialLevel());
            sP += Float.parseFloat(avg.getSoundProof());
            rA += Float.parseFloat(avg.getRatingRA());
            f += Float.parseFloat(avg.getFood());
            con += Float.parseFloat(avg.getConvenience());
            w += Float.parseFloat(avg.getWifi());
            o += Float.parseFloat(avg.getOverallRating());
        }
        HashMap<String, Float> avgRs = new HashMap<>();
        avgRs.put("Cleanliness", c / allDormsReviews.get(d).size());
        avgRs.put("Social Level", s / allDormsReviews.get(d).size());
        avgRs.put("Soundproof", sP / allDormsReviews.get(d).size());
        avgRs.put("RA", rA / allDormsReviews.get(d).size());
        avgRs.put("Food", f / allDormsReviews.get(d).size());
        avgRs.put("Convenience", con / allDormsReviews.get(d).size());
        avgRs.put("WiFi", w / allDormsReviews.get(d).size());
        avgRs.put("Overall Rating", o / allDormsReviews.get(d).size());
        return avgRs;
    }
    /**
     * Updates the average ratings of a Dorm.
     * @param d the dorm profile to be updated.
     */
    private void updateAverageRatings(Dorm d) { //
        HashMap<String, Float> x = calculateAverageRatings(d);
        d.setAvgCleanliness(x.get("Cleanliness"));
        d.setAvgSocialLevel(x.get("Social Level"));
        d.setAvgSoundProof(x.get("Soundproof"));
        d.setAvgRARating(x.get("RA"));
        d.setAvgFood(x.get("Food"));
        d.setAvgConvenience(x.get("Convenience"));
        d.setAvgWifi(x.get("WiFi"));
        d.setAvgOverallRating(x.get("Overall Rating"));
    }

    /**
     * A getter for a particular Dorm, searched for by their name.
     * @param dName the Residence Name of the Dorm to find.
     * @return the desired Dorm.
     */

    public Dorm getDorm(String dName) {
        for (Dorm d : allDormsReviews.keySet()) {
            if (dName.equalsIgnoreCase(d.getResidenceName())) {
                return d;

            }
        }
        return null;
    }

    /**
     * Searches and returns for a review by using their reviewID.
     * @param ID the ID of the DormReview the user seeks.
     * @return the desired DormReview
     */
    @Override
    public DormReview getReviewByID(String ID){
        for (DormReview dr: listDormReviews){
            if (dr.getID().equalsIgnoreCase(ID)){
                return dr;
            }
        }
        return null;
    }

    /**
     * A getter for the HashMap of Dorm profiles and their reviews.
     * @return a HashMap with the Dorms as a key and an ArrayList of their associated ProfessorReviews as the value.
     */
    public HashMap<Dorm, ArrayList<DormReview>> getAllDormReviews(){
        return allDormsReviews;
    }


    /**
     * Allows a user to upvote a Review.
     * @param ID the ID of the Review the user desires to upvote.
     * @return true or false for whether the upvote was successful. The upvote is only successful if the review exists.
     */
    @Override
    public boolean upvote(String ID){
        DormReview dr = getReviewByID(ID);
        if (dr!=null) {
            getReviewByID(ID).upVote();
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * A getter for the Review's university name. A helper method for sorters.
     * @param ID the ID for the Review being sought.
     * @return the University name of the Review given.
     */
    public String getUniName(String ID){
        return getReviewByID(ID).getReview().get("University");
    }

    /** Allows a user to downvote a review.
     *
     * @param ID the ID for the review in question.
     * @return whether the downvote was successful. Downvoting is only successful if the review in question exists.
     */
    @Override
    public boolean downvote(String ID){
        DormReview dr = getReviewByID(ID);
        if (dr!=null) {
            getReviewByID(ID).downVote();
            return true;
        }
        else{
            return false;
        }
    }

    /** A getter for all the DormReview IDs that prints to the console.
     *
     */
    @Override
    public void getAllIDs(){
        for (DormReview dr:listDormReviews){
            System.out.println(dr.getID());
        }
    }
    /**
     * Sets the reviewIDs according to the amount of reviews made for all Dorm profiles.
     */
    protected void setReviewIDs(){
        reviewIDs = listDormReviews.size() - 1;
    }

    /**
     * A general getter for the values all the Dorm attributes.
     * @param arg the sought-after attribute.
     * @param d the Dorm profile with its desired attribute.
     * @return the String of the Dorm's attribute.
     */
    public String getDormAttribute(String arg, Dorm d) {
        String retval = null;
        switch (arg) {
            case "name":
                retval = d.getResidenceName();
                break;
            case "university":
                retval = d.getUniversity();
                break;
            case "floor":
                retval = d.getFloorNumber();
                break;
            case "cleanliness":
                retval = String.valueOf(d.getAvgCleanliness());
                break;
            case "overall":
                retval = String.valueOf(d.getAvgOverallRating());
                break;
            case "social":
                retval = String.valueOf(d.getAvgSocialLevel());
                break;
            case "sound":
                retval = String.valueOf(d.getAvgSoundProof());
                break;
            case "convenience":
                retval = String.valueOf(d.getAvgConvenience());
                break;
            case "wifi":
                retval = String.valueOf(d.getAvgWifi());
                break;
            case "food":
                retval = String.valueOf(d.getAvgFood());
                break;
            case "RA":
                retval = String.valueOf(d.getAvgRARating());
                break;
        }
        return retval;
    }
    /**
     * A general getter for the values all attributes of a DormReview.
     * @param arg the sought-after attribute.
     * @param d the DormReview with its desired attribute.
     * @return the String of the DormReview's attribute.
     */
    public String getDormReviewAttribute(String arg, DormReview d) {
        String retval = null;
        switch (arg) {
            case "name":
                retval = d.getDormName();
                break;
            case "cleanliness":
                retval = String.valueOf(d.getCleanliness());
                break;
            case "overall":
                retval = String.valueOf(d.getOverallRating());
                break;
            case "social":
                retval = String.valueOf(d.getSocialLevel());
                break;
            case "sound":
                retval = String.valueOf(d.getSoundProof());
                break;
            case "convenience":
                retval = String.valueOf(d.getConvenience());
                break;
            case "wifi":
                retval = String.valueOf(d.getWifi());
                break;
            case "food":
                retval = String.valueOf(d.getFood());
                break;
            case "RA":
                retval = String.valueOf(d.getRatingRA());
                break;
            case "upvotes":
                retval = String.valueOf(d.getUpvotes());
                break;
            case "downvotes":
                retval = String.valueOf(d.getDownvotes());
                break;
            case "ID":
                retval = d.getID();
                break;
            case "reviewer":
                retval = d.getReviewer();
                break;
            case "timestamp":
                retval = d.getTimestamp().toString();
                break;
            case "comment":
                retval = d.getComment();
                break;
        }
        return retval;
    }
    /**
     * A getter for the list of reviews in a Dorm profile.
     * @param d the desired Dorm profile with its desired reviews.
     * @return an ArrayList of DormReviews associated with the dorm.
     */
    public ArrayList<DormReview> getListOfReviews(Dorm d) {return allDormsReviews.get(d);}

    public void editRating(String arg, String newVal, String ID, DormReview r, UniversityManager unim) {
        String uniName = getUniName(ID);
        Dorm d = unim.getDormInCertainUniByName(uniName, r.getDormName());
        r.editReview(arg, newVal);
        updateAverageRatings(d);
    }

    public ArrayList<DormReview> getListOfAllDormReviews() {
        return listDormReviews;
    }
}