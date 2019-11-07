package kr.co.timeattack.web.account.model;


import kr.co.timeattack.web.account.dto.AccountDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class AccountModel {
    private Long id;
    @NonNull private String username;
    @NonNull private String password;

    public AccountDto toDto(){return new AccountDto(username,password);}

}
