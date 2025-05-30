package test.interview.demo.domain;

import lombok.*;
import org.springframework.stereotype.Service;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String email;
    private int customerNumber;

}