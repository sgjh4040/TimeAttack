package kr.co.timeattack.web.login;


import kr.co.timeattack.web.member.MemberRepository;
import kr.co.timeattack.web.member.model.MemberModel;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private PasswordEncoder passwordEncoder;
    private MemberRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MemberModel> accountModelOptional = repository.list().stream().filter(x -> x.getMemberEmail().equals(username)).findFirst();
        if(accountModelOptional.isPresent()) {
            MemberModel m = accountModelOptional.get();
            String[] roles =  m.getRoles().toArray(new String[m.getRoles().size()]);
            return User.builder()
                    .username(m.getMemberEmail())
                    .password(passwordEncoder.encode(m.getMemberPassword()))
                    .roles(roles).build();
        } else {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
    }
}
