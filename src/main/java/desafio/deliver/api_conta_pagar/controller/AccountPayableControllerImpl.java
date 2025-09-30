package desafio.deliver.api_conta_pagar.controller;

import desafio.deliver.api_conta_pagar.dto.RequestCreateAccountPayable;
import desafio.deliver.api_conta_pagar.exception.BusinessRuleException;
import desafio.deliver.api_conta_pagar.service.AccountPayableService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
@RestController

public class AccountPayableControllerImpl implements AccountPayableController{

    @Autowired
    private AccountPayableService accountPayableService;

    @Override
    public void register(@Valid @RequestBody  RequestCreateAccountPayable requestBody) throws BusinessRuleException, SQLException {
        accountPayableService.register(requestBody);
    }
}
