package desafio.deliver.api_conta_pagar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class RequestCreateAccountPayable {

    private String name;
    private String originationValue;
    private Date dueDate;
    private Date paymentDate;
}
