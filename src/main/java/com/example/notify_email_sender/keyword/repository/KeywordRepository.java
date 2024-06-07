package com.example.notify_email_sender.keyword.repository;

import com.example.notify_email_sender.keyword.domain.Keyword;
import com.example.notify_email_sender.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Long> {
    void deleteAllByUser(User user);
    List<Keyword> findAllByUserUserId(Long userId);
    Optional<Keyword> findByUserAndUserKeyword(User user, String userKeyword);
    void deleteByKeywordId(Long keywordId);

}
