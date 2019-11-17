package kr.co.timeattack.web.login;


import kr.co.timeattack.web.member.MemberRepository;
import kr.co.timeattack.web.member.model.MemberModel;
import kr.co.timeattack.web.member.model.RoleModel;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    private MemberRepository repository;
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MemberModel> accountModelOptional = repository.findByMemberEmail(username);
        if(accountModelOptional.isPresent()) {
            MemberModel m = accountModelOptional.get();
//            String[] roles =  m.getRoles().toArray(new String[m.getRoles().size()]);
            String[] roles =  m.getRoles().stream().map(RoleModel::getName).map(x -> x.name()).toArray(String[]::new);

            return User.builder().username(m.getMemberEmail()).password(passwordEncoder.encode(m.getMemberPassword())).roles(roles).build();
//            return User.builder()
//                    .username(m.getMemberEmail())
//                    .password(m.getMemberPassword())
//                    .roles(roles).build();
        } else {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
    }
}
