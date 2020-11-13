package com.sixshop.holiday.demo.holiday.exception;

public class InsufficientLeaveException extends RuntimeException{

    public InsufficientLeaveException() {
        super("휴가가 부족합니다.");
    }
}
