import ReviewSystem.ProfessorSystem.Professor;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import ReviewSystem.ProfessorSystem.Professor;
public class ProfessorTests {
    @Test(timeout = 50)
    public void testGetProfName() {
        Professor p = new Professor("Jack", "comp sci", "UofT");

        assertEquals("Prof's name is incorrect", "Jack", p.getProfessorName());
    }

    @Test(timeout = 50)
    public void testGetAvgAttendance() {
        Professor p = new Professor("Jack", "comp sci", "UofT");
        p.setAverageAttendance(5.5f);

        assert p.getAverageAttendance() == 5.5f : "Wrong average attendance";
    }

    @Test(timeout = 50)
    public void testGetAvgClarity() {
        Professor p = new Professor("Jack", "comp sci", "UofT");
        p.setAverageClarity(5.5f);

        assert p.getAverageClarity() == 5.5f : "Wrong average clarity";
    }

    @Test(timeout = 50)
    public void testGetAvgDifficulty() {
        Professor p = new Professor("Jack", "comp sci", "UofT");
        p.setAverageDifficulty(5.5f);

        assert p.getAverageDifficulty() == 5.5f : "Wrong average difficulty";
    }

    @Test(timeout = 50)
    public void testGetAvgEngagement() {
        Professor p = new Professor("Jack", "comp sci", "UofT");
        p.setAverageEngagement(5.5f);

        assert p.getAverageEngagement() == 5.5f : "Wrong average engagement";
    }

    @Test(timeout = 50)
    public void testOverallRating() {
        Professor p = new Professor("Jack", "comp sci", "UofT");
        p.setAvgOverallRating(5.5f);

        assert p.getAvgOverallRating() == 5.5f : "Wrong average overall rating";
    }

}
