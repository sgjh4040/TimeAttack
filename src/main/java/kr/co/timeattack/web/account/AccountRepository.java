package kr.co.timeattack.web.account;

import kr.co.timeattack.web.account.model.AccountModel;

import java.util.List;

public interface AccountRepository {
    List<AccountModel> list();
    AccountModel findById(Long id);
    void create(AccountModel m );
    void update(AccountModel m);
    void delete(long id);

}
