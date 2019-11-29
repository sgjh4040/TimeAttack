package kr.co.timeattack.web.good.dto;


import kr.co.timeattack.web.order.model.OrderModel;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderGoodDto {
    private Long memberId;
    private Long goodId;
    private int orderGoodsqty;
    private String goodTitle;
    private int goodSalesPrice;
    private String goodsFilename;
    private int goodsPoint;
    private String ordererName;
    private String receiverName;
    private String receiverHp;
    private String receiverTel;
    private String postcode;
    private String address;
    private String detailaddress;
    private String extraaddress;
    private String deliveryMessage;
    private String payMethod;
    private String cardComName;
    private String cardPayMonth;
    private String deliveryState;
    private String payOrderHp;


    public OrderModel toOrderModel(){
        return new OrderModel(ordererName,receiverName,receiverHp,receiverTel,address,detailaddress,postcode,deliveryMessage,payMethod,cardComName,cardPayMonth,deliveryState,payOrderHp);
    }
}
