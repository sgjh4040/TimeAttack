package kr.co.timeattack.web.member.dto;


import kr.co.timeattack.web.member.model.MemberModel;
import kr.co.timeattack.web.member.model.RoleEnum;
import kr.co.timeattack.web.member.model.RoleModel;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private Long id;
    @NonNull
    @Email(message = "email 형식을 지켜주세요")
    private String memberEmail;
    @NonNull
    @Size(min=5, max=20, message = "password는 5 ~ 20 글자 범위에서 입력해주세요")
    private String memberPassword;
    @NonNull
    private String memberNickname;
    @Size(min = 1, message = "role은 최소 1개 이상 선택해주세요.")
    private Set<RoleEnum> roles;

    public MemberModel toModel() {
        MemberModel m = new MemberModel(memberEmail,memberPassword,memberNickname);
        Set<RoleModel> roles = this.roles.stream().map(x -> new RoleModel(m, x)).collect(toSet());
        m.getRoles().addAll(roles);
        return m;

    }
}
