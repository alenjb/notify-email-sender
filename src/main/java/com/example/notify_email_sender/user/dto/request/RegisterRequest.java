package com.example.notify_email_sender.user.dto.request;

import com.example.notify_email_sender.user.domain.UserMajor;

public record RegisterRequest(
        String nickname,
        String email,
        UserMajor userMajor
) {
}
