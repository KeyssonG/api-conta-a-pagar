package desafio.deliver.api_conta_pagar.controller;

import desafio.deliver.api_conta_pagar.dto.RequestCreateAccountPayable;
import desafio.deliver.api_conta_pagar.exception.BusinessRuleException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;

public interface AccountPayableController {

    @PostMapping("/register/account-payable")
    @Operation(
            summary = "Cadastrar uma nova conta a pagar",
            description = "Endpoint para cadastrar uma nova conta a pagar."
    )
    void register(@RequestBody RequestCreateAccountPayable requestCreateAccountPayable)
            throws BusinessRuleException, SQLException;
}
