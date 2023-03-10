package cn.ean.oaemp.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @FileName UserLoginVO
 * @Author ean
 * @Date 2023/3/11 00:01
 **/
@Data
@Accessors(chain = false)
@ApiModel(value = "UserLoginVO", description = "UserLoginVO对象")
public class UserLoginVO {

    @ApiModelProperty(value = "登录工号", required = true)
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @ApiModelProperty(value = "验证码", required = true)
    private String code;
}
