package kr.co.timeattack.web.cart;

import com.querydsl.jpa.impl.JPAQuery;
import com.sun.tools.jconsole.JConsoleContext;
import kr.co.timeattack.web.cart.dto.CartDto;
import kr.co.timeattack.web.cart.model.CartModel;
import kr.co.timeattack.web.cart.model.QCartGoodsModel;
import kr.co.timeattack.web.cart.model.QCartModel;
import kr.co.timeattack.web.good.model.GoodModel;
import kr.co.timeattack.web.good.model.QGoodModel;
import kr.co.timeattack.web.member.model.QMemberModel;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import sun.tools.jconsole.JConsole;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@Repository
public class CartRepositoryDelegate extends QuerydslRepositorySupport {
    private final CartRepository repository;

    public CartRepositoryDelegate(CartRepository repository){
        super(CartModel.class);
        this.repository=repository;
    }

    public List<CartModel> findAllByUser(Long userId) {

        QCartModel cart = QCartModel.cartModel;
        QMemberModel member = QMemberModel.memberModel;
        QGoodModel good = QGoodModel.goodModel;
        QCartGoodsModel cartGood = QCartGoodsModel.cartGoodsModel;

        return from(cart)
                .join(cart.member,member)
                .where(cart.member.id.eq(userId))
                .fetchJoin()
                .join(cart.cartGood,cartGood)
                .fetchJoin()
                .join(cartGood.goods,good)
                .fetchJoin()
                .fetch();

    }
    public Long save(CartModel m){
        if(m.getId() == null){
            CartModel returnedModel = repository.save(m);
            return returnedModel.getId();

        }else{
            Optional<CartModel> cartModel = repository.findById(m.getId());
            cartModel.orElseThrow(() -> new RuntimeException("카트정보를 찾을수 없습니다."));
            return cartModel.get().getId();
        }

    }
    public Optional<CartModel> findbyId(Long id){
        return repository.findById(id);
    }



}
