package kr.co.timeattack.web.good;

import kr.co.timeattack.web.good.model.GoodModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class GoodRepositoryImpl implements GoodRepository {

    private List<GoodModel> list = new ArrayList<>();

    @Override
    public List<GoodModel> list() {
        return list;
    }

    @Override
    public List<GoodModel> selectGoodsList(String goodsStatus) {
        return null;
    }

    @Override
    public GoodModel findById(Long id) {
        return null;
    }



    @Override
    public void create(GoodModel m) {
        this.list.add(m);
    }

    @Override
    public void update(GoodModel m) {

    }

    @Override
    public void delete(GoodModel m) {

    }

}
