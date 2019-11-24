package kr.co.timeattack.web.cart;


import kr.co.timeattack.web.cart.dto.CartDto;
import kr.co.timeattack.web.cart.model.CartGoodsModel;
import kr.co.timeattack.web.cart.model.CartModel;
import kr.co.timeattack.web.good.model.GoodModel;
import kr.co.timeattack.web.member.model.MemberModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartService {
    private CartRepositoryDelegate cartRepository;
    private CartGoodRepository cartGoodRepository;

    public Map<String,List> myCartList(Long id){
        Map<String,List> cartMap = new HashMap<String,List>();
        List<CartModel> myCartList = cartRepository.findAllByUser(id);
        if(myCartList.size()==0){
            return null;
        }
        cartMap.put("myCartList",myCartList);

        return cartMap;
    }



    public List<CartDto> list(CartDto dto) {
//        List<CartModel> list = cartRepository.selectCartList(dto.toModel());
//        if(list.size()==0){
//            return null;
//        }
//        return list.stream().map(x -> x.toDto()).collect(Collectors.toList());
        return null;
    }

    //동일 상품 존재유무 확인
    public boolean findCartGoods(CartDto dto) {
//        return cartRepository.selectCountInCart(dto.toModel());
        return true;
    }
    //장바구니에 카트 추가
    @Transactional
    public void addGoodsInCart(CartDto dto) {

        //dto to Model,,,, 수정 필요
        Long memberId = dto.getMemberId();
        int orderGoodsQty = dto.getCartGoodqty();
        Long goodId = dto.getGoodId();
        MemberModel order = new MemberModel(memberId);

        CartModel cart = new CartModel();
        cart.setMember(order);
        cart.setId(dto.getId());
        Long newCartId = cartRepository.save(cart);
        cart.setId(newCartId);

        GoodModel good = new GoodModel(goodId);
        CartGoodsModel cartGood = new CartGoodsModel(good,orderGoodsQty);

        cartGood.setGoodsQty(orderGoodsQty);
        cartGood.setGoods(good);
        cartGood.setCart(cart);
        cartGood.setCart(cart);
        cartGoodRepository.save(cartGood);
    }
    @Transactional
    public void delete(Long id){
        cartRepository.deleteById(id);
    }

    //장바구니 개수 수정
    public boolean modifyCartQty(CartDto dto) {

        boolean result = true;
//        cartRepository.updateCartGoodsQty(dto.toModel());
        return result;
    }

    //장바구나 삭제
    public void removeCartGoods(int cartId) {

    }
}
