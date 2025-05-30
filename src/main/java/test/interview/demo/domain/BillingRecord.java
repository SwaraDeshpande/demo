package test.interview.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillingRecord implements Core {

    private UUID id;
    private Date createdTime;
    private BigDecimal price;
    private User user;

    public UUID getId() {
        return id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

}

