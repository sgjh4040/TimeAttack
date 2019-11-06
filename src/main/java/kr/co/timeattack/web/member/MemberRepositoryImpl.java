package kr.co.timeattack.web.member;

import kr.co.timeattack.web.member.model.MemberModel;

import java.util.ArrayList;
import java.util.List;

public class MemberRepositoryImpl implements MemberRepository {
    private List<MemberModel> list = new ArrayList<>();

    @Override
    public List<MemberModel> list() {
        return list;
    }

    @Override
    public MemberModel findbyId(Long id) {
        return null;
    }

    @Override
    public void create(MemberModel m) {

    }

    @Override
    public void update(MemberModel m) {

    }

    @Override
    public void delete(Long id) {

    }
}
