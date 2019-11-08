package kr.co.timeattack.web.cart.dto;


import kr.co.timeattack.web.cart.model.CartModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private Long cartId;
    private Long goodId;
    private Long memberId;
    private Long cardNum;

    public CartModel toModel(){return new CartModel(cartId,goodId,memberId,cardNum);}
}
