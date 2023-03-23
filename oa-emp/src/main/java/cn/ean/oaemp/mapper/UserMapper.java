package cn.ean.oaemp.mapper;

import cn.ean.oaemp.model.po.UserPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @FileName UserMapper
 * @Author ean
 * @Date 2023/3/11 15:56
 **/
@Mapper
public interface UserMapper extends BaseMapper<UserPO> {

}
