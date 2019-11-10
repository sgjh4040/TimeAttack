package kr.co.timeattack.web.account;

import kr.co.timeattack.web.account.model.AccountModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccountRepository {
    List<AccountModel> list();
    AccountModel findById(Long id);
    void create(AccountModel m );
    void update(AccountModel m);
    void delete(Long id);
    Page<AccountModel> findAll(Pageable pageable);

}
