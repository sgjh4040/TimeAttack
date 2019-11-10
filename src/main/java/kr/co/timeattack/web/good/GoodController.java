package kr.co.timeattack.web.good;

import kr.co.timeattack.web.good.dto.GoodDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class GoodController {

    private GoodService goodService;

    @GetMapping("/")
    public ModelAndView mainlist(){
        ModelAndView mv = new ModelAndView("/test");
        System.out.println("시작");
        List<GoodDto> list= goodService.list();
        System.out.println("list:"+list.get(0).toString());
        mv.addObject("goodlist",list);
        return mv;
    }



}
