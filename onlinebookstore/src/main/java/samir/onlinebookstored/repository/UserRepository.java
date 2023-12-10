package samir.onlinebookstored.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import samir.onlinebookstored.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUsername(String username);
}
