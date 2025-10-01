package desafio.deliver.api_conta_pagar.service;

import desafio.deliver.api_conta_pagar.model.FeesResult;
import org.springframework.stereotype.Service;

@Service
public class FeesServiceImpl implements FeesService {

    public FeesResult calculateFineAndInterest(int DaysOverdue) {
        if (DaysOverdue <= 0) {
            return new FeesResult(0.0, 0.0);
        } else if (DaysOverdue == 3) {
            return new FeesResult(2.0, 0.1);
        } else if (DaysOverdue > 3 && DaysOverdue < 5) {
            return new FeesResult(3.0, 0.2);

        } else if (DaysOverdue >= 5) {
            return new FeesResult(5.0, 0.3);
        }
        return new FeesResult(0.0, 0.0);
    }
}
