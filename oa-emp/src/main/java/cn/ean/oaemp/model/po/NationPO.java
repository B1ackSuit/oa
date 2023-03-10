package cn.ean.oaemp.model.po;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @FileName NationPO
 * @Author ean
 * @Date 2023/3/8 21:57
 **/
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false,of = "nationName")
@Accessors(chain = true)
@TableName("oa_emp_nation")
@ApiModel(value="NationPO对象", description="NationPO对象")
public class NationPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    @ApiModelProperty(value = "民族")
    @TableField(value = "nation_name")
    @Excel(name = "民族")
    @NonNull
    private String nationName;

}
