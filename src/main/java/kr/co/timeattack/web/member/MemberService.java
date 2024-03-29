package kr.co.timeattack.web.member;


import kr.co.timeattack.web.member.dto.AdminMemberDto;
import kr.co.timeattack.web.member.dto.MemberDto;
import kr.co.timeattack.web.member.model.MemberModel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private MemberRepositoryDelegate memberRepository;


    public MemberModel findByEmail(String email){
        return memberRepository.findByEmail(email);

    }

    @Transactional
    public void create(MemberDto dto){ memberRepository.create(dto);}

    @Transactional
    public void delete(Long id) {
        memberRepository.deleteById(id);
    }

}
