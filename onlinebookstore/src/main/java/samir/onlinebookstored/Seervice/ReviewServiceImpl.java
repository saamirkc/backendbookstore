//package samir.onlinebookstored.Seervice;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import samir.onlinebookstored.entity.Review;
//import samir.onlinebookstored.repository.ReviewRepository;
//
//import java.util.List;
//@Service
//public class ReviewServiceImpl implements ReviewService{
//    @Autowired
//    private ReviewRepository reviewRepository;
//    @Override
//    public List<Review> getReviewsByBookId(Long bookId) {
//        return reviewRepository.findByBookId(bookId);
//    }
//
//    @Override
//    public Review saveReview(Review review) {
//        return reviewRepository.save(review);
//    }
//}
package samir.onlinebookstored.Seervice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samir.onlinebookstored.entity.Book;
import samir.onlinebookstored.entity.Review;
import samir.onlinebookstored.repository.BookRepository;
import samir.onlinebookstored.repository.ReviewRepository;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Review> getReviewsByBookId(Long bookId) {
        return reviewRepository.findByBookId(bookId);
    }

    @Override
    public Review saveReview(Long bookId, Review review) {
        // Fetch the associated Book
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));

        // Set the Book reference in the Review
        review.setBook(book);

        // Save the Review
        return reviewRepository.save(review);
    }
}
