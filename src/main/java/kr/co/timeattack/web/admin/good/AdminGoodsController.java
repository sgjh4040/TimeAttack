package kr.co.timeattack.web.admin.good;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class AdminGoodsController {

    private AdminGoodsService adminGoodsService;

    @PostMapping
    public void addNewGoodsImage(){

    }




}
