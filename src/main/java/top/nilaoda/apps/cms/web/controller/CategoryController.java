package top.nilaoda.apps.cms.web.controller;

import top.nilaoda.apps.cms.bean.Category;
import top.nilaoda.apps.cms.bean.extend.CategoryExtend;
import top.nilaoda.apps.cms.service.CategoryService;
import top.nilaoda.apps.cms.util.CustomerException;
import top.nilaoda.apps.cms.util.Message;
import top.nilaoda.apps.cms.util.MessageUtil;
import top.nilaoda.apps.cms.util.PageVM;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "查询所有分类")
    @GetMapping("findAll")
    public Message findAll() {
        List<CategoryExtend> data = categoryService.findAll();
        return MessageUtil.success(data);
    }

    @ApiOperation(value = "查询所有父级分类")
    @GetMapping("findAllParent")
    public Message findAllParent() {
        List<Category> data = categoryService.findAllParent();
        return MessageUtil.success(data);
    }

    //分页查询
    @ApiOperation("分页查询所有")
    @GetMapping("pageQueryAll")
    public Message pageQueryAll(int page, int pageSize) {
        PageVM<CategoryExtend> data = categoryService.pageQuery(page, pageSize);
        return MessageUtil.success(data);
    }

    @GetMapping("findById")
    public Message findById(long id) {
        Category data = categoryService.findById(id);
        return MessageUtil.success(data);
    }

    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Category category) throws CustomerException {
        categoryService.saveOrUpdate(category);
        return MessageUtil.success("更新成功");
    }

    @DeleteMapping("deleteById")
    public Message deleteById(long id) {
        categoryService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
}
