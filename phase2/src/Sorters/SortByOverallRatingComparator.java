package Sorters;

import ReviewSystem.Review;

import java.util.Comparator;
/**
 *SortByOverallRatingComparator is a comparator class that implements Comparator interface.
 * This comparator can be used in the sort method of CourseReviewManger, DormReviewManager,and ProfessorReviewManager
 * * It will sort the Review based on the overall rating of a review
 * @author Yuou Lei
 */
public class SortByOverallRatingComparator implements Comparator<Review> {
    /**
     *
     * @param r1 the first Review object to be compared.
     * @param r2 the second Review object to be compared.
     * @return Compares its two arguments for order.
     * Returns a negative integer, zero, or a positive integer as the First review's overall rating
     * is less than, equal to, or greater than the second.
     */
    @Override
    public int compare(Review r1, Review r2) {
        return Integer.compare(Integer.parseInt(r1.getOverallRating()), Integer.parseInt(r2.getOverallRating()));
    }
}
