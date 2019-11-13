package kr.co.timeattack.web.order.model;


import kr.co.timeattack.web.order.dto.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel {

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

    public OrderDto toDto(){
        return new OrderDto(
        orderSeqNum,
        memberId,
        orderId,
        goodsId,
        goodsTitle,
        goodsSalesPrice,
        totalGoodsPrice,
        cartGoodsQty,
        orderGoodsQty,
        ordererName,
        receiverName,
        receiverHp1,
        receiverHp2,
        receiverTel1,
        receiverTel2,
        deliveryAddress,
        deliveryMessage,
        deliveryMethod,
        giftWrapping,
        payMethod,
        cardComName,
        cardPayMonth,
        payOrdererHpnum,
        deliveryState,
        finalTotalPrice,
        goodsQty,
        goodsFileName,
        ordererHp
        );
    }
}
