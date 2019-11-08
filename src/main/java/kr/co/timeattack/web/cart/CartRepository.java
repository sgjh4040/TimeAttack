package kr.co.timeattack.web.cart;

import kr.co.timeattack.web.cart.model.CartModel;
import kr.co.timeattack.web.good.model.GoodModel;

import java.util.List;

public interface CartRepository {

    public List<CartModel> selectCartList(CartModel m);
    public List<GoodModel> selectGoodList(List<CartModel> cartList);
    void insertGoodsInCart(CartModel m);
    void updateCartGoods(CartModel m);
    void deleteCartGoods(int cartId );
    boolean selectCountInCart(CartModel m);



}
