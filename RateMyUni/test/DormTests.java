import ReviewSystem.DormSystem.Dorm;
import org.junit.Test;
//import phase1.Dorm;

import static org.junit.Assert.assertEquals;
public class DormTests {

    @Test(timeout = 50)
    public void testGetResidenceName(){
        Dorm d = new Dorm("res", "4", "UofT");

        assertEquals("The residence name is incorrect\n", "res", d.getResidenceName());
    }

    @Test(timeout = 50)
    public void testGetFloorNumber(){
        Dorm d = new Dorm("res", "4", "UofT");

        assertEquals("The floor number is incorrect\n", "4", d.getFloorNumber());
    }

    @Test(timeout = 50)
    public void testGetUniversity(){
        Dorm d = new Dorm("res", "4", "UofT");

        assertEquals("The university is incorrect\n", "UofT", d.getUniversity());
    }

    @Test(timeout = 50)
    public void testGetAvgCleanliness(){
        Dorm d = new Dorm("res", "4", "UofT");
        d.setAvgCleanliness(5.5f);

        assert d.getAvgCleanliness() == 5.5f : "got the wrong average cleanliness";
    }

    @Test(timeout = 50)
    public void testGetAvgSocialLevel(){
        Dorm d = new Dorm("res", "4", "UofT");
        d.setAvgSocialLevel(5.5f);

        assert d.getAvgSocialLevel() == 5.5f : "got the wrong average social level";
    }

    @Test(timeout = 50)
    public void testGetAvgSoundProof(){
        Dorm d = new Dorm("res", "4", "UofT");
        d.setAvgSoundProof(5.5f);

        assert d.getAvgSoundProof() == 5.5f : "got the wrong average sound proof";
    }

    @Test(timeout = 50)
    public void testGetAvgRARating(){
        Dorm d = new Dorm("res", "4", "UofT");
        d.setAvgRARating(5.5f);

        assert d.getAvgRARating() == 5.5f : "got the wrong average RA rating";
    }

    @Test(timeout = 50)
    public void testGetAvgFood(){
        Dorm d = new Dorm("res", "4", "UofT");
        d.setAvgFood(5.5f);

        assert d.getAvgFood() == 5.5f : "got the wrong average food rating";
    }

    @Test(timeout = 50)
    public void testGetAvgConvenience(){
        Dorm d = new Dorm("res", "4", "UofT");
        d.setAvgConvenience(5.5f);

        assert d.getAvgConvenience() == 5.5f : "got the wrong average level of convenience";
    }

    @Test(timeout = 50)
    public void testGetAvgWifi(){
        Dorm d = new Dorm("res", "4", "UofT");
        d.setAvgWifi(5.5f);

        assert d.getAvgWifi() == 5.5f : "got the wrong average wifi rating";
    }

    @Test(timeout = 50)
    public void testGetAvgOverallRating(){
        Dorm d = new Dorm("res", "4", "UofT");
        d.setAvgOverallRating(5.5f);

        assert d.getAvgOverallRating() == 5.5f : "got the wrong overall average rating";
    }

}
