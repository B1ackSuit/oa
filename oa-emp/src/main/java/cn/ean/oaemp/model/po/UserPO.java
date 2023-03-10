package cn.ean.oaemp.model.po;

import cn.ean.oaemp.config.security.CustomAuthorityDeserializer;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * * @EqualsAndHashCode(callSuper = true):用自己的属性和父类继承的属性来生成hashcode
 * * @EqualsAndHashCode(callSuper = false):只用自己的属性来生成hashcode
 * * @RequiredArgsConstructor(修饰类) 配合@NonNull(修饰属性)可以生成指定参数的构造方法
 *
 * @Author ean
 * @FileName UserPO
 * @Date 2023/1/3 17:20
 **/

/**
 * @FileName UserPO
 * @Author ean
 * @Date 2023/3/8 22:03
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("oa_emp_user")
@ApiModel(value = "UserPO", description = "UserPO对象")
public class UserPO implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "pk_id")
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    @ApiModelProperty(value = "登录工号")
    @TableField(value = "uk_workid")
    private Integer workId;

    @ApiModelProperty(value = "密码")
    @TableField(value = "password")
    private String password;

    @ApiModelProperty(value = "员工姓名")
    @TableField(value = "emp_name")
    private String empName;

    @ApiModelProperty(value = "手机号")
    @TableField(value = "phone")
    private String phone;

    @ApiModelProperty(value = "用户头像")
    @TableField(value = "user_face")
    private String userFace;

    @ApiModelProperty(value = "是否启用")
    @TableField(value = "is_enabled")
    @Getter(AccessLevel.NONE)
    private Boolean enabled;

    @ApiModelProperty(value = "角色")
    @TableField(exist = false)
    private List<RolePO> roles;

    /**
     * Returns the authorities granted to the user. Cannot return <code>null</code>.
     *
     * 把对应的角色名转化为SimpleGrantedAuthority
     *
     * @return the authorities, sorted by natural key (never <code>null</code>)
     */
    // @Override
    // @JsonDeserialize(using = CustomAuthorityDeserializer.class)
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    //     List<SimpleGrantedAuthority> collection = roles
    //             .stream()
    //             .map(rolePO -> new SimpleGrantedAuthority(rolePO.getAuthority()))
    //             .collect(Collectors.toList());
    //     return collection;
    // }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    /**
     * Returns the password used to authenticate the user.
     *
     * @return the password
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Returns the username used to authenticate the user. Cannot return <code>null</code>.
     *
     * @return the username (never <code>null</code>)
     */
    @Override
    public String getUsername() {
        return String.valueOf(workId);
    }

    /**
     * Indicates whether the user's account has expired. An expired account cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user's account is valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is locked or unlocked. A locked user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is not locked, <code>false</code> otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) has expired. Expired
     * credentials prevent authentication.
     *
     * @return <code>true</code> if the user's credentials are valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled or disabled. A disabled user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is enabled, <code>false</code> otherwise
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
