package cn.ean.oaemp.util;

import cn.ean.oasecurity.model.po.UserPO;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @FileName UserUtils
 * @Author ean
 * @Date 2023/4/5 19:17
 **/
public class UserUtils {

    public static UserPO getCurrentUser() {
        return (UserPO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
