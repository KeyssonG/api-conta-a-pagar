package desafio.deliver.api_conta_pagar.controller;

import desafio.deliver.api_conta_pagar.dto.request.RequestCreateAccountPayable;
import desafio.deliver.api_conta_pagar.entity.AccountPayableEntity;
import desafio.deliver.api_conta_pagar.exception.BusinessRuleException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.List;

public interface AccountPayableController {

    @PostMapping("/register/account-payable")
    @Operation(
            summary = "Cadastrar uma nova conta a pagar",
            description = "Endpoint para cadastrar uma nova conta a pagar."
    )
    void register(@RequestBody RequestCreateAccountPayable requestCreateAccountPayable)
            throws BusinessRuleException, SQLException;

    @GetMapping("/account-payable")
    @Operation(
            summary = "Consulta contas a pagar",
            description = "Endpoint para consultar contas a pagar."
    )
    List<AccountPayableEntity> searchAccountsPayable()
            throws BusinessRuleException, SQLException;
}
