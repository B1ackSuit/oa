package cn.ean.oasecurity.service.impl;

import cn.ean.oasecurity.model.bo.ResponseBO;
import cn.ean.oasecurity.model.po.UserPO;
import cn.ean.oasecurity.repository.UserRepository;
import cn.ean.oasecurity.service.IResetPasswordService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @FileName ResetPasswordService
 * @Author ean
 * @Date 2023/3/23 00:18
 **/
@Service
public class ResetPasswordServiceImpl implements IResetPasswordService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public ResetPasswordServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseBO resetPassword(String workId, String newPassword) {
        // 查询用户信息
        UserPO user = userRepository.findByWorkId(workId);
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }

        String hashedPassword = passwordEncoder.encode(newPassword);

        // 更新用户密码和盐
        user.setPassword(hashedPassword);
        userRepository.save(user);

        return ResponseBO.success("密码重置成功");
    }

}
