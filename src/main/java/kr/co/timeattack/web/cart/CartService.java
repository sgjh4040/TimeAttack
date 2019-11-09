package kr.co.timeattack.web.cart;


import kr.co.timeattack.web.cart.dto.CartDto;
import kr.co.timeattack.web.cart.model.CartModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartService {
    private CartRepository cartRepository;

    public List<CartDto> list(CartDto dto) {
        List<CartModel> list = cartRepository.selectCartList(dto.toModel());
        return list.stream().map(x -> x.toDto()).collect(Collectors.toList());
    }

    //동일 상품 존재유무 확인
    public boolean findCartGoods(CartDto dto) {
        return cartRepository.selectCountInCart(dto.toModel());
    }

    //장바구니에 카트 추가
    public void addGoodsInCart(CartDto dto) {
        cartRepository.insertGoodsInCart(dto.toModel());
    }

    //장바구니 수정
    public void modifyCart(CartDto dto) {
        cartRepository.updateCartGoods(dto.toModel());
    }

    //장바구나 삭제
    public void removeCartGoods(int cartId) {
        cartRepository.deleteCartGoods(cartId);
    }
}
