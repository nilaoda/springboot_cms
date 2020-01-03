package top.nilaoda.apps.cms.service;

import top.nilaoda.apps.cms.bean.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    Role findById(long id);

    long saveOrUpdate(Role role);

    long deleteById(long id);
}
