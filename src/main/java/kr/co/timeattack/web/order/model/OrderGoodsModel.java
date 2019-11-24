package kr.co.timeattack.web.order.model;

import kr.co.timeattack.web.good.model.GoodModel;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "order_goods")
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderGoodsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    private OrderModel order;

    @NonNull
    @OneToOne
    private GoodModel goods;

    @NonNull
    @Column(name = "goods_qty")
    private int goodsQty;
}
