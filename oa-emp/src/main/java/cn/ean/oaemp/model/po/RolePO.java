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
 * @FileName RolePO
 * @Author ean
 * @Date 2023/3/8 22:02
 **/
@Data
@Accessors(chain = true)
@TableName("oa_emp_role")
@ApiModel(value="RolePO对象", description="RolePO对象")
public class RolePO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    @ApiModelProperty(value = "角色")
    @TableField("authority")
    private String authority;

    @ApiModelProperty(value = "角色名称")
    @TableField("auth_desc")
    private String authDescription;

}
