package cn.ean.oasecurity.config;

import cn.ean.oasecurity.model.bo.ResponseBO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @FileName CustomAuthenticationEntryPoint
 * @Author ean
 * @Date 2023/3/17 15:10
 **/
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    /**
     * Commences an authentication scheme.
     * <p>
     * <code>ExceptionTranslationFilter</code> will populate the <code>HttpSession</code>
     * attribute named
     * <code>AbstractAuthenticationProcessingFilter.SPRING_SECURITY_SAVED_REQUEST_KEY</code>
     * with the requested target URL before calling this method.
     * <p>
     * Implementations should modify the headers on the <code>ServletResponse</code> as
     * necessary to commence the authentication process.
     *
     * @param request       that resulted in an <code>AuthenticationException</code>
     * @param response      so that the user agent can begin authentication
     * @param authException that caused the invocation
     */
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        PrintWriter out = response.getWriter();

        ResponseBO bo = ResponseBO.error("尚未登录/未有此账号，请重新登录或者输入账号信息");
        bo.setCode(401);

        out.write(new ObjectMapper().writeValueAsString(bo));
        out.flush();
        out.close();
    }
}
