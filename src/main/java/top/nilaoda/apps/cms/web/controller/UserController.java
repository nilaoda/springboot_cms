package top.nilaoda.apps.cms.web.controller;

import top.nilaoda.apps.cms.bean.User;
import top.nilaoda.apps.cms.service.UserService;
import top.nilaoda.apps.cms.util.Message;
import top.nilaoda.apps.cms.util.MessageUtil;
import top.nilaoda.apps.cms.vm.UserVM;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("通过用户名密码进行登录,登录成功返回token")
    @PostMapping("login")
    public Message login(@RequestBody UserVM userVM) {
        /*
            模拟登录
            1.验证用户身份
            2.如果正确 产生一个token -jwt
            3.维护token到后台
            4.将token返回给前端
         */
        Map<String, String> map = new HashMap<>();
        map.put("token", "admin-token");
        return MessageUtil.success(map);
    }

    @ApiOperation("通过token获取用户信息")
    @GetMapping("info")
    public Message info(String token) {
        /*
            通过token找到用户信息
            找到用户角色信息
            将用户基本信息与角色信息返回给前端
         */
        Map<String, Object> map = new HashMap<>();
        map.put("name", "admin");
        map.put("roles", new String[]{"admin"});
        map.put("avatar", "");
        map.put("introduction", "超级管理员");
        return MessageUtil.success(map);
    }

    @PostMapping("logout")
    public Message logout() {
        /*
            将token失效
         */
        return MessageUtil.success("success");
    }

    @GetMapping("findAll")
    public Message findAll() {
        List<User> data = userService.findAll();
        return MessageUtil.success(data);
    }

    @GetMapping("findById")
    public Message findById(long id) {
        User data = userService.findById(id);
        return MessageUtil.success(data);
    }

    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(User user) {
        userService.saveOrUpdate(user);
        return MessageUtil.success("更新成功");
    }

    @DeleteMapping("deleteById")
    public Message deleteById(long id) {
        userService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
}
