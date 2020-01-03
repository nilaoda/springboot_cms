package top.nilaoda.apps.cms.service;

import top.nilaoda.apps.cms.bean.User;
import top.nilaoda.apps.cms.util.CustomerException;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(long id);

    List<User> findByName(String name);

    long saveOrUpdate(User user) throws CustomerException;

    long deleteById(long id);
}
