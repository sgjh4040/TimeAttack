package kr.co.timeattack.web.member;

import kr.co.timeattack.web.member.dto.MemberDto;
import kr.co.timeattack.web.member.model.MemberModel;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class MemberRepositoryDelegate extends QuerydslRepositorySupport {

    private final MemberRepository repository;
    Logger logger  = LoggerFactory.getLogger(MemberRepositoryDelegate.class);

    public MemberRepositoryDelegate(MemberRepository repository){
        super(MemberModel.class);
        this.repository = repository;
    }
    public List<MemberModel> findAll(){
        return repository.findAll();
    }

    public void create(MemberDto dto) {
        if(dto.getId() == null) {
            repository.save(dto.toModel());
        } else {
            Optional<MemberModel> memberModel = repository.findById(dto.getId());
            memberModel.orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없어 업데이트할 수 없습니다."));
            MemberModel m = memberModel.get();
            m.update(dto);
        }
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public MemberModel findByEmail(String email){
        return repository.findByMemberEmail(email).orElseThrow(() -> new RuntimeException("사용자가 없습니다."));
    }

}
