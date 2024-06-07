package com.example.notify_email_sender.common.exception.model;

import com.example.notify_email_sender.common.exception.enums.ErrorCode;
import lombok.Getter;

@Getter
public class NotFoundUserException extends NotifyException {

    public NotFoundUserException(ErrorCode errorCode) {
        super(errorCode);

    }
}
