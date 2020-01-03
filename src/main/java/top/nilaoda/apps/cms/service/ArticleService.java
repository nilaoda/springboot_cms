package top.nilaoda.apps.cms.service;

import top.nilaoda.apps.cms.bean.Article;
import top.nilaoda.apps.cms.bean.extend.ArticleExtend;
import top.nilaoda.apps.cms.util.CustomerException;
import top.nilaoda.apps.cms.util.PageVM;

import java.util.List;

public interface ArticleService {
    List<Article> findAll();

    Article findById(long id);

    List<ArticleExtend> findAllWithAuthorAndCategory();

    List<ArticleExtend> findByTitleWithAuthorAndCategory(String title);

    ArticleExtend findByIdWithAuthorAndCategory(long id);

    long saveOrUpdate(Article article) throws CustomerException;

    long deleteById(long id) throws CustomerException;

    long batchDelete(long[] ids) throws CustomerException;

    PageVM<ArticleExtend> pageQuery(int page, int pageSize);
}
