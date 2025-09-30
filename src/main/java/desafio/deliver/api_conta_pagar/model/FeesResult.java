package desafio.deliver.api_conta_pagar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class FeesResult {
    private final double fine;
    private final double interestPerDay;

    public double getInterest() {
        return interestPerDay;
    }
}
