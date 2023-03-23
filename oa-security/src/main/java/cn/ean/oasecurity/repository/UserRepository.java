package cn.ean.oasecurity.repository;

import cn.ean.oasecurity.model.po.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @FileName UserRepository
 * @Author ean
 * @Date 2023/3/17 14:38
 **/
@Repository
public interface UserRepository extends JpaRepository<UserPO, Integer> {

    /**
     * 根据workId即登录的用户名获取用户
     * @param workId
     * @return 用户
     */
    UserPO findByWorkId(String workId);

}
