package desafio.deliver.api_conta_pagar.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class RequestCreateAccountPayable {

    private String name;
    private BigDecimal originationValue;

    private LocalDate dueDate;
    private LocalDate paymentDate;
}
