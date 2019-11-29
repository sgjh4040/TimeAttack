package kr.co.timeattack.web.order;


import kr.co.timeattack.web.good.dto.OrderGoodDto;
import kr.co.timeattack.web.good.model.GoodModel;
import kr.co.timeattack.web.member.model.MemberModel;
import kr.co.timeattack.web.order.model.OrderGoodsModel;
import kr.co.timeattack.web.order.model.OrderModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepositoryDelegate orderRepository;
    private OrderGoodRepository orderGoodRepository;


    public void addOrder(List<OrderGoodDto> orderList){
        for(int i=0; i<orderList.size();i++){
            OrderGoodDto dto = orderList.get(i);
            Long memberId = dto.getMemberId();
            int orderGoodsQty = dto.getOrderGoodsqty();
            Long goodId = dto.getGoodId();
            MemberModel orderer = new MemberModel(memberId);

            OrderModel order = dto.toOrderModel();
            order.setMember(orderer);

            Long newORderId = orderRepository.save(order);

            order.setId(newORderId);
            GoodModel good = new GoodModel(goodId);
            OrderGoodsModel orderGood = new OrderGoodsModel(good,orderGoodsQty);
            orderGood.setOrder(order);
            orderGoodRepository.save(orderGood);
        }

    }


}
