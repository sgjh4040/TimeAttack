package kr.co.timeattack.web.cart;

import kr.co.timeattack.web.cart.model.CartGoodsModel;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CartGoodRepository extends PagingAndSortingRepository<CartGoodsModel, Long> {

}
