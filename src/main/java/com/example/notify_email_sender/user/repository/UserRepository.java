package com.example.notify_email_sender.user.repository;

import com.example.notify_email_sender.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long > {
    public Optional<User> findByGoogleId(String googleId);
    void deleteByUserId(Long userId);
}
