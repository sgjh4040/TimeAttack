package kr.co.timeattack.web.good;

import kr.co.timeattack.web.good.dto.GoodDto;
import kr.co.timeattack.web.good.model.GoodModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class GoodService {

    @Autowired GoodRepository goodRepository;

    public List<GoodDto> list(){
        List<GoodModel> list = goodRepository.list();
        return list.stream().map(x -> x.toDto()).collect(Collectors.toList());

    }
    public void create(GoodDto dto){goodRepository.create(dto.toModel());}
}
