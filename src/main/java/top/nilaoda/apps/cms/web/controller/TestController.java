package top.nilaoda.apps.cms.web.controller;

import top.nilaoda.apps.cms.bean.Test;
import top.nilaoda.apps.cms.service.TestService;
import top.nilaoda.apps.cms.util.Message;
import top.nilaoda.apps.cms.util.MessageUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author nilaoda
 * @version 1.0
 * @description 测试API
 * @date 2019/12/19
 * @time 11:52
 */

@Validated //数据校验
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    //  http.../test/findAll
    @ApiOperation(value = "查询所有Test")
    @GetMapping("findAll")
    public Message findAll() {
        List<Test> all = testService.findAll();
        //将返回数据封装为统一格式
        return MessageUtil.success(all);
    }

    @ApiOperation(value = "通过id删除Test")
    @DeleteMapping("deleteById")
    public Message deleteById(long id) {
        testService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "保存或更新", notes = "如果id为空，为保存；id不为空，为修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", paramType = "form"),
            @ApiImplicitParam(name = "name", value = "姓名", paramType = "form", required = true),
            @ApiImplicitParam(name = "age", value = "年龄", paramType = "form", required = true)
    })
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Long id, @NotNull String name, @NotNull Integer age) {
        Test test = new Test(id, name, age);
        testService.saveOrUpdate(test);
        return MessageUtil.success("更新成功");
    }
}
