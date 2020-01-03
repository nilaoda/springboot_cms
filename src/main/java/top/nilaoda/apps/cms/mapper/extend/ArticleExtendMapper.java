package top.nilaoda.apps.cms.mapper.extend;

import top.nilaoda.apps.cms.bean.extend.ArticleExtend;

import java.util.List;

public interface ArticleExtendMapper {
    List<ArticleExtend> findAllWithAuthorAndCategory();

    List<ArticleExtend> pageQueryWithAuthorAndCategory(int page, int pageSize);

    ArticleExtend findByIdWithAuthorAndCategory(long id);

    List<ArticleExtend> findByTitleWithAuthorAndCategory(String title);

    long queryTotalCount();
}
