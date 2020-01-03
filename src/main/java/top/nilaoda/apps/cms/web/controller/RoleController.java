package top.nilaoda.apps.cms.web.controller;

import top.nilaoda.apps.cms.bean.Role;
import top.nilaoda.apps.cms.service.RoleService;
import top.nilaoda.apps.cms.util.Message;
import top.nilaoda.apps.cms.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("findAll")
    public Message findAll() {
        List<Role> data = roleService.findAll();
        return MessageUtil.success(data);
    }

    @GetMapping("findById")
    public Message findById(long id) {
        Role data = roleService.findById(id);
        return MessageUtil.success(data);
    }

    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Role role) {
        roleService.saveOrUpdate(role);
        return MessageUtil.success("更新成功");
    }

    @DeleteMapping("deleteById")
    public Message deleteById(long id) {
        roleService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
}
