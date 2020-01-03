package top.nilaoda.apps.cms.web.controller;

import top.nilaoda.apps.cms.bean.Comment;
import top.nilaoda.apps.cms.service.CommentService;
import top.nilaoda.apps.cms.util.Message;
import top.nilaoda.apps.cms.util.MessageUtil;
import top.nilaoda.apps.cms.util.PageVM;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("findAll")
    public Message findAll() {
        List<Comment> data = commentService.findAll();
        return MessageUtil.success(data);
    }

    @GetMapping("findByContent")
    public Message findByContent(String content) {
        List<Comment> data = commentService.findByContent(content);
        return MessageUtil.success(data);
    }

    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Comment comment) {
        commentService.saveOrUpdate(comment);
        return MessageUtil.success("更新成功");
    }

    @DeleteMapping("deleteById")
    public Message deleteById(long id) {
        commentService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation("分页查询所有")
    @GetMapping("pageQueryAll")
    public Message pageQueryAll(int page, int pageSize) {
        PageVM<Comment> pageVM = commentService.pageQuery(page, pageSize);
        return MessageUtil.success(pageVM);
    }

}
