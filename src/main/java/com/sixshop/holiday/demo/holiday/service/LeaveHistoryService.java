package com.sixshop.holiday.demo.holiday.service;

import com.sixshop.holiday.demo.employee.domain.Employee;
import com.sixshop.holiday.demo.employee.service.EmployeeService;
import com.sixshop.holiday.demo.holiday.domain.CalculationType;
import com.sixshop.holiday.demo.holiday.domain.LeaveCalculate;
import com.sixshop.holiday.demo.holiday.domain.LeaveHistory;
import com.sixshop.holiday.demo.holiday.domain.request.LeaveRequest;
import com.sixshop.holiday.demo.holiday.exception.InsufficientLeaveException;
import com.sixshop.holiday.demo.holiday.repository.LeaveHistoryRepository;
import java.beans.Transient;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LeaveHistoryService {

    private final LeaveHistoryRepository leaveHistoryRepository;
    private final EmployeeService employeeService;

    @Transactional
    public LeaveHistory created(LeaveRequest holidayRequest){
        Employee employee = employeeService.findById(holidayRequest.getId());

//        List<LeaveHistory> leaveHistories = leaveHistoryRepository.findAllByEmployeeId(holidayRequest.getId());
        if(employee.checkLeave()){
            throw new InsufficientLeaveException();
        }

        return leaveHistoryRepository.save(
            LeaveHistory.builder()
//                .employee(employee)
                .startDate(holidayRequest.getStartDate())
                .andDate(holidayRequest.getAndDate())
                .type(holidayRequest.getType())
                .deductionHours(holidayRequest.getDeductionHours())
                .calculationType(holidayRequest.getType().getCalculationType())
                .build()
        );
    }


}
