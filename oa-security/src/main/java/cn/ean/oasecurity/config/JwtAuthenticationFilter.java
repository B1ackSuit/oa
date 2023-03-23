package cn.ean.oasecurity.config;

import cn.ean.oasecurity.service.CustomUserDetailsService;
import cn.ean.oasecurity.util.security.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @FileName JwtAuthenticationFilter
 * @Author ean
 * @Date 2023/3/17 14:46
 **/
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    private JwtUtils jwtUtils;

    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    public JwtAuthenticationFilter(JwtUtils jwtUtils,
                                   CustomUserDetailsService customUserDetailsService) {
        this.jwtUtils = jwtUtils;
        this.customUserDetailsService = customUserDetailsService;
    }

    public JwtAuthenticationFilter() {
    }



    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    @NotNull FilterChain filterChain)
            throws ServletException, IOException {
        String authHeader = httpServletRequest.getHeader(tokenHeader);
        // 存在token
        if (null != authHeader && authHeader.startsWith(tokenHead)) {

            // 将JWT的tokenHead截取掉，就是token
            String authToken = authHeader.substring(tokenHead.length());
            String userName = jwtUtils.getUsernameFromToken(authToken);

            // token存在用户名，但是未登录
            if (null != userName && null == SecurityContextHolder.getContext().getAuthentication()) {
                // 自动登录(UserDetailsService已重写)
                UserDetails userDetails = customUserDetailsService.loadUserByUsername(userName);

                // 验证token是否有效，然后重新设置用户对象
                if (jwtUtils.validateToken(authToken, userDetails)) {
                    // 更新security登录的用户对象
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails,
                                    null,
                                    userDetails.getAuthorities());

                    authenticationToken
                            .setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
