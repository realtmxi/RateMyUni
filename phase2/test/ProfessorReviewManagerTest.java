import ReviewSystem.ProfessorSystem.Professor;
import ReviewSystem.ProfessorSystem.ProfessorReviewManager;
import ReviewSystem.Review;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.HashMap;
import ReviewSystem.ProfessorSystem.Professor;
import ReviewSystem.ProfessorSystem.ProfessorReviewManager;
import ReviewSystem.Review;
public class ProfessorReviewManagerTest {
    @Test
    public void testGetAllProfsReviews() {
        ProfessorReviewManager pManager = new ProfessorReviewManager();
        pManager.createProfessor("Mario", "Math", "University Of Toronto");
    }


    @Test
    public void testCreateProfessor() {
        ProfessorReviewManager pManager = new ProfessorReviewManager();
        Professor p2 = new Professor("hu","Math","uoft");
        Professor p = pManager.createProfessor("Mario", "Math", "University Of Toronto");
        assertTrue(pManager.getAllProfReviews().containsKey(p));
        assertFalse(pManager.getAllProfReviews().containsKey(p2));
    }

    @Test(timeout=100)
    public void testAddReview(){
        ProfessorReviewManager pManager = new ProfessorReviewManager();
        Professor p = pManager.createProfessor("Mario", "Math", "University Of Toronto");

        HashMap<String,String> review1 = new HashMap<>();
        review1.put("Difficulty", String.valueOf(3));
        review1.put("Clarity", String.valueOf(3));
        review1.put("Engagement", String.valueOf(4));
        review1.put("Overall Rating", String.valueOf(4));
        review1.put("Attendance", String.valueOf(true));
        review1.put("Textbook", String.valueOf(false));
        Review r1 = pManager.addReview(review1,"nuo",p);
        assertTrue(pManager.getAllProfReviews().get(p).contains(r1));
        //    assertTrue(pManager.getListProfReviews().contains(r1)); in the code it does not add the new reviews to listProfReviwes
    }
    @Test
    public void testGetProf(){
        ProfessorReviewManager pManager = new ProfessorReviewManager();
        Professor p2 = new Professor("hu","Math","uoft");
        Professor pr1 = pManager.createProfessor("Mario", "Math", "University Of Toronto");
        assertTrue(pManager.getAllProfReviews().containsKey(pr1));
       assertFalse(pManager.getAllProfReviews().containsKey(p2));
    }

    @Test
    public void testDeleteReview(){
        ProfessorReviewManager pManager = new ProfessorReviewManager();
        Professor p = pManager.createProfessor("Mario", "Math", "University Of Toronto");
        HashMap<String,String> review1 = new HashMap<>();
        review1.put("Difficulty", String.valueOf(3));
        review1.put("Clarity", String.valueOf(3));
        review1.put("Engagement", String.valueOf(4));
        review1.put("Overall Rating", String.valueOf(4));
        review1.put("Attendance", String.valueOf(true));
        review1.put("Textbook", String.valueOf(false));
        Review r1 = pManager.addReview(review1,"nuo",p);
        Review r2 = pManager.addReview(review1,"ami",p);
        pManager.deleteReview(r1.ID,p);
        assertTrue(pManager.getAllProfReviews().get(p).contains(r2));
        assertFalse(pManager.getAllProfReviews().get(p).contains(r1));
    }

    @Test(timeout=200)
    public void testGetReviewID(){
        ProfessorReviewManager pManager = new ProfessorReviewManager();
        Professor p = pManager.createProfessor("Mario", "Math", "University Of Toronto");
        HashMap<String,String> review1 = new HashMap<>();
        review1.put("Difficulty", String.valueOf(3));
        review1.put("Clarity", String.valueOf(3));
        review1.put("Engagement", String.valueOf(4));
        review1.put("Overall Rating", String.valueOf(4));
        review1.put("Attendance", String.valueOf(true));
        review1.put("Textbook", String.valueOf(false));
        Review r1 = pManager.addReview(review1,"nuo",p);
        Review r2 = pManager.addReview(review1,"ami",p);
        assertEquals(r1,pManager.getReviewByID(r1.getID()));
        assertEquals(r2, pManager.getReviewByID(r2.getID()));

    }

    @Test
    public void testCalculateAverageRatings(){
        ProfessorReviewManager pManager = new ProfessorReviewManager();
        Professor p = pManager.createProfessor("Mario", "Math", "University Of Toronto");
        HashMap<String,String> review1 = new HashMap<>();
        review1.put("Difficulty", String.valueOf(3));
        review1.put("Clarity", String.valueOf(3));
        review1.put("Engagement", String.valueOf(4));
        review1.put("Overall Rating", String.valueOf(4));
        review1.put("Attendance", String.valueOf(true));
        review1.put("Textbook", String.valueOf(false));
        HashMap<String,String> review2 = new HashMap<>();
        review2.put("Difficulty", String.valueOf(4));
        review2.put("Clarity", String.valueOf(2));
        review2.put("Engagement", String.valueOf(3));
        review2.put("Overall Rating", String.valueOf(4));
        review2.put("Attendance", String.valueOf(true));
        review2.put("Textbook", String.valueOf(true));
        pManager.addReview(review1,"Nuo",p);
        pManager.addReview(review2,"Nuo",p);
        HashMap<String, Float> rating = pManager.calculateAverageRatings(p);
        assertEquals(3.5, rating.get("Difficulty"), 0.001);
        assertEquals(2.5, rating.get("Clarity"), 0.001);
        assertEquals((3.5), rating.get("Engagement"),0.001);
        assertEquals((4), rating.get("Overall Rating"), 0.001);
        assertEquals((100), rating.get("Attendance"), 0.001);
        assertEquals((50),rating.get("Textbook"),0.001);

    }

    @Test(timeout=200)
    public void testUpvote(){
        ProfessorReviewManager pManager = new ProfessorReviewManager();
        Professor p = pManager.createProfessor("Mario", "Math", "University Of Toronto");
        HashMap<String,String> review1 = new HashMap<>();
        review1.put("Difficulty", String.valueOf(3));
        review1.put("Clarity", String.valueOf(3));
        review1.put("Engagement", String.valueOf(4));
        review1.put("Overall Rating", String.valueOf(4));
        review1.put("Attendance", String.valueOf(true));
        review1.put("Textbook", String.valueOf(false));
        Review r1 = pManager.addReview(review1,"Nuo",p);
        assertTrue(pManager.upvote(r1.getID()));
        assertFalse(pManager.upvote("123"));
    }

    @Test(timeout=100)
    public void testDownVote(){
        ProfessorReviewManager pManager = new ProfessorReviewManager();
        Professor p = pManager.createProfessor("Mario", "Math", "University Of Toronto");
        HashMap<String,String> review1 = new HashMap<>();
        review1.put("Difficulty", String.valueOf(3));
        review1.put("Clarity", String.valueOf(3));
        review1.put("Engagement", String.valueOf(4));
        review1.put("Overall Rating", String.valueOf(4));
        review1.put("Attendance", String.valueOf(true));
        review1.put("Textbook", String.valueOf(false));
        Review r1 = pManager.addReview(review1,"Nuo",p);
        assertTrue(pManager.downvote(r1.getID()));
        assertFalse(pManager.downvote("123"));
    }

}

