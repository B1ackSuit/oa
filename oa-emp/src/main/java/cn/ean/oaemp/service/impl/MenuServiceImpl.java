package cn.ean.oaemp.service.impl;

import cn.ean.oaemp.mapper.MenuMapper;
import cn.ean.oaemp.model.po.MenuPO;
import cn.ean.oaemp.service.IMenuService;
import cn.ean.oaemp.util.UserUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @FileName MenuServiceImpl
 * @Author ean
 * @Date 2023/4/5 19:15
 **/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuPO> implements IMenuService {

    private final MenuMapper menuMapper;

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public MenuServiceImpl(MenuMapper menuMapper,
                           RedisTemplate<String, Object> redisTemplate) {
        this.menuMapper = menuMapper;
        this.redisTemplate = redisTemplate;
    }

    /**
     * 通过用户id获取菜单列表
     *
     * @return
     */
    @Override
    public List<MenuPO> getMenusByUserId() {
        Integer userId = UserUtils.getCurrentUser().getWorkId();
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        // 查询缓存中是否有数据
        List<MenuPO> menus = (List<MenuPO>) valueOperations.get("menu_" + userId);

        if (CollectionUtils.isEmpty(menus)) {
            menus = menuMapper.getMenusByUserId(userId);
            valueOperations.set("menu_" + userId, menus);
        }
        return menus;
    }
}
