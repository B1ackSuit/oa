package cn.ean.oaemp.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @FileName SalaryPO
 * @Author ean
 * @Date 2023/3/8 22:02
 **/
@Data
@Accessors(chain = true)
@TableName("oa_emp_salary")
@ApiModel(value="SalaryPO对象", description="SalaryPO对象")
public class SalaryPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "pkId")
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    @ApiModelProperty(value = "基本工资")
    @TableField(value = "basic_salary")
    private Integer basicSalary;

    @ApiModelProperty(value = "奖金")
    private Integer bonus;

    @ApiModelProperty(value = "午餐补助")
    @TableField(value = "lunch_salary")
    private Integer lunchSalary;

    @ApiModelProperty(value = "交通补助")
    @TableField(value = "traffic_salary")
    private Integer trafficSalary;

    @ApiModelProperty(value = "应发工资")
    @TableField(value = "all_salary")
    private Integer allSalary;

    @ApiModelProperty(value = "养老金基数")
    @TableField(value = "pension_base")
    private Integer pensionBase;

    @ApiModelProperty(value = "养老金比率")
    @TableField(value = "pension_per")
    private Float pensionPer;

    @ApiModelProperty(value = "启用时间")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @TableField(value = "create_date")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "医疗基数")
    @TableField(value = "medical_base")
    private Integer medicalBase;

    @ApiModelProperty(value = "医疗保险比率")
    @TableField(value = "medical_per")
    private Float medicalPer;

    @ApiModelProperty(value = "公积金基数")
    @TableField(value = "accumulation_fund_base")
    private Integer accumulationFundBase;

    @ApiModelProperty(value = "公积金比率")
    @TableField(value = "accumulation_fund_per")
    private Float accumulationFundPer;

    @ApiModelProperty(value = "名称")
    @TableField(value = "salary_name")
    private String salaryName;


}
