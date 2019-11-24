package kr.co.timeattack.web.cart.model;


import kr.co.timeattack.web.good.model.GoodModel;
import kr.co.timeattack.web.member.model.MemberModel;
import lombok.*;
import org.springframework.data.util.Lazy;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "cart_goods")
@ToString
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class CartGoodsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = LAZY)
    private CartModel cart;
    @NonNull

    @OneToOne
    private GoodModel goods;

    @NonNull
    @Column(name = "goods_qty")
    private int goodsQty;

}
