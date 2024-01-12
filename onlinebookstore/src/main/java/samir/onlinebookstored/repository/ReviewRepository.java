package samir.onlinebookstored.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import samir.onlinebookstored.entity.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findByBookId(Long bookId);
}
