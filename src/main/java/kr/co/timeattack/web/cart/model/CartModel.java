package kr.co.timeattack.web.cart.model;


import kr.co.timeattack.web.cart.dto.CartDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartModel {
    private Long cartId;
    private Long goodId;
    private Long memberId;
    private Long cardNum;

    public CartDto toDto(){return new CartDto(cartId,goodId,memberId,cardNum);}


}
