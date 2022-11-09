package ReviewSystem.ProfessorSystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import ReviewSystem.UniversitySystem.UniversityManager;
import ReviewSystem.ReviewManager;
import ReviewSystem.Review;

/**
 * The ProfessorReviewManager handles the creation of Professor and ProfessorReview objects to create and edit the reviewable dorm profile and create, edit or remove reviews.
 *
 */
public class ProfessorReviewManager extends ReviewManager implements Serializable {
    //private static final long serialVersionUID = -4795072596354797799L;
    /**
     * Stores an ArrayList of ProfessorReviews (value) attached to a Professor (key).
     */
    private final HashMap<Professor, ArrayList<ProfessorReview>> allProfsReviews = new HashMap<>();
    /**
     * A list of ProfessorReviews
     */
    private final ArrayList<ProfessorReview> listProfReviews = new ArrayList<>();
    /**
     * A counter for each ProfessorReview created
     */
    private int reviewIDs;

    /**
     * Initializes a new instance of ProfessorReviewManager with a new HashMap for all Professors and their reviews,
     * a list of ProfessorReviews, and sets the review IDs variable according to how many reviews there are in the list of ProfessorReviews.
     */
    public ProfessorReviewManager() {
        setReviewIDs();
    }

    /**
     * A sorter method for various sortBy methods to reorganize display of reviews according to the user's desire.
     *
     * @param comparator the comparator being used to organize the list of Reviews for a particular Professor
     */
    @Override
    public void sort(Comparator<Review> comparator) {
        listProfReviews.sort(comparator.reversed());
    }

    /**
     * Initializes an instance of Professor
     *
     * @param pName      is the Professor's name
     * @param dep        is the department the Professor teaches in.
     * @param university is the university the Professor teaches at.
     */
    public Professor createProfessor(String pName, String dep, String university) {
        Professor prof = new Professor(pName, dep, university);
        allProfsReviews.put(prof, new ArrayList<>());
        return prof;
    }

    /**
     * A getter for the HashMap of Professor profiles and their reviews.
     *
     * @return a HashMap with the Professors as a key and an ArrayList of their associated ProfessorReviews as the value.
     */
    public HashMap<Professor, ArrayList<ProfessorReview>> getAllProfReviews() {
        return allProfsReviews;
    }

    /**
     * A getter for all the ProfessorReview IDs that prints to the console.
     */
    public void getAllIDs() {
        for (ProfessorReview pr : listProfReviews) {
            System.out.println(pr.getID());
        }
    }

    /**
     * Initializes a ProfessorReview and attaches it in the HashMap to the Professor being reviewed, and the list of all
     * ProfessorReviews. Professor profiles' averages are updated upon each ProfessorReview added to it.
     *
     * @param review   A HashMap of String key rating categories and String values that can be parsed later to be Integer or Boolean.
     *                 The ProfessorReview should be instantiated with a University name, profName, Comment, Overall Rating, Difficulty, Clarity, Engagement, Attendance and Textbook ratings.
     * @param reviewer The username of the user making this review.
     * @param p        The corresponding Dorm to which the review is being added.
     * @return returns the created ProfessorReview
     */
    public ProfessorReview addReview(HashMap<String, String> review, String reviewer, Professor p) {
        ProfessorReview r = new ProfessorReview(reviewer, review);
        reviewIDs++;
        r.setID("PR" + reviewIDs);
        allProfsReviews.get(p).add(r);
        listProfReviews.add(r);
        updateAverageRatings(p);
        return r;
    }

    /**
     * A getter for a particular Professor, searched for by their name.
     *
     * @param profName the first and last name of the Professor to find.
     * @return the desired Professor.
     */
    public Professor getProf(String profName) {
        for (Professor p : allProfsReviews.keySet()) {
            if (profName.equalsIgnoreCase(p.getProfessorName())) {
                return p;
            }
        }
        return null;
    }

