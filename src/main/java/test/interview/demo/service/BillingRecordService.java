package test.interview.demo.service;

import org.springframework.stereotype.Service;
import test.interview.demo.repository.*;
import test.interview.demo.domain.BillingRecord;

import java.util.List;

@Service
public class BillingRecordService {

    public List<BillingRecord> getAllBillingRecords() {
        return FakeDB.allBillingRecords;
    }
}

