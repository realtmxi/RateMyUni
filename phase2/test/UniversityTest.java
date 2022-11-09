import ReviewSystem.UniversitySystem.*;
import org.junit.*;
import ReviewSystem.CourseSystem.*;
import ReviewSystem.ProfessorSystem.*;
import ReviewSystem.DormSystem.*;
import static org.junit.Assert.*;
public class UniversityTest {
    @Test(timeout=50)
    public void testUniversityGetName(){
        University u1 = new University("1");
        University u2 = new University("2");
        assertEquals(u1.getUniversityName(),"1");
        assertEquals(u2.getUniversityName(),"2");
        assertNotEquals("2", u1.getUniversityName());
        assertNotEquals("1", u2.getUniversityName());
    }
    @Test(timeout=50)
    public void testUniversityAddProfessor(){
        University u1 = new University("1");
        University u2 = new University("2");
        Professor p1 = new Professor("mario", "math","1");
        Professor p2 = new Professor("mario", "math","2");
        u1.addProfessor(p1);
        u2.addProfessor(p2);
        assertEquals(u1.getProfessors().get("mario"), p1);
        assertEquals(u2.getProfessors().get("mario"), p2);
        assertNotEquals(u1.getProfessors().get("mario"), p2);
        assertNotEquals(u2.getProfessors().get("mario"), p1);
    }

    @Test(timeout=50)
    public void testUniversityAddDorm(){
        University u1 = new University("1");
        University u2 = new University("2");
        Dorm d1 = new Dorm("1","3","1");
        Dorm d2 = new Dorm("1","3","2");
        u1.addDorm(d1);
        u2.addDorm(d2);
        assertEquals(u1.getDorms().get("1"), d1);
        assertEquals(u2.getDorms().get("1"), d2);
        assertNotEquals(u1.getDorms().get("1"), d2);
        assertNotEquals(u2.getDorms().get("q"), d1);
    }
    @Test(timeout=50)
    public void testUniversityAddCourse(){
        University u1 = new University("1");
        University u2 = new University("2");
        Course c1 = new Course("a","m","1");
        Course c2 = new Course("a","m","2");
        u1.addCourse(c1);
        u2.addCourse(c2);
        assertEquals((u1.getCourses().get("a")), c1);
        assertEquals((u2.getCourses().get("a")), c2);
        assertNotEquals((u2.getCourses().get("a")), c1);
        assertNotEquals((u1.getCourses().get("a")), c2);
    }

    @Test(timeout=50)
    public void testUniversityGetCertainProfessor(){
        University u1 = new University("1");
        Professor p1 = new Professor("a", "math","1");
        Professor p2 = new Professor("b", "math","1");
        u1.addProfessor(p1);
        u1.addProfessor(p2);
        assertEquals(u1.getCertainProfessor("a"), p1);
        assertEquals(u1.getCertainProfessor("b"), p2);
        assertNull(u1.getCertainProfessor("c"));

    }

    @Test(timeout=50)
    public void testUniversityGetCertainCourse(){
        University u1 = new University("1");
        Course c1 = new Course("a","m","1");
        Course c2 = new Course("b","m","1");
        u1.addCourse(c1);
        u1.addCourse(c2);
        assertEquals(u1.getCertainCourse("a"), c1);
        assertEquals(u1.getCertainCourse("b"), c2);
        assertNull(u1.getCertainCourse("c"));

    }

    @Test(timeout=50)
    public void testUniversityGetCertainDorm(){
        University u1 = new University("1");
        Dorm d1 = new Dorm("a","3","1");
        Dorm d2 = new Dorm("b","3","1");
        u1.addDorm(d1);
        u1.addDorm(d2);
        assertEquals(u1.getCertainDorm("a"), d1);
        assertEquals(u1.getCertainDorm("b"), d2);
        assertNull(u1.getCertainDorm("c"));

    }
    @Test(timeout=50)
    public void testUniversityContainCertainProfessor(){
        University u1 = new University("1");
        Professor p1 = new Professor("a", "math","1");
        Professor p2 = new Professor("b", "math","1");
        u1.addProfessor(p1);
        u1.addProfessor(p2);
        assertTrue(u1.whetherContainProfessor("a"));
        assertTrue(u1.whetherContainProfessor("b"));
        assertFalse(u1.whetherContainProfessor("c"));
        assertTrue(u1.whetherContainProfessor("A"));
        assertTrue(u1.whetherContainProfessor("B"));

    }

    @Test(timeout=50)
    public void testUniversityContainCertainCourse(){
        University u1 = new University("1");
        Course c1 = new Course("a","m","1");
        Course c2 = new Course("b","m","1");
        u1.addCourse(c1);
        u1.addCourse(c2);
        assertTrue(u1.whetherContainCourse("a"));
        assertTrue(u1.whetherContainCourse("b"));
        assertFalse(u1.whetherContainCourse("c"));
        assertTrue(u1.whetherContainCourse("A"));
        assertTrue(u1.whetherContainCourse("B"));

    }

    @Test(timeout=50)
    public void testUniversityContainCertainDorm(){
        University u1 = new University("1");
        Dorm d1 = new Dorm("a","3","1");
        Dorm d2 = new Dorm("b","3","1");
        u1.addDorm(d1);
        u1.addDorm(d2);
        assertTrue(u1.whetherContainDorm("a"));
        assertTrue(u1.whetherContainDorm("b"));
        assertFalse(u1.whetherContainDorm("c"));
        assertTrue(u1.whetherContainDorm("A"));
        assertTrue(u1.whetherContainDorm("B"));

    }




}
