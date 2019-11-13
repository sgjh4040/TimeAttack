package kr.co.timeattack.web.good;

import kr.co.timeattack.web.good.dto.GoodDto;
import kr.co.timeattack.web.good.model.GoodModel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GoodService {

    private GoodRepository goodRepository;

    //메인화면 책 리스트
    public Map<String, List<GoodDto>> listGoods() {
        Map<String, List<GoodDto>> goodsMap = new HashMap<String, List<GoodDto>>();

        List<GoodModel> list = goodRepository.selectGoodsList("bestseller");
        goodsMap.put("bestseller", list.stream().map(x -> x.toDto()).collect(Collectors.toList()));

        list = goodRepository.selectGoodsList("newbook");
        goodsMap.put("bestseller", list.stream().map(x -> x.toDto()).collect(Collectors.toList()));

        list = goodRepository.selectGoodsList("newbook");
        goodsMap.put("bestseller", list.stream().map(x -> x.toDto()).collect(Collectors.toList()));

        return goodsMap;
    }

    public Map goodsDetail(int goodId) {
        Map goodsMap = new HashMap();
        GoodModel goodModel = goodRepository.selectGoodsDetail(goodId);
        goodsMap.put("good", goodModel);
        return goodsMap;
    }

    public List<GoodDto> list() {
        List<GoodModel> list = goodRepository.list();
        return list.stream().map(x -> x.toDto()).collect(Collectors.toList());

    }

    public List<String> keywordSearch(String keyword){
        List<String> list = goodRepository.selectKeywordSearch(keyword);
        return list;
    }

    public List<GoodDto> searchGoods(String searchWord){
        List goodList = goodRepository.selectGoodsBySearchWord(searchWord).stream().map(x -> x.toDto()).collect(Collectors.toList());

        return goodList;
    }
}
