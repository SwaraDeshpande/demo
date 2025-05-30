package test.interview.demo.repository;

import org.springframework.stereotype.Service;
import test.interview.demo.domain.Invoice;
import test.interview.demo.repository.FakeDB;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Service
public class InvoiceRepo {

    public Invoice getById(UUID id) {
        return FakeDB.idToInvoiceMap.get(id);
    }

    public Collection<Invoice> getAll() {
        return new ArrayList<>(FakeDB.idToInvoiceMap.values());
    }
}
