package kr.co.timeattack.web.good;

import kr.co.timeattack.web.good.model.GoodModel;
import kr.co.timeattack.web.good.model.ImageFileModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class GoodRepositoryImpl implements GoodRepository {


    @Override
    public List<GoodModel> list() {
        return null;
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
    }

    @Override
    public List<ImageFileModel> selectGoodsDetailImage(int id) {
        return null;
    }

    @Override
    public List<GoodModel> selectGoodsBySearchWord(String searchWord) {
        return null;
    }
}
