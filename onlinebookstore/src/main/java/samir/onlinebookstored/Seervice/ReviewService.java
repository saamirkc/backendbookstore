//package samir.onlinebookstored.Seervice;
//
//import samir.onlinebookstored.entity.Review;
//
//import java.util.List;
//
//public interface ReviewService {
//    List<Review> getReviewsByBookId(Long bookId);
//    Review saveReview(Review review);
//}
package samir.onlinebookstored.Seervice;

import samir.onlinebookstored.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getReviewsByBookId(Long bookId);
    Review saveReview(Long bookId, Review review);
}
