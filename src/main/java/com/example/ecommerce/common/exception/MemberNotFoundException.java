package com.example.ecommerce.common.exception;

import com.example.ecommerce.common.status.CustomExceptionStatus;

import static com.example.ecommerce.status.CustomExceptionStatus.MEMBER_NOT_FOUND;

public class MemberNotFoundException extends CustomException {
    public MemberNotFoundException() {
        this(MEMBER_NOT_FOUND);
    }

    public MemberNotFoundException(CustomExceptionStatus status) {
        super(status);
    }
    public MemberNotFoundException(String code, String message) {
        super(code, message);
    }
}