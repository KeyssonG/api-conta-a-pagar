package desafio.deliver.api_conta_pagar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "account_payable")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountPayableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal originationValue;

    @Column(name = "adjusted_value")
    private BigDecimal adjustedValue;

    @Temporal(TemporalType.DATE)
    private Date dueDate;
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @Column(name = "days_between")
    private Long daysBetween;
}
