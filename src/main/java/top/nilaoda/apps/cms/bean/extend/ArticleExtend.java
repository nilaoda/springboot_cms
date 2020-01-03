package top.nilaoda.apps.cms.bean.extend;

import top.nilaoda.apps.cms.bean.Article;
import top.nilaoda.apps.cms.bean.Category;
import top.nilaoda.apps.cms.bean.User;

public class ArticleExtend extends Article {
    public static final String STATUS_UNCHECK = "待审核";
    public static final String STATUS_CHECK_PASS = "审核通过";
    public static final String STATUS_CHECK_NOPASS = "审核未通过";

    private long count;

    private User author;

    private Category category;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
