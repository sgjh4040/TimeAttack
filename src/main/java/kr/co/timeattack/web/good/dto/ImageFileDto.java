package kr.co.timeattack.web.good.dto;


import kr.co.timeattack.web.good.model.ImageFileModel;
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
    private int imageId;
    private String fileName;
    private String fileType;
    private String regId;

    public ImageFileModel toModel(){return new ImageFileModel(goodsId,imageId,fileName,fileType,regId);}
}
