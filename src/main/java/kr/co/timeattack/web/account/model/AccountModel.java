package kr.co.timeattack.web.account.model;


import kr.co.timeattack.web.account.dto.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountModel {
    private Long id;
    private String username;
    private String password;

    public AccountDto toDto(){return new AccountDto(id,username,password);}

}
