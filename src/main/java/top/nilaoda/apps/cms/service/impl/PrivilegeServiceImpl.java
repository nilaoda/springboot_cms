package top.nilaoda.apps.cms.service.impl;

import top.nilaoda.apps.cms.bean.Privilege;
import top.nilaoda.apps.cms.mapper.PrivilegeMapper;
import top.nilaoda.apps.cms.service.PrivilegeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {
    @Resource
    private PrivilegeMapper privilegeMapper;

    @Override
    public List<Privilege> findAll() {
        return privilegeMapper.selectByExample(null);
    }

    @Override
    public Privilege findById(long id) {
        return privilegeMapper.selectByPrimaryKey(id);
    }

    @Override
    public long saveOrUpdate(Privilege privilege) {
        if (privilege.getId() == null) {
            return privilegeMapper.insert(privilege);
        } else {
            return privilegeMapper.updateByPrimaryKey(privilege);
        }
    }

    @Override
    public long deleteById(long id) {
        return privilegeMapper.deleteByPrimaryKey(id);
    }
}
