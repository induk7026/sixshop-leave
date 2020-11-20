package com.sixshop.holiday.demo.holiday.controller;

import com.sixshop.holiday.demo.holiday.domain.LeaveHistory;
import com.sixshop.holiday.demo.holiday.domain.request.UpdateLeaveRequest;
import com.sixshop.holiday.demo.holiday.domain.request.LeaveRequest;
import com.sixshop.holiday.demo.holiday.service.LeaveHistoryService;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolidayController {

    private LeaveHistoryService leaveHistoryService;

    public HolidayController(LeaveHistoryService holidayService) {
        this.leaveHistoryService = holidayService;
    }


    @PostMapping("/apis/v2/leave")
    public ResponseEntity<Void> create(@RequestBody LeaveRequest leaveRequest){
        LeaveHistory holidayHistory = leaveHistoryService.created(leaveRequest);
        URI uri = URI.create("/apis/v2/holiday"+ holidayHistory.getId());
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/apis/v2/leave/findAll")
    public ResponseEntity<List<LeaveHistory>> findAll(){
        List<LeaveHistory> leaveHistories = leaveHistoryService.findAll();
        return ResponseEntity.ok(leaveHistories);
    }

    @PatchMapping("/apis/v2/leave")
    public ResponseEntity<Void> update(UpdateLeaveRequest updateLeaveRequest){
        leaveHistoryService.updateLeaveHistory(updateLeaveRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/apis/v2/leave/{leave-history-id}")
    public ResponseEntity<Void> delete(@PathVariable("leave-history-id") Long leaveHistoryId){
        leaveHistoryService.deleteById(leaveHistoryId);
        return ResponseEntity.noContent().build();
    }

}
