package cn.ean.oasecurity.service.impl;

import cn.ean.oasecurity.model.bo.ResponseBO;
import cn.ean.oasecurity.model.vo.UserLoginVO;
import cn.ean.oasecurity.service.ILoginService;
import cn.ean.oasecurity.util.charopn.StringUtils;
import cn.ean.oasecurity.util.security.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @FileName LoginServiceImpl
 * @Author ean
 * @Date 2023/3/22 15:53
 **/
@Service
public class LoginServiceImpl implements ILoginService {

    private final UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtils jwtUtils;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    public LoginServiceImpl(UserDetailsService userDetailsService,
                            PasswordEncoder passwordEncoder,
                            JwtUtils jwtUtils) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    /**
     * 登录返回token
     *
     * @param userLoginVO
     * @param request
     * @return ResponseBO
     */
    @Override
    public ResponseBO login(UserLoginVO userLoginVO, HttpServletRequest request) {
        String captcha = (String) request.getSession().getAttribute("captcha");
        String code = userLoginVO.getCode();
        if (StringUtils.isBlank(code) || !captcha.equals(code)) {
            return ResponseBO.error("验证码填写错误");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(userLoginVO.getUsername());

        if (null == userDetails || !passwordEncoder.matches(userLoginVO.getPassword(), userDetails.getPassword())) {
            return ResponseBO.error("用户名或密码不正确");
        }
        if (!userDetails.isEnabled()) {
            return ResponseBO.error("账号被禁用，请联系管理员");
        }
        UsernamePasswordAuthenticationToken auth =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
        String token = jwtUtils.generateToken(userDetails.getUsername());
        Map<String, String> tokenMap = new HashMap<>(16);
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return ResponseBO.success("登录成功", tokenMap);
    }

    @Override
    public ResponseBO signup(UserLoginVO userLoginVO) {
        return null;
    }
}
