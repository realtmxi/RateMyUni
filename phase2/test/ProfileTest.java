import ReviewSystem.CourseSystem.CourseReview;
import ReviewSystem.ProfessorSystem.ProfessorReview;
import ReviewSystem.Review;
import UserProfileSystem.ProfileSystem.Profile;
import org.junit.*;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;


public class ProfileTest{
    @Test(timeout=50)
    public void testSetGetUserName(){
        Profile p = new Profile("nuo", "2022","85060090@qq.com");
        assertEquals("nuo", p.getUsername());
        p.setUsername("Nuo");
        assertEquals("Nuo",p.getUsername());
    }

    @Test(timeout=50)
    public void testSetGetYear(){
        Profile p = new Profile("nuo", "2021","85060090@qq.com");
        assertEquals("2021", p.getYear());
        p.setYear("2022");
        assertEquals("2022",p.getYear());
    }


    @Test(timeout=50)
    public void testSetGetEmail(){
        Profile p = new Profile("nuo", "2021","85060090@qq.com");
        assertEquals("85060090@qq.com", p.getEmail());
        p.setEmail("850@qq.com");
        assertEquals("850@qq.com",p.getEmail());

    }


    @Test(timeout=50)
    public void testSetWhetherAdmin(){
        Profile p = new Profile("nuo", "2021","85060090@qq.com");
        assertFalse(p.isAdmin());
        p.setAdmin(true);
        assertTrue(p.isAdmin());
        p.setAdmin(true);
        assertTrue(p.isAdmin());
        p.setAdmin(false);
        assertFalse(p.isAdmin());

    }



//    @Test(timeout=50)
//    public void testMethodReviewsLeft(){
//        HashMap<String,String> review1 = new HashMap<>();
//        review1.put("1","2");
//        HashMap<String,String> review2 = new HashMap<>();
//        review2.put("2","2");
//        Review r1 = new CourseReview("nuo", review1);
//        Review r2 = new ProfessorReview("nuo", review2);
//        Profile p = new Profile("nuo", "2021","85060090@qq.com");
//        p.addToReviewsLeft(r1);
//        p.addToReviewsLeft(r2);
//        assertTrue(p.getReviewsLeft().contains(r1));
//        assertTrue(p.getReviewsLeft().contains(r2));
//        p.deleteFromReviewsLeft(r1);
//        p.deleteFromReviewsLeft(r2);
//        assertFalse(p.getReviewsLeft().contains(r1));
//        assertFalse(p.getReviewsLeft().contains(r2));
//    }
//
//    @Test(timeout=50)
//    public void testMethodReviewsLeft(){
//        HashMap<String,String> review1 = new HashMap<>();
//        review1.put("1","2");
//        HashMap<String,String> review2 = new HashMap<>();
//        review2.put("2","2");
//        Review r1 = new CourseReview("nuo", review1);
//        Review r2 = new ProfessorReview("nuo", review2);
//        Profile p = new Profile("nuo", "2021","85060090@qq.com");
//        p.addToReviewsLeft(r1);
//        p.addToReviewsLeft(r2);
//        assertTrue(p.getReviewsLeft().contains(r1));
//        assertTrue(p.getReviewsLeft().contains(r2));
//        p.deleteFromReviewsLeft(r1);
//        p.deleteFromReviewsLeft(r2);
//        assertFalse(p.getReviewsLeft().contains(r1));
//        assertFalse(p.getReviewsLeft().contains(r2));
//    }


    @Test(timeout=50)
    public void testaddRemoveVotedReviews(){
        HashMap<String,String> review1 = new HashMap<>();
        review1.put("1","2");
        HashMap<String,String> review2 = new HashMap<>();
        review2.put("2","2");
        Review r1 = new CourseReview("nuo", review1);
        Review r2 = new ProfessorReview("nuo", review2);
        Profile p = new Profile("nuo", "2021","85060090@qq.com");
        ArrayList<String> l1= new ArrayList<>();
        l1.add(r1.ID);
        l1.add(r2.ID);
        p.addToUpvotedReviews(r1.ID);
        p.addToUpvotedReviews(r2.ID);
        assertEquals(p.getUpvotedReviews(),l1);
        l1.remove(r2.ID);
        p.removeFromUpvotedReviews(r1.ID);
        assertEquals(p.getUpvotedReviews(),l1);
        ArrayList<String> l2= new ArrayList<>();
        l2.add(r2.ID);
        l2.add(r1.ID);
        p.addToDownvotedReviews(r2.ID);
        p.addToDownvotedReviews(r1.ID);
        assertEquals(p.getDownvotedReviews(),l2);
        l2.remove(r1.ID);
        p.removeFromDownvotedReviews(r1.ID);
        assertEquals(p.getDownvotedReviews(),l2);




    }




//    @Test(timeout=50)
//    public void testGetAllID(){
//        HashMap<String,String> review1 = new HashMap<>();
//        review1.put("1","2");
//        HashMap<String,String> review2 = new HashMap<>();
//        review2.put("2","2");
//        Review r1 = new CourseReview("nuo", review1);
//        Review r2 = new ProfessorReview("nuo", review2);
//        Profile p = new Profile("nuo", "2021","85060090@qq.com");
//        ArrayList<String> l1= new ArrayList<>();
//        l1.add(r1.ID);
//        l1.add(r2.ID);
//        p.addToReviewsLeft(r1);
//        p.addToReviewsLeft(r2);
//        assertEquals(l1, p.getReviewsLeftIDs());
//
//    }






}
