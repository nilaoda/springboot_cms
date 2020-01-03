package top.nilaoda.apps.cms.service;

import top.nilaoda.apps.cms.bean.Comment;
import top.nilaoda.apps.cms.util.PageVM;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    List<Comment> findByContent(String content);

    Comment findById(long id);

    long saveOrUpdate(Comment comment);

    long deleteById(long id);

    PageVM<Comment> pageQuery(int page, int pageSize);
}
