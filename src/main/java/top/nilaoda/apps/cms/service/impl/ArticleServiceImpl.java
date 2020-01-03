package top.nilaoda.apps.cms.service.impl;

import top.nilaoda.apps.cms.bean.Article;
import top.nilaoda.apps.cms.bean.ArticleExample;
import top.nilaoda.apps.cms.bean.extend.ArticleExtend;
import top.nilaoda.apps.cms.mapper.ArticleMapper;
import top.nilaoda.apps.cms.mapper.extend.ArticleExtendMapper;
import top.nilaoda.apps.cms.service.ArticleService;
import top.nilaoda.apps.cms.util.CustomerException;
import top.nilaoda.apps.cms.util.PageVM;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ArticleExtendMapper articleExtendMapper;

    @Override
    public List<Article> findAll() {
        return articleMapper.selectByExample(null);
    }

    @Override
    public Article findById(long id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ArticleExtend> findAllWithAuthorAndCategory() {
        return articleExtendMapper.findAllWithAuthorAndCategory();
    }

    @Override
    public List<ArticleExtend> findByTitleWithAuthorAndCategory(String title) {
        title = "%" + title + "%";
        return articleExtendMapper.findByTitleWithAuthorAndCategory(title);
    }

    @Override
    public ArticleExtend findByIdWithAuthorAndCategory(long id) {
        return articleExtendMapper.findByIdWithAuthorAndCategory(id);
    }

    @Override
    public long saveOrUpdate(Article article) throws CustomerException {
        if (article.getId() == null) {
            //同一个作者不允许发布相同标题的文章
            ArticleExample articleExample = new ArticleExample();
            articleExample.createCriteria()
                    .andAuthorIdEqualTo(article.getAuthorId())
                    .andTitleEqualTo(article.getTitle());
            List<Article> articles = articleMapper.selectByExample(articleExample);
            if (articles.size() > 0)
                throw new CustomerException("你已发布过同标题文章");

            //初始化部分参数
            article.setReadTimes(0L);
            article.setPublishTime(new Date().getTime());
            article.setThumpDown(0L);
            article.setThumpUp(0L);
            article.setStatus(ArticleExtend.STATUS_UNCHECK); //状态
            return articleMapper.insert(article);
        } else {
            return articleMapper.updateByPrimaryKey(article);
        }
    }

    @Override
    public long deleteById(long id) throws CustomerException {
        Article article = articleMapper.selectByPrimaryKey(id);
        if (article == null)
            throw new CustomerException("该文章不存在");
        return articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public long batchDelete(long[] id) throws CustomerException {
        long count = 0;
        for (long l : id) {
            count += this.deleteById(l);
        }
        return count;
    }

    @Override
    public PageVM<ArticleExtend> pageQuery(int page, int pageSize) {
        //查数据
        List<ArticleExtend> list = articleExtendMapper.pageQueryWithAuthorAndCategory(page, pageSize);
        //查数量
        long total = articleExtendMapper.queryTotalCount();
        //构造对象
        PageVM<ArticleExtend> pageVM = new PageVM<>();
        pageVM.setList(list);
        pageVM.setPage(page);
        pageVM.setPageSize(pageSize);
        pageVM.setTotal(total);
        return pageVM;
    }
}
