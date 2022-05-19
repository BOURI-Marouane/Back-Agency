package ma.atos.agency.entities;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String accountNumber;
    private String fullName;
    private BigDecimal balance;


    @ManyToOne
    Client client;




}
