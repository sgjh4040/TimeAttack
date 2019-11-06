package kr.co.timeattack.web.good;

import kr.co.timeattack.web.good.model.GoodModel;

import java.util.ArrayList;
import java.util.List;

public class GoodRepositoryImpl implements GoodRepository {

    private List<GoodModel> list = new ArrayList<>();

    @Override
    public List<GoodModel> list() {
        return list;
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
