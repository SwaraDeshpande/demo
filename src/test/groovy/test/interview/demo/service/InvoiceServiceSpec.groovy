import test.interview.demo.domain.Invoice
import test.interview.demo.domain.User
import test.interview.demo.service.InvoiceService

def "getInvoiceById() - happy path"() {
    given:
    def invoiceRepo = Mock(InvoiceRepo)
    def invoiceService = new InvoiceService(invoiceRepo)

    def invoice = new Invoice()
    invoice.setId(1)
    invoice.setAmount(100.0)

    def user = new User()
    user.setEmail("user@example.com")
    user.setCustomerNumber(1)
    invoice.setUser(user)

    invoiceRepo.findById(1) >> Optional.of(invoice)

    when:
    def result = invoiceService.getInvoiceById(1)

    then:
    result.getId() == 1
    result.getUser().getEmail() == "user@example.com"
}