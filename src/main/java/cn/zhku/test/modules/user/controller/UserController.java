package cn.zhku.test.modules.user.controller;

import cn.zhku.test.modules.book.service.BookService;
import cn.zhku.test.modules.user.service.UserService;
import cn.zhku.test.pojo.entity.User;
import cn.zhku.test.util.modle.CommonQo;
import cn.zhku.test.util.modle.Result;
import cn.zhku.test.web.BaseController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user/")




public class UserController extends BaseController {
    /**
     *
     */
    @Autowired
    private UserService userService;



    @RequiresPermissions("useradd")
    @ResponseBody
    @RequestMapping("add")
    public Result add(User entity) throws Exception {
        entity.setId(UUID.randomUUID().toString().replace("-","").toUpperCase());   //用32位大小的UUID来设置用户id
/*        Timestamp t = new Timestamp(System.currentTimeMillis());
        entity.setEntry(t);*/
        if (userService.add(entity) == 1){
            return new Result("1", "插入成员成功");}
        else{
            return new Result("2", "插入成员失败");}

    }

    @RequiresPermissions("userdelete")
    @ResponseBody
    @RequestMapping("delete")
    public Result delete(String id, User entity) throws Exception {
        if (userService.delete(entity) == 1){
            return new Result("1", "成功成员材料");}
        else{
            return new Result("2", "删除成员失败");}
    }


/*    @RequiresRoles("userjkgry")*/
    @RequiresPermissions("userupdate")
    @ResponseBody
    @RequestMapping("update")
    public Result update(User entity) throws Exception {
        logger.info("======================="+entity.getName()+"===================================");
        logger.info("======================="+entity.getSex()+"===================================");
        if (userService.update(entity) == 1){
            return new Result("1", "更新成员信息成功");}
        else{
            return new Result("2", "更新成员信息失败");}
    }

    @RequiresPermissions("userget")
    @ResponseBody
    @RequestMapping("get")
    public User get(String id) throws Exception {
        return userService.get(id);
    }

    @RequiresPermissions("userlist")
    @ResponseBody
    @RequestMapping("list")
    public PageInfo<User> list(User entity, CommonQo commonQo) throws Exception {
        PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize(), "id desc");
        //  通过服务层获取查询后的用户列表
        List<User> userList = userService.findList(entity);
        //  返回 pageBean实体
        return new PageInfo<User>(userList);
    }



}
