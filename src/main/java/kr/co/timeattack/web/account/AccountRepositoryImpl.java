package kr.co.timeattack.web.account;

import kr.co.timeattack.web.account.model.AccountModel;
import kr.co.timeattack.web.account.model.comparator.ModelComparator;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
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

    @Override
    public Page<AccountModel> findAll(Pageable pageable) {
        pageable.getSort().stream().forEach(x -> list.sort(new ModelComparator(x.getProperty(), x.getDirection())));

        int start = pageable.getPageNumber() * pageable.getPageSize();
        int end = pageable.getPageNumber() * pageable.getPageSize() + pageable.getPageSize();

        if(start > list.size() - 1) return new PageImpl<>(Collections.emptyList(), pageable, list.size());
        if(end > list.size() - 1) end = list.size();

        List<AccountModel> pagedList = list.subList(start, end);
        return new PageImpl<>(pagedList, pageable, list.size());
    }
}
