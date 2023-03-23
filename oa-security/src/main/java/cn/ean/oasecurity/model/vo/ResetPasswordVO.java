package cn.ean.oasecurity.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @FileName ResetPasswordVO
 * @Author ean
 * @Date 2023/3/23 00:16
 **/
@Data
@Accessors(chain = true)
public class ResetPasswordVO {

    private String workId;
    private String newPassword;

}
