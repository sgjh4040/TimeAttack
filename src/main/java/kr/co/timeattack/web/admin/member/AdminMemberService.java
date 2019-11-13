package kr.co.timeattack.web.admin.member;


import kr.co.timeattack.web.member.dto.MemberDto;
import kr.co.timeattack.web.member.model.MemberModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AdminMemberService {
    AdminMemberRepository adminMemberRepository;
    public List<MemberDto> listMember(HashMap cond){

        List<MemberModel> list = adminMemberRepository.listMember(cond);
        return list.stream().map(x -> x.toDto()).collect(Collectors.toList());

    }

    public MemberDto memberDetail(int memberId){
        return adminMemberRepository.memberDetail(memberId).toDto();
    }

    public void modifyMemberInfo(HashMap memberMap){
        String memberId = (String)memberMap.get("memberId");
        adminMemberRepository.modifyMemberInfo(memberMap);
    }


}
