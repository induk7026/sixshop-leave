package com.sixshop.holiday.demo.employee.service;

import com.sixshop.holiday.demo.employee.domain.Employee;
import com.sixshop.holiday.demo.employee.exception.NoSuchEmployeeException;
import com.sixshop.holiday.demo.employee.repository.EmployeeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(NoSuchEmployeeException::new);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
