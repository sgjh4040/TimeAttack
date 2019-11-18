package kr.co.timeattack.web.good;


import kr.co.timeattack.web.good.dto.GoodDto;
import kr.co.timeattack.web.good.model.GoodModel;
import kr.co.timeattack.web.good.model.QGoodModel;
import kr.co.timeattack.web.member.model.MemberModel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public class GoodRepositoryImpl extends QuerydslRepositorySupport implements CustomGoodRepository {


    public GoodRepositoryImpl(){
        super(GoodModel.class);
    }

    @Override
    public List<GoodModel> findAllGoodByStatus(String status) {
        QGoodModel good = QGoodModel.goodModel;
        return from(good)
                .where(good.goodsStatus.eq(status))
                .fetch();
    }

}
