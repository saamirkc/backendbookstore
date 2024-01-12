//package samir.onlinebookstored.Controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import samir.onlinebookstored.Seervice.ReviewService;
//import samir.onlinebookstored.entity.Review;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/reviews")
//public class ReviewController {
//    @Autowired
//    private ReviewService reviewService;
//    @GetMapping("/book/{bookId}")
//    public ResponseEntity<List<Review>> getReviewsByBookId(@PathVariable Long bookId) {
//        List<Review> reviews = reviewService.getReviewsByBookId(bookId);
//        return ResponseEntity.ok(reviews);
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<Review> addReview(@RequestBody Review review) {
//        Review savedReview = reviewService.saveReview(review);
//        return ResponseEntity.ok(savedReview);
//    }
//}
package samir.onlinebookstored.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import samir.onlinebookstored.Seervice.ReviewService;
import samir.onlinebookstored.entity.Review;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin("*")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<Review>> getReviewsByBookId(@PathVariable Long bookId) {
        List<Review> reviews = reviewService.getReviewsByBookId(bookId);
        return ResponseEntity.ok(reviews);
    }

    @PostMapping("/add/{bookId}")  // Updated the endpoint to include bookId in the path
    public ResponseEntity<Review> addReview(@PathVariable Long bookId, @RequestBody Review review) {
        Review savedReview = reviewService.saveReview(bookId, review);
        return ResponseEntity.ok(savedReview);
    }
}
