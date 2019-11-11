package kr.co.timeattack.web.good.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageFileDto {
    private int goodsId;
    private int ImageId;
    private String fileName;
    private String fileType;
    private String regId;
}
