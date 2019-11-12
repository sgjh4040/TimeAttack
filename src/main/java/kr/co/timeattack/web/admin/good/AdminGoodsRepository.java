package kr.co.timeattack.web.admin.good;

import kr.co.timeattack.web.good.dto.GoodDto;
import kr.co.timeattack.web.good.model.GoodModel;
import kr.co.timeattack.web.good.model.ImageFileModel;

import java.util.List;
import java.util.Map;


public interface AdminGoodsRepository {
    public int insertNewGoods(Map newGoodsMap);
    public List<GoodModel> selectNewGoodsList(Map cond);
    public GoodModel selectGoodsDetail(int goodId);
    public List selectGoodsImageFileList(int goodId);
    public void insertGoodsImageFile(List fileList);
    public void updateGoodsInfo(Map goodsMap);
    public void updateGoodsImage(List<ImageFileModel> imageFileList);
    public void deleteGoodsImage(int imageId);
    public void deleteGoodsImage(List fileList);
    public void updateOrderGoods(Map orderMap);

}
