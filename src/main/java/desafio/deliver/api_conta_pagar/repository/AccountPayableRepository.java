package desafio.deliver.api_conta_pagar.repository;

import desafio.deliver.api_conta_pagar.entity.AccountPayableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountPayableRepository extends JpaRepository<AccountPayableEntity, Long> {
}
