package cn.ean.oasecurity.service;

import cn.ean.oasecurity.model.bo.ResponseBO;
import cn.ean.oasecurity.model.vo.UserLoginVO;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @FileName ILoginService
 * @Author ean
 * @Date 2023/3/22 15:50
 **/
public interface ILoginService {

    /**
     * 登录返回token
     * @param username
     * @param password
     * @param code
     * @param request
     * @return ResponseBO
     */
    ResponseBO login(UserLoginVO userLoginVO);

    ResponseBO signup(UserLoginVO userLoginVO);

}
