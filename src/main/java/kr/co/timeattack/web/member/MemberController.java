package kr.co.timeattack.web.member;

import kr.co.timeattack.web.member.dto.MemberDto;
import kr.co.timeattack.web.member.model.MemberModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;

    @GetMapping("/login")
    public String loginForm(HttpServletRequest req){
        String referer = req.getHeader("Referer");
        req.getSession().setAttribute("prevPage",referer);
        return "login";
    }


    @GetMapping("/member/create")
    public ModelAndView register(Model m){
        ModelAndView mv = new ModelAndView("member/create");
        m.addAttribute("member", new MemberDto());
        return mv;
    }
    @PostMapping("/member/create")
    public ModelAndView createPost(@ModelAttribute("member") @Valid MemberDto dto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ModelAndView mv = new ModelAndView("member/create");
            mv.addObject("member",dto);
            return mv;
        }else{
            memberService.create(dto);
            return new ModelAndView("redirect:/");
        }
    }

    @GetMapping("/mypage/mydetail")
    public ModelAndView myDetailInfo(Principal principal){
        ModelAndView mv = new ModelAndView("mypage/myDetailInfo");
        String memberEmail = principal.getName();

        MemberModel member = memberService.findByEmail(memberEmail);
        mv.addObject("member",member);
        return mv;
    }
}
