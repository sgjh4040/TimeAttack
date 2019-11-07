package kr.co.timeattack.web.account;

import kr.co.timeattack.web.account.dto.AccountDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static java.util.Collections.EMPTY_LIST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AccountServiceTest {
    AccountRepository repository;
    AccountService service;

    @BeforeEach
    void beforeEach(){
        this.repository = Mockito.mock(AccountRepository.class);
        this.service = new AccountService(this.repository);
    }

    @Test
    void list() {
        when(repository.list()).thenReturn(EMPTY_LIST);
        List<AccountDto> list = service.list();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    void create() {
    }
}
