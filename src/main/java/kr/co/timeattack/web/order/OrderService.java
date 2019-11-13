package kr.co.timeattack.web.order;


import kr.co.timeattack.web.order.dto.OrderDto;
import kr.co.timeattack.web.order.model.OrderModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public List<OrderDto> listMyOrderGoods(int orderId){
        List<OrderModel> list = orderRepository.listMyOrderGoods(orderId);
        return list.stream().map(x-> x.toDto()).collect(Collectors.toList());
    }

    public void addNewOrder(List<OrderDto> myOrderList){
        orderRepository.insertNewOrder(myOrderList.stream().map(x-> x.toModel()).collect(Collectors.toList()));

    }
    public OrderDto findMyOrder(int orderId){
        return orderRepository.findMyOrder(orderId).toDto();
    }
}
