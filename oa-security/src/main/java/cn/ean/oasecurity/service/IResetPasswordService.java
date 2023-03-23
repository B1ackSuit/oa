package cn.ean.oasecurity.service;

import cn.ean.oasecurity.model.bo.ResponseBO;

/**
 * @FileName IResetPasswordService
 * @Author ean
 * @Date 2023/3/23 00:15
 **/
public interface IResetPasswordService {

    /**
     * 重置密码
     * @param username 用户名
     * @param newPassword 新密码
     * @return
     */
    ResponseBO resetPassword(String username, String newPassword);

}
