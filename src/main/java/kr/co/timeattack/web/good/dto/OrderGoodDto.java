package kr.co.timeattack.web.good.dto;


import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderGoodDto {
    private Long goodId;
    private int orderGoodsqty;
    private String goodTitle;
    private int goodSalesPrice;
    private String goodsFilename;
    private int goodsPoint;
}
