package cn.zhku.test.shiro;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.Set;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2018/1/19 23:33.
 * 说明：
 */
public interface ShiroDao {

    /**
     *  查找登录管理员的角色
     * @param id   管理员id
     *  @return 角色集合
     */
    @Select("SELECT name FROM role WHERE id IN (SELECT role_id FROM user WHERE id = #{id}) ")
    Set<String> findRoleByUserId(@Param("id") String id);



/*    @Select("SELECT name FROM dictionary  WHERE id IN (SELECT permission_id FROM role_permission WHERE role_id IN " +
            "  (SELECT role_id FROM user_role WHERE user_id = #{user_id})) ")
    Set<String> findPermissionByUserId(@Param("user_id") String usrId);*/


}