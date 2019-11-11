package kr.co.timeattack.web.cart;

import kr.co.timeattack.web.cart.dto.CartDto;
import kr.co.timeattack.web.member.MemberRepository;
import kr.co.timeattack.web.member.MemberService;
import kr.co.timeattack.web.member.model.MemberModel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class CartController {

    private CartService cartService;
    private MemberRepository memberRepository;
    private CartDto cartDto;

    //장바구니 리스트
    @GetMapping("cart/list")
    public ModelAndView myCartMain(HttpServletRequest request, Principal principal){
        String userEmail = principal.getName();
        ModelAndView mv = new ModelAndView("cart/list");
        HttpSession session = request.getSession();
        int userId = memberRepository.findbyEmail(userEmail).getMemberId();
        cartDto.setMemberId(userId);
        Map<String, List> cartMap = cartService.myCartList(cartDto);
        session.setAttribute("cartMap",cartMap);
        return mv;
    }


    //장바구니 등록
    @PostMapping("/cart/create")
    public ModelAndView createPost(@RequestParam("goodId") int goodId, BindingResult bindingResult, Principal principal) {


        if (bindingResult.hasErrors()) {
            ModelAndView mv = new ModelAndView("cart/create");
            return mv;
        } else {

            boolean isAreadyExist = cartService.findCartGoods(cartDto);

            if (isAreadyExist) {
                ModelAndView mv = new ModelAndView("cart/create");
                return mv;
            } else {
                cartService.addGoodsInCart(cartDto);
                return new ModelAndView("redirect:/cart/list");
            }


        }
    }

    @PostMapping("/cart/remove")
    public ModelAndView removeCartGoods(){
        ModelAndView mav = new ModelAndView();
        cartService.removeCartGoods('1');
        mav.setViewName("redirect:/cart");
        return mav;
    }


}
