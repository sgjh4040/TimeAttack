package kr.co.timeattack.web.good;


import kr.co.timeattack.web.good.dto.GoodDto;
import kr.co.timeattack.web.good.model.GoodModel;
import kr.co.timeattack.web.good.model.ImageFileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface GoodRepository extends JpaRepository<GoodModel, Long>,CustomGoodRepository {
    List<GoodModel> findAll();
    Optional<GoodModel> findById(String id);



//    //상품 상태에 따른 리스트
//    List<GoodModel> selectGoodsList(String goodsStatus);
//    //키워드 검색
//    List<String> selectKeywordSearch(String keyword);
//    //ID 로 검색
//    GoodModel selectGoodsDetail(int id);
//
//    //책 이미지 검색
//    List<ImageFileModel> selectGoodsDetailImage(int id);
//    List<GoodModel> selectGoodsBySearchWord(String searchWord);
//
//    //test
//    void test(GoodModel model);

}
