package top.nilaoda.apps.cms.web.controller;

import top.nilaoda.apps.cms.bean.Article;
import top.nilaoda.apps.cms.bean.extend.ArticleExtend;
import top.nilaoda.apps.cms.service.ArticleService;
import top.nilaoda.apps.cms.util.ExcelUtils;
import top.nilaoda.apps.cms.util.Message;
import top.nilaoda.apps.cms.util.MessageUtil;
import top.nilaoda.apps.cms.util.PageVM;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Validated
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @ApiOperation("查询所有文章")
    @GetMapping("findAll")
    public Message findAllWithAuthorAndCategory() {
        List<ArticleExtend> data = articleService.findAllWithAuthorAndCategory();
        return MessageUtil.success(data);
    }

    @ApiOperation("通过标题查询文章")
    @GetMapping("findByTitle")
    public Message findByTitle(String title) {
        List<ArticleExtend> data = articleService.findByTitleWithAuthorAndCategory(title);
        return MessageUtil.success(data);
    }

    @ApiOperation("通过文章ID查询文章")
    @GetMapping("finById")
    public Message findByIdWithAuthorAndCategory(long id) {
        ArticleExtend data = articleService.findByIdWithAuthorAndCategory(id);
        return MessageUtil.success(data);
    }

    @PostMapping("saveOrUpdate")
    @ApiOperation(value = "保存或更新", notes = "如果id为空，为保存；id不为空，为修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", paramType = "form"),
            @ApiImplicitParam(name = "title", value = "标题", paramType = "form", required = true),
            @ApiImplicitParam(name = "content", value = "内容", paramType = "form", required = true),
            @ApiImplicitParam(name = "source", value = "源", paramType = "form"),
            @ApiImplicitParam(name = "authorId", value = "作者id", paramType = "form", required = true),
            @ApiImplicitParam(name = "category", value = "分类id", paramType = "form", required = true)
    })
    public Message saveOrUpdate(@NotNull Long id,
                                @NotNull String title,
                                @NotNull String content,
                                String source,
                                @NotNull long authorId,
                                @NotNull long categoryId) {
        Article article = articleService.findById(id);
        article.setId(id);
        article.setTitle(title);
        article.setContent(content);
        article.setSource(source);
        article.setAuthorId(authorId);
        article.setCategoryId(categoryId);

        articleService.saveOrUpdate(article);
        return MessageUtil.success("更新成功");
    }

    @ApiOperation("通过id删除文章")
    @DeleteMapping("deleteById")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "主键", paramType = "query", required = true)})
    public Message deleteById(@NotNull long id) {
        articleService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    //ids=1&ids=2&ids=3                 springmvc
    //ids[0]=1&ids[1]=2&ids[2]=3        struts2
    @ApiOperation("通过id批量删除文章")
    @PostMapping("batchDelete")
    public Message batchDelete(long[] ids) {
        articleService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }

    //分页查询
    @ApiOperation("分页查询所有")
    @GetMapping("pageQueryAll")
    public Message pageQueryAll(int page, int pageSize) {
        PageVM<ArticleExtend> pageVM = articleService.pageQuery(page, pageSize);
        return MessageUtil.success(pageVM);
    }

    @ApiOperation("导出为Excel")
    @GetMapping("export")
    public void export(HttpServletResponse response) throws Exception {
        //查出所有数据
        List<ArticleExtend> all = articleService.findAllWithAuthorAndCategory();
        //导出Excel
        String excelName = "articles";
        String[] headList = new String[]{"编号", "标题", "作者", "所属栏目", "发布日期"};
        String[] fieldList = new String[]{"id", "title", "authorName", "categoryName", "publishTime"};
        List<Map<String, Object>> dataList = new ArrayList<>();
        for (ArticleExtend article : all) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", article.getId());
            map.put("title", article.getTitle());
            map.put("authorName", article.getAuthor() != null ? article.getAuthor().getUsername() : "");
            map.put("categoryName", article.getCategory() != null ? article.getCategory().getName() : "");
            map.put("publishTime", article.getPublishTime());
            dataList.add(map);
        }
        //调用工具类
        ExcelUtils.createExcel(response, excelName, headList, fieldList, dataList);
    }
}
