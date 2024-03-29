package kr.co.timeattack.web.cart.model;


import com.sun.istack.NotNull;
import kr.co.timeattack.web.cart.dto.CartDto;
import kr.co.timeattack.web.good.model.GoodModel;
import kr.co.timeattack.web.member.model.MemberModel;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "cart")
@ToString(exclude = "member")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CartModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = LAZY)
    private MemberModel member;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartGoodsModel> cartGood= new ArrayList<>();;


}
