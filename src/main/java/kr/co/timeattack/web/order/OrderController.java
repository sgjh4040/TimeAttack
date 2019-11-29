package kr.co.timeattack.web.order;


import kr.co.timeattack.web.good.GoodService;
import kr.co.timeattack.web.good.dto.GoodDto;
import kr.co.timeattack.web.good.dto.OrderGoodDto;
import kr.co.timeattack.web.member.MemberService;
import kr.co.timeattack.web.member.model.MemberModel;
import kr.co.timeattack.web.order.dto.OrdererDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;
    private GoodService goodService;
    private MemberService memberService;

    @PostMapping("/ordereach")
    public ModelAndView orderGoods(@ModelAttribute("orderDto") OrderGoodDto orderGoodDto, HttpServletRequest request, Principal principal) throws Exception{

        request.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();

        OrderGoodDto ordergoodDto = orderGoodDto;

        Long goodId = orderGoodDto.getGoodId();

        ModelAndView mv = new ModelAndView("order/orderGoodsForm");

        String userEmail = principal.getName();
        MemberModel memberModel = memberService.findByEmail(userEmail);


        GoodDto goodDto = goodService.goodsDetail(goodId);
        List myOrderList = new ArrayList<OrderGoodDto>();

        ordergoodDto.setMemberId(memberModel.getId());
        ordergoodDto.setGoodSalesPrice(goodDto.getGoodsSalesPrice());
        orderGoodDto.setGoodsFilename(goodDto.getGoodsFilename());
        orderGoodDto.setGoodsPoint(goodDto.getGoodsPoint());
        orderGoodDto.setGoodTitle(goodDto.getGoodsTitle());
        myOrderList.add(orderGoodDto);
        System.out.println(orderGoodDto.toString());

        mv.addObject("orderList",myOrderList);
        mv.addObject("member",memberModel);

        session.setAttribute("myOrderList", myOrderList);
        session.setAttribute("orderer", memberModel);

        return mv;
    }

    @PostMapping("/order")
    public ModelAndView orderGoodsPost(@ModelAttribute("goods") @Valid OrdererDto dto, HttpServletRequest request){


        HttpSession session = request.getSession();
        List<OrderGoodDto> myOrderList = (List<OrderGoodDto>)session.getAttribute("myOrderList");

        for (int i=0; i<myOrderList.size();i++){
            OrderGoodDto orderGoodDto = (OrderGoodDto) myOrderList.get(i);
            System.out.println(orderGoodDto.toString());
            orderGoodDto.setOrdererName(dto.getOrdererName());
            orderGoodDto.setReceiverName(dto.getReceiverName());
            orderGoodDto.setReceiverHp(dto.getReceiverHp());
            orderGoodDto.setReceiverTel(dto.getReceiverTel());
            orderGoodDto.setPostcode(dto.getPostcode());
            orderGoodDto.setAddress(dto.getAddress());
            orderGoodDto.setDetailaddress(dto.getDetailaddress());
            orderGoodDto.setExtraaddress(dto.getExtraaddress());
            orderGoodDto.setDeliveryMessage(dto.getDeliveryMessage());
            orderGoodDto.setPayMethod(dto.getPayMethod());
            orderGoodDto.setCardComName(dto.getCardComName());
            orderGoodDto.setCardPayMonth(dto.getCardPayMonth());
            orderGoodDto.setDeliveryState(dto.getDeliveryState());
            orderGoodDto.setPayOrderHp(dto.getPayOrderHp());

            myOrderList.set(i,orderGoodDto);
        }
        orderService.addOrder(myOrderList);

        System.out.println(dto.toString());
        ModelAndView mv = new ModelAndView("/order/orderGoodsForm");
        mv.addObject("myOrderList",myOrderList);
        return mv;
    }


//    @PostMapping
//    public ModelAndView payToOrderGoods(@RequestParam Map<String,String> receiverMap){
//
//    }
}
