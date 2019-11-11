package kr.co.timeattack.web.member;


import kr.co.timeattack.web.member.dto.MemberDto;
import kr.co.timeattack.web.member.model.MemberModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {
    @Autowired MemberRepository memberRepository;

    public List<MemberDto> list(){
        List<MemberModel> list =memberRepository.list();
        return list.stream().map(x -> x.toDto()).collect(Collectors.toList());
    }
    public void create(MemberDto dto){ memberRepository.create(dto.toModel());}




}
