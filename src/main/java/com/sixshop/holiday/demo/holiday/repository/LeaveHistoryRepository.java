package com.sixshop.holiday.demo.holiday.repository;

import com.sixshop.holiday.demo.holiday.domain.LeaveHistory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveHistoryRepository extends JpaRepository<LeaveHistory, Long> {

    LeaveHistory save(LeaveHistory holidayHistory);

    List<LeaveHistory> findAllByEmployeeId(Long employeeId);

}
