package top.nilaoda.apps.cms.service;

import top.nilaoda.apps.cms.bean.Privilege;

import java.util.List;

public interface PrivilegeService {
    List<Privilege> findAll();

    Privilege findById(long id);

    long saveOrUpdate(Privilege privilege);

    long deleteById(long id);
}
