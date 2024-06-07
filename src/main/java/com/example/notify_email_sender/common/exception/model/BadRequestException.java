package com.example.notify_email_sender.common.exception.model;

import com.example.notify_email_sender.common.exception.enums.ErrorCode;

public class BadRequestException extends NotifyException {
    public BadRequestException(ErrorCode errorCode) {
        super(errorCode);
    }
}
