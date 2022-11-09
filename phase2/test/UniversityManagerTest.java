import ReviewSystem.UniversitySystem.*;
import org.junit.*;
import ReviewSystem.CourseSystem.*;
import ReviewSystem.ProfessorSystem.*;
import ReviewSystem.DormSystem.*;


import static org.junit.Assert.*;
public class UniversityManagerTest {
    @Test(timeout=50)
    public void testGetCertainUniversityByName(){
        UniversityManager um = new UniversityManager();
        University u1 = new University("1");
        University u2 = new University("2");
        um.getUniversities().put("1",u1);
        um.getUniversities().put("2",u2);
        assertEquals(um.getCertainUniversityByName("1"),u1);
        assertEquals(um.getCertainUniversityByName("2"),u2);
        assertNotEquals(um.getCertainUniversityByName("2"),u1);
        assertNotEquals(um.getCertainUniversityByName("1"),u2);

    }

    @Test(timeout=50)
    public void testCreateUniversityByName(){
        UniversityManager um = new UniversityManager();
        um.createUniversityWithName("1");
        um.createUniversityWithName("2");
        um.createUniversityWithName("a");
        assertTrue(um.whetherHaveUniversity("1"));
        assertTrue(um.whetherHaveUniversity("2"));
        assertTrue(um.whetherHaveUniversity("A"));
        assertTrue(um.whetherHaveUniversity("a"));
        assertFalse(um.whetherHaveUniversity("3"));
        assertFalse(um.whetherHaveUniversity("b"));

    }

    @Test(timeout=50)
    public void testAddEntitiesInCertainUni() {
        UniversityManager um = new UniversityManager();
        um.createUniversityWithName("1");
        um.createUniversityWithName("2");
        Dorm d1 = new Dorm("e", "3", "1");
        Dorm d2 = new Dorm("f", "3", "2");
        Professor p1 = new Professor("c", "math", "1");
        Professor p2 = new Professor("d", "math", "2");
        Course c1 = new Course("a", "m", "1");
        Course c2 = new Course("b", "m", "2");
        um.addCourseInCertainUni("1", c1);
        um.addCourseInCertainUni("2", c2);
        um.addProfessorInCertainUni("1", p1);
        um.addProfessorInCertainUni("2", p2);
        um.addDormInCertainUni("1", d1);
        um.addDormInCertainUni("2", d2);
        assertTrue(um.whetherCertainUniHaveCourse("1", "a"));
        assertTrue(um.whetherCertainUniHaveCourse("2", "b"));
        assertTrue(um.whetherCertainUniHaveProfessor("1", "c"));
        assertTrue(um.whetherCertainUniHaveProfessor("2", "d"));
        assertTrue(um.whetherCertainUniHaveDorm("1", "e"));
        assertTrue(um.whetherCertainUniHaveDorm("2", "f"));
    }

    @Test(timeout=50)
    public void testWhetherContain(){
        UniversityManager um = new UniversityManager();
        um.createUniversityWithName("1");
        um.createUniversityWithName("2");
        Dorm d1 = new Dorm("e","3","1");
        Dorm d2 = new Dorm("f","3","2");
        Professor p1 = new Professor("c", "math","1");
        Professor p2 = new Professor("d", "math","2");
        Course c1 = new Course("a","m","1");
        Course c2 = new Course("b","m","2");
        um.addCourseInCertainUni("1",c1);
        um.addCourseInCertainUni("2",c2);
        um.addProfessorInCertainUni("1",p1);
        um.addProfessorInCertainUni("2",p2);
        um.addDormInCertainUni("1",d1);
        um.addDormInCertainUni("2",d2);
        assertTrue(um.whetherCertainUniHaveCourse("1","A"));
        assertTrue(um.whetherCertainUniHaveCourse("2","B"));
        assertTrue(um.whetherCertainUniHaveProfessor("1","C"));
        assertTrue(um.whetherCertainUniHaveProfessor("2","D"));
        assertTrue(um.whetherCertainUniHaveDorm("1","E"));
        assertTrue(um.whetherCertainUniHaveDorm("2","F"));
        assertFalse(um.whetherCertainUniHaveCourse("1","b"));
        assertFalse(um.whetherCertainUniHaveCourse("2","a"));
        assertFalse(um.whetherCertainUniHaveProfessor("1","d"));
        assertFalse(um.whetherCertainUniHaveProfessor("2","c"));
        assertFalse(um.whetherCertainUniHaveDorm("1","f"));
        assertFalse(um.whetherCertainUniHaveDorm("2","e"));
    }
    @Test(timeout=50)
    public void testGetEntitiesInCertainUni() {
        UniversityManager um = new UniversityManager();
        um.createUniversityWithName("1");
        um.createUniversityWithName("2");
        Dorm d1 = new Dorm("e", "3", "1");
        Dorm d2 = new Dorm("f", "3", "2");
        Professor p1 = new Professor("c", "math", "1");
        Professor p2 = new Professor("d", "math", "2");
        Course c1 = new Course("a", "m", "1");
        Course c2 = new Course("b", "m", "2");
        um.addCourseInCertainUni("1", c1);
        um.addCourseInCertainUni("2", c2);
        um.addProfessorInCertainUni("1", p1);
        um.addProfessorInCertainUni("2", p2);
        um.addDormInCertainUni("1", d1);
        um.addDormInCertainUni("2", d2);
        assertEquals(um.getDormInCertainUniByName("1","e"),d1);
        assertEquals(um.getDormInCertainUniByName("2","f"),d2);
        assertEquals(um.getProfessorInCertainUniByName("1","c"),p1);
        assertEquals(um.getProfessorInCertainUniByName("2","d"),p2);
        assertEquals(um.getCourseInCertainUniByName("1","a"),c1);
        assertEquals(um.getCourseInCertainUniByName("2","b"),c2);
        assertNotEquals(um.getDormInCertainUniByName("1","e"),d2);
        assertNotEquals(um.getDormInCertainUniByName("2","f"),d1);
        assertNotEquals(um.getProfessorInCertainUniByName("1","c"),p2);
        assertNotEquals(um.getProfessorInCertainUniByName("2","d"),p1);
        assertNotEquals(um.getCourseInCertainUniByName("1","a"),c2);
        assertNotEquals(um.getCourseInCertainUniByName("2","b"),c1);
        assertNull(um.getDormInCertainUniByName("1","f"));
        assertNull(um.getProfessorInCertainUniByName("1","d"));
        assertNull(um.getCourseInCertainUniByName("2","a"));
    }





}
