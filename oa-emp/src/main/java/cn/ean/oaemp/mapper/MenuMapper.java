package cn.ean.oaemp.mapper;

import cn.ean.oaemp.model.po.MenuPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @FileName MenuMapper
 * @Author ean
 * @Date 2023/4/5 19:08
 **/
@Mapper
public interface MenuMapper extends BaseMapper<MenuPO> {

    List<MenuPO> getMenusByUserId(Integer workId);

}
