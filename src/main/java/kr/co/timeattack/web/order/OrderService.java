package kr.co.timeattack.web.order;


import kr.co.timeattack.web.good.model.GoodModel;
import kr.co.timeattack.web.member.model.MemberModel;
import kr.co.timeattack.web.order.dto.OrderDto;
import kr.co.timeattack.web.order.model.OrderModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private OrderRepositoryDelegate orderRepository;


    public void addOrder(OrderDto dto){
        Long memberId = dto.getMemberId();
        int orderGoodsQty = dto.getOrderGoodsQty();
        Long goodId = dto.getGoodsId();

        MemberModel orderer = new MemberModel(memberId);
    }


}
