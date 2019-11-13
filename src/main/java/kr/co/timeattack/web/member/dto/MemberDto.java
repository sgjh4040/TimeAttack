package kr.co.timeattack.web.member.dto;


import kr.co.timeattack.web.member.model.MemberModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private int memberId;
    @Email(message = "email 형식을 지켜주세요")
    private String memberEmail;
    @Size(min=5, max=20, message = "password는 5 ~ 20 글자 범위에서 입력해주세요")
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
    @Size(min = 1, message = "role은 최소 1개 이상 선택해주세요.")
    private Set<String> roles;

    public MemberModel toModel() {
        return new MemberModel(
                memberId,
                memberEmail,
                memberPassword,
                memberNickname,
                snsYn,
                memberPh,
                zipCode,
                address1,
                address2,
                memberBirth,
                memberRegDate,
                delYn,
                roles);
    }
}
