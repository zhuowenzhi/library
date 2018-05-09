package cn.zhku.test.modules.book.dao;

import cn.zhku.test.pojo.entity.Book;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookDao {
    /*
 * 根据type是否为'未过期'和'已过期'
 * */
    @Select("select quantity from book where id=#{id}")
    int check(String id);
}
