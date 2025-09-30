package desafio.deliver.api_conta_pagar.service;

import desafio.deliver.api_conta_pagar.dto.request.RequestCreateAccountPayable;
import desafio.deliver.api_conta_pagar.entity.AccountPayableEntity;
import desafio.deliver.api_conta_pagar.exception.BusinessRuleException;
import desafio.deliver.api_conta_pagar.exception.enums.ErrorCode;
import desafio.deliver.api_conta_pagar.model.FeesResult;
import desafio.deliver.api_conta_pagar.repository.AccountPayableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class AccountPayableServiceImpl implements AccountPayableService{

    @Autowired
    private AccountPayableRepository accountPayableRepository;

    @Autowired
    private FeesServiceImpl feesService;

    @Override
    public void register(RequestCreateAccountPayable requestBody) {
        try {
            if (requestBody.getName() == null || requestBody.getName().isBlank()) {
                throw new BusinessRuleException(ErrorCode.INVALID_NAME);
            }

            if (requestBody.getOriginationValue() == null || requestBody.getOriginationValue().compareTo(BigDecimal.ZERO) <= 0) {
                throw new BusinessRuleException(ErrorCode.INVALID_ORIGINATION_VALUE);
            }

            LocalDate dueDate = requestBody.getDueDate();
            LocalDate paymentDate = requestBody.getPaymentDate();

            if (dueDate == null) {
                throw new BusinessRuleException(ErrorCode.INVALID_DUE_DATE);
            }

            if (paymentDate == null) {
                throw new BusinessRuleException(ErrorCode.INVALID_PAYMENT_DATE);
            }

            if (paymentDate.isBefore(dueDate)) {
                throw new BusinessRuleException(ErrorCode.PAYMENT_DATE_BEFORE_DUE);
            }

            long numberOfDays = ChronoUnit.DAYS.between(dueDate, paymentDate);

            FeesResult feesResult;
            try {
                feesResult = feesService.calculateFineAndInterest((int) numberOfDays);
            } catch (Exception e) {
                throw new BusinessRuleException(ErrorCode.CALCULATION_ERROR);
            }

            BigDecimal fine = requestBody.getOriginationValue()
                    .multiply(BigDecimal.valueOf(feesResult.getFine() / 100));

            BigDecimal fineAmount = requestBody.getOriginationValue()
                    .add(fine);

            BigDecimal dailyInterest = fineAmount
                    .multiply(BigDecimal.valueOf(feesResult.getInterestPerDay() / 100));

            BigDecimal totalInterest = dailyInterest.multiply(BigDecimal.valueOf(numberOfDays));

            BigDecimal adjustedValue = fineAmount.add(totalInterest);

            AccountPayableEntity entity = AccountPayableEntity.builder()
                    .name(requestBody.getName())
                    .originationValue(requestBody.getOriginationValue())
                    .dueDate(java.sql.Date.valueOf(dueDate))
                    .paymentDate(java.sql.Date.valueOf(paymentDate))
                    .daysBetween(numberOfDays)
                    .adjustedValue(adjustedValue.setScale(2, RoundingMode.HALF_UP))
                    .build();
            accountPayableRepository.save(entity);
        } catch (BusinessRuleException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao registrar conta a pagar: " + e.getMessage(), e);
        }
    }

    @Override
    public List<AccountPayableEntity> getAllAccounts() {
        try {
            return accountPayableRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar contas a pagar: " + e.getMessage(), e);
        }
    }
}
