package kr.co.timeattack.web.main;


import kr.co.timeattack.web.good.GoodService;
import kr.co.timeattack.web.good.dto.GoodDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class MainController {
    private GoodService goodService;

    @GetMapping("/")
    public ModelAndView bestsellerList(){
        ModelAndView mv = new ModelAndView("/main/bestseller");
        Map<String, List<GoodDto>> goodsMap = goodService.listGoods();
        mv.addObject("goodlist", goodsMap.get("bestseller"));


        return mv;
    }
    @GetMapping("/newbook")
    public ModelAndView newbookList(){
        ModelAndView mv = new ModelAndView("/main/newbook");
        Map<String, List<GoodDto>> goodsMap = goodService.listGoods();
        mv.addObject("goodlist", goodsMap.get("newbook"));


        return mv;
    }
    @GetMapping("/steadyseller")
    public ModelAndView steadysellerList(){
        ModelAndView mv = new ModelAndView("/main/steadyseller");
        Map<String, List<GoodDto>> goodsMap = goodService.listGoods();
        mv.addObject("goodlist", goodsMap.get("bestseller"));


        return mv;
    }
}
