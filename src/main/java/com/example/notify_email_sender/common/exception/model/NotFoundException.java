package com.example.notify_email_sender.common.exception.model;

import com.example.notify_email_sender.common.exception.enums.ErrorCode;

public class NotFoundException extends NotifyException{
    public NotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
