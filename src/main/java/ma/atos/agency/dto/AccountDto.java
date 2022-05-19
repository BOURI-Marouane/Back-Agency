package ma.atos.agency.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountDto {
    private int id;
    private String accountNumber;
    private String fullName;
    private BigDecimal balance;


}
