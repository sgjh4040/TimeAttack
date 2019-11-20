package kr.co.timeattack.web.cart;

import kr.co.timeattack.web.cart.model.CartModel;
import kr.co.timeattack.web.good.model.GoodModel;

import java.util.List;

public interface CustomCartRepository {

    List<CartModel> findAllByUser(Long userId);

}
