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
 * @FileName PoliticsStatusPO
 * @Author ean
 * @Date 2023/3/8 21:59
 **/

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false,of = "politicsStatusName")
@Accessors(chain = true)
@TableName("oa_emp_politics_status")
@ApiModel(value="PoliticsStatusPO对象", description="PoliticsStatusPO对象")
public class PoliticsStatusPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "pkId")
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    @ApiModelProperty(value = "政治面貌")
    @TableField(value = "politics_status_name")
    // @Excel(name = "政治面貌")
    @NonNull
    private String politicsStatusName;


}

