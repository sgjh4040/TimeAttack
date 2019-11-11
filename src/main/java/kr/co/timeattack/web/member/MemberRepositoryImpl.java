package kr.co.timeattack.web.member;

import kr.co.timeattack.web.member.model.MemberModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
    private List<MemberModel> list = new ArrayList<>();

    @Override
    public List<MemberModel> list() {
        return list;
    }

    @Override
    public MemberModel findbyEmail(String email) {
        return new MemberModel();
    }

    @Override
    public void create(MemberModel m) {
        this.list.add(m);

    }

    @Override
    public void update(MemberModel m) {

    }

    @Override
    public void delete(Long id) {

    }
}
