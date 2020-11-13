package com.sixshop.holiday.demo.employee.repository;

import com.sixshop.holiday.demo.employee.domain.Employee;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findById(long id);
}
