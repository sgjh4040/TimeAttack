package kr.co.timeattack.web.member;

import kr.co.timeattack.web.member.model.MemberModel;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;


public interface MemberRepository extends PagingAndSortingRepository<MemberModel, Long> {
    List<MemberModel>  findAll();
    Optional<MemberModel> findByMemberEmail(String email);

}
