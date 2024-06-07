package com.example.notify_email_sender.common.exception.model;

import com.example.notify_email_sender.common.exception.enums.ErrorCode;

public class ConflictException extends NotifyException {
    public ConflictException(ErrorCode errorCode) {
        super(errorCode);
    }
}
