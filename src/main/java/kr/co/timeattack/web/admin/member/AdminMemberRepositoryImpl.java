package kr.co.timeattack.web.admin.member;

import kr.co.timeattack.web.member.model.MemberModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;


@Repository
public class AdminMemberRepositoryImpl implements AdminMemberRepository {
    @Override
    public ArrayList<MemberModel> listMember(HashMap cond) {
        return null;
    }

    @Override
    public MemberModel memberDetail(int memberId) {
        return null;
    }

    @Override
    public void modifyMemberInfo(HashMap memberMap) {

    }
}
