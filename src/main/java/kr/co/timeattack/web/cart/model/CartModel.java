package kr.co.timeattack.web.cart.model;


import kr.co.timeattack.web.cart.dto.CartDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartModel {
    private int cartId;
    private int goodId;
    private int memberId;
    private int cartNum;
    private Date creDate;

    public CartDto toDto(){return new CartDto(cartId,goodId,memberId,cartNum,creDate);}


}
