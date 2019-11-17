package kr.co.timeattack.web.good;

import kr.co.timeattack.web.good.model.GoodModel;
import kr.co.timeattack.web.good.model.ImageFileModel;
import kr.co.timeattack.web.member.model.MemberModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class GoodRepositoryImpl implements GoodRepository {

    private List<GoodModel> list;


    @Override
    public List<GoodModel> list() {
        return list;
    }

    @Override
    public List<GoodModel> selectGoodsList(String goodsStatus) {
        return null;
    }

    @Override
    public List<String> selectKeywordSearch(String keyword) {
        return null;
    }


    @Override
    public GoodModel selectGoodsDetail(int id) {
        return null;
//        Optional<GoodModel> goodModelOptional = list.stream().filter(x -> x.getGoodsId()==id).findFirst();
//        if(goodModelOptional.isPresent()){
//            System.out.println("모델 존재");
//            GoodModel model = goodModelOptional.get();
//            System.out.println(model.toString());
//            return model;
//        }else{
//            System.out.println("모델 존재하지 않음");
//            return null;
//        }
    }

    @Override
    public List<ImageFileModel> selectGoodsDetailImage(int id) {
        return null;
    }

    @Override
    public List<GoodModel> selectGoodsBySearchWord(String searchWord) {
        return null;
    }

    @Override
    public void test(GoodModel model) {
            list.add(model);
    }
}
