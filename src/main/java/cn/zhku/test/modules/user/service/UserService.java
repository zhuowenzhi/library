package cn.zhku.test.modules.user.service;

import cn.zhku.test.pojo.entity.User;
import cn.zhku.test.pojo.entity.UserExample;
import cn.zhku.test.pojo.mapper.UserMapper;
import cn.zhku.test.util.interfaceUtils.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService implements IBaseService<User> {
    @Autowired
    private UserMapper userMapper;
/*    @Autowired
    private UserDao userDao;*/
    @Override
    public int add(User entity) throws Exception {
        return userMapper.insert(entity);
    }

    @Override
    public int update(User entity) throws Exception {
        return userMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int delete(User entity) throws Exception {
        return userMapper.deleteByPrimaryKey(entity.getId());
    }

    @Override
    public User get(String id) throws Exception {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User get(User entity) throws Exception {
        UserExample userExample =new UserExample();
        userExample.or().andIdEqualTo(entity.getId());
        if (userExample!=null) {
            return userMapper.selectByExample(userExample).get(0);
        }else {
            return null;
        }
    }

    @Override
    public List<User> findList(User entity) throws Exception {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (entity.getName()!=null){
            criteria.andNameLike("%"+entity.getName()+"%");
        }
        if (entity.getPhone()!=null){
            criteria.andPhoneEqualTo(entity.getPhone());
        }
        return userMapper.selectByExample(userExample);
    }

}
