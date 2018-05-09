package cn.zhku.test.modules.book.service;

import cn.zhku.test.modules.book.dao.BookDao;
import cn.zhku.test.pojo.entity.Book;
import cn.zhku.test.pojo.entity.BookExample;
import cn.zhku.test.pojo.mapper.BookMapper;
import cn.zhku.test.util.interfaceUtils.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by MyDog on 2018/3/9.
 */
@Component
public class BookService implements IBaseService<Book> {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookDao bookDao;

    public int add(Book entity) throws Exception {
        return bookMapper.insert(entity);
    }

    @Override
    public int update(Book entity) throws Exception {
        return bookMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int delete(Book entity) throws Exception {
        return bookMapper.deleteByPrimaryKey(entity.getId());
    }

    @Override
    public Book get(String id) throws Exception {
        return bookMapper.selectByPrimaryKey(id);
    }

    @Override
    public Book get(Book entity) throws Exception {
        BookExample bookExample =new BookExample();
        bookExample.or().andIdEqualTo(entity.getId());
        if (bookExample!=null) {
            return bookMapper.selectByExample(bookExample).get(0);
        }else {
            return null;
        }
    }

    @Override
    public List<Book> findList(Book entity) throws Exception {
        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        if (entity.getName()!=null){
            criteria.andNameLike("%"+entity.getName()+"%");
        }
        if (entity.getPublication()!=null){
            criteria.andPublicationLike("%"+entity.getPublication()+"%");
        }
        return bookMapper.selectByExample(bookExample);
    }

    public int check(String id) throws Exception {
        return bookDao.check(id);
    }
}
