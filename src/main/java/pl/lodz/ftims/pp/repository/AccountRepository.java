package pl.lodz.ftims.pp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.lodz.ftims.pp.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findByLogin(String login);
}
