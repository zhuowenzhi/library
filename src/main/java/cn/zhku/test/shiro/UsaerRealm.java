package cn.zhku.test.shiro;

import cn.zhku.test.pojo.entity.Book;
import cn.zhku.test.pojo.entity.User;
import cn.zhku.test.pojo.entity.UserExample;
import cn.zhku.test.pojo.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2018/1/19 23:13.
 * 说明：
 */
public class UsaerRealm extends AuthorizingRealm {

    private static Logger logger = LoggerFactory.getLogger(UsaerRealm.class);

    // 用户对应的角色信息与权限信息都保存在数据库中，通过UserService获取数据
    @Autowired
    private ShiroDao shiroDao;
    @Autowired
    private UserMapper userMapper;



    /**
     * 提供用户信息返回权限信息
     * @param principals the primary identifying principals of the AuthorizationInfo that should be retrieved.
     * @return the AuthorizationInfo associated with this principals.
     * @see SimpleAuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String phone = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 根据用户名查询当前用户拥有的角色
        Set<String> roleIdSet = shiroDao.findRoleByUserId(phone);
        logger.info("============ roleSet ============="+roleIdSet.toString());
        System.out.println();
        // 将角色名称提供给info
        authorizationInfo.setRoles(roleIdSet);


        // 根据用户名查询当前用户权限
        Set<String> permissionSet = new HashSet<String>();
        for (String s:roleIdSet) {
            if (s.equals("系统管理员")) {
                permissionSet.add("useradd");
                permissionSet.add("useredit");
                permissionSet.add("userdelete");
                permissionSet.add("userget");
                permissionSet.add("userlist");
            }

            else if (s.equals("图书管理员")) {
                permissionSet.add("bookadd");
                permissionSet.add("bookedit");
                permissionSet.add("bookdelete");
                permissionSet.add("bookget");
                permissionSet.add("booklist");
                permissionSet.add("userbookadd");
                permissionSet.add("userbookedit");
                permissionSet.add("userbookdelete");
            }

            else if (s.equals("借阅者")) {
                permissionSet.add("userbookget");
                permissionSet.add("userbooklist");
            }

            else if (s.equals("系统、图书管理员")) {
                permissionSet.add("useradd");
                permissionSet.add("useredit");
                permissionSet.add("userdelete");
                permissionSet.add("userget");
                permissionSet.add("userlist");
                permissionSet.add("bookadd");
                permissionSet.add("bookedit");
                permissionSet.add("bookdelete");
                permissionSet.add("bookget");
                permissionSet.add("booklist");
                permissionSet.add("userbookadd");
                permissionSet.add("userbookedit");
                permissionSet.add("userbookdelete");
            }
            else if (s.equals("系统管理员、借阅者")) {
                permissionSet.add("useradd");
                permissionSet.add("useredit");
                permissionSet.add("userdelete");
                permissionSet.add("userget");
                permissionSet.add("userlist");
                permissionSet.add("userbookget");
                permissionSet.add("userbooklist");
            }

            else if (s.equals("图书管理员、借阅者")) {
                permissionSet.add("bookadd");
                permissionSet.add("bookedit");
                permissionSet.add("bookdelete");
                permissionSet.add("bookget");
                permissionSet.add("booklist");
                permissionSet.add("userbookadd");
                permissionSet.add("userbookedit");
                permissionSet.add("userbookdelete");
                permissionSet.add("userbookget");
                permissionSet.add("userbooklist");
            }

            else if (s.equals("系统、图书管理员、借阅者")) {
                permissionSet.add("userbookadd");
                permissionSet.add("userbookedit");
                permissionSet.add("userbookdelete");
                permissionSet.add("userbookget");
                permissionSet.add("userbooklist");
                permissionSet.add("useradd");
                permissionSet.add("useredit");
                permissionSet.add("userdelete");
                permissionSet.add("userget");
                permissionSet.add("userlist");
                permissionSet.add("bookadd");
                permissionSet.add("bookedit");
                permissionSet.add("bookdelete");
                permissionSet.add("bookget");
                permissionSet.add("booklist");
            }



        }

        logger.info("===========  permissionSet =============="+permissionSet.toString());
        System.out.println();
        // 将权限名称提供给info
        authorizationInfo.setStringPermissions(permissionSet);

        return authorizationInfo;
    }

    /**
     * 提供账户信息返回认证信息
     * @param token the authentication token containing the user's principal and credentials.
     * @return an {@link AuthenticationInfo} object containing account data resulting from the
     * authentication ONLY if the lookup is successful (i.e. account exists and is valid, etc.)
     * @throws AuthenticationException if there is an error acquiring data or performing
     *                                 realm-specific authentication logic for the specified <tt>token</tt>
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String phone = (String) token.getPrincipal();
        UserExample userExample = new UserExample();
        userExample.or().andPhoneEqualTo(phone);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList == null && userList.size() == 0) {
            // 用户名不存在抛出异常
            throw new UnknownAccountException();
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userList.get(0).getPhone(),
                userList.get(0).getPassword(), getName());
        return authenticationInfo;
    }
}