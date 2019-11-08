package kr.co.timeattack.web.cart;

import kr.co.timeattack.web.cart.dto.CartDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class CartController {

    private CartService cartService;

    //장바구니 등록
    @PostMapping("/cart/create")
    public ModelAndView createPost(@ModelAttribute("cart") @Valid CartDto dto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            ModelAndView mv = new ModelAndView("cart/create");
            return mv;
        } else {
            boolean isAreadyExist = cartService.findCartGoods(dto);

            if (isAreadyExist) {
                ModelAndView mv = new ModelAndView("cart/create");
                return mv;
            } else {
                cartService.addGoodsInCart(dto);
                return new ModelAndView("redirect:/cart/list");
            }


        }
    }


}
