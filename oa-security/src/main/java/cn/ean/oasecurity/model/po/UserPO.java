package cn.ean.oasecurity.model.po;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @FileName UserPO
 * @Author ean
 * @Date 2023/3/15 16:35
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Entity(name = "oa_emp_user")
@Table(name = "oa_emp_user")
public class UserPO implements Serializable, UserDetails {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pkId;

    @Column(name = "workid")
    private Integer workId;

    @Column(name = "password")
    private String password;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "user_face")
    private String userFace;

    @Column(name = "is_enabled")
    @Getter(AccessLevel.NONE)
    private Boolean enabled;

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
