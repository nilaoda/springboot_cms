package top.nilaoda.apps.cms.service.impl;

import top.nilaoda.apps.cms.bean.User;
import top.nilaoda.apps.cms.bean.UserExample;
import top.nilaoda.apps.cms.mapper.UserMapper;
import top.nilaoda.apps.cms.service.UserService;
import top.nilaoda.apps.cms.util.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectByExample(null);
    }

    @Override
    public User findById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> findByName(String name) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(name);
        return userMapper.selectByExample(userExample);
    }

    @Override
    public long saveOrUpdate(User user) throws CustomerException {
        if (user.getId() == null) {
            List<User> u = findByName(user.getUsername());
            if (u.size() > 0) {
                throw new CustomerException("用户名被占用");
            }
            return userMapper.insert(user);
        } else {
            return userMapper.updateByPrimaryKey(user);
        }
    }

    @Override
    public long deleteById(long id) {
        return userMapper.deleteByPrimaryKey(id);
    }
}
