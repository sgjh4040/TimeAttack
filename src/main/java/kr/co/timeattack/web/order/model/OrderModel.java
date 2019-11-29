package kr.co.timeattack.web.order.model;


import kr.co.timeattack.web.member.model.MemberModel;
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
    public OrderModel(String ordererName,String receiverName,String receiverHp,String receiverTel,String address, String detailaddress,String postcode,String deliveryMessage, String payMethod,String cardComName,String cardPayMonth,String deliveryState,String payOrderHp){
        this.ordererName = ordererName;
        this.receiverName = receiverName;
        this.receiverHp = receiverHp;
        this.receiverTel = receiverTel;
        this.address = address;
        this.detailaddress = detailaddress;
        this.postcode = postcode;
        this.deliveryMessage =deliveryMessage;
        this.payMethod = payMethod;
        this.cardComName =cardComName;
        this.cardPayMonth =cardPayMonth;
        this.deliveryState =deliveryState;
        this.payOrderHp =payOrderHp;




    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = LAZY)
    @NonNull private MemberModel member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderGoodsModel> orderGood = new ArrayList<>();



    @Column(name = "Orderer_name")
    private String ordererName;

    @Column(name = "receiver_name")
    private String receiverName;

    @Column(name = "receiver_hp")
    private String receiverHp;

    @Column(name = "receiver_tel")
    private String receiverTel;

    @Column(name = "address")
    private String address;

    @Column(name = "detail_address")
    private String detailaddress;

    @Column(name = "postcode")
    private String postcode;

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

    @Column(name = "pay_order_hp")
    private String payOrderHp;




}
