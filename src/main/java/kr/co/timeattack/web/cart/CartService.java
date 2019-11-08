package kr.co.timeattack.web.cart;


import kr.co.timeattack.web.cart.dto.CartDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartService {
    private CartRepository cartRepository;

    //동일 상품 존재유무 확인
    public boolean findCartGoods(CartDto dto){
        return cartRepository.selectCountInCart(dto.toModel());
    }
    //장바구니에 카트 추가
    public void addGoodsInCart(CartDto dto){
        cartRepository.insertGoodsInCart(dto.toModel());
    }

    //장바구니 수정
    public void modifyCart(CartDto dto){
        cartRepository.updateCartGoods(dto.toModel());
    }
    //장바구나 삭제
    public void removeCartGoods(int cartId){
        cartRepository.deleteCartGoods(cartId);
    }
}
