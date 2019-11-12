package kr.co.timeattack.web.cart;

import kr.co.timeattack.web.cart.model.CartModel;
import kr.co.timeattack.web.good.model.GoodModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@AllArgsConstructor
public class CartRepositoryImpl implements CartRepository {

    private List<CartModel> list;
    private List<GoodModel> goodlist;

    @Override
    public List<CartModel> selectCartList(CartModel m) {
       List<CartModel> cartList = list;
       return list;
    }

    @Override
    public List<GoodModel> selectGoodList(List<CartModel> cartList) {
        List<GoodModel> myGoodsList;
        myGoodsList = goodlist;
        return myGoodsList;
    }

    //장바구니 추가
    @Override
    public void insertGoodsInCart(CartModel m) {
        this.list.add(m);

    }

    @Override
    public void updateCartGoodsQty(CartModel m) {
        this.list.add(m);
    }

    @Override
    public void deleteCartGoods(int cartId) {
        this.list.remove('1');
    }

    //장바구니 동일상품 존재 유무
    @Override
    public boolean selectCountInCart(CartModel m) {
        return false;
    }
}
