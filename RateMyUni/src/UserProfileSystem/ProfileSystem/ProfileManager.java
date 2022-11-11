package UserProfileSystem.ProfileSystem;

import ReviewSystem.Review;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class ProfileManager implements Serializable {
    private final ArrayList<Profile> allProfiles;
    private final HashMap<String, Profile> nameToAllProfiles;
    public ProfileManager() {
        this.allProfiles = new ArrayList<>();
        nameToAllProfiles = new HashMap<>();
    }

    public ArrayList<Profile> getAllProfiles(){
        return allProfiles;
    }

    public HashMap<String, Profile> getNameToAllProfiles(){
        return nameToAllProfiles;
    }


    public boolean addProfile(Profile profile){
        // Return true if there isn't a name in the list of profile that has the same name with profile,
        //else return false
        if(!nameToAllProfiles.containsKey(profile.username)) {
            allProfiles.add(profile);
            nameToAllProfiles.put(profile.getUsername(), profile);
            return true;
        }
        else{
            return false;
        }

    }

    public void deleteProfile(Profile profile){
        if (allProfiles.contains(profile)){
            allProfiles.remove(profile);
            nameToAllProfiles.remove(profile.getUsername(),profile);
        }

    }


    public void editName(String originalName, String newName){
        // we know that a profile definitely exists
        Profile profile = findProfileByName(originalName);
        profile.setUsername(newName);
        nameToAllProfiles.put(newName, nameToAllProfiles.remove(originalName));


    }

    public void editYear(String userName, String newGraduatingYear){
        Profile profile = findProfileByName(userName);
        profile.setYear(newGraduatingYear);

    }
    public void editEmail(String userName,String newEmail){
        Profile profile = findProfileByName(userName);
        profile.setEmail(newEmail);
    }
    public Profile findProfileByName(String name){
        // return phase1.Profile object if there exists a profile with the name, else return null
        if(nameToAllProfiles.containsKey(name)){
            return nameToAllProfiles.get(name);
        }
        return null;
    }
    public void printProfileReviews(Profile p) {
        p.printReviews();

    }

    public ArrayList<Review> getReviewsLeft(Profile p){
        return p.getReviewsLeft();
    }

    public ArrayList<String> getReviewsLeftIDs(Profile p){
        return p.getReviewsLeftIDs();
    }


    public void updateReviewsLeft(Profile p, Review r){
        p.addToReviewsLeft(r);
        //if profile exists, just add review to list of reviews left
        //otherwise, automatically create a profile with username, n/a for email, and n/a for year (change year to String type)
    }

    public void deleteFromProfileReviews(String username, Review r){
        Profile p = findProfileByName(username);
        p.deleteFromReviewsLeft(r);
    }

    public void updateUpvotedReviews(Profile p,String ID){
        if (p.getDownvotedReviews().contains(ID)){
            p.removeFromDownvotedReviews(ID);
        }
        p.addToUpvotedReviews(ID);
    }

    public void updateDownvotedReviews(Profile p, String ID){
        if (p.getUpvotedReviews().contains(ID)){
            p.removeFromUpvotedReviews(ID);
        }
        p.addToDownvotedReviews(ID);
    }

    public ArrayList<String> getUpvotedReviews(Profile p){
        return p.getUpvotedReviews();
    }


    public ArrayList<String> getDownvotedReviews(Profile p){
        return p.getDownvotedReviews();
    }

    public void displayReviewIDsForDelete(String username){
        Profile p = findProfileByName(username);
        if (p.isAdmin()) {
            for (Profile profile : allProfiles) {
                profile.printReviewIDs();
            }
        } else {
            p.printReviewIDs();
        }

    }

    public void displayReviewIDsForEdit(String username){
        Profile p = findProfileByName(username);
        p.printReviewIDs();
    }

    public String getAttribute(String arg, Profile p){
        String retval = null;
        switch(arg){
            case "name":
                retval = p.getUsername();
                break;
            case "email":
                retval = p.getEmail();
                break;
            case "year":
                retval = p.getYear();
                break;
            case "upvoted":
                retval = p.getUpvotedReviews().toString();
                break;
        }
        return retval;
    }

}
