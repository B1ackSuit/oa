package cn.ean.oaemp.service;

import cn.ean.oaemp.model.po.UserPO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @FileName IUserService
 * @Author ean
 * @Date 2023/3/11 15:57
 **/

public interface IUserService extends IService<UserPO> {

    /**
     * 根据用户名获取用户
     * @param workId
     * @return 用户的用户名
     */
    UserPO getUserByUserName(String workId);


}
