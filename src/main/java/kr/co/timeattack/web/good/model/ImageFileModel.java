package kr.co.timeattack.web.good.model;


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
    private int ImageId;
    private String fileName;
    private String fileType;
    private String regId;
}
