package test.interview.demo.domain;

import lombok.*;
import test.interview.demo.constants.InvoiceStatus;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Invoice implements Core {

    private List<BillingRecord> billingRecords;
    private Date createdTime;
    private UUID id;
    private InvoiceStatus status;
    private User user;

    public UUID getId() {
        return id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

}