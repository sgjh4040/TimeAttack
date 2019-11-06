package kr.co.timeattack.web.good.dto;

import kr.co.timeattack.web.good.model.GoodModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GoodDto {
    private Long id;
    private String sort;
    private String title;
    private String writer;
    private String publisher;
    private Long price;
    private Long salesPrice;
    private Long point;
    private Date publishedDate;
    private Long totalPage;
    private String isbn;
    private Long deliveryPrice;
    private String status;
    private String intro;
    private String publisherComment;
    private String contentsOrder;


    public GoodModel toModel() {
        return new GoodModel(
                id,
                sort,
                title,
                writer,
                publisher,
                price,
                salesPrice,
                point,
                publishedDate,
                totalPage,
                isbn,
                deliveryPrice,
                status,
                intro,
                publisherComment,
                contentsOrder
        );
    }
}
