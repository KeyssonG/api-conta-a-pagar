package desafio.deliver.api_conta_pagar.exception;

import desafio.deliver.api_conta_pagar.exception.enums.ErrorCode;

public class BusinessRuleException extends RuntimeException {

    private final ErrorCode errorCode;

    public BusinessRuleException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}