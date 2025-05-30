package test.interview.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.interview.demo.service.BillingRecordService;
import  test.interview.demo.domain.BillingRecord;

import java.util.List;

@RestController
@RequestMapping("/billing-record")
public class BillingRecordController {

    @Autowired
    private BillingRecordService billingRecordService;

    @GetMapping
    public ResponseEntity<List<BillingRecord>> getAllBillingRecords() {
        return ResponseEntity.ok(billingRecordService.getAllBillingRecords());
    }
}

