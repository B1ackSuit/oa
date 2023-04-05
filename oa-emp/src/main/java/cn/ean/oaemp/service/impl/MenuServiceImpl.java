package cn.ean.oaemp.service.impl;

import cn.ean.oaemp.mapper.MenuMapper;
import cn.ean.oaemp.model.po.MenuPO;
import cn.ean.oaemp.service.IMenuService;
import cn.ean.oaemp.util.UserUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @FileName MenuServiceImpl
 * @Author ean
 * @Date 2023/4/5 19:15
 **/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuPO> implements IMenuService {

    private final MenuMapper menuMapper;

    @Autowired
    public MenuServiceImpl(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    /**
     * 通过用户id获取菜单列表
     *
     * @return
     */
    @Override
    public List<MenuPO> getMenusByUserId() {
        return menuMapper.getMenusByUserId(UserUtils.getCurrentUser().getWorkId());
    }
}
