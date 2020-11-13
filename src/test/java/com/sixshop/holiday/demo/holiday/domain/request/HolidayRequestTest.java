package com.sixshop.holiday.demo.holiday.domain.request;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class HolidayRequestTest {


    @Test
    public void test(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("-------");
        System.out.println(localDateTime.toString());
    }
}