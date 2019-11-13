package kr.co.timeattack.web.order;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class OrderController {

    private OrderService orderService;
    private OrderRepository orderRepository;


//    @PostMapping
//    public ModelAndView payToOrderGoods(@RequestParam Map<String,String> receiverMap){
//
//    }
}
