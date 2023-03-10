package cn.ean.oaemp.model.po;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @FileName PositionPO
 * @Author ean
 * @Date 2023/3/8 22:00
 **/
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false,of = "positionName")
@Accessors(chain = true)
@TableName("oa_emp_position")
@ApiModel(value="PositionPO对象", description="PositionPO对象")
public class PositionPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "pkId")
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    @ApiModelProperty(value = "职位")
    @TableField(value = "position_name")
    // @Excel(name = "职位",width = 15)
    @NonNull
    private String positionName;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "是否启用")
    @TableField(value = "is_enabled")
    private Boolean enabled;


}