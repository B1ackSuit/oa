package cn.ean.oaemp.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @FileName UserRolePO
 * @Author ean
 * @Date 2023/3/8 22:04
 **/
@Data
@Accessors(chain = true)
@TableName("oa_emp_user_role")
@ApiModel(value = "UserRolePO对象", description = "UserRolePO对象")
public class UserRolePO {

    @TableId(value = "pk_id", type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Integer pkId;

    @TableField("user_id")
    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @TableField("role_id")
    @ApiModelProperty(value = "角色id")
    private Integer roleId;
}
