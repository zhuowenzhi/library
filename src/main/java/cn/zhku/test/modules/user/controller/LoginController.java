package cn.zhku.test.modules.user.controller;

import cn.zhku.test.modules.user.service.LoginService;
import cn.zhku.test.modules.user.service.UserService;
import cn.zhku.test.pojo.entity.User;
import cn.zhku.test.util.modle.CommonQo;
import cn.zhku.test.util.modle.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by MyDog on 2018/3/21.
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    /**
     *  用户登录
     * @param form  User类，必须参数：phone，password
     * @return
     */
    @ResponseBody
    @RequestMapping("/user/login")
    public User login(User form, HttpSession httpSession) throws Exception{
        System.out.println("========================="+form);
        User user = loginService.login(form);
        if(user != null){
            UsernamePasswordToken token = new UsernamePasswordToken(user.getPhone().toString(), user.getPassword());
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();

            //   记住用户登陆状态
            token.setRememberMe(true);

            //httpSession.setAttribute("user",user);
            session.setAttribute("user",user);
            //  shiro登陆用户信息
            subject.login(token);
            return user;
        }
        else
            return null;
    }

    @ResponseBody
    @RequestMapping("/user/CheckPhone")
    public Result loginCheckPhone(User user){
        if(loginService.CheckPhone(user))
            return new Result("1","手机号未注册");
        else
            return new Result("2","手机号已注册");
    }

    @ResponseBody
    @RequestMapping("/user/register")
    public Result loginCheckPhone(User user, String verifyCode){
        System.out.print("===================="+user.getPassword()+"========================");
        user.setId(UUID.randomUUID().toString().replace("-","").toUpperCase());   //用32位长度的UUID来设置用户id
        user.setRoleId("2");
        if(loginService.register(user) == 1)
            return new Result("1","用户注册成功");
        else
            return new Result("2","用户注册失败");
    }

    /**
     *  验证用户名是否被注册
     * @param username  用户名
     * @return Message
     */
    @ResponseBody
    @RequestMapping("/user/registerCheckUsername")
    public Result registerVerifyCode(String username){
        if(loginService.registerCheckUsername(username))
            return new Result("1","用户名尚未被注册");
        else
            return new Result("2","用户名已经被注册");

    }

    @ResponseBody
    @RequestMapping("/user/nowUserInfo")
    public User nowUserInfo(HttpSession httpSession) {
        //User user = (User) httpSession.getAttribute("user");
        Session session = SecurityUtils.getSubject().getSession();
        User user = (User) session.getAttribute("user");
        if (user == null)
            return null;
        user.setPassword("  ");
        return user;
    }


/*    @ResponseBody
    @RequestMapping("/user/findRolebyphone")
    public Result role(String phone) throws Exception {
        User user = new User();
        user.setPhone(phone);
        List<User> userList = new ArrayList<>(userService.findList(user));
        if (!userList.isEmpty()) {
            return new Result(userList,"1","此人存在");
        }
        else{
            return new Result(null,"2","查无此人");}
    }*/

}