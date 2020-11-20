package com.sixshop.holiday.demo.holiday.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoSuchLeaveHistoryException extends RuntimeException {

    public NoSuchLeaveHistoryException(){
        super("찾을 수가 없습니다.");
    }

}
