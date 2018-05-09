package cn.zhku.test.modules.user.service;

import cn.zhku.test.pojo.entity.User;
import cn.zhku.test.pojo.entity.UserExample;
import cn.zhku.test.pojo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MyDog on 2018/3/21.
 */
@Service
public class LoginService {
    @Autowired
    UserMapper userMapper;




    /**
     *  登录服务
     * @param form  user ,必须参数:phone，password
     * @return True：成功 False：失败
     */
    public User login(User form) {
        UserExample userExample = new UserExample();
        userExample.or().andPhoneEqualTo(form.getPhone());
        //  根据手机号查询用户
        List<User> userList = userMapper.selectByExample(userExample);
        //  如果用户不存在,则返回null
        if (userList.size() == 0) {
            return null;
        }
        //  userList.get(0)  取结果集的第一个用户
        if (userList.get(0) != null && userList.get(0).getPassword().equals(form.getPassword()))
            return userList.get(0);
        else
            return null;
    }

    //检验手机号

    /**
     *  查询是否有相同手机号的用户
     * @param user 必须参数:phone
     * @return  true 手机号不存在  false 手机号存在
     */
    public boolean CheckPhone(User user) {
        UserExample userExample = new UserExample();
        userExample.or().andPhoneEqualTo(user.getPhone());
        if(userMapper.selectByExample(userExample).size() > 0)
            return false;   //  若有相同手机号的用户，返回false
        else
            return true;    //   否则返回true
    }

    //  用户注册

    /**
     *  注册用户
     * @param user  user实体
     * @return
     */
    public int register(User user) {
        return userMapper.insertSelective(user);
    }


    /**
     *  查询是否有相同用户名的用户
     * @param username  前端传入的用户名
     * @return
     */
    public boolean registerCheckUsername(String username) {
        UserExample userExample = new UserExample();
        userExample.or().andNameEqualTo(username);
        if(userMapper.selectByExample(userExample).size() > 0)
            return false;   //  若有相同用户名的用户，返回false
        else
            return true;    //   否则返回true

    }
}