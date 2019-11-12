package kr.co.timeattack.web.good.model;


import kr.co.timeattack.web.good.dto.ImageFileDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageFileModel {
    private int goodsId;
    private int imageId;
    private String fileName;
    private String fileType;
    private String regId;

    public ImageFileDto toDto(){return new ImageFileDto(goodsId,imageId,fileName,fileType,regId);}
}
