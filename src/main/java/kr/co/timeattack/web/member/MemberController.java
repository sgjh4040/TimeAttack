package kr.co.timeattack.web.member;

import kr.co.timeattack.web.member.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class MemberController {
    @Autowired MemberService memberService;

    @GetMapping("/login")
    public ModelAndView member(){
        ModelAndView mv = new ModelAndView("login/login");
        return mv;
    }

    /**
     * 로그인
     * @param id
     * **/
    @PostMapping("/login")
    public ModelAndView login(Long id){
        ModelAndView mv =new ModelAndView("redirect:/main");
        memberService.login(id);
        return mv;
    }
    /**
     *
     * **/
    @GetMapping("/register")
    public ModelAndView register(){
        ModelAndView mv = new ModelAndView("member/register");
        return mv;
    }
    @PostMapping("member/register")
    public ModelAndView createPost(@ModelAttribute("member") @Valid MemberDto dto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ModelAndView mv = new ModelAndView("member/register");
            mv.addObject("member",dto);
            return mv;
        }else{
            memberService.create(dto);
            return new ModelAndView("redirect:/main");
        }


    }
}
