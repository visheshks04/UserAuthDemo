package com.demo.UserAuth.repositories;

import com.demo.UserAuth.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Query("SELECT COUNT(*) >= 1 from User u where u.username = :username")
    boolean findExistByUsername(String username);
}