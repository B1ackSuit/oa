package cn.ean.oaemp.model.po;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @FileName DepartmentPO
 * @Author ean
 * @Date 2023/3/8 21:48
 **/
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Accessors(chain = true)
@TableName("oa_emp_department")
@ApiModel(value = "DepartmentPO对象", description = "DepartmentPO对象")
public class DepartmentPO implements Serializable {

    public static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "pkId")
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    @ApiModelProperty(value = "部门名称")
    @TableField(value = "dep_name")
    // @Excel(name = "部门",width = 15)
    @NonNull
    private String depName;

    @ApiModelProperty(value = "父id")
    @TableField("parent_id")
    private Integer parentId;

    @ApiModelProperty(value = "路径")
    @TableField("dep_path")
    private String depPath;

    @ApiModelProperty(value = "是否启用")
    @TableField("is_enabled")
    private Boolean enabled;

    @ApiModelProperty(value = "是否上级")
    @TableField("is_parent")
    private Boolean isParent;

    @ApiModelProperty(value = "子部门列表")
    @TableField(exist = false)
    private List<Department> children;

    @ApiModelProperty(value = "返回结果，存储过程使用")
    @TableField(exist = false)
    private Integer result;
}
