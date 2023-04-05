package cn.ean.oaemp.service.impl;

import cn.ean.oaemp.mapper.UserMapper;
import cn.ean.oaemp.model.po.UserPO;
import cn.ean.oaemp.service.IUserService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @FileName UserServiceImpl
 * @Author ean
 * @Date 2023/3/11 15:59
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPO> implements IUserService {

    private final UserMapper userMapper;



    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;

    }


    /**
     * 根据用户名获取用户
     *
     * @param workId
     * @return 用户的用户名
     */
    // @Override
    // public UserPO getUserByUserName(String workId) {
    //     return userMapper.selectOne(new QueryWrapper<UserPO>()
    //             .eq("uk_workid", workId)
    //             .eq("is_enabled", true));
    // }
}
