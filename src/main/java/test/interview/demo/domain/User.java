package test.interview.demo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Data
@Builder
@Getter
@Setter
public class User {

    private String email;
    private int customerNumber;

}