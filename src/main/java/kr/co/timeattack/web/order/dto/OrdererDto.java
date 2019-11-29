package kr.co.timeattack.web.order.dto;


import kr.co.timeattack.web.order.model.OrderModel;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrdererDto {
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


}
