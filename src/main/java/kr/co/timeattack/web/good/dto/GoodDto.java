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
    private long id;
    private String sort;
    private String title;
    private String writer;
    private String publisher;
    private long price;
    private long salesPrice;
    private long point;
    private Date publishedDate;
    private long totalPage;
    private String isbn;
    private long deliveryPrice;
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
