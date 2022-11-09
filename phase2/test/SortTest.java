import ReviewSystem.ProfessorSystem.Professor;
import ReviewSystem.ProfessorSystem.ProfessorReview;
import ReviewSystem.ProfessorSystem.ProfessorReviewManager;
import ReviewSystem.Review;
import Sorters.SortByVotesComparator;
import Sorters.SortByOverallRatingComparator;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.HashMap;

public class SortTest {
    @Test(timeout=1000)
    public void testSortByOverallRatingComparator(){
        // test sort by overall rating through the case of professor, others would be trivially hold
        ProfessorReviewManager pm = new ProfessorReviewManager();
        Professor p = pm.createProfessor("Francois Pitt", "CS", "UofT");

        HashMap<String, String> review1 = new HashMap<>();
        review1.put("Difficulty", String.valueOf(3));
        review1.put("Clarity", String.valueOf(3));
        review1.put("Engagement", String.valueOf(4));
        review1.put("Overall Rating", String.valueOf(3));
        review1.put("Attendance", String.valueOf(true));
        review1.put("Textbook", String.valueOf(false));
        review1.put("profName", "Francois Pitt");
        pm.addReview(review1, "mur", p);
        HashMap<String, String> review2 = new HashMap<>();
        review2.put("Difficulty", String.valueOf(3));
        review2.put("Clarity", String.valueOf(3));
        review2.put("Engagement", String.valueOf(4));
        review2.put("Attendance", String.valueOf(true));
        review2.put("Textbook", String.valueOf(false));
        review2.put("Overall Rating", "4");
        review2.put("profName", "Francois Pitt");
        pm.addReview(review2, "murphyy", p);
        SortByOverallRatingComparator comparator = new SortByOverallRatingComparator();
        pm.sort(comparator);
        assertEquals(pm.getListOfAllProfReviews().get(0).getOverallRating(), "4");

    }

    @Test(timeout=1000)
    public void testSortByVotes(){
        // test sort by votes through the case of professor
        ProfessorReviewManager pManager = new ProfessorReviewManager();
        Professor p = pManager.createProfessor("Francois Pitt", "CS", "UofT");

        HashMap<String,String> review1 = new HashMap<>();
        review1.put("Difficulty", String.valueOf(3));
        review1.put("Clarity", String.valueOf(3));
        review1.put("Engagement", String.valueOf(4));
        review1.put("Overall Rating", String.valueOf(4));
        review1.put("Attendance", String.valueOf(true));
        review1.put("Textbook", String.valueOf(false));
        Review r1 = pManager.addReview(review1,"murphy",p);
        pManager.upvote(r1.getID());

        HashMap<String, String> review2 = new HashMap<>();
        review2.put("Difficulty", String.valueOf(3));
        review2.put("Clarity", String.valueOf(3));
        review2.put("Engagement", String.valueOf(4));
        review2.put("Attendance", String.valueOf(true));
        review2.put("Textbook", String.valueOf(false));
        review2.put("Overall Rating", "4");
        review2.put("profName", "Francois Pitt");
        Review r2 = pManager.addReview(review2, "murphyy", p);
        pManager.downvote(r2.getID());

        SortByVotesComparator comparator = new SortByVotesComparator();
        pManager.sort(comparator);
        assertEquals(pManager.getListOfAllProfReviews().get(0).getUpvotes(), 1);

    }
}