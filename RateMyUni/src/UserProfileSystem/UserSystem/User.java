package UserProfileSystem.UserSystem;

import UserProfileSystem.ProfileSystem.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;

/**
 * creating the phase1.User class for our domain's Log-In System
 * Users should be accessed and their information modified by phase1.UserManager
 */

public class User implements Serializable {
    private String userName;
    private String password;
    private ArrayList<String> history;
    protected boolean admin; //whether this user is an admin or not
    protected boolean online = false; //logged out by default
    private  LocalDateTime banEndTime; // potential need for conversion from another java.time class
    protected Profile profile;


    /** regular phase1.User constructor
     * Initializes information for log-in, as well as provides a new history to check previous log-ins.
     * Admin status, online status and ban time are set when actually active.
     * @param userName initializes username provided
     * @param password initializes password provided
     */
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.history = new ArrayList<>();
        this.profile = new Profile(userName,"unknown","unknown");
        // no instantiation of banEndTime as getBanEndTime() covers Optional nullable if there is none.
    }

    /**
     * Get the username associated with the user
     * @return username, a string of username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * set the username associated with the user
     * @param userName, a string of username
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get the password associated with the user
     * @return password, a string of user password
     */
    public String getPassword() {
        return password;
    }

    /**
     * set the password associated with the user
     * @param password, a string of user password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * to check whether the account is an Admin account
     * @return true or false to check whether Admin
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * set the user to be an Admin user account or not
     * @param permission true or false to determine whether the user to be an admin user
     */
    public void setAdmin(boolean permission) {
        if (!admin) {
            this.admin = permission;
            this.profile.setAdmin(permission);
        }
    }

    /**
     * set the profile of the user
     * @param p a profile
     */
    public void setProfile(Profile p){
        profile = p;
    }

    /**
     * get the profile of the user
     * @return Profile
     */
    public Profile getProfile() {
        return profile;
    }

    /**
     * determine whether the user is online
     * @return true or false
     */
    protected boolean isOnline() {
        return online;
    }

    /**
     * set the condition of user whether is online or not
     * @param status, a boolean true or false
     */
    protected void setOnline(boolean status) {
        this.online = status;
    }

    /**
     * get an ArrayList of log in time history with the user
     * @return ArrayList<String>, logInTime
     */
    public ArrayList<String> getHistory() {
        return this.history;
    }

    /**
     * add the logInTime to the user log in history
     * @param logInTime, a LocalDateTime
     */
    protected void setHistory(LocalDateTime logInTime) {this.history.add(dateToString(logInTime));}

    public Optional<LocalDateTime> getBanEndTime() {
        return Optional.ofNullable(banEndTime);
    }

    /**
     * set the Banning end time of the user.
     * @param date, a LocalDateTime.
     */
    protected void setBanEndTime(LocalDateTime date) {
        this.banEndTime = date;
    }

    /**
     * transfer the LocalDateTime to "yyyy-MM--dd HH:mm:ss" format.
     * @param dt, a LocalDateTime
     * @return a string as above format of time.
     */
    protected static String dateToString(LocalDateTime dt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // (https://howtodoinjava.com/java/date-time/format-localdatetime-to-string/)
        return dt.format(formatter);
    }

    /**
     * override print statement to print the username.
     * @return username of the user.
     */
    @Override
    public String toString(){
        return this.getUserName();
    }

}

