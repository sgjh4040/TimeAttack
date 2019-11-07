package kr.co.timeattack.web.account;

import kr.co.timeattack.web.account.dto.AccountDto;
import kr.co.timeattack.web.account.model.AccountModel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountService {
    private AccountRepository accountRepository;

    public List<AccountDto> list(){
        List<AccountModel> list = accountRepository.list();
        return list.stream().map(x -> x.toDto()).collect(Collectors.toList());

    }
    public void create(AccountDto dto){
        accountRepository.create(dto.toModel());
    }
}
