package top.nilaoda.apps.cms.service.impl;

import top.nilaoda.apps.cms.bean.Role;
import top.nilaoda.apps.cms.mapper.RoleMapper;
import top.nilaoda.apps.cms.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAll() {
        return roleMapper.selectByExample(null);
    }

    @Override
    public Role findById(long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public long saveOrUpdate(Role role) {
        if (role.getId() == null) {
            return roleMapper.insert(role);
        } else {
            return roleMapper.updateByPrimaryKey(role);
        }
    }

    @Override
    public long deleteById(long id) {
        return roleMapper.deleteByPrimaryKey(id);
    }
}
