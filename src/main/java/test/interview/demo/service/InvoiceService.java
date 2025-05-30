package test.interview.demo.service;

import lombok.extern.slf4j.Slf4j;
import test.interview.demo.domain.BillingRecord;
import test.interview.demo.exception.ResourceNotFoundException;
import test.interview.demo.domain.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.interview.demo.repository.FakeDB;
import test.interview.demo.repository.InvoiceRepo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class InvoiceService {

    public Invoice getInvoiceById(UUID id) {
        Invoice invoice = FakeDB.idToInvoiceMap.get(id);
        if (invoice == null) {
            throw new ResourceNotFoundException("Invoice not found with id: " + id);
        }

        // Remove duplicate billing records by ID
        Map<UUID, BillingRecord> uniqueById = new LinkedHashMap<>();
        for (BillingRecord record : invoice.getBillingRecords()) {
            uniqueById.put(record.getId(), record); // Keeps only one per ID
        }

        invoice.setBillingRecords(new ArrayList<>(uniqueById.values()));
        return invoice;
    }

    public List<Invoice> getAllInvoices(String date) {
        Collection<Invoice> invoices = FakeDB.idToInvoiceMap.values();
        List<Invoice> result = new ArrayList<>(invoices);
        log.info("All invoices: " + result);

        if (date != null) {
            LocalDate filterDate = LocalDate.parse(date);
            ZoneId utcZone = ZoneOffset.UTC; // UTC timezone

            result = result.stream()
                    .filter(i -> i.getCreatedTime().toInstant()
                            .atZone(utcZone)
                            .toLocalDate()
                            .equals(filterDate))
                    .collect(Collectors.toList());

            log.info("Invoices after filtering by local date " + date + ": " + result);
        }

        return result;
    }


}
