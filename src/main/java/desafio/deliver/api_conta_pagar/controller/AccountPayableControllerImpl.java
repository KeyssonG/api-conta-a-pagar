package desafio.deliver.api_conta_pagar.controller;

import desafio.deliver.api_conta_pagar.dto.request.RequestCreateAccountPayable;
import desafio.deliver.api_conta_pagar.entity.AccountPayableEntity;
import desafio.deliver.api_conta_pagar.exception.BusinessRuleException;
import desafio.deliver.api_conta_pagar.service.AccountPayableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController

public class AccountPayableControllerImpl implements AccountPayableController{

    @Autowired
    private AccountPayableService accountPayableService;

    @Override
    public void register(@RequestBody  RequestCreateAccountPayable requestBody) throws BusinessRuleException, SQLException {
        accountPayableService.register(requestBody);
    }

    @Override
    public List<AccountPayableEntity> searchAccountsPayable() throws BusinessRuleException, SQLException {
        return accountPayableService.getAllAccounts();
    }
}
