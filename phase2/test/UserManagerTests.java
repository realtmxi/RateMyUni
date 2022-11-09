import UserProfileSystem.UserSystem.User;
import UserProfileSystem.UserSystem.UserManager;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
//import phase1.User;
//import phase1.UserManager;

import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class UserManagerTests {
    UserManager userManager = new UserManager();

    @Test(timeout=50)
    @DisplayName("UserMangerConstructor should work")
    public void testUserManagerConstructor() {
        HashMap<String, String> userInfoMap = userManager.getAllUserInfo();
        String passWord = "protected_password";
        assertEquals(userInfoMap.get("defaultAdmin"), passWord, "defaultAdmin phase1.User should be created successfully");
        assertFalse("This userinfo hashmap should not be empty", userInfoMap.isEmpty());
    }

    @Test(timeout = 50)
    public void testGetAllUsers(){
        userManager.addUser("Leo", "12345");
        assertEquals("[defaultAdmin, Leo]", userManager.getAllUsers().toString(), "Users have been added successfully");
    }
    @Test(timeout = 50)
    public void testDeleteUsers(){
        userManager.addUser("Leo", "12345");
        userManager.deleteUser("Leo");
        assertEquals("[defaultAdmin]", userManager.getAllUsers().toString(), "Leo should be deleted successfully");

    }
    @Test
    public void testChangeUserStatus(){
        User user = new User("John", "234");
        userManager.addUser(user.getUserName(),user.getPassword());
        userManager.changeUserStatus(user);
        assertTrue(userManager.checkUserOnline(user), "The status should be true");
    }

    @Test
    public void testDeleteUser(){

        userManager.addUser("Elsa", "aa");
        assertEquals("[defaultAdmin, Elsa]", userManager.getAllUsers().toString());
        userManager.deleteUser("Elsa");
        assertEquals("[defaultAdmin]", userManager.getAllUsers().toString());
    }

    // test addUser()
    @Test(timeout = 50)
    public void testAddUser() {
        User un = new User("first", "1");
        User uno = new User("First", "2");
        User deux = new User("second", "2");
        UserManager um1 = new UserManager();

        um1.addUser(un.getUserName(),un.getPassword());
        um1.addUser(uno.getUserName(),uno.getPassword());
        um1.addUser(deux.getUserName(),deux.getPassword());


        assertEquals(un.getPassword(), um1.getUser("first").getPassword(), "This user should be in the system");
        assertEquals("[]", um1.getUser("second").getHistory().toString(), "This user should be in the system");
        assertEquals(uno.getUserName(), um1.getUser("First").getUserName(), "This user should exist in the system");


    }

    // test checkLogInInfo()
    @Test(timeout = 50)
    public void testCheckLogInInfo() {
        User un = new User("first", "1");
        User deux = new User("second", "1");
        User trois = new User("third", "3");
        UserManager um1 = new UserManager();

        um1.addUser(un.getUserName(),un.getPassword());
        um1.addUser(deux.getUserName(),deux.getPassword());
        um1.addUser(trois.getUserName(),trois.getPassword());


        assertFalse("Username is incorrect", um1.checkLogInInfo("third", "1"));
        assertFalse("Password is incorrect", um1.checkLogInInfo("second", "3"));
        assertTrue(um1.checkLogInInfo("first", "1"), "Username and password are correct");
    }
    @Test
    public void testGetUser(){
        User leo = new User("leo", "123");
        userManager.addUser(leo.getUserName(),leo.getPassword());
        User newUser = userManager.getUser("leo");
        assertEquals(newUser.getUserName(), "leo");
    }

    // test addToHistory()
    @Test(timeout = 50)
    public void testAddToHistory() {
        User un = new User("first", "1");
        UserManager um1 = new UserManager();
        um1.addUser(un.getUserName(),un.getPassword());
        um1.addToHistory(un);

        User deux = new User("second", "1");
        um1.addUser(deux.getUserName(),deux.getPassword());
        um1.addToHistory(deux);

        User trois = new User("third", "3");
        um1.addUser(trois.getUserName(),trois.getPassword());
        um1.addToHistory(trois);
        um1.addToHistory(un);

        User quatre = new User("four", "4");
        um1.addUser(quatre.getUserName(),quatre.getPassword());
        um1.addToHistory(quatre);
        um1.addToHistory(trois);

        assertEquals(2, trois.getHistory().size(), "This user's history should have two login times");
        assertEquals(2, un.getHistory().size(), "This user's history should have two login times");
        assertEquals(1, deux.getHistory().size(), "This user's history should have one login times");

    }

    //test getAllUserInfo()
    @Test(timeout = 50)
    public void testGetAllUserInfo() {
        User elsa = new User("elsa", "pw");
        User Elsa = new User("Elsa", "pw2");
        UserManager um1 = new UserManager();



        assertEquals("{defaultAdmin=protected_password}", um1.getAllUserInfo().toString(), "There should be a default Admin in the phase1.UserManager");
        um1.addUser(elsa.getUserName(),elsa.getPassword());
        um1.addUser(Elsa.getUserName(),Elsa.getPassword());
        assertEquals(3, um1.getAllUserInfo().size(), "There are three users stored in phase1.UserManager");
    }

    // test banUser()
    @Test
    public void testBanUser() {
        User un = new User("first", "1");
        User deux = new User("second", "1");
        User trois = new User("third", "3");
        UserManager um1 = new UserManager();

        um1.addUser(un.getUserName(),un.getPassword());
        um1.addUser(deux.getUserName(),deux.getPassword());
        um1.addUser(trois.getUserName(),trois.getPassword());

        um1.banUser(un, 10); // tested on June 20th, only 11 days left in the month
        um1.banUser(un, 0);


//        assertTrue(um1.checkBanStatus(un),"phase1.User should be banned");
//        assertEquals("10 hour(s) remaining on your ban", um1.checkBanRem(un));
//        assertFalse("phase1.User should not be banned", um1.checkBanStatus(deux));
//        um1.banUser(deux, 0);
//        assertFalse("phase1.User should not be banned", um1.checkBanStatus(deux));
//        um1.banUser(deux, 1);
//        assertEquals("1 hour(s) remaining on your ban", um1.checkBanRem(deux));
    }

    // test makeUserAdmin()

    @Test(timeout=50)
    public void testMakeUserAdmin(){
        User un = new User("first", "1");
        User deux = new User("second", "1");
        UserManager um1 = new UserManager();

        um1.addUser(un.getUserName(),un.getPassword());
        um1.addUser(deux.getUserName(),deux.getPassword());

        um1.makeUserAdmin(un);

        assertTrue(un.isAdmin(), "This user is an admin");
        assertFalse("This user should not be an admin", deux.isAdmin());
        um1.makeUserAdmin(deux);
        assertTrue(deux.isAdmin(), "This user is an admin");

    }
}
