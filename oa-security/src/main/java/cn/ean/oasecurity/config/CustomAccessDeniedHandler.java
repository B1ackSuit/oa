package cn.ean.oasecurity.config;

import cn.ean.oasecurity.model.bo.ResponseBO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @FileName CustomAccessDeniedHandler
 * @Author ean
 * @Date 2023/3/17 15:09
 **/
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    /**
     * Handles an access denied failure.
     *
     * @param request               that resulted in an <code>AccessDeniedException</code>
     * @param response              so that the user agent can be advised of the failure
     * @param accessDeniedException that caused the invocation
     * @throws IOException      in the event of an IOException
     * @throws ServletException in the event of a ServletException
     */
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException)
            throws IOException, ServletException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        ResponseBO bo = ResponseBO.error("权限不足，请联系管理员！");
        bo.setCode(403);
        out.write(new ObjectMapper().writeValueAsString(bo));
        out.flush();
        out.close();
    }
}
