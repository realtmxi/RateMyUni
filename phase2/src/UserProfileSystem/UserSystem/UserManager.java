package UserProfileSystem.UserSystem;

import UserProfileSystem.ProfileSystem.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

/**
 * A use case class that is responsible for creating new users, storing user log-in info and their profiles,
 *
 */
public class UserManager implements Serializable {
    private static final long serialVersionUID = -8704400108370323000L;
    private final HashMap<String,String> allUserInfo;
    private final ArrayList<User> allUsers;
    private final ProfileManager profileManager;
    //must store a profile manager to update the list of profiles in profile manager


    /**
     * Initiates hashmap containing user info as well as a default admin
     */
    public UserManager(){
        allUserInfo = new HashMap<>();
        allUsers = new ArrayList<>();
        profileManager = new ProfileManager();
        addUser("defaultAdmin","protected_password");
        makeUserAdmin(getUser("defaultAdmin"));
        //every user system should have a default admin
    }

    /**
     * Allows user to change their usernames
     * @param user the user whose name is to be changed
     * @param newName the new name
     */
    public void changeName(User user, String newName){
        String oldName = user.getUserName();
        user.setUserName(newName);
        allUserInfo.remove(oldName);
        allUserInfo.put(newName,user.getPassword());
    }


    /**
     * checks whether the new name already exists
     * @param newName the name that the username will be changed to
     * @return boolean indicating whether this new name is valid
     */
    public boolean checkIfNameExists(String newName){
        return allUserInfo.containsKey(newName);
    }


    public HashMap<String,String> getAllUserInfo(){
        return allUserInfo;
    }

    public ArrayList<User> getAllUsers(){
        return allUsers;
    }

    /**
     * Searches for a user with a certain username, returns null if user does not exist
     * @param username name of the user to be searched for
     * @return User
     */
    public User getUser(String username){
        //assuming username exists
        for (User found_user : allUsers) {
            if (found_user.getUserName().equals(username)) {
                return found_user;
            }
        }
        return null;
    }

    public Profile getUserProfile(User user){
        return user.getProfile();
    }

    public String getUserName(User user){
        return user.getUserName();
    }

    public User createNewUser(String username, String password){
        return new User(username, password);
    }

    /**
     * Tries to add the user to the system, if user already exists, return false
     * @param username the name of the user to be added
     * @param password the password of the user to be added
     * @return boolean indicating whether add was successful or not
     */
    public boolean addUser(String username, String password){
        if(!allUserInfo.containsKey(username)){
            allUserInfo.put(username, password);
            User user = createNewUser(username,password);
            allUsers.add(user);
            profileManager.addProfile(user.getProfile());
            return true;
        }
        else{return false;}
    }

    public void deleteUser(String username){
        User user = getUser(username);
        if (allUserInfo.containsKey(username)) {
            allUserInfo.remove(username);
            allUsers.remove(user);
            profileManager.deleteProfile(user.getProfile());
        }
    }




//Below are ban use methods and helpers


    /**
     * Bans the user for a specified number of hours
     * @param user the user to be banned
     * @param duration the duration in hours to ban user for
     * @return boolean indicating whether ban was successful
     */
    public boolean banUser(User user, long duration) {

        if (!checkBanStatus(user)) { //checks whether BanEndTime is null
            user.setBanEndTime(LocalDateTime.now().plusHours(duration));
            return true;
        }
        //can't ban user if they're already banned
        else{
            return false;
        }
    }


    /**
     * Checks whether this user is still banned
     * @param user the user whose ban status has to be checked
     * @return boolean indicating whether the user is still banned
     */
    public boolean checkBanStatus(User user) {
        //Return true if it is currently baned and still banned,
        // otherwise return false and update the banEndTime status
        Optional<LocalDateTime> currentBanTime = user.getBanEndTime();

        if (currentBanTime.isEmpty()) {
            // check whether currentBanTime has a value
            return false;
        } else {
            long compareResult = LocalDateTime.now().until(currentBanTime.get(), ChronoUnit.MINUTES);
            if (compareResult <= 0) {
                // ban is over, unban now
                unBan(user);
                return false;
            } else {
                return true;
            }
        }
    }

    /**
     * Unbans the user once its ban is over
     * @param user user to be unbanned
     */
    private void unBan(User user){
        user.setBanEndTime(null);
    }





    public void changeUserStatus(User user){
        //changes the active status of user
        user.setOnline(!user.isOnline());
    }

    /**
     * @param username username inputted
     * @param password password inputted
     * @return boolean indicating whether username and password matched with an existing user
     */
    public boolean checkLogInInfo(String username, String password){
        return allUserInfo.containsKey(username) && allUserInfo.get(username).equals(password);
    }

    /**
     * Updates the user's log-in history upon logging in
     * @param userAccount a user whose log-in history needs to be updated
     */
    public void addToHistory(User userAccount) { //
        userAccount.setHistory(LocalDateTime.now());
    }

    public ArrayList<String> getUserHistory(User userAccount) { return userAccount.getHistory();}

    public void makeUserAdmin(User user){
        user.setAdmin(true);
    }

    public boolean checkUserIsAdmin(User user){
        return user.isAdmin();
    }

    public boolean checkUserOnline(User user){return user.isOnline();}
    public ProfileManager getProfileManager(){
        return profileManager;
    }


}
