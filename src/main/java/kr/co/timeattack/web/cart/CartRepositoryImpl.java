package kr.co.timeattack.web.cart;

import com.querydsl.jpa.impl.JPAQuery;
import kr.co.timeattack.web.cart.model.CartModel;
import kr.co.timeattack.web.cart.model.QCartModel;
import kr.co.timeattack.web.good.model.GoodModel;
import kr.co.timeattack.web.good.model.QGoodModel;
import kr.co.timeattack.web.member.model.QMemberModel;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;



public class CartRepositoryImpl extends QuerydslRepositorySupport implements CustomCartRepository {

    public CartRepositoryImpl(){super(CartModel.class);}


    @Override
    public List<CartModel> findAllByUser(Long userId) {

        QCartModel cart = QCartModel.cartModel;
        QMemberModel member = QMemberModel.memberModel;
        QGoodModel good = QGoodModel.goodModel;

        return from(cart)
                .innerJoin(cart.member,member)
                .innerJoin(cart.goods,good)
                .where(cart.member.id.eq(userId))
                .fetchJoin()
                .fetch();

    }
}
