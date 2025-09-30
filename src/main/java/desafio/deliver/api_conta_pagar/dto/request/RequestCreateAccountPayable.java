package desafio.deliver.api_conta_pagar.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class RequestCreateAccountPayable {

    @NotBlank(message = "O nome é obrigatório.")
    private String name;

    @NotNull(message = "O valor de origem é obrigatório.")
    private BigDecimal originationValue;

    @NotNull(message = "A data de vencimento é obrigatória.")
    private LocalDate dueDate;

    @NotNull(message = "A data de pagamento é obrigatória.")
    private LocalDate paymentDate;
}
