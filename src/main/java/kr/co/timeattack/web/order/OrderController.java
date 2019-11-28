package kr.co.timeattack.web.order;


import com.sun.tools.jconsole.JConsoleContext;
import kr.co.timeattack.web.good.GoodService;
import kr.co.timeattack.web.good.dto.GoodDto;
import kr.co.timeattack.web.good.dto.OrderGoodDto;
import kr.co.timeattack.web.good.model.GoodModel;
import kr.co.timeattack.web.member.MemberService;
import kr.co.timeattack.web.member.dto.MemberDto;
import kr.co.timeattack.web.member.model.MemberModel;
import kr.co.timeattack.web.order.dto.OrderDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.tools.jconsole.JConsole;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@AllArgsConstructor
public class OrderController {



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
    public ModelAndView orderGddsPost(@ModelAttribute("goods") @Valid OrderDto dto,HttpServletRequest request){


        HttpSession session = request.getSession();
        List<GoodDto> myOrderList = (List<GoodDto>)session.getAttribute("myOrderList");

        for (int i=0; i<myOrderList.size();i++){
            GoodDto orderDto = (GoodDto) myOrderList.get(i);
            System.out.println(orderDto.toString());
        }

        System.out.println("주문");
        System.out.println(dto.toString());
        ModelAndView mv = new ModelAndView("/order/orderGoodsForm");




        return mv;
    }


//    @PostMapping
//    public ModelAndView payToOrderGoods(@RequestParam Map<String,String> receiverMap){
//
//    }
}
