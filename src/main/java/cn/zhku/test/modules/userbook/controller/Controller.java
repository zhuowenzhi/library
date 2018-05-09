package cn.zhku.test.modules.userbook.controller;

import cn.zhku.test.modules.book.service.BookService;
import cn.zhku.test.modules.userbook.service.Service;
import cn.zhku.test.pojo.entity.Book;
import cn.zhku.test.pojo.entity.BookExample;
import cn.zhku.test.pojo.entity.User;
import cn.zhku.test.pojo.entity.UserBook;
import cn.zhku.test.util.modle.CommonQo;
import cn.zhku.test.util.modle.Result;
import cn.zhku.test.web.BaseController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Created by MyDog on 2018/3/9.
 */
@RestController
@RequestMapping("/userbook/")
public class Controller extends BaseController{
    @Autowired
    private Service service;
    @Autowired
    private BookService bookService;

    @RequiresPermissions("userbookadd")
    @ResponseBody
    @RequestMapping("add")
    public Result add(UserBook entity) throws Exception {
        entity.setId(UUID.randomUUID().toString().replace("-","").toUpperCase());
        if (bookService.check(entity.getBookId()) == 0&&entity.getOperate().equals("借阅")){
            return new Result("1", "借阅失败;库存不足");}
        else if (bookService.check(entity.getBookId()) != 0&&entity.getOperate().equals("借阅")){
            Book book=bookService.get(entity.getBookId());
            book.setQuantity(book.getQuantity()-1);
            bookService.update(book);
            service.add(entity);
            return new Result("2", "借阅成功");}
        else{
            Book book=bookService.get(entity.getBookId());
            book.setQuantity(book.getQuantity()+1);
            bookService.update(book);
            service.add(entity);
            return new Result("3", "归还成功");
        }
    }

    @RequiresPermissions("userbookdelete")
    @ResponseBody
    @RequestMapping("delete")
    public Result delete(UserBook entity) throws Exception {
        if (service.delete(entity) == 1){
            return new Result("1", "成功借阅材料");}
        else{
            return new Result("2", "删除借阅失败");}
    }

    @RequiresPermissions("userbookupdate")
    @ResponseBody
    @RequestMapping("update")
    public Result update(String id, UserBook entity) throws Exception {
        if (service.update(entity) == 1){
            return new Result("1", "更新借阅信息成功");}
        else{
            return new Result("2", "更新借阅信息失败");}
    }

    @RequiresPermissions("userbookget")
    @ResponseBody
    @RequestMapping("get")
    public UserBook get(String id) throws Exception {
        return service.get(id);
    }

    @RequiresPermissions("userbooklist")
    @ResponseBody
    @RequestMapping("list")
    public PageInfo<UserBook> list(UserBook entity, CommonQo commonQo) throws Exception {
        PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize(),"date desc");
        //  通过服务层获取查询后的用户列表
        List<UserBook> userBookList= service.findList(entity);
        //  返回 pageBean实体
        return new PageInfo<UserBook>(userBookList);
    }
}
