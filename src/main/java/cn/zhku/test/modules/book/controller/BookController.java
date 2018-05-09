package cn.zhku.test.modules.book.controller;

import cn.zhku.test.modules.book.service.BookService;
import cn.zhku.test.modules.userbook.service.Service;
import cn.zhku.test.pojo.entity.Book;
import cn.zhku.test.util.modle.CommonQo;
import cn.zhku.test.util.modle.Result;
import cn.zhku.test.web.BaseController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Created by MyDog on 2018/3/9.
 */
@RestController
@RequestMapping("/book/")
public class BookController extends BaseController {
    @Autowired
    BookService bookService;

    @RequiresPermissions("bookadd")
    @ResponseBody
    @RequestMapping("add")
    public Result add(Book entity) throws Exception {
        System.out.println("================"+entity);
        entity.setId(UUID.randomUUID().toString().replace("-","").toUpperCase());   //用32位大小的UUID来设置用户id
        if (bookService.add(entity) == 1){
            return new Result("1", "插入书籍成功");}
        else{
            return new Result("2", "插入书籍失败");}
    }

    @RequiresPermissions("bookdelete")
    @ResponseBody
    @RequestMapping("delete")
    public Result delete(String id, Book entity) throws Exception {
        if (bookService.delete(entity) == 1){
            return new Result("1", "成功删除书籍");}
        else{
            return new Result("2", "删除书籍失败");}
    }

    @RequiresPermissions("bookupdate")
    @ResponseBody
    @RequestMapping("update")
    public Result update(String id, Book entity) throws Exception {
        if (bookService.update(entity) == 1){
            return new Result("1", "更新书籍信息成功");}
        else{
            return new Result("2", "更新书籍信息失败");}
    }

    @RequiresPermissions("bookget")
    @ResponseBody
    @RequestMapping("get")
    public Book get(@RequestParam("id") String id) throws Exception {
        System.out.println(id+"=======================================================");
        return bookService.get(id);
    }

    @RequiresPermissions("booklist")
    @ResponseBody
    @RequestMapping("list")
    public PageInfo<Book> list(Book entity, CommonQo commonQo) throws Exception {
        if (commonQo.getSort().equals("1"))  //字符串"1"是sort的默认值，相当于 order by 1 ,即按主键排序
        {
            commonQo.setSort("press desc");
        }
        else if(commonQo.getSort().equals("2")){
            commonQo.setSort("press asc");
        }
        else{
            commonQo.setSort("status desc");
        }
        PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize(), commonQo.getSort());
        //  通过服务层获取查询后的用户列表
        List<Book> bookList= bookService.findList(entity);
        //  返回 pageBean实体
        return new PageInfo<Book>(bookList);
    }
}
