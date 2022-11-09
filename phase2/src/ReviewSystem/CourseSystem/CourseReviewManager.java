package ReviewSystem.CourseSystem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import ReviewSystem.UniversitySystem.UniversityManager;
import ReviewSystem.ReviewManager;
import ReviewSystem.Review;

/**
 * The CourseReviewManager handles the creation of Course and CourseReviews objects to create and edit the reviewable course profile and create, edit or remove reviews.
 *
 */
public class CourseReviewManager extends ReviewManager implements Serializable {
    private final HashMap<Course, ArrayList<CourseReview>> allCourseReviews = new HashMap<>();
    private final ArrayList<CourseReview> listCourseReviews = new ArrayList<>();
    private int reviewIDs;

    /**
     * A sorter method for various sortBy methods to reorganize display of reviews according to the user's desire.
     * @param comparator the comparator being used to organize the list of Reviews for a particular Dorm.
     */
    @Override
    public void sort(Comparator<Review> comparator){
       listCourseReviews.sort(comparator.reversed());
    }

    public ArrayList<CourseReview> getListOfAllCourseReviews(){
        return listCourseReviews;
    }

    /**
     * Initializes a new instance of CourseReviewManager with a new HashMap for all Course and their reviews,
     * a list of CourseReviews, and sets the review IDs variable according to how many reviews there are in the list of CourseReviews.
     */
    public CourseReviewManager(){
        setReviewIDs();

    }

    /**
     * Initializes an instance of Course.
     * @param courseCode the Course's Code
     * @param dep the department associated with the course.
     * @param uni the University where this Dorm is located.
     */
    public Course createCourse(String courseCode, String dep, String uni) {
        Course c = new Course(courseCode, dep, uni);
        allCourseReviews.put(c, new ArrayList<>());
        return c;
    }

    /**
     * A getter for the Review's university name. A helper method for sorters.
     * @param ID the ID for the Review being sought.
     * @return the University name of the Review given.
     */
    public String getUniName(String ID){
        return getReviewByID(ID).getReview().get("University");
    }

    /**
     * A getter for the list of the totality of CourseReviews made.
     * @return an ArrayList of CourseReviews.
     */
    public ArrayList<CourseReview> getListCourseReviews(){
        return listCourseReviews;
    }


    /**
     *Initializes a CourseReview and attaches it in the HashMap to the Course being reviewed,and the list of all
     *CourseReviews. Upon each CourseReview addition, the reviewable Course profile averages are updated with its new averages.
     *@param review A HashMap of String key comment or rating categories and String values that can be parsed later to be Integer or Boolean.
     *a CourseReview HashMap should be instantiated with a University name, Course Code, Comment, Overall Rating, Difficulty, Workload, Participation,
     *Theoretical, Applicable, Inclusive categories.
     *@param reviewer the username of the User making this review.
     * @param c the Course profile to which the new CourseReview will be attached.
     *@return the created CourseReview.
     */
    public CourseReview addReview(HashMap<String,String> review, String reviewer,Course c){
        CourseReview r = new CourseReview(reviewer,review);
        reviewIDs++;
        r.setID("CR"+reviewIDs);
        allCourseReviews.get(c).add(r);
        listCourseReviews.add(r);
        updateAverageRatings(c);
        return r;
    }

