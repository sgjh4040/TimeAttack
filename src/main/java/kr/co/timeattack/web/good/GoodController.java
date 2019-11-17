package kr.co.timeattack.web.good;

import kr.co.timeattack.web.good.dto.GoodDto;
import kr.co.timeattack.web.good.model.GoodModel;
import lombok.AllArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class GoodController {

    private GoodService goodService;



    //상품 디테일 페이
    @GetMapping("/goods")
    public ModelAndView goodDetail(@RequestParam("id") String goodId, HttpServletRequest request){

        ModelAndView mv = new ModelAndView("goods/goodsDetail");
        HttpSession session=request.getSession();
        GoodDto goodDto = goodService.goodsDetail(Integer.parseInt(goodId));
        mv.addObject("good",goodDto);
        addGoodsInQuick(goodId,goodDto,session);
        return mv;
    }

    @GetMapping("/keywordSearch")
    public @ResponseBody String keywordSearch(@RequestParam("keyword") String keyword,
                                              HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        if(keyword== null || keyword.equals("")){
            return null;
        }
        keyword = keyword.toUpperCase();
        List<String> keywordList = goodService.keywordSearch(keyword);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("keyword", keywordList);

        String jsonInfo = jsonObject.toString();
        return jsonInfo;
    }
    @GetMapping("/goodSearch")
    public ModelAndView searchGoods(@RequestParam("searchWord") String searchWord,
                                    HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new ModelAndView("goods/goodsSearch");
        List<GoodDto> goodsList = goodService.searchGoods(searchWord);
        mv.addObject("goodsList",goodsList);
        return mv;
    }





    private void addGoodsInQuick(String goodId, GoodDto goodDto, HttpSession session){

    }





}
