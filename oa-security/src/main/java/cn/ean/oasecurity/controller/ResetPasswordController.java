package cn.ean.oasecurity.controller;

import cn.ean.oasecurity.model.bo.ResponseBO;
import cn.ean.oasecurity.model.vo.ResetPasswordVO;
import cn.ean.oasecurity.service.IResetPasswordService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @FileName ResetPasswordController
 * @Author ean
 * @Date 2023/3/22 23:17
 **/
@RestController
public class ResetPasswordController {

    private final IResetPasswordService resetPasswordService;

    public ResetPasswordController(IResetPasswordService resetPasswordService) {
        this.resetPasswordService = resetPasswordService;
    }

    @PostMapping("/reset-password")
    public ResponseBO reset(@RequestBody ResetPasswordVO resetPasswordVO) {
        try {
            return resetPasswordService.resetPassword(resetPasswordVO.getWorkId(), resetPasswordVO.getNewPassword());
        } catch (Exception e) {
            return ResponseBO.error("修改密码时出错");
        }
    }
}
