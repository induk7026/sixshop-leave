package com.sixshop.holiday.demo.employee.controller;

import com.sixshop.holiday.demo.employee.domain.Employee;
import com.sixshop.holiday.demo.employee.service.EmployeeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/apis/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAll(){
        List<Employee> list = employeeService.findAll();
        list.forEach(employee -> {
            employee.getLeaveHistories();
//            System.out.println(employee.toString());
        });
        return list;
    }
}
