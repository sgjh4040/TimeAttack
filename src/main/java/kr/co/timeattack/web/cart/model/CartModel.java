package kr.co.timeattack.web.cart.model;


import com.sun.istack.NotNull;
import kr.co.timeattack.web.cart.dto.CartDto;
import kr.co.timeattack.web.good.model.GoodModel;
import kr.co.timeattack.web.member.model.MemberModel;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

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
    @ManyToOne(fetch = LAZY)
    @NotNull
    private GoodModel goods;
    @Column(name = "cart_goods_qty")
    private int cartGoodqty;

    @Column(name = "cre_date")
    private String creDate;




}
