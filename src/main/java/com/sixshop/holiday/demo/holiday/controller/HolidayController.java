package com.sixshop.holiday.demo.holiday.controller;

import com.sixshop.holiday.demo.holiday.domain.LeaveHistory;
import com.sixshop.holiday.demo.holiday.domain.request.LeaveRequest;
import com.sixshop.holiday.demo.holiday.service.LeaveHistoryService;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolidayController {

    private LeaveHistoryService holidayService;

    public HolidayController(LeaveHistoryService holidayService) {
        this.holidayService = holidayService;
    }


    @PostMapping("/apis/v2/holiday")
    public ResponseEntity<Void> create(@RequestBody LeaveRequest holidayRequest){
        LeaveHistory holidayHistory = holidayService.created(holidayRequest);
        URI uri = URI.create("/apis/v2/holiday"+ holidayHistory.getId());
        return ResponseEntity.created(uri).build();
    }

    @PatchMapping("/apis/v2/holiday")
    public ResponseEntity<Void> update(){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/apis/v2/holiday/{history-id}")
    public ResponseEntity<Void> delete(@PathVariable("history-id") String historyId){
        return ResponseEntity.ok().build();
    }

}
