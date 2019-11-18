package kr.co.timeattack.web.good;

import kr.co.timeattack.web.good.model.GoodModel;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface CustomGoodRepository {

    List<GoodModel> findAllGoodByStatus(String status);
}
