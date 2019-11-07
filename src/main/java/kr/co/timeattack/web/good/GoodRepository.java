package kr.co.timeattack.web.good;


import kr.co.timeattack.web.good.model.GoodModel;

import java.util.List;

public interface GoodRepository {
    List<GoodModel> list();

    //ㅅㅏㅇㅍㅜㅁ ㅅㅏㅇㅌㅐㅇㅔ ㄸㅏㄹㅡㄴ ㄹㅣㅅㅡㅌㅡ
    List<GoodModel> selectGoodsList(String goodsStatus);

    GoodModel findById(Long id);
    void create(GoodModel m);
    void update(GoodModel m);
    void delete(GoodModel m);

}
