package com.example.notify_email_sender.user.service;

import com.example.notify_email_sender.common.service.EmailService;
import com.example.notify_email_sender.keyword.domain.Keyword;
import com.example.notify_email_sender.keyword.repository.KeywordRepository;
import com.example.notify_email_sender.notice.domain.Notice;
import com.example.notify_email_sender.user.domain.User;
import com.example.notify_email_sender.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final KeywordRepository keywordRepository;

    @Autowired
    private EmailService emailService;



    public void findAndSendEmail(Notice notice) {
        String noticeTitle = notice.getNoticeTitle();
        // 모든 키워드를 가져와서 사용자 ID에 해당하는 키워드 매핑
        Map<String, Set<Long>> keywordToUserIdsMap = new HashMap<>();
        List<Keyword> allKeywords = keywordRepository.findAll();
        for (Keyword keyword : allKeywords) {
            keywordToUserIdsMap.computeIfAbsent(keyword.getUserKeyword(), k -> new HashSet<>()).add(keyword.getUser().getUserId());
        }

        // notice title에 포함된 키워드를 찾아서 이메일 보내기
        for (String keyword : keywordToUserIdsMap.keySet()) {
            if (noticeTitle.contains(keyword)) {
                Set<Long> userIds = keywordToUserIdsMap.get(keyword);
                for (Long userId : userIds) {
                    // 해당 사용자 ID에 해당하는 이메일 찾기
                    Optional<User> optionalUser = userRepository.findById(userId);
                    if (optionalUser.isPresent()) {
                        User user = optionalUser.get();
                        // 이메일 보내기
                        sendKeywordEmail(user, keyword, notice);
                    }
                }
            }
        }
    }


    public void sendKeywordEmail(User user,String keyword, Notice notice) {
        String to = user.getEmail();
        String nickname =user.getNickName();
        Long postId = notice.getNoticeId();
        String postLink = notice.getNoticeUrl();

        emailService.sendNotificationEmail(to, nickname, keyword, postLink);
    }
}
