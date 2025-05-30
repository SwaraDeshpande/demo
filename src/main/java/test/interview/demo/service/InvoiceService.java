package test.interview.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import test.interview.demo.domain.BillingRecord;
import test.interview.demo.domain.Invoice;
import test.interview.demo.exception.ResourceNotFoundException;
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

    private final InvoiceRepo invoiceRepo;

        public Invoice getInvoiceById(UUID id) {
            Invoice invoice = invoiceRepo.getById(id);
            if (invoice == null) {
                throw new ResourceNotFoundException("Invoice not found with id: " + id);
            }

            // Deduplicate billing records by ID
            Map<UUID, BillingRecord> uniqueById = new LinkedHashMap<>();
            for (BillingRecord record : invoice.getBillingRecords()) {
                uniqueById.put(record.getId(), record);
            }

            invoice.setBillingRecords(new ArrayList<>(uniqueById.values()));
            return invoice;
        }

    public List<Invoice> getAllInvoices(String date) {
        Collection<Invoice> invoices = invoiceRepo.getAll();
        List<Invoice> result = new ArrayList<>(invoices);
        log.info("All invoices: " + result);

        if (date != null) {
            LocalDate filterDate = LocalDate.parse(date);
            ZoneId utcZone = ZoneOffset.UTC;

            result = result.stream()
                    .filter(i -> i.getCreatedTime().toInstant()
                            .atZone(utcZone)
                            .toLocalDate()
                            .equals(filterDate))
                    .collect(Collectors.toList());

            log.info("Filtered invoices by date {}: {}", date, result);
        }

        return result;
    }
}
