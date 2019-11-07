package kr.co.timeattack.web.account.dto;


import kr.co.timeattack.web.account.model.AccountModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    @Size(min = 3, max = 20, message = "유저이름은 3~20 글자 범위에서 입력해 주세요")
    private String username;
    @Size(min=5, max=20, message = "비밀번호는 5 ~ 20 글자 범위에서 입력해주세요")
    private String password;

    public AccountModel toModel() { return new AccountModel(username,password);}
}
