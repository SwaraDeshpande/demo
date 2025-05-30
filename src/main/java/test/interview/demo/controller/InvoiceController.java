package test.interview.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.interview.demo.service.InvoiceService;
import test.interview.demo.domain.Invoice;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable UUID id) {
        return ResponseEntity.ok(invoiceService.getInvoiceById(id));
    }

    @GetMapping
    public ResponseEntity<List<Invoice>> getAllInvoices(@RequestParam(required = false) String date) {
        return ResponseEntity.ok(invoiceService.getAllInvoices(date));
    }
}

