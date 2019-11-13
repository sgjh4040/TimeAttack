package kr.co.timeattack.web.admin.good;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class AdminGoodsController {

    private AdminGoodsService adminGoodsService;

    @PostMapping
    public void addNewGoods(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception{

        multipartRequest.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        String imageFileName= null;

        Map newGoodsMap = new HashMap();
        Enumeration enu = multipartRequest.getParameterNames();
        while(enu.hasMoreElements()){
            String name = (String)enu.nextElement();
            String value = multipartRequest.getParameter(name);
            newGoodsMap.put(name,value);

            
        }




    }




}
