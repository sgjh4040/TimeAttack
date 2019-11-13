package kr.co.timeattack.web.order;

import kr.co.timeattack.web.order.model.OrderModel;

import java.util.List;

public interface OrderRepository {
   public List<OrderModel> listMyOrderGoods(int orderId);

   public void insertNewOrder(List<OrderModel> orderList);

   public OrderModel findMyOrder(int ordierId);

   public void removeGoodsFromCart(List<OrderModel> myOrderList);


}
