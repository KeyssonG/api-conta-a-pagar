package desafio.deliver.api_conta_pagar.service;

import desafio.deliver.api_conta_pagar.dto.RequestCreateAccountPayable;
import desafio.deliver.api_conta_pagar.entity.AccountPayableEntity;
import desafio.deliver.api_conta_pagar.model.FeesResult;
import desafio.deliver.api_conta_pagar.repository.AccountPayableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

@Service
public class AccountPayableServiceImpl implements AccountPayableService{

    @Autowired
    private AccountPayableRepository accountPayableRepository;

    @Autowired
    private FeesServiceImpl feesService;

    @Override
    public void register(RequestCreateAccountPayable requestBody) {
        LocalDate dueDate = requestBody.getDueDate();
        LocalDate paymentDate = requestBody.getPaymentDate();

        long numberOfDays = ChronoUnit.DAYS.between(dueDate, paymentDate);

        FeesResult feesResult = feesService.calculateFineAndInterest((int) numberOfDays);
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
    }
}
