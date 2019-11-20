package kr.co.timeattack.web.member.dto;

import kr.co.timeattack.web.member.model.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdminMemberDto {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberNickname;
    private String snsYn;
    private String memberPh;
    private String zipCode;
    private String address1;
    private String address2;
    private String memberBirth;
    private String memberRegDate;
    private String delYn;
    private Set<RoleEnum> roles;
}
