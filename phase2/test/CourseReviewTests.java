import ReviewSystem.CourseSystem.CourseReview;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.HashMap;

public class CourseReviewTests {

    @Test
    public void testCourseReviewConstructor() {
        HashMap<String, String> review = new HashMap<>();
        review.put("Comment", "jokes");
        review.put("Difficulty", "3");
        review.put("Workload", "3");
        review.put("Participation", "4");
        review.put("Overall Rating", "3");
        review.put("profName", "Mario");
        review.put("Inclusive", "true");
        review.put("Theoretical", "false");
        review.put("Course Code", "MAT224");
        review.put("Applicable", "true");
        CourseReview cReview = new CourseReview("Elsa", review);

        assertEquals("MAT224", cReview.getCourseCode());
    }
}
