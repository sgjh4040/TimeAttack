package kr.co.timeattack.web.member;

import kr.co.timeattack.web.account.model.AccountModel;
import kr.co.timeattack.web.member.model.MemberModel;


import java.util.List;


public interface MemberRepository {
    List<MemberModel> list();
    MemberModel findbyId(Long id);

    void create(MemberModel m);
    void update(MemberModel m);
    void delete(Long id);
}
