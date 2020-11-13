package com.sixshop.holiday.demo.holiday.domain;

import static com.sixshop.holiday.demo.employee.domain.Employee.DEFAULT_INT;

import java.time.LocalDate;
import java.time.Period;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

    LocalDate joiningCompanyDate = LocalDate.parse("2018-01-01");

    @Test
    public void test(){
        Period period = Period.between(this.joiningCompanyDate, LocalDate.now()).minusYears(1);
        System.out.println(DEFAULT_INT + (Math.floor(period.getYears()/2)));
    }


}