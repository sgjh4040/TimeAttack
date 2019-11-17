package kr.co.timeattack.web.member.model;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;


@Entity
@Table(name = "role")
@ToString(exclude = "member")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = LAZY)
    @NonNull private MemberModel member;
    @Enumerated(EnumType.STRING)
    @NonNull private RoleEnum name;


}