    /** Deletes a review from a course profile using the Course Code and the CourseReview's ID.
     *
     * @param  c the corresponding entity of the Course
     * @param ID the ID of the CourseReview to be deleted.
     */
    public void deleteReview( String ID, Course c){
        ArrayList<CourseReview> newList = allCourseReviews.get(c);
        CourseReview r = getReviewByID(ID);
        if (r!=null) {
            newList.remove(r);
            allCourseReviews.replace(c, allCourseReviews.get(c), newList);
            CourseReview cr = getReviewByID(ID);
            listCourseReviews.remove(cr);
            updateAverageRatings(c);
        }
    }
    /**
     * A helper method to calculate the new averages when a new review is made and attached to a Course.
     * @param c the course profile with new averages.
     * @return a HashMap with a String key for rating category names and Float value for the rating.
     */
    public HashMap<String, Float> calculateAverageRatings(Course c) { // gets average ratings of each rating domain
        HashMap<String, Float> avgRs = new HashMap<>();
        float d = 0;
        float w = 0;
        float o = 0;
        float a = 0;
        float i = 0;
        float t = 0;
        float p = 0;

        for (CourseReview avg : allCourseReviews.get(c)) {
            d += Float.parseFloat(avg.getDifficulty());
            w += Float.parseFloat(avg.getWorkload());
            o += Float.parseFloat(avg.getOverallRating());
            if (Boolean.parseBoolean(avg.isApplicable())){
                a++;
            }
            if (Boolean.parseBoolean(avg.isInclusive())){
                i++;
            }
            if (Boolean.parseBoolean(avg.isTheoretical())){
                t++;
            }
            if (Boolean.parseBoolean(avg.getParticipation())){
                p++;
            }
        }
        avgRs.put("Difficulty", d / allCourseReviews.get(c).size());
        avgRs.put("Workload", w / allCourseReviews.get(c).size());
        avgRs.put("Overall Rating", o / allCourseReviews.get(c).size());
        avgRs.put("Inclusive", (i / (allCourseReviews.get(c).size())) * 100);
        avgRs.put("Applicable", (a / (allCourseReviews.get(c).size())) * 100);
        avgRs.put("Theoretical", (t / (allCourseReviews.get(c).size())) * 100);
        avgRs.put("Participation", (p / (allCourseReviews.get(c).size())) * 100);
        return avgRs;
    }

    /**
     * Updates the average ratings of a Course profile.
     * @param c the Course profile to be updated.
     */
    private void updateAverageRatings(Course c) { //
        HashMap<String, Float> x = calculateAverageRatings(c);
        c.setAverageDifficulty(x.get("Difficulty"));
        c.setAverageWorkload(x.get("Workload"));
        c.setAvgOverallRating(x.get("Overall Rating"));
        c.setAvgInclusive(x.get("Inclusive"));
        c.setAvgApplicable(x.get("Applicable"));
        c.setAvgTheoretical(x.get("Theoretical"));
        c.setAvgParticipation(x.get("Participation"));
    }

    /**
     * A getter for a particular Course, searched for by their course code.
     * @param courseCode the Course Code of the Course to find.
     * @return the desired Course object.
     */
    public Course getCourse(String courseCode) {
        for (Course c : allCourseReviews.keySet()) {
            if (courseCode.equalsIgnoreCase(c.getCourseCode())) {
                return c;
            }
        }
        return null;
    }


    public String getCourseCode(Course c){
        return c.getCourseCode();
    }


    /**
     * A getter for the HashMap of Course profiles and their reviews.
     * @return a HashMap with the Course as a key and an ArrayList of their associated CourseReviews as the value.
     */
    public HashMap<Course, ArrayList<CourseReview>> getAllCourseReviews(){
        return allCourseReviews;
    }

    /**
     * Searches and returns for a review by using their reviewID.
     * @param ID the ID of the CourseReview the user seeks.
     * @return the desired CourseReview
     */
    @Override
    public CourseReview getReviewByID(String ID){
        for (CourseReview cr: listCourseReviews){
            if (cr.getID().equalsIgnoreCase(ID)){
                return cr;
            }
        }
        return null;
    }

    /**
     * Allows a user to upvote a Review.
     * @param ID the ID of the Review the user desires to upvote.
     * @return true or false for whether the upvote was successful. The upvote is only successful if the review exists.
     */
    @Override
    public boolean upvote(String ID){
        CourseReview cr = getReviewByID(ID);
        if (cr!=null) {
            getReviewByID(ID).upVote();
            return true;
        }
        else{
            return false;
        }
    }

