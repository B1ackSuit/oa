package cn.ean.oaemp.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @FileName EmployeePO
 * @Author ean
 * @Date 2023/3/8 21:49
 **/
@Data
@Accessors(chain = true)
@TableName("oa_emp_employee")
@ApiModel(value = "EmployeePO对象", description = "EmployeePO对象")
public class EmployeePO  implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "员工编号")
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    @ApiModelProperty(value = "员工姓名")
    @TableField(value = "emp_name")
    // @Excel(name = "员工姓名")
    private String empName;

    @ApiModelProperty(value = "性别")
    // @Excel(name = "性别")
    private String gender;

    @ApiModelProperty(value = "出生日期")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    // @Excel(name = "出生日期",width = 20,format = "yyyy-MM-dd")
    private LocalDate birthday;

    @ApiModelProperty(value = "身份证号")
    @TableField(value = "id_card")
    // @Excel(name = "身份证号",width = 30)
    private String idCard;

    @ApiModelProperty(value = "婚姻状况")
    // @Excel(name = "婚姻状况")
    private String wedlock;

    @ApiModelProperty(value = "民族")
    @TableField(value = "nation_id")
    private Integer nationId;

    @ApiModelProperty(value = "籍贯")
    @TableField(value = "native_place")
    // @Excel(name = "籍贯")
    private String nativePlace;

    @ApiModelProperty(value = "政治面貌")
    @TableField(value = "politic_id")
    private Integer politicId;

    @ApiModelProperty(value = "邮箱")
    // @Excel(name = "邮箱",width = 30)
    private String email;

    @ApiModelProperty(value = "电话号码")
    // @Excel(name = "电话号码",width = 15)
    private String phone;

    @ApiModelProperty(value = "联系地址")
    // @Excel(name = "联系地址",width = 40)
    private String address;

    @ApiModelProperty(value = "所属部门")
    @TableField(value = "department_id")
    private Integer departmentId;

    @ApiModelProperty(value = "职称ID")
    @TableField(value = "job_level_id")
    private Integer jobLevelId;

    @ApiModelProperty(value = "职位ID")
    @TableField(value = "pos_id")
    private Integer posId;

    @ApiModelProperty(value = "聘用形式")
    @TableField(value = "engage_form")
    // @Excel(name = "聘用形式")
    private String engageForm;

    @ApiModelProperty(value = "最高学历")
    @TableField(value = "tiptop_degree")
    // @Excel(name = "最高学历")
    private String tiptopDegree;

    @ApiModelProperty(value = "所属专业")
    // @Excel(name = "所属专业",width = 20)
    private String specialty;

    @ApiModelProperty(value = "毕业院校")
    // @Excel(name = "毕业院校",width = 20)
    private String school;

    @ApiModelProperty(value = "入职日期")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @TableField(value = "begin_date")
    // @Excel(name = "入职日期",width = 20,format = "yyyy-MM-dd")
    private LocalDate beginDate;

    @ApiModelProperty(value = "在职状态")
    @TableField(value = "work_state")
    // @Excel(name = "在职状态")
    private String workState;

    @ApiModelProperty(value = "工号")
    @TableField(value = "work_id")
    // @Excel(name = "工号")
    private String workId;

    @ApiModelProperty(value = "合同期限")
    @TableField(value = "contract_term")
    // @Excel(name = "合同期限",suffix = "年")
    private Double contractTerm;

    @ApiModelProperty(value = "转正日期")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @TableField(value = "conversion_time")
    // @Excel(name = "转正日期",width = 20,format = "yyyy-MM-dd")
    private LocalDate conversionTime;

    @ApiModelProperty(value = "离职日期")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @TableField(value = "not_work_date")
    private LocalDate notWorkDate;

    @ApiModelProperty(value = "合同起始日期")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @TableField(value = "begin_contract")
    // @Excel(name = "合同起始日期",width = 20,format = "yyyy-MM-dd")
    private LocalDate beginContract;

    @ApiModelProperty(value = "合同终止日期")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @TableField(value = "end_contract")
    // @Excel(name = "合同终止日期",width = 20,format = "yyyy-MM-dd")
    private LocalDate endContract;

    @ApiModelProperty(value = "工龄")
    @TableField(value = "work_age")
    private Integer workAge;

    @ApiModelProperty(value = "工资账套ID")
    @TableField(value = "salary_id")
    private Integer salaryId;

    @ApiModelProperty(value = "民族")
    @TableField(exist = false)
    // @ExcelEntity(name = "民族")
    private NationPO nationPO;

    @ApiModelProperty(value = "政治面貌")
    @TableField(exist = false)
    // @ExcelEntity(name = "政治面貌")
    private PoliticsStatusPO politicsStatusPO;

    @ApiModelProperty(value = "部门")
    @TableField(exist = false)
    // @ExcelEntity(name = "部门")
    private DepartmentPO departmentPO;

    @ApiModelProperty(value = "职称")
    @TableField(exist = false)
    // @ExcelEntity(name = "职称")
    private JobLevelPO jobLevelPO;

    @ApiModelProperty(value = "职位")
    @TableField(exist = false)
    // @ExcelEntity(name = "职位")
    private PositionPO positionPO;


    @ApiModelProperty(value = "工资账套")
    @TableField(exist = false)
    private SalaryPO salaryPO;

}