    /**
     * A getter for the Review's university name. A helper method for sorters.
     *
     * @param ID the ID for the Review being sought.
     * @return the University name of the Review given.
     */
    public String getUniName(String ID) {
        return getReviewByID(ID).getReview().get("University");
    }

    /**
     * Deletes a review from a Professor profile using the Professor's name and the ProfessorReview's ID.
     *
     * @param p  is the corresponding entity of professor
     * @param ID The ID of the ProfessorReview they want to delete.
     */

    public void deleteReview(String ID, Professor p) {
        ArrayList<ProfessorReview> newList = allProfsReviews.get(p);
        ProfessorReview r = getReviewByID(ID);
        if (r != null) {
            newList.remove(r);
            allProfsReviews.replace(p, allProfsReviews.get(p), newList);
            ProfessorReview pr = getReviewByID(ID);
            listProfReviews.remove(pr);
            updateAverageRatings(p);
        }

    }

    /**
     * Searches and returns for a review by using their reviewID.
     *
     * @param ID the ID of the ProfessorReview the user seeks.
     * @return the desired ProfessorReview
     */
    @Override
    public ProfessorReview getReviewByID(String ID) {
        for (ProfessorReview pr : listProfReviews) {
            if (pr.getID().equalsIgnoreCase(ID)) {
                return pr;
            }
        }
        return null;
    }

