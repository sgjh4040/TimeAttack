package kr.co.timeattack.web.good;

import kr.co.timeattack.web.good.dto.GoodDto;
import kr.co.timeattack.web.good.model.GoodModel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class GoodService {

    private GoodRepository goodRepository;

    //메인화면 책 리스트
    public Map<String, List<GoodDto>> listGoods() {
        Map<String, List<GoodDto>> goodsMap = new HashMap<String, List<GoodDto>>();

        List<GoodModel> list = goodRepository.findAllGoodByStatus("bestseller");
        goodsMap.put("bestseller", list.stream().map(x -> x.toDto()).collect(Collectors.toList()));

        list = goodRepository.findAllGoodByStatus("newbook");
        goodsMap.put("newbook", list.stream().map(x -> x.toDto()).collect(Collectors.toList()));

        list = goodRepository.findAllGoodByStatus("steadyseller");
        goodsMap.put("newbook", list.stream().map(x -> x.toDto()).collect(Collectors.toList()));

        return goodsMap;
    }

    public GoodDto goodsDetail(Long goodId) {
        Optional<GoodModel> goodModel = goodRepository.findById(goodId);

        return goodModel.get().toDto();
    }
//
//    public List<GoodDto> list() {
//        List<GoodModel> list = goodRepository.list();
//        return list.stream().map(x -> x.toDto()).collect(Collectors.toList());
//
//    }
//
//    public List<String> keywordSearch(String keyword){
//        List<String> list = goodRepository.selectKeywordSearch(keyword);
//        return list;
//    }
//
//    public List<GoodDto> searchGoods(String searchWord){
//        List goodList = goodRepository.selectGoodsBySearchWord(searchWord).stream().map(x -> x.toDto()).collect(Collectors.toList());
//
//        return goodList;
//    }
}
