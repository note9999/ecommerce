package com.example.ecommerce.common.status;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CustomExceptionStatus {
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "400101", "Member Not Found"),

    ACCOUNT_NOT_FOUND(HttpStatus.BAD_REQUEST, "400201", "Account Not Found"),
    ACCOUNT_NOT_MATCH_OWNER(HttpStatus.BAD_REQUEST, "400202", "This is not your account."),
    ACCOUNT_NOT_CHARGE_MINUS(HttpStatus.BAD_REQUEST, "400203", "You cannot charge less than zero."),

    PRODUCT_NOT_FOUND(HttpStatus.BAD_REQUEST, "400301", "Product Not Found"),
    PRODUCT_NOT_ENOUGH_STOCK(HttpStatus.BAD_REQUEST, "400302", "We're out of stock."),

    ORDER_NOT_FOUND(HttpStatus.BAD_REQUEST, "400401", "Order Not Found"),
    ORDER_NOT_MATCH_OWNER(HttpStatus.BAD_REQUEST, "400402", "This is not a user's order."),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}