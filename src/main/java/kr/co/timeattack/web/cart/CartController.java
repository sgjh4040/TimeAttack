package kr.co.timeattack.web.cart;

import com.sun.tools.jconsole.JConsoleContext;
import kr.co.timeattack.web.cart.dto.CartDto;
import kr.co.timeattack.web.member.MemberRepository;
import kr.co.timeattack.web.member.MemberService;
import kr.co.timeattack.web.member.dto.MemberDto;
import kr.co.timeattack.web.member.model.MemberModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.*;
import java.security.Principal;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class CartController {

    private CartService cartService;
    private MemberRepository memberRepository;

    //장바구니 리스트
    @GetMapping("cart/list")
    public ModelAndView myCartMain(@NonNull HttpServletRequest request,@NonNull Principal principal) {
        CartDto cartDto = new CartDto();
        String userEmail = principal.getName();
        ModelAndView mv = new ModelAndView("cart/myCartList");
        HttpSession session = request.getSession();
        Long userId = memberRepository.findByMemberEmail(userEmail).get().getId();
        Map<String, List> cartMap = cartService.myCartList(userId);
        session.setAttribute("cartMap", cartMap);
        return mv;
    }


    //장바구니 등록
    @PostMapping("/cart/create")
    public @ResponseBody String createPost(@RequestParam("goodId") int goodId, Principal principal) {

        System.out.println("cart create");
        CartDto cartDto = new CartDto();
        //유저 email
        String userEmail = principal.getName();
        System.out.println("userEmail"+userEmail);
        if(userEmail.equals("") || userEmail==null){
            return "not_login";

        }else{
            Long userId = memberRepository.findByMemberEmail(userEmail).get().getId();
            cartDto.setGoodId(Long.valueOf(goodId));
            cartDto.setMemberId(userId);
            cartService.addGoodsInCart(cartDto);
            return "add_success";

        }

//        if (bindingResult.hasErrors()) {
//            ModelAndView mv = new ModelAndView("cart/create");
//            return mv;
//        } else {
//
//            CartDto cartDto = new CartDto();
//            boolean isAreadyExist = cartService.findCartGoods(cartDto);
//
//            if (isAreadyExist) {
//                ModelAndView mv = new ModelAndView("cart/create");
//                return mv;
//            } else {
//                cartService.addGoodsInCart(cartDto);
//                return new ModelAndView("redirect:/cart/list");
//            }
//
//
//        }
    }

    @PostMapping("/cart/modify")
    public @ResponseBody
    String modifyCart(@RequestParam("goodId") int goodId,
                      @RequestParam("cartGoodqty") int cartGoodqty,Principal principal,
                      HttpServletRequest request) {
        String userEmail = principal.getName();
        Long userId = memberRepository.findByMemberEmail(userEmail).get().getId();

        CartDto cartDto = new CartDto();
        cartDto.setGoodId(Long.valueOf(goodId));
        cartDto.setMemberId(userId);
        cartDto.setCartGoodqty(cartGoodqty);
        boolean result = cartService.modifyCartQty(cartDto);

        if(result){
            return "modify_succes";
        }else{
            return "modify_failed";
        }




    }

    @PostMapping("/cart/remove")
    public ModelAndView removeCartGoods() {
        ModelAndView mav = new ModelAndView();
        cartService.removeCartGoods('1');
        mav.setViewName("redirect:/cart");
        return mav;
    }


}
