import org.junit.*;
import static org.junit.Assert.*;
import java.util.HashMap;
import ReviewSystem.CourseSystem.CourseReviewManager;
import ReviewSystem.CourseSystem.Course;
import ReviewSystem.Review;
public class CourseReviewManagerTest {
    @Test(timeout=50)
    public void testCreatCourse() {
        CourseReviewManager cManager = new CourseReviewManager();
        Course c = cManager.createCourse("MAT237", "Math", "University Of Toronto");
        Course c1 = cManager.createCourse("MAT244", "Math", "University Of Toronto");
        assertTrue(cManager.getAllCourseReviews().containsKey(c));
        assertTrue(cManager.getAllCourseReviews().containsKey(c1));

    }


    @Test(timeout=50)
    public void testAddReview() {
        CourseReviewManager cManager2 = new CourseReviewManager();
        Course c1 = cManager2.createCourse("MAT237", "Math", "University Of Toronto");
        Course c2 = cManager2.createCourse("MAT224","MATH","University of Toronto");
        HashMap<String,String> review1 = new HashMap<>();
        review1.put("Difficulty", String.valueOf(3));
        review1.put("Workload", String.valueOf(3));
        review1.put("Overall Rating", String.valueOf(4));
        review1.put("Inclusive", String.valueOf(true));
        review1.put("Applicable", String.valueOf(true));
        review1.put("Theoretical", String.valueOf(false));
        review1.put("Participation", String.valueOf(false));
        HashMap<String,String> review2 = new HashMap<>();
        review2.put("Difficulty", String.valueOf(4));
        review2.put("Workload", String.valueOf(2));
        review2.put("Overall Rating", String.valueOf(3));
        review2.put("Inclusive", String.valueOf(true));
        review2.put("Applicable", String.valueOf(false));
        review2.put("Theoretical", String.valueOf(false));
        review2.put("Participation", String.valueOf(true));
        Review r1 = cManager2.addReview(review1,"NUO",c1);
        Review r2 = cManager2.addReview(review2,"NUO",c2);
        assertTrue(cManager2.getAllCourseReviews().get(c1).contains(r1));
        assertTrue(cManager2.getListCourseReviews().contains(r2));
        assertTrue(cManager2.getAllCourseReviews().get(c2).contains(r2));
        assertTrue(cManager2.getListCourseReviews().contains(r1));
    }

    @Test(timeout=50)
    public void testDeleteReview() {
        CourseReviewManager cManager2 = new CourseReviewManager();
        Course c1 = cManager2.createCourse("MAT237", "Math", "University Of Toronto");
        Course c2 = cManager2.createCourse("MAT224","MATH","University of Toronto");
        HashMap<String,String> review1 = new HashMap<>();
        review1.put("Difficulty", String.valueOf(3));
        review1.put("Workload", String.valueOf(3));
        review1.put("Overall Rating", String.valueOf(4));
        review1.put("Inclusive", String.valueOf(true));
        review1.put("Applicable", String.valueOf(true));
        review1.put("Theoretical", String.valueOf(false));
        review1.put("Participation", String.valueOf(false));
        HashMap<String,String> review2 = new HashMap<>();
        review2.put("Difficulty", String.valueOf(4));
        review2.put("Workload", String.valueOf(2));
        review2.put("Overall Rating", String.valueOf(3));
        review2.put("Inclusive", String.valueOf(true));
        review2.put("Applicable", String.valueOf(false));
        review2.put("Theoretical", String.valueOf(false));
        review2.put("Participation", String.valueOf(true));
        Review r1 = cManager2.addReview(review1,"NUO",c1);
        Review r2 = cManager2.addReview(review2,"NUO",c2);
        assertTrue(cManager2.getAllCourseReviews().get(c1).contains(r1));
        assertTrue(cManager2.getListCourseReviews().contains(r1));
        assertTrue(cManager2.getAllCourseReviews().get(c2).contains(r2));
        assertTrue(cManager2.getListCourseReviews().contains(r2));
        cManager2.deleteReview(r1.ID,c1);
        assertFalse(cManager2.getAllCourseReviews().get(c1).contains(r1));
        assertFalse(cManager2.getListCourseReviews().contains(r1));
        cManager2.deleteReview(r2.ID, c2);
        assertFalse(cManager2.getAllCourseReviews().get(c2).contains(r2));
        assertFalse(cManager2.getListCourseReviews().contains(r2));

    }


