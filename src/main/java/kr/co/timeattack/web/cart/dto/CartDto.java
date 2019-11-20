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

    private Long id;
    private Long goodId;
    private Long memberId;
    private int cartGoodqty;
    private String creDate;

}
