package kr.co.timeattack.web.good.model;

import kr.co.timeattack.web.good.dto.GoodDto;
import lombok.*;

import java.util.Date;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GoodModel {
    private String goodsId;
    private String goodsTitle;
    private String goodsWriter;
    private int goodsPrice;
    private String goodsPublisher;
    private String goodsSort;
    private int goodsSalesPrice;
    private int goodsPoint;
    private Date goodsPublishedDate;
    private int goodsTotalPage;
    private String goodsIsbn;
    private String goodsDeliveryPrice;
    private String goodsDeliveryDate;
    private String goodsFilename;
    private String goodsStatus;
    private String goodsIntro;
    private String goodsContentsOrder;
    private Date goodsCredate;

    public GoodDto toDto() {
        return new GoodDto(
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