    @Test(timeout=50)
    public void testCalculateAverage() {
        CourseReviewManager cManager = new CourseReviewManager();
        Course c1 = cManager.createCourse("MAT237", "Math", "University Of Toronto");
        HashMap<String,String> review1 = new HashMap<>();
        review1.put("Difficulty", String.valueOf(3));
        review1.put("Workload", String.valueOf(3));
        review1.put("Overall Rating", String.valueOf(4));
        review1.put("Inclusive", String.valueOf(true));
        review1.put("Applicable", String.valueOf(true));
        review1.put("Theoretical", String.valueOf(false));
        review1.put("Participation", String.valueOf(false));
        HashMap<String,String> review2 = new HashMap<>();
        review2.put("Difficulty", String.valueOf(4));
        review2.put("Workload", String.valueOf(2));
        review2.put("Overall Rating", String.valueOf(3));
        review2.put("Inclusive", String.valueOf(true));
        review2.put("Applicable", String.valueOf(false));
        review2.put("Theoretical", String.valueOf(false));
        review2.put("Participation", String.valueOf(true));
        cManager.addReview(review1,"NUO",c1);
        cManager.addReview(review2,"NUO",c1);
        HashMap<String, Float> rating = cManager.calculateAverageRatings(c1);
        assertEquals(3.5, rating.get("Difficulty"), 0.001);
        assertEquals(2.5, rating.get("Workload"), 0.001);
        assertEquals((3.5), rating.get("Overall Rating"),0.001);
        assertEquals((100), rating.get("Inclusive"), 0.001);
        assertEquals((50), rating.get("Applicable"), 0.001);
        assertEquals((0),rating.get("Theoretical"),0.001);
        assertEquals((50),rating.get("Participation"),0.001);

    }
    @Test
    public void testGetAllCourseReviews() {
        CourseReviewManager cManager2 = new CourseReviewManager();
        Course c1 = cManager2.createCourse("MAT237", "Math", "University Of Toronto");
        Course c2 = cManager2.createCourse("MAT224","MATH","University of Toronto");
        HashMap<String,String> review1 = new HashMap<>();
        review1.put("Difficulty", String.valueOf(3));
        review1.put("Workload", String.valueOf(3));
        review1.put("Overall Rating", String.valueOf(4));
        review1.put("Inclusive", String.valueOf(true));
        review1.put("Applicable", String.valueOf(true));
        review1.put("Theoretical", String.valueOf(false));
        review1.put("Participation", String.valueOf(false));
        HashMap<String,String> review2 = new HashMap<>();
        review2.put("Difficulty", String.valueOf(4));
        review2.put("Workload", String.valueOf(2));
        review2.put("Overall Rating", String.valueOf(3));
        review2.put("Inclusive", String.valueOf(true));
        review2.put("Applicable", String.valueOf(false));
        review2.put("Theoretical", String.valueOf(false));
        review2.put("Participation", String.valueOf(true));
        Review r1 = cManager2.addReview(review1,"NUO",c1);
        Review r2 = cManager2.addReview(review2,"NUO",c2);
        assertTrue(cManager2.getAllCourseReviews().containsKey(c1));
        assertTrue(cManager2.getAllCourseReviews().containsKey(c2));
        assertTrue(cManager2.getAllCourseReviews().get(c1).contains(r1));
        assertTrue(cManager2.getAllCourseReviews().get(c2).contains(r2));
    }

    @Test(timeout=50)
    public void testGetReviewByID(){
        CourseReviewManager cManager2 = new CourseReviewManager();
        Course c1 = cManager2.createCourse("MAT237", "Math", "University Of Toronto");
        HashMap<String,String> review1 = new HashMap<>();
        review1.put("Difficulty", String.valueOf(3));
        review1.put("Workload", String.valueOf(3));
        review1.put("Overall Rating", String.valueOf(4));
        review1.put("Inclusive", String.valueOf(true));
        review1.put("Applicable", String.valueOf(true));
        review1.put("Theoretical", String.valueOf(false));
        review1.put("Participation", String.valueOf(false));
        Review r1 = cManager2.addReview(review1,"NUO",c1);
        assertEquals(r1, cManager2.getReviewByID(r1.getID()));
    }
    @Test(timeout=50)
    public void testUpvote(){
        CourseReviewManager cManager2 = new CourseReviewManager();
        Course c1 = cManager2.createCourse("MAT237", "Math", "University Of Toronto");
        HashMap<String,String> review1 = new HashMap<>();
        review1.put("Difficulty", String.valueOf(3));
        review1.put("Workload", String.valueOf(3));
        review1.put("Overall Rating", String.valueOf(4));
        review1.put("Inclusive", String.valueOf(true));
        review1.put("Applicable", String.valueOf(true));
        review1.put("Theoretical", String.valueOf(false));
        review1.put("Participation", String.valueOf(false));
        Review r1 = cManager2.addReview(review1,"NUO",c1);
        assertTrue(cManager2.upvote(r1.getID()));
        assertFalse(cManager2.upvote("123"));
    }

    @Test(timeout=50)
    public void testDownVote(){
        CourseReviewManager cManager2 = new CourseReviewManager();
        Course c1 = cManager2.createCourse("MAT237", "Math", "University Of Toronto");
        HashMap<String,String> review1 = new HashMap<>();
        review1.put("Difficulty", String.valueOf(3));
        review1.put("Workload", String.valueOf(3));
        review1.put("Overall Rating", String.valueOf(4));
        review1.put("Inclusive", String.valueOf(true));
        review1.put("Applicable", String.valueOf(true));
        review1.put("Theoretical", String.valueOf(false));
        review1.put("Participation", String.valueOf(false));
        Review r1 = cManager2.addReview(review1,"NUO",c1);
        assertTrue(cManager2.downvote(r1.getID()));
        assertFalse(cManager2.downvote("123"));
    }




}
