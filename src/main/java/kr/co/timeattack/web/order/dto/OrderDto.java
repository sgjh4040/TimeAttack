package kr.co.timeattack.web.order.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private int orderSeqNum;
    private int memberId;
    private int orderId;
    private int goodsId;
    private String goodsTitle;
    private int goodsSalesPrice;
    private int totalGoodsPrice;
    private int cartGoodsQty;
    private int orderGoodsQty;
    private String ordererName;
    private String receiverName;
    private String receiverHp1;
    private String receiverHp2;
    private String receiverTel1;
    private String receiverTel2;

    private String deliveryAddress;
    private String deliveryMessage;
    private String deliveryMethod;
    private String giftWrapping;
    private String payMethod;
    private String cardComName;
    private String cardPayMonth;
    private String payOrdererHpnum;
    private String deliveryState;

    private String finalTotalPrice;
    private int goodsQty;
    private String goodsFileName;
    private String ordererHp;
}
