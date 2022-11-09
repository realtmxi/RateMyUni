package Sorters;

import ReviewSystem.Review;

import java.util.Comparator;
/**
 *SortByVotesComparator is a comparator class that implements Comparator interface.
 * This comparator can be used in the sort method of CourseReviewManger, DormReviewManager,and ProfessorReviewManager
 * It will sort the Review based on upvote and downvote.
 * @author Yuou Lei
 */
public class SortByVotesComparator implements Comparator<Review> {

    /**
     *
     * @param o1 the first Review to be compared.
     * @param o2 the second Review to be compared.
     * @return Returns a negative integer, zero, or a positive integer as the First review's popularity
     *      * is less than, equal to, or greater than the second.
     *      * popularity is calculated as 2 times of upvote plus downvote.
     */
    @Override
    public int compare(Review o1, Review o2) {
        int popularity1 = o1.getUpvotes() * 2 - o1.getDownvotes();
        int popularity2 = o2.getUpvotes() * 2 - o2.getDownvotes();
        return Integer.compare(popularity1, popularity2);
    }
}
