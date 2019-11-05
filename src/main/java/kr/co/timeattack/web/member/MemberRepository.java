package kr.co.timeattack.web.member;

import kr.co.timeattack.web.account.model.AccountModel;
import kr.co.timeattack.web.member.model.MemberModel;

public interface MemberRepository {
    MemberModel findbyId(Long id);

    void create(MemberModel m);
    void update(MemberModel m);
    void delete(Long id);
}
