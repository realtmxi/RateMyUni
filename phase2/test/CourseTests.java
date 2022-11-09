import ReviewSystem.CourseSystem.Course;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class CourseTests {
    @Test(timeout = 50)
    public void testGetCourseCode() {
        Course c = new Course("csc207", "comp sci", "UofT");

        assertEquals("Course code is incorrect", "csc207", c.getCourseCode());
    }

    @Test(timeout = 50)
    public void testGetDepartment() {
        Course c = new Course("csc207", "comp sci", "UofT");

        assertEquals("Department is incorrect", "comp sci", c.getDepartment());
    }

    @Test(timeout = 50)
    public void testGetUniversity() {
        Course c = new Course("csc207", "comp sci", "UofT");

        assertEquals("University is incorrect", "UofT", c.getUniversity());
    }

    @Test(timeout = 50)
    public void testGetAvgOverallRating() {
        Course c = new Course("csc207", "comp sci", "UofT");
        c.setAvgOverallRating(5.5f);

        assert c.getAvgOverallRating() == 5.5f : "Wrong overall average rating";
    }

    @Test(timeout = 50)
    public void testGetAvgTheoretical() {
        Course c = new Course("csc207", "comp sci", "UofT");
        c.setAvgTheoretical(5.5f);

        assert c.getAvgTheoretical() == 5.5f : "Wrong average theoretical rating";
    }

    @Test(timeout = 50)
    public void testGetAvgApplicable() {
        Course c = new Course("csc207", "comp sci", "UofT");
        c.setAvgApplicable(5.5f);

        assert c.getAvgApplicable() == 5.5f : "Wrong average applicable rating";
    }

    @Test(timeout = 50)
    public void testGetAvgInclusive() {
        Course c = new Course("csc207", "comp sci", "UofT");
        c.setAvgInclusive(5.5f);

        assert c.getAvgInclusive() == 5.5f : "Wrong average inclusive rating";
    }

    @Test(timeout = 50)
    public void testGetAvgDifficulty() {
        Course c = new Course("csc207", "comp sci", "UofT");
        c.setAverageDifficulty(5.5f);

        assert c.getAverageDifficulty() == 5.5f : "Wrong average difficulty rating";
    }

    @Test(timeout = 50)
    public void testGetAvgWorkload() {
        Course c = new Course("csc207", "comp sci", "UofT");
        c.setAverageWorkload(5.5f);

        assert c.getAverageWorkload() == 5.5f : "Wrong average workload rating";
    }

    @Test(timeout = 50)
    public void testSetCourseCode() {
        Course c = new Course("csc207", "comp sci", "UofT");
        c.setCourseCode("csc209");

        assertEquals("Course code did not change", "csc209", c.getCourseCode());
    }

    @Test(timeout = 50)
    public void testSetDepartment() {
        Course c = new Course("csc207", "comp sci", "UofT");
        c.setDepartment("eng sci");

        assertEquals("Department did not change", "eng sci", c.getDepartment());
    }

    @Test(timeout = 50)
    public void testSetUniversity() {
        Course c = new Course("csc207", "comp sci", "UofT");
        c.setUniversity("Waterloo");

        assertEquals("University did not change", "Waterloo", c.getUniversity());
    }
}