    /**
     * Allows a user to upvote a Review.
     *
     * @param ID the ID of the Review the user desires to upvote.
     * @return true or false for whether the upvote was successful. The upvote is only successful if the review exists.
     */
    @Override
    public boolean upvote(String ID) {
        ProfessorReview pr = getReviewByID(ID);
        if (pr != null) {
            getReviewByID(ID).upVote();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Allows a user to downvote a review.
     *
     * @param ID the ID for the review in question.
     * @return whether the downvote was successful. Downvoting is only successful if the review in question exists.
     */
    @Override
    public boolean downvote(String ID) {
        ProfessorReview pr = getReviewByID(ID);
        if (pr != null) {
            getReviewByID(ID).downVote();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void undoUpvote(String ID) {
        //note, this method is ONLY called when we are sure a review of this ID exists
        getReviewByID(ID).undoUpvote();
    }

    @Override
    public void undoDownvote(String ID) {
        //note, this method is ONLY called when we are sure a review of this ID exists
        getReviewByID(ID).undoDownvote();
    }


    /**
     * A helper method to calculate the new averages when a new review is made and attached to a Professor.
     *
     * @param p the Professor profile with new averages.
     * @return a HashMap with a String key for rating category names and Float value for the rating.
     */
    public HashMap<String, Float> calculateAverageRatings(Professor p) {
        HashMap<String, Float> avgRs = new HashMap<>();
        float d = 0;
        float c = 0;
        float e = 0;
        float o = 0;
        float a = 0;
        float t = 0;
        for (ProfessorReview avg : allProfsReviews.get(p)) {
            d += Float.parseFloat(avg.getDifficulty());
            c += Float.parseFloat(avg.getClarity());
            e += Float.parseFloat(avg.getEngagement());
            o += Float.parseFloat(avg.getOverallRating());
            if (Boolean.parseBoolean(avg.getAttendance())) {
                a++;
            }
            if (Boolean.parseBoolean(avg.getTextbook())) {
                t++;
            }
        }

        avgRs.put("Difficulty", d / allProfsReviews.get(p).size());
        avgRs.put("Clarity", c / allProfsReviews.get(p).size());
        avgRs.put("Engagement", e / allProfsReviews.get(p).size());
        avgRs.put("Overall Rating", o / allProfsReviews.get(p).size());
        avgRs.put("Attendance", (a / (allProfsReviews.get(p).size())) * 100);
        avgRs.put("Textbook", (t / (allProfsReviews.get(p).size())) * 100);
        return avgRs;
    }

    /**
     * Updates the average ratings of a Professor profile.
     *
     * @param p the Professor profile to be updated.
     */
    protected void updateAverageRatings(Professor p) {
        HashMap<String, Float> x = calculateAverageRatings(p);
        p.setAverageDifficulty(x.get("Difficulty"));
        p.setAverageClarity(x.get("Clarity"));
        p.setAverageEngagement(x.get("Engagement"));
        p.setAvgOverallRating(x.get("Overall Rating"));
        p.setAverageAttendance(x.get("Attendance"));
        p.setAverageTextbook(x.get("Textbook"));
    }

    /**
     * Sets the reviewIDs according to the amount of reviews made for all Professor profiles.
     */
    protected void setReviewIDs() {
        reviewIDs = listProfReviews.size() - 1;
    }

    /**
     * A general getter for the values all the Professor attributes.
     *
     * @param arg the sought-after attribute.
     * @param p   the Professor profile with its desired attribute.
     * @return the String of the Professor's attribute.
     */
    public String getProfAttribute(String arg, Professor p) {
        String retval = null;
        switch (arg) {
            case "name":
                retval = p.getProfessorName();
                break;
            case "department":
                retval = p.getDepartment();
                break;
            case "university":
                retval = p.getUniversity();
                break;
            case "overall":
                retval = String.valueOf(p.getAvgOverallRating());
                break;
            case "difficulty":
                retval = String.valueOf(p.getAverageDifficulty());
                break;
            case "engagement":
                retval = String.valueOf(p.getAverageEngagement());
                break;
            case "clarity":
                retval = String.valueOf(p.getAverageClarity());
                break;
            case "attendance":
                retval = String.valueOf(p.getAverageAttendance());
                break;
            case "textbook":
                retval = String.valueOf(p.getAverageTextbook());
                break;
            default:
                break;
        }
        return retval;
    }

    /**
     * A general getter for the values all attributes of a ProfessorReview.
     *
     * @param arg the sought-after attribute.
     * @param p   the ProfessorReview with its desired attribute.
     * @return the String of the ProfessorReview's attribute.
     */
    public String getProfReviewAttribute(String arg, ProfessorReview p) {
        String retval = null;
        switch (arg) {
            case "name":
                retval = p.getProfName();
                break;
            case "course":
                retval = p.getCourseName();
                break;
            case "reviewer":
                retval = p.getReviewer();
                break;
            case "comment":
                retval = p.getComment();
                break;
            case "overall":
                retval = String.valueOf(p.getOverallRating());
                break;
            case "difficulty":
                retval = String.valueOf(p.getDifficulty());
                break;
            case "engagement":
                retval = String.valueOf(p.getEngagement());
                break;
            case "clarity":
                retval = String.valueOf(p.getClarity());
                break;
            case "attendance":
                retval = String.valueOf(p.getAttendance());
                break;
            case "textbook":
                retval = String.valueOf(p.getTextbook());
                break;
            case "timestamp":
                retval = String.valueOf(p.getTimestamp());
                break;
            case "ID":
                retval = p.getID();
                break;
            case "upvotes":
                retval = String.valueOf(p.getUpvotes());
                break;
            case "downvotes":
                retval = String.valueOf(p.getDownvotes());
                break;
            default:
                break;
        }
        return retval;
    }

    /**
     * A getter for the list of reviews in a Professor profile.
     *
     * @param p the desired Professor profile with its desired reviews.
     * @return an ArrayList of ProfessorReviews associated with the professor.
     */
    public ArrayList<ProfessorReview> getListOfReviews(Professor p) {
        return allProfsReviews.get(p);
    }

    public void editRating(String arg, String newVal, String ID, ProfessorReview r, UniversityManager unim) {
        String uniName = getUniName(ID);
        Professor prof = unim.getProfessorInCertainUniByName(uniName, r.getProfName());
        r.editReview(arg, newVal);
        updateAverageRatings(prof);
    }

    public void editCourseName(ProfessorReview r, String cn) {r.editReview("Course Code", cn);}

    public ArrayList<ProfessorReview> getListOfAllProfReviews() {
        return listProfReviews;
    }
}





