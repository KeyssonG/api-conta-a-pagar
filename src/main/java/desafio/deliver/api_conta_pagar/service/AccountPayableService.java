package desafio.deliver.api_conta_pagar.service;

import desafio.deliver.api_conta_pagar.dto.request.RequestCreateAccountPayable;
import desafio.deliver.api_conta_pagar.entity.AccountPayableEntity;

import java.util.List;

public interface AccountPayableService {
    void register(RequestCreateAccountPayable requestCreateAccountPayable);

    List<AccountPayableEntity> getAllAccounts();
}
