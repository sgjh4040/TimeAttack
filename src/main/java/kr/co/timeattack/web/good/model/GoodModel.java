package kr.co.timeattack.web.good.model;

import kr.co.timeattack.web.cart.model.CartGoodsModel;
import kr.co.timeattack.web.cart.model.CartModel;
import kr.co.timeattack.web.good.dto.GoodDto;
import kr.co.timeattack.web.order.model.OrderModel;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "goods")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class GoodModel {

    public GoodModel(Long id){
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "goods_title")
    @NonNull private String goodsTitle;

    @Column(name = "goods_writer")
    @NonNull private String goodsWriter;

    @Column(name = "goods_price")
    @NonNull private int goodsPrice;

    @Column(name = "goods_publisher")
    private String goodsPublisher;

    @Column(name = "goods_sort")
    private String goodsSort;

    @Column(name = "goods_sales_price")
    private int goodsSalesPrice;

    @Column(name="goods_point")
    private int goodsPoint;

    @Column(name = "goods_published_date")
    private String goodsPublishedDate;

    @Column(name = "goods_total_page")
    private int goodsTotalPage;

    @Column(name = "goods_isbn")
    private String goodsIsbn;

    @Column(name = "goods_delivery_price")
    private int goodsDeliveryPrice;

    @Column(name = "goods_delivery_date")
    private String goodsDeliveryDate;

    @Column(name = "goods_filename")
    private String goodsFilename;

    @Column(name= "goods_status")
    private String goodsStatus;

    @Column(name = "goods_intro")
    private String goodsIntro;

    @Column(name = "goods_contents_order")
    private String goodsContentsOrder;

    @Column(name = "goods_credate")
    private String goodsCredate;



    public GoodDto toDto() {
        return new GoodDto(
        id,
        goodsTitle,
        goodsWriter,
        goodsPrice,
        goodsPublisher,
        goodsSort,
        goodsSalesPrice,
        goodsPoint,
        goodsPublishedDate,
        goodsTotalPage,
        goodsIsbn,
        goodsDeliveryPrice,
        goodsDeliveryDate,
        goodsFilename,
        goodsStatus,
        goodsIntro,
        goodsContentsOrder,
        goodsCredate
        );
    }

}
