package kr.co.timeattack.web.admin.good;

import kr.co.timeattack.web.good.dto.GoodDto;
import kr.co.timeattack.web.good.dto.ImageFileDto;
import kr.co.timeattack.web.good.model.GoodModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdminGoodsService {

    private AdminGoodsRepository adminGoodsRepository;

    public int addNewGoods(Map newGoodsMap){
        int goodId = adminGoodsRepository.insertNewGoods(newGoodsMap);
        ArrayList<ImageFileDto> imageFileList = (ArrayList)newGoodsMap.get("imageFileList");
        for (ImageFileDto imageFileDto: imageFileList){
            imageFileDto.setGoodsId(goodId);
        }
        adminGoodsRepository.insertGoodsImageFile(imageFileList);
        return goodId;
    }

    public List<GoodDto> listNewGoods(Map cond){
        List<GoodModel> list = adminGoodsRepository.selectNewGoodsList(cond);
        return list.stream().map(x-> x.toDto()).collect(Collectors.toList());
    }

    //상세 상품 정보
    public Map goodsDetail(int goodId){
        Map goodsMap = new HashMap();
        GoodDto goodDto = adminGoodsRepository.selectGoodsDetail(goodId).toDto();
        List imageFileList = adminGoodsRepository.selectGoodsImageFileList(goodId);
        goodsMap.put("goods",goodDto);
        goodsMap.put("imageFileList",imageFileList);
        return goodsMap;

    }
    //이미지 파일들
    public List goodsImageFile(int goodId){
        List imageList = adminGoodsRepository.selectGoodsImageFileList(goodId);
        return imageList;
    }

    public void modifyGoodsImage(List<ImageFileDto> imageFileList){
        adminGoodsRepository.updateGoodsImage(imageFileList.stream().map(x-> x.toModel()).collect(Collectors.toList()));
    }

    public void modifyOrderGoods(Map orderMap){
        adminGoodsRepository.updateOrderGoods(orderMap);
    }

    public void removeGoodsImage(int imageId){
        adminGoodsRepository.deleteGoodsImage(imageId);
    }

    public void addNewGoodsImage(List imageFileList){
        adminGoodsRepository.insertGoodsImageFile(imageFileList);
    }

}
