import org.junit.*;
import UserProfileSystem.UserSystem.User;

import static org.junit.Assert.*;
/* import java.util.ArrayList;
* import java.util.List;
* import java.util.Arrays;
*/

public class UserTests {

    // the non-admin phase1.User constructor
    @Test(timeout = 50)
    public void testBasicUserConstructor() {
        User user = new User("elsa", "test1");

        assertEquals("Password is incorrect", "test1", user.getPassword());
    }

    // test getUserName()
    @Test(timeout = 50)
    public void testGetUserName() {
        User user = new User("elsa", "test");

        assertEquals("Username does not output correctly for this user\n", "elsa", user.getUserName());
    }

    // test getPassword()
    @Test(timeout = 50)
    public void testGetPassword() {
        User xavier = new User("x", "x2022");
        User allen = new User("allen", "admin");
        allen.setAdmin(true);
        assertEquals("Password output incorrect\n", "x2022", xavier.getPassword());
        assertEquals("Password output incorrect\n", "admin", allen.getPassword());

    }

    // test setPassword for Users to change their password
    @Test(timeout = 50)
    public void testSetPassword() {
        User a = new User("a", "1");
        a.setPassword("3");

        assertEquals("Password did not change", "3", a.getPassword());
    }

    // test isAdmin()
    @Test(timeout = 50)
    public void testGetAdmin() {
        User banana = new User("anna", "banana");
        User dragonFruit = new User("jake", "american");
        dragonFruit.setAdmin(true);

        assertFalse("phase1.User is not an admin", banana.isAdmin());
        assertTrue("phase1.User is an admin", dragonFruit.isAdmin());
    }

    // test setAdmin()
    @Test(timeout = 50)
    public void testSetAdmin() {
        User banana = new User("anna", "banana");
        User carrot = new User("sally", "carrot");
        carrot.setAdmin(true);
        User dragonFruit = new User("jake", "american");
        dragonFruit.setAdmin(true);
        User elderBerry = new User("sambuca", "soda");

        banana.setAdmin(false);
        carrot.setAdmin(true);
        dragonFruit.setAdmin(false);
        elderBerry.setAdmin(true);


        assertFalse("phase1.User should not be an admin", banana.isAdmin());
        assertTrue("phase1.User should be an admin", carrot.isAdmin());
        assertTrue("Admin users should not change admin status", dragonFruit.isAdmin());
        assertTrue("phase1.User should be an admin", elderBerry.isAdmin());

    }


}
