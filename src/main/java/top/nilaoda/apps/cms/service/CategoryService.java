package top.nilaoda.apps.cms.service;

import top.nilaoda.apps.cms.bean.Category;
import top.nilaoda.apps.cms.bean.extend.CategoryExtend;
import top.nilaoda.apps.cms.util.PageVM;

import java.util.List;

public interface CategoryService {
    List<CategoryExtend> findAll();

    List<Category> findAllParent();

    PageVM<CategoryExtend> pageQuery(int page, int pageSize);

    Category findById(long id);

    long saveOrUpdate(Category category);

    long deleteById(long id);
}
