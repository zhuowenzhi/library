package cn.zhku.test.modules.userbook.service;

import cn.zhku.test.pojo.entity.UserBook;
import cn.zhku.test.pojo.entity.UserBookExample;
import cn.zhku.test.pojo.mapper.UserBookMapper;
import cn.zhku.test.util.interfaceUtils.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by MyDog on 2018/3/9.
 */
@Component
public class Service implements IBaseService<UserBook> {
    @Autowired
    private UserBookMapper userBookMapper;
    @Override
    public int add(UserBook entity) throws Exception {
        return userBookMapper.insert(entity);
    }

    @Override
    public int update(UserBook entity) throws Exception {
        return userBookMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int delete(UserBook entity) throws Exception {
        return userBookMapper.deleteByPrimaryKey(entity.getUserId(), entity.getBookId());
    }

    @Override
    public UserBook get(String id) throws Exception {
        return userBookMapper.selectByPrimaryKey(id);
    }

    @Override
    public UserBook get(UserBook entity) throws Exception {
        UserBookExample userBookExample =new UserBookExample();
        userBookExample.or().andIdEqualTo(entity.getId());
        if (userBookExample!=null) {
            return userBookMapper.selectByExample(userBookExample).get(0);
        }else {
            return null;
        }
    }

    @Override
    public List<UserBook> findList(UserBook entity) throws Exception {
        UserBookExample userBookExample = new UserBookExample();
        UserBookExample.Criteria criteria = userBookExample.createCriteria();
        if (entity.getUserId()!=null){
            criteria.andBookIdEqualTo(entity.getUserId());
        }
        return userBookMapper.selectByExample(userBookExample);
    }

}
