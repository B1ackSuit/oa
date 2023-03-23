package cn.ean.oasecurity.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @FileName UserLoginVO
 * @Author ean
 * @Date 2023/3/22 15:50
 **/
@Data
@Accessors(chain = false)
public class UserLoginVO {


    private String username;


    private String password;


    private String code;
}

