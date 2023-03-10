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
 * @FileName JobLevelPO
 * @Author ean
 * @Date 2023/3/8 21:54
 **/

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false,of = "levelName")
@Accessors(chain = true)
@TableName("oa_emp_job_level")
@ApiModel(value="JobLevelPO对象", description="JobLevelPO对象")
public class JobLevelPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "pkId")
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    @ApiModelProperty(value = "职称名称")
    @TableField(value = "level_name")
    // @Excel(name = "职称名称")
    @NonNull
    private String levelName;

    @ApiModelProperty(value = "职称等级")
    @TableField(value = "title_level")
    private String titleLevel;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "是否启用")
    @TableField(value = "is_enabled")
    private Boolean enabled;

}
