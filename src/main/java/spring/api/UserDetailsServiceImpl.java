package spring.api;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        System.out.println(">>>> UserDetailsServiceImpl");
        List<GrantedAuthority> authorities = new ArrayList<>();
        if ("user".equals(username)) {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            // username,password,enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,authorities
            return new User(username, new BCryptPasswordEncoder().encode("123456"), true, true, true, true, authorities);
        } else if ("admin".equals(username)) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            authorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            return new User(username, new BCryptPasswordEncoder().encode("123456"), true, true, true, true, authorities);
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }
}
