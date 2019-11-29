package kr.co.timeattack.web.order;

import kr.co.timeattack.web.order.model.OrderGoodsModel;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderGoodRepository extends PagingAndSortingRepository<OrderGoodsModel,Long> {
}
