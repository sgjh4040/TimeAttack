package kr.co.timeattack.web.order.model;


import com.sun.istack.NotNull;
import kr.co.timeattack.web.good.model.GoodModel;
import kr.co.timeattack.web.member.model.MemberModel;
import kr.co.timeattack.web.order.dto.OrderDto;
import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name="orders")
@ToString(exclude = "member")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = LAZY)
    @NonNull private MemberModel member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderGoodsModel> orderGood = new ArrayList<>();

    @Column(name = "order_goods_qty")
    private int orderGoodsQty;

    @Column(name = "Orderer_name")
    private String ordererName;

    @Column(name = "receiver_name")
    private String receiverName;

    @Column(name = "receiver_hp")
    private String receiverHp;

    @Column(name = "receiver_tel")
    private String receiverTel;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Column(name = "delivery_message")
    private String deliveryMessage;

    @Column(name = "pay_method")
    private String payMethod;

    @Column(name = "card_com_name")
    private String cardComName;

    @Column(name = "card_pay_month")
    private String cardPayMonth;

    @Column(name = "delivery_state")
    private String deliveryState;

    @Column(name="goods_qty")
    private int goodsQty;


}
