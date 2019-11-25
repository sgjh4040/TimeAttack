package kr.co.timeattack.web.good.dto;


import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class orderDto {
    private Long goodId;
    private int goodsQty;
}
