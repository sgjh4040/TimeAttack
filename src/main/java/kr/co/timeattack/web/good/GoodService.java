package kr.co.timeattack.web.good;

import kr.co.timeattack.web.good.dto.GoodDto;
import kr.co.timeattack.web.good.model.GoodModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GoodService {

    @Autowired GoodRepository goodRepository;

    public List<GoodDto> list(){
        List<GoodModel> list = goodRepository.list();
        return list.stream().map(x -> x.toDto()).collect(Collectors.toList());

    }

    //메인화면 책 리스트
    public Map<String, List<GoodDto>> listGoods(){
        Map<String, List<GoodDto>> goodsMap = new HashMap<String, List<GoodDto>>();
        List<GoodModel> goodsList = goodRepository.selectGoodsList("bestseller");
        goodsMap.put("bestseller",goodsList.stream().map(x -> x.toDto()).collect(Collectors.toList()));

        goodsList = goodRepository.selectGoodsList("newbook");
        goodsMap.put("bestseller",goodsList.stream().map(x -> x.toDto()).collect(Collectors.toList()));

        goodsList = goodRepository.selectGoodsList("steadyseller");
        goodsMap.put("bestseller",goodsList.stream().map(x -> x.toDto()).collect(Collectors.toList()));

        return  goodsMap;

    }

    public void create(GoodDto dto){goodRepository.create(dto.toModel());}
}
