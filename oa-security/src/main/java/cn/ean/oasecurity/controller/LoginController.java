package cn.ean.oasecurity.controller;

import cn.ean.oasecurity.model.bo.ResponseBO;
import cn.ean.oasecurity.model.vo.UserLoginVO;
import cn.ean.oasecurity.service.ILoginService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @FileName LoginController
 * @Author ean
 * @Date 2023/3/22 15:45
 **/
@RestController
public class LoginController {

    private final ILoginService loginService;

    @Autowired
    public LoginController(ILoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseBO login(@RequestBody UserLoginVO userLoginVO, HttpServletRequest request) {
        return loginService.login(userLoginVO, request);
    }
}
