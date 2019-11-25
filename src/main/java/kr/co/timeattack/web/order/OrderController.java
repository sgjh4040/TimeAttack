package kr.co.timeattack.web.order;


import kr.co.timeattack.web.good.GoodService;
import kr.co.timeattack.web.good.dto.GoodDto;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class OrderController {

    private GoodService goodService;
    private MemberService memberService;

    @GetMapping("/order")
    public ModelAndView orderGoods(@RequestParam("id") String goodId, HttpServletRequest request,Principal principal) throws Exception{

        request.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();

        ModelAndView mv = new ModelAndView("order/orderGoodsForm");

        String userEmail = principal.getName();
        MemberModel memberModel = memberService.findByEmail(userEmail);


        GoodDto goodDto = goodService.goodsDetail(Long.parseLong(goodId));
        List myOrderList = new ArrayList<GoodDto>();

        myOrderList.add(goodDto);

        mv.addObject("orderList",myOrderList);
        mv.addObject("member",memberModel);

        session.setAttribute("myOrderList", myOrderList);
        session.setAttribute("orderer", memberModel);

        return mv;





    }


//    @PostMapping
//    public ModelAndView payToOrderGoods(@RequestParam Map<String,String> receiverMap){
//
//    }
}
