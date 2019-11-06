package kr.co.timeattack.web.member.model;

import kr.co.timeattack.web.member.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberModel {
    private Long memberId;
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

    public MemberDto toDto() {
        return new MemberDto(
                memberId,
                memberEmail,
                memberPassword,
                memberNickname,
                snsYn, memberPh,
                zipCode,
                address1,
                address2,
                memberBirth,
                memberRegDate,
                delYn);
    }

}
