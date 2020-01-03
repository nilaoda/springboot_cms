package top.nilaoda.apps.cms.mapper.extend;

import top.nilaoda.apps.cms.bean.Comment;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommentExtendMapper {
    @Select("select * from cms_comment limit ${(page-1)*pageSize},${pageSize}")
    @Results({@Result(id = true, column = "id", property = "id"),
            @Result(column = "article_id", property = "articleId"),
            @Result(column = "parent_id", property = "parentId")})
    List<Comment> pageQuery(int page, int pageSize);

    @Select("select count(*) from cms_comment")
    long queryTotalCount();
}
