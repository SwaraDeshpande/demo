package test.interview.demo.service

import spock.lang.Specification
import test.interview.demo.domain.Invoice
import test.interview.demo.repository.FakeDB
import test.interview.demo.service.InvoiceService

class InvoiceServiceSpec extends Specification {

    def invoiceService = new InvoiceService(null) // InvoiceRepo not used

    def 'getInvoiceById() happy path using FakeDB'() {
        given:
        def id = UUID.fromString("11111111-1111-1111-1111-111111111111")
        def invoice = Invoice.builder().id(id).billingRecords([]).build()
        FakeDB.idToInvoiceMap.put(id, invoice)

        when:
        def result = invoiceService.getInvoiceById(id)

        then:
        result == invoice
    }
}
