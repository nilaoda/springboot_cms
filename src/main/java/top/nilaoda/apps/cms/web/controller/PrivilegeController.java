package top.nilaoda.apps.cms.web.controller;

import top.nilaoda.apps.cms.bean.Privilege;
import top.nilaoda.apps.cms.service.PrivilegeService;
import top.nilaoda.apps.cms.util.Message;
import top.nilaoda.apps.cms.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/privilege")
public class PrivilegeController {
    @Autowired
    private PrivilegeService privilegeService;

    @GetMapping("findAll")
    public Message findAll() {
        List<Privilege> data = privilegeService.findAll();
        return MessageUtil.success(data);
    }

    @GetMapping("findById")
    public Message findById(long id) {
        Privilege data = privilegeService.findById(id);
        return MessageUtil.success(data);
    }

    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Privilege privilege) {
        privilegeService.saveOrUpdate(privilege);
        return MessageUtil.success("更新成功");
    }

    @DeleteMapping("deleteById")
    public Message deleteById(long id) {
        privilegeService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
}
