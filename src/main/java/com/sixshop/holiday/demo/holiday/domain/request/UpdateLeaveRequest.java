package com.sixshop.holiday.demo.holiday.domain.request;

import com.sixshop.holiday.demo.holiday.domain.LeaveType;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class UpdateLeaveRequest {

    private Long id;
    private LeaveType type;
    private double deductionHours;
    private LocalDateTime startDate;
    private LocalDateTime andDate;
}
