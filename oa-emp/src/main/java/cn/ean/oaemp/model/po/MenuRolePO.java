package cn.ean.oaemp.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @FileName MenuRolePO
 * @Author ean
 * @Date 2023/3/8 21:56
 **/
@Data
@Accessors(chain = true)
@TableName("oa_emp_menu_role")
@ApiModel(value="MenuRolePO对象", description="MenuRolePO对象")
public class MenuRolePO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "pkId")
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    @ApiModelProperty(value = "菜单id")
    @TableField(value = "menu_id")
    private Integer menuId;

    @ApiModelProperty(value = "权限id")
    @TableField(value = "role_id")
    private Integer roleId;

}
