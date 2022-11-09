package ReviewSystem.DormSystem;
import java.io.Serializable;

/** A reviewable dorm in a university with ratings on its attributable aspects.
 *
 */
public class Dorm implements Serializable {
    private String residenceName;
    private String floorNumber;
    private final String university;
    Float avgCleanliness;
    Float avgSocialLevel;
    Float avgSoundProof;
    Float avgRARating;
    Float avgFood;
    Float avgConvenience;
    Float avgWifi;
    Float avgOverallRating;

    /** The constructor for object phase1.Dorm to be reviewed.
     *
     * @param res is the name of the dorm Residence
     * @param floor indicates which dorm floor is being reviewed
     * @param u the university associated with this dorm.
     */
    public Dorm(String res, String floor, String u){
        this.residenceName = res;
        this.floorNumber = floor;
        this.university = u;
    }

    private void setResidenceName(String res){
        this.residenceName = res;
    }

    private void setFloorNumber(String f){
        this.floorNumber = f;
    }

    /**
     * Gets the dorm's Residence Name
     * @return A string of the Residence Name.
     */
    public String getResidenceName(){
        return this.residenceName;
    }

    /**
     * Gets the floor number being reviewed of this dorm building.
     * @return A string of the floor number.
     */
    public String getFloorNumber() {
        return this.floorNumber;
    }

    /**
     * Gets the dorm's associated university name.
     * @return A string of the university name.
     */
    public String getUniversity() {
        return this.university;
    }

    /**
     * Gets the average level of Cleanliness rating from reviews associated with this Dorm's reviewable profile.
     * @return a float of the average rating.
     */
    public Float getAvgCleanliness() {
        return avgCleanliness;
    }

    /**
     * Sets the Dorm's average level of Cleanliness rating from reviews associated with this Dorm's reviewable profile.
     * @param avgCleanliness the new average Cleanliness rating.
     *
     */
    public void setAvgCleanliness(Float avgCleanliness) {
        this.avgCleanliness = avgCleanliness;
    }

    /**
     * Gets the average Social Level rating from reviews associated with this Dorm's reviewable profile.
     * @return a float of the average rating.
     */
    public Float getAvgSocialLevel() {
        return avgSocialLevel;
    }

    /**
     * Sets the Dorm's average Social Level rating from reviews associated with this Dorm's reviewable profile.
     * @param avgSocialLevel the new average Social Level rating.
     *
     */
    public void setAvgSocialLevel(Float avgSocialLevel) {
        this.avgSocialLevel = avgSocialLevel;
    }

    /**
     * Gets the average Soundproof rating from reviews associated with this Dorm's reviewable profile.
     * @return a float of the average rating.
     */
    public Float getAvgSoundProof() {
        return avgSoundProof;
    }

    /**
     * Sets the Dorm's average level of Soundproof rating from reviews associated with this Dorm's reviewable profile.
     * @param avgSoundProof the new average Soundproof rating.
     *
     */
    public void setAvgSoundProof(Float avgSoundProof) {
        this.avgSoundProof = avgSoundProof;
    }

    /**
     * Gets the average RA rating from reviews associated with this Dorm's reviewable profile.
     * @return a float of the average rating.
     */
    public Float getAvgRARating() {
        return avgRARating;
    }

    /**
     * Sets the Dorm's average RA rating from reviews associated with this Dorm's reviewable profile.
     * @param avgRARating the new average RA rating.
     *
     */
    public void setAvgRARating(Float avgRARating) {
        this.avgRARating = avgRARating;
    }

    /**
     * Gets the average Food rating from reviews associated with this Dorm's reviewable profile.
     * @return a float of the average rating.
     */
    public Float getAvgFood() {
        return avgFood;
    }

    /**
     * Sets the Dorm's average Food rating from reviews associated with this Dorm's reviewable profile.
     * @param avgFood the new average Food rating.
     *
     */
    public void setAvgFood(Float avgFood) {
        this.avgFood = avgFood;
    }

    /**
     * Gets the average level of Convenience rating from reviews associated with this Dorm's reviewable profile.
     * @return a float of the average rating.
     */
    public Float getAvgConvenience() {
        return avgConvenience;
    }

    /**
     * Sets the Dorm's average level of Convenience rating from reviews associated with this Dorm's reviewable profile.
     * @param avgConvenience the new average Convenience rating.
     *
     */
    public void setAvgConvenience(Float avgConvenience) {
        this.avgConvenience = avgConvenience;
    }

    /**
     * Gets the average WiFi rating from reviews associated with this Dorm's reviewable profile.
     * @return a float of the average rating.
     */
    public Float getAvgWifi() {
        return avgWifi;
    }

    /**
     * Sets the Dorm's average level of WiFi rating from reviews associated with this Dorm's reviewable profile.
     * @param avgWifi the new average WiFi rating.
     */
    public void setAvgWifi(Float avgWifi) {
        this.avgWifi = avgWifi;
    }

    /**
     * Gets the average Overall Rating from reviews associated with this Dorm's reviewable profile.
     * @return a float of the average rating.
     */
    public Float getAvgOverallRating() {
        return avgOverallRating;
    }

    /**
     * Sets the Dorm's average Overall Rating from reviews associated with this Dorm's reviewable profile.
     * @param avgOverallRating the new average Overall Rating.
     */
    public void setAvgOverallRating(Float avgOverallRating) {
        this.avgOverallRating = avgOverallRating;
    }

    /**
     * A representation of this reviewable Dorm profile.
     * @return a String representation of the dorm profile.
     */
    @Override
    public String toString(){
        return String.format("===[Dorm Profile]===\nResidence Name: %s\nUniversity: %s\nFloor Number: %s\n===[Average Ratings]===\n" +
                        "Average Overall Rating: %s\nAverage Cleanliness Rating: %s\nAverage Social Level: " +
                        "%s\nAverage Soundproof Rating: %s\nAverage RA rating: %s\n" +
                        "Average Food Rating: %s\nAverage Convenience Level: %s\nAverage WiFi speed: %s\n", residenceName,
                university,floorNumber,avgOverallRating,avgCleanliness,avgSocialLevel,avgSoundProof,avgRARating
                ,avgFood,avgConvenience,avgWifi);

    }

}