    /** Allows a user to downvote a review.
     *
     * @param ID the ID for the review in question.
     * @return whether the downvote was successful. Downvoting is only successful if the review in question exists.
     */
    @Override
    public boolean downvote(String ID){
        CourseReview cr = getReviewByID(ID);
        if (cr!=null) {
            getReviewByID(ID).downVote();
            return true;
        }
        else{
            return false;
        }
    }

    /** A getter for all the CourseReview IDs that prints to the console.
     *
     */
    @Override
    public void getAllIDs(){
        for (CourseReview cr:listCourseReviews){
            System.out.println(cr.getID());
        }
    }

    /**
     * Sets the reviewIDs according to the amount of reviews made for all Course profiles.
     */
    protected void setReviewIDs(){
        reviewIDs = listCourseReviews.size() - 1;
    }

    /**
     * A general getter for the values all the Course attributes.
     * @param arg the sought-after attribute.
     * @param c the Course profile with its desired attribute.
     * @return the String of the Course's attribute.
     */
    public String getCourseAttribute(String arg,Course c){
        String retval = null;
        switch(arg){
            case "course code":
                retval = c.getCourseCode();
                break;
            case "department":
                retval = c.getDepartment();
                break;
            case "university":
                retval = c.getUniversity();
                break;
            case "difficulty":
                retval = String.valueOf(c.getAverageDifficulty());
                break;
            case "workload":
                retval = String.valueOf(c.getAverageWorkload());
                break;
            case "theory":
                retval = String.valueOf(c.getAvgTheoretical());
                break;
            case "applied":
                retval = String.valueOf(c.getAvgApplicable());
                break;
            case "inclusive":
                retval = String.valueOf(c.getAvgInclusive());
                break;
            case "overall":
                retval = String.valueOf(c.getAvgOverallRating());
                break;
            default:
                break;
        }
        return retval;
    }

    /**
     * A general getter for the values all attributes of a CourseReview.
     * @param arg the sought-after attribute.
     * @param cr the CourseReview with its desired attribute.
     * @return the String of the CourseReview's attribute.
     */
    public String getCourseReviewAttribute(String arg,CourseReview cr){
        String retval = null;
        switch(arg){
            case "course code":
                retval = cr.getCourseCode();
                break;
            case "ID":
                retval = cr.getID();
                break;
            case "reviewer":
                retval = cr.getReviewer();
                break;
            case "comment":
                retval = cr.getComment();
                break;
            case "difficulty":
                retval = String.valueOf(cr.getDifficulty());
                break;
            case "workload":
                retval = String.valueOf(cr.getWorkload());
                break;
            case "overall":
                retval = String.valueOf(cr.getOverallRating());
                break;
            case "theoretical":
                retval = String.valueOf(cr.isTheoretical());
                break;
            case "applicable":
                retval = String.valueOf(cr.isApplicable());
                break;
            case "inclusive":
                retval = String.valueOf(cr.isInclusive());
                break;
            case "upvotes":
                retval = String.valueOf(cr.getUpvotes());
                break;
            case "downvotes":
                retval = String.valueOf(cr.getDownvotes());
                break;
            case "timestamp":
                retval = cr.getTimestamp().toString();
                break;
            case "participation":
                retval = String.valueOf(cr.getParticipation());
                break;
            default:
                break;
        }
        return retval;
    }


    /**
     * A getter for the list of reviews in a Course profile.
     * @param course the desired Course profile with its desired reviews.
     * @return an ArrayList of CourseReviews associated with the course.
     */
    public ArrayList<CourseReview> getListOfReviews(Course course) {
        return allCourseReviews.get(course);
    }

    public void editRating(String arg, String newVal, String ID, CourseReview r, UniversityManager unim) {
        String uniName = getUniName(ID);
        Course c = unim.getCourseInCertainUniByName(uniName, r.getCourseCode());
        r.editReview(arg, newVal);
        updateAverageRatings(c);
    }


}
