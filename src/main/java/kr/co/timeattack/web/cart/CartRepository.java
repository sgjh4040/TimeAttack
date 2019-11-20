package kr.co.timeattack.web.cart;

import kr.co.timeattack.web.cart.model.CartModel;
import kr.co.timeattack.web.good.model.GoodModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<CartModel, Long>, CustomCartRepository {

    List<CartModel> findAll();
    default void create(CartModel m ) {save(m);}
    Optional<CartModel> findById(Long id);



}
