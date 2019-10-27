package kr.co.timeattack.web.account.dto;


import kr.co.timeattack.web.account.model.AccountModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private Long id;
    private String username;
    private String password;

    public AccountModel toModel() { return new AccountModel(id,username,password);}
}
