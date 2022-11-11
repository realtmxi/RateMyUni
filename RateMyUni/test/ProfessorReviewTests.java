import ReviewSystem.ProfessorSystem.ProfessorReview;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.HashMap;
import ReviewSystem.ProfessorSystem.ProfessorReview;
public class ProfessorReviewTests {

    @Test
    public void testProfessorReviewConstructor() {
        HashMap<String, String> review = new HashMap<>();
        review.put("Comment", "jokes");
        review.put("Difficulty", "3");
        review.put("Engagement", "3");
        review.put("Clarity", "4");
        review.put("Overall Rating", "3");
        review.put("profName", "Mario");
        review.put("Attendance", "true");
        review.put("Textbook", "false");
        review.put("Course Code", "MAT224");
        ProfessorReview pReview = new ProfessorReview("Elsa", review);

        assertEquals("Mario", pReview.getProfName());
    }

    @Test
    public void testGetCourseName() {
        HashMap<String, String> review = new HashMap<>();
        review.put("Comment", "jokes");
        review.put("Difficulty", "3");
        review.put("Engagement", "3");
        review.put("Clarity", "4");
        review.put("Overall Rating", "3");
        review.put("profName", "Mario");
        review.put("Attendance", "true");
        review.put("Textbook", "false");
        review.put("Course Code", "MAT224");
        ProfessorReview pReview = new ProfessorReview("Elsa", review);

        assertEquals("MAT224", pReview.getCourseName());
    }

    @Test
    public void testGetComment() {
        HashMap<String, String> review = new HashMap<>();
        review.put("Comment", "jokes");
        review.put("Difficulty", "3");
        review.put("Engagement", "3");
        review.put("Clarity", "4");
        review.put("Overall Rating", "3");
        review.put("profName", "Mario");
        review.put("Attendance", "true");
        review.put("Textbook", "false");
        review.put("Course Code", "MAT224");
        ProfessorReview pReview = new ProfessorReview("Elsa", review);

        assertEquals("jokes", pReview.getComment());
    }

    @Test
    public void testGetAttendance() {
        HashMap<String, String> review = new HashMap<>();
        review.put("Comment", "jokes");
        review.put("Difficulty", "3");
        review.put("Engagement", "3");
        review.put("Clarity", "4");
        review.put("Overall Rating", "3");
        review.put("profName", "Mario");
        review.put("Attendance", "true");
        review.put("Textbook", "false");
        review.put("Course Code", "MAT224");
        ProfessorReview pReview = new ProfessorReview("Elsa", review);

        assertEquals("true", pReview.getAttendance());
    }

    @Test
    public void testGetTextbook() {
        HashMap<String, String> review = new HashMap<>();
        review.put("Comment", "jokes");
        review.put("Difficulty", "3");
        review.put("Engagement", "3");
        review.put("Clarity", "4");
        review.put("Overall Rating", "3");
        review.put("profName", "Mario");
        review.put("Attendance", "true");
        review.put("Textbook", "false");
        review.put("Course Code", "MAT224");
        ProfessorReview pReview = new ProfessorReview("Elsa", review);

        assertEquals("false", pReview.getTextbook());
    }

    @Test
    public void testGetDifficulty() {
        HashMap<String, String> review = new HashMap<>();
        review.put("Comment", "jokes");
        review.put("Difficulty", "3");
        review.put("Engagement", "3");
        review.put("Clarity", "4");
        review.put("Overall Rating", "3");
        review.put("profName", "Mario");
        review.put("Attendance", "true");
        review.put("Textbook", "false");
        review.put("Course Code", "MAT224");
        ProfessorReview pReview = new ProfessorReview("Elsa", review);

        assertEquals("3", pReview.getDifficulty());
    }

    @Test
    public void testGetEngagement() {
        HashMap<String, String> review = new HashMap<>();
        review.put("Comment", "jokes");
        review.put("Difficulty", "3");
        review.put("Engagement", "3");
        review.put("Clarity", "4");
        review.put("Overall Rating", "3");
        review.put("profName", "Mario");
        review.put("Attendance", "true");
        review.put("Textbook", "false");
        review.put("Course Code", "MAT224");
        ProfessorReview pReview = new ProfessorReview("Elsa", review);

        assertEquals("3", pReview.getEngagement());
    }

    @Test
    public void testGetClarity() {
        HashMap<String, String> review = new HashMap<>();
        review.put("Comment", "jokes");
        review.put("Difficulty", "3");
        review.put("Engagement", "3");
        review.put("Clarity", "4");
        review.put("Overall Rating", "3");
        review.put("profName", "Mario");
        review.put("Attendance", "true");
        review.put("Textbook", "false");
        review.put("Course Code", "MAT224");
        ProfessorReview pReview = new ProfessorReview("Elsa", review);

        assertEquals("4", pReview.getClarity());
    }

    @Test
    public void testGetOverallRating() {
        HashMap<String, String> review = new HashMap<>();
        review.put("Comment", "jokes");
        review.put("Difficulty", "3");
        review.put("Engagement", "3");
        review.put("Clarity", "4");
        review.put("Overall Rating", "3");
        review.put("profName", "Mario");
        review.put("Attendance", "true");
        review.put("Textbook", "false");
        review.put("Course Code", "MAT224");
        ProfessorReview pReview = new ProfessorReview("Elsa", review);

        assertEquals("3", pReview.getOverallRating());
    }

    @Test
    public void testGetProfName() {
        HashMap<String, String> review = new HashMap<>();
        review.put("Comment", "jokes");
        review.put("Difficulty", "3");
        review.put("Engagement", "3");
        review.put("Clarity", "4");
        review.put("Overall Rating", "3");
        review.put("profName", "Elsa");
        review.put("Attendance", "true");
        review.put("Textbook", "false");
        review.put("Course Code", "MAT224");
        ProfessorReview pReview = new ProfessorReview("Elsa", review);

        assertEquals("Elsa", pReview.getProfName());
    }
}
