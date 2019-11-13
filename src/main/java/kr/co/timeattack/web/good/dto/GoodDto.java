package kr.co.timeattack.web.good.dto;

import kr.co.timeattack.web.good.model.GoodModel;
import lombok.*;

import java.util.Date;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GoodDto {
    private int goodsId;
    private String goodsTitle;
    private String goodsWriter;
    private int goodsPrice;
    private String goodsPublisher;
    private String goodsSort;
    private int goodsSalesPrice;
    private int goodsPoint;
    private String goodsPublishedDate;
    private int goodsTotalPage;
    private String goodsIsbn;
    private int goodsDeliveryPrice;
    private String goodsDeliveryDate;
    private String goodsFilename;
    private String goodsStatus;
    private String goodsIntro;
    private String goodsContentsOrder;
    private String goodsCredate;


    public GoodModel toModel() {
        return new GoodModel(
                goodsId,
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
