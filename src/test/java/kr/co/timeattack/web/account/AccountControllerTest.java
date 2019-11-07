package kr.co.timeattack.web.account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

class AccountControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean AccountService service;


}
