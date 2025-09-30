package desafio.deliver.api_conta_pagar.service;

import desafio.deliver.api_conta_pagar.dto.RequestCreateAccountPayable;

public interface AccountPayableService {
    void register(RequestCreateAccountPayable requestCreateAccountPayable);
}
