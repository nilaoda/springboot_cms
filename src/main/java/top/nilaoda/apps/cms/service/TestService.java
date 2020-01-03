package top.nilaoda.apps.cms.service;

import top.nilaoda.apps.cms.bean.Test;
import top.nilaoda.apps.cms.util.CustomerException;

import java.util.List;

public interface TestService {
    List<Test> findAll();

    int deleteById(long id);

    int saveOrUpdate(Test test) throws CustomerException;

    Test findByName(String name);
}
