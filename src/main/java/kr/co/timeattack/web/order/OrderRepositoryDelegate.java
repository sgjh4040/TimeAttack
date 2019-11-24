package kr.co.timeattack.web.order;


import kr.co.timeattack.web.order.model.OrderModel;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryDelegate extends QuerydslRepositorySupport {
    private final OrderRepository repository;

    public OrderRepositoryDelegate(OrderRepository repository){
        super(OrderModel.class);
        this.repository = repository;
    }
}
