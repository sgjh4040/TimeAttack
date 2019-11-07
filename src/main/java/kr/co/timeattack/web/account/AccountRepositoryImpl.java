package kr.co.timeattack.web.account;

import kr.co.timeattack.web.account.model.AccountModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
@AllArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

    private List<AccountModel> list;

    @Override
    public List<AccountModel> list() {
        return list;
    }

    @Override
    public AccountModel findById(Long id) {
        return null;
    }

    @Override
    public void create(AccountModel m) {
        this.list.add(m);

    }

    @Override
    public void update(AccountModel m) {

    }

    @Override
    public void delete(Long id) {

    }
}
