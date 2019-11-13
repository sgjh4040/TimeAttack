package kr.co.timeattack.web.admin.member;

import kr.co.timeattack.web.member.model.MemberModel;

import java.util.ArrayList;
import java.util.HashMap;

public interface AdminMemberRepository {
    public ArrayList<MemberModel> listMember(HashMap cond);
    public MemberModel memberDetail(int memberId);
    public void modifyMemberInfo(HashMap memberMap);
}
