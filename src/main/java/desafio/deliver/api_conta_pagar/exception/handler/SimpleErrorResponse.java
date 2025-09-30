package desafio.deliver.api_conta_pagar.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class SimpleErrorResponse {
    private int status;
    private String message;
    private LocalDateTime timestamp;
}