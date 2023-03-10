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
import java.util.List;

/**
 * @FileName MenuPO
 * @Author ean
 * @Date 2023/3/8 21:55
 **/
@Data
@Accessors(chain = true)
@TableName("oa_emp_menu")
@ApiModel(value="MenuPO对象", description="MenuPO对象")
public class MenuPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    @ApiModelProperty(value = "url")
    private String url;

    @ApiModelProperty(value = "path")
    private String path;

    @ApiModelProperty(value = "组件")
    private String component;

    @ApiModelProperty(value = "菜单名")
    private String name;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "是否保持激活")
    @TableField(value = "is_keep_alive")
    private Boolean keepAlive;

    @ApiModelProperty(value = "是否要求权限")
    @TableField(value = "is_require_auth")
    private Boolean requireAuth;

    @ApiModelProperty(value = "父id")
    private Integer parentId;

    @ApiModelProperty(value = "是否启用")
    @TableField(value = "is_enabled")
    private Boolean enabled;

    @ApiModelProperty(value = "子菜单")
    @TableField(exist = false)
    private List<MenuPO> children;

    @ApiModelProperty(value = "角色列表")
    @TableField(exist = false)
    private List<RolePO> roles;
}
