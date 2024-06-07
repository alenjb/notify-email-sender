package com.example.notify_email_sender.common.exception.model;

import com.example.notify_email_sender.common.exception.enums.ErrorCode;

public class UnAuthorizedException extends NotifyException{

    public UnAuthorizedException(ErrorCode errorCode) {
        super(errorCode);
    }
}
