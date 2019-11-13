package kr.co.timeattack.web.order;

import kr.co.timeattack.web.order.model.OrderModel;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public List<OrderModel> listMyOrderGoods(int orderId) {
        return null;
    }

    @Override
    public void insertNewOrder(List<OrderModel> orderList) {

    }

    @Override
    public OrderModel findMyOrder(int ordierId) {
        return null;
    }

    @Override
    public void removeGoodsFromCart(List<OrderModel> myOrderList) {

    }
}
