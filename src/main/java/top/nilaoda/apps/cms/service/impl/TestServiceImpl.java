package top.nilaoda.apps.cms.service.impl;

import top.nilaoda.apps.cms.bean.Test;
import top.nilaoda.apps.cms.mapper.TestMapper;
import top.nilaoda.apps.cms.service.TestService;
import top.nilaoda.apps.cms.util.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author nilaoda
 * @version 1.0
 * @description 测试类
 * @date 2019/12/19
 * @time 11:49
 */
@Service
public class TestServiceImpl implements TestService {
    @Resource
    private TestMapper testMapper;

    @Override
    public List<Test> findAll() {
        //调用mapper完成查询 返回结果
        return testMapper.findAll();
    }

    @Override
    public int deleteById(long id) {
        return testMapper.deleteById(id);
    }

    @Override
    public int saveOrUpdate(Test test) throws CustomerException {
        if (test.getId() == null) {
            //保存
            Test t = testMapper.findByName(test.getName());
            if (t != null) {
                //名字被占用
                throw new CustomerException("名字被占用");
            }
            return testMapper.insert(test);
        } else
            return testMapper.update(test);
    }

    @Override
    public Test findByName(String name) {
        return testMapper.findByName(name);
    }
}
