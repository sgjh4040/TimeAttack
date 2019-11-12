package kr.co.timeattack.web.admin.good;

import kr.co.timeattack.web.good.dto.GoodDto;
import kr.co.timeattack.web.good.model.GoodModel;
import kr.co.timeattack.web.good.model.ImageFileModel;
import kr.co.timeattack.web.member.model.MemberModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class AdminGoodsRepositoryImpl implements AdminGoodsRepository {

    private List<GoodModel> goodList = new ArrayList<>();


    //새로운 상품 등록
    @Override
    public int insertNewGoods(Map newGoodsMap) {
        //새로운 상품 등록 후 상품 id 반
        return 0;
    }

    //상품 리스트
    @Override
    public List<GoodModel> selectNewGoodsList(Map cond) {

        return null;
    }

    //상품 상세 정보
    @Override
    public GoodModel selectGoodsDetail(int goodId) {
        return null;
    }


    //상품 이미지 리스트
    @Override
    public List selectGoodsImageFileList(int goodId) {
        return null;
    }


    @Override
    public void insertGoodsImageFile(List fileList) {

    }

    @Override
    public void updateGoodsInfo(Map goodsMap) {

    }

    @Override
    public void updateGoodsImage(List<ImageFileModel> imageFileList) {

    }

    @Override
    public void deleteGoodsImage(int imageId) {

    }

    @Override
    public void deleteGoodsImage(List fileList) {

    }

    @Override
    public void updateOrderGoods(Map orderMap) {

    }
}
