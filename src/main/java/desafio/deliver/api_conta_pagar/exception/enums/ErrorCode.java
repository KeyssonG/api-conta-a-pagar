package desafio.deliver.api_conta_pagar.exception.enums;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    INVALID_DUE_DATE("Data de vencimento inválida fornecida.", HttpStatus.BAD_REQUEST),
    PAYMENT_DATE_BEFORE_DUE("A data de pagamento não pode ser anterior à data de vencimento.", HttpStatus.BAD_REQUEST),
    CALCULATION_ERROR("Ocorreu um erro durante o cálculo de multa e juros.", HttpStatus.INTERNAL_SERVER_ERROR);
    private final String message;
    private final HttpStatus status;

    ErrorCode(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}