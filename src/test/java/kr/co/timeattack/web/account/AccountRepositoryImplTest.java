package kr.co.timeattack.web.account;

import kr.co.timeattack.web.account.model.AccountModel;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryImplTest {

    AccountRepository repository;
    final int SIZE = 100;

    private List<AccountModel> createList() {
        return IntStream.range(1, (SIZE + 1)).mapToObj(x -> new AccountModel(format("test%03d", x), "test" + x)).collect(Collectors.toList());
    }

//    @BeforeEach
//    void beforeEach(){
//
//        this.repository = new AccountRepositoryImpl(createList());
//        List<AccountModel> list = repository.list();
//        assertThat(list.size()).isEqualTo(SIZE);
//    }

    @Test
    void list() {
        //given 컨디션
        this.repository = new AccountRepositoryImpl(createList());

        //when 메소드
        List<AccountModel> list = repository.list();
        //then
        assertThat(list.size()).isEqualTo(SIZE);
    }

    @Test
    void findById() {
    }

    @Test
    void create() {
        this.repository = new AccountRepositoryImpl(new ArrayList<>());
        //when
        repository.create(new AccountModel("username", "password"));
        //then
        assertThat(this.repository.list().size()).isEqualTo(1);

    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}
