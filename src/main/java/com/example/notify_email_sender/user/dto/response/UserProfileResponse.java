package com.example.notify_email_sender.user.dto.response;

import java.util.List;

public record UserProfileResponse(
        String nickname,
        String email,
        String major,
        List<String> keywords
) {
}
