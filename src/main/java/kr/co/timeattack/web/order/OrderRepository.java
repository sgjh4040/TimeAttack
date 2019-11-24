package kr.co.timeattack.web.order;

import kr.co.timeattack.web.order.model.OrderModel;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends PagingAndSortingRepository<OrderModel,Long> {

   List<OrderModel> findAll();
   default void create(OrderModel m){save(m);}
   Optional<OrderModel> findById(Long id);


}
