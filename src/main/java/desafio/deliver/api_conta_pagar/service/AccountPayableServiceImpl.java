package desafio.deliver.api_conta_pagar.service;

import desafio.deliver.api_conta_pagar.dto.RequestCreateAccountPayable;
import desafio.deliver.api_conta_pagar.entity.AccountPayableEntity;
import desafio.deliver.api_conta_pagar.repository.AccountPayableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountPayableServiceImpl implements AccountPayableService{

    @Autowired
    private AccountPayableRepository accountPayableRepository;

    @Override
    public void register(RequestCreateAccountPayable requestCreateAccountPayable) {
        AccountPayableEntity entity = AccountPayableEntity.builder()
                .name(requestCreateAccountPayable.getName())
                .originationValue(requestCreateAccountPayable.getOriginationValue())
                .dueDate(requestCreateAccountPayable.getDueDate())
                .paymentDate(requestCreateAccountPayable.getPaymentDate())
                .build();
        accountPayableRepository.save(entity);
    }
}
