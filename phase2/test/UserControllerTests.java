import ControllerPresenter.Dictionaries.EnglishPromptDictionary;
import ControllerPresenter.Dictionaries.PromptDictionary;
import ControllerPresenter.UserController;
import UserProfileSystem.UserSystem.User;
import UserProfileSystem.UserSystem.UserManager;
import org.junit.*;


import static org.junit.Assert.*;


public class UserControllerTests {

    PromptDictionary pd = new EnglishPromptDictionary();
    @Test(timeout=50)

    public void testUserControllerConstructor(){
        UserController usercontroller = new UserController(pd);
        // assert true
    }

    @Test
    public void testCreateAccount(){
        UserController userController = new UserController(pd);
        UserManager userManager = new UserManager();
        User user = userController.createAccount(userManager, "Murphy", "phase0test1");

        assertEquals("Murphy", user.getUserName());
        assertEquals("phase0test1", user.getPassword());
        assertTrue(userManager.checkLogInInfo("Murphy", "phase0test1"));
        assertTrue(userManager.checkUserOnline(user));

    }

    @Test(timeout=50)
    public void testLogOut(){
        UserController userController = new UserController(pd);
        UserManager userManager = new UserManager();
        User user = userController.createAccount(userManager, "Murphy", "phase0test1");
        userController.logOut(userManager, user);
        assertFalse(userManager.checkUserOnline(user));
    }
    @Test(timeout=50)
    public void testLogIn(){
        UserController userController = new UserController(pd);
        UserManager userManager = new UserManager();
        User user = userController.createAccount(userManager, "Murphy", "phase0test1");
        // Assume logOut is true from previous test
        userController.logOut(userManager, user);
        userController.logIn(userManager,"Murphy", "phase0test1");

        assertTrue(userManager.checkUserOnline(user));
    }



    @Test(timeout=50)
    public void testCheckAdminStatus(){
        UserController userController = new UserController(pd);
        UserManager userManager = new UserManager();
        User user = userController.createAccount(userManager, "Murphy", "phase0test1");
        assertFalse(userController.CheckAdminStatus(userManager, "Murphy"));
    }
}