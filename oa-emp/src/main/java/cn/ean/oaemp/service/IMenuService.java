package cn.ean.oaemp.service;

import cn.ean.oaemp.model.po.MenuPO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @FileName IMenuService
 * @Author ean
 * @Date 2023/4/5 19:14
 **/
public interface IMenuService extends IService<MenuPO> {

    /**
     * 通过用户id获取菜单列表
     * @return
     */
    List<MenuPO> getMenusByUserId();
}
