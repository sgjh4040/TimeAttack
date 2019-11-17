package kr.co.timeattack.web.member.model;

import kr.co.timeattack.web.good.model.GoodModel;
import kr.co.timeattack.web.member.dto.MemberDto;
import kr.co.timeattack.web.order.model.OrderModel;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Entity
@Table(name = "member")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class MemberModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_email")
    @NonNull private String memberEmail;

    @Column(name = "member_password")
    @NonNull  private String memberPassword;

    @Column(name = "member_nickname")
    @NonNull private String memberNickname;

    @Column(name = "sns_yn")
    private String snsYn;

    @Column(name = "member_ph")
    private String memberPh;

    @Column(name = "zip_code")
    private String zipCode;

    private String address1;
    private String address2;

    @Column(name = "member_birth")
    private String memberBirth;

    @Column(name = "member_reg_date")
    private String memberRegDate;

    @Column(name = "del_yn")
    private String delYn;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderModel> order;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RoleModel> roles = new HashSet<>();




    public MemberDto toDto() {
        Set<RoleEnum> roles = this.roles.stream().map(RoleModel::getName).collect(toSet());
        return new MemberDto(id, memberEmail, memberPassword, memberNickname, snsYn, memberPh, zipCode, address1, address2, memberBirth, memberRegDate, delYn, roles);
    }

    public void update(MemberDto dto){

    }


}
