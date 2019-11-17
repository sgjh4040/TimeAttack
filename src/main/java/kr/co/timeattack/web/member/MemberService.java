package kr.co.timeattack.web.member;


import kr.co.timeattack.web.member.dto.MemberDto;
import kr.co.timeattack.web.member.model.MemberModel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private MemberRepositoryDelegate memberRepository;

    public List<MemberDto> list(){
        List<MemberModel> list =memberRepository.findAll();
        return list.stream().map(x -> x.toDto()).collect(Collectors.toList());
    }
    @Transactional
    public void create(MemberDto dto){ memberRepository.create(dto);}

    @Transactional
    public void delete(Long id) {
        memberRepository.deleteById(id);
    }

}
