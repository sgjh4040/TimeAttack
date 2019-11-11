package kr.co.timeattack.web.cart.dto;


import kr.co.timeattack.web.cart.model.CartModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {

    private int cartId;
    private int goodId;
    private int memberId;
    private int cartNum;
    private Date creDate;

    public CartModel toModel(){return new CartModel(cartId,goodId,memberId,cartNum,creDate);}
}
