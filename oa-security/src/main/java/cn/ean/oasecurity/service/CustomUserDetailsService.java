package cn.ean.oasecurity.service;

import cn.ean.oasecurity.model.po.UserPO;
import cn.ean.oasecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @FileName CustomUserDetailsService
 * @Author ean
 * @Date 2023/3/17 15:08
 **/
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPO userPO = userRepository.findByWorkId(username);
        return userPO;
    }

}
