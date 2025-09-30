package desafio.deliver.api_conta_pagar.service;

import desafio.deliver.api_conta_pagar.model.FeesResult;

public interface FeesService {
    FeesResult calculateFineAndInterest(int DaysOverdue);
}
