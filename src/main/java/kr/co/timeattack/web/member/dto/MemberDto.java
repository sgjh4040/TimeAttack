package kr.co.timeattack.web.member.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
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
}
