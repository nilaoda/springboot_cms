package top.nilaoda.apps.cms.service.impl;

import top.nilaoda.apps.cms.bean.Category;
import top.nilaoda.apps.cms.bean.CategoryExample;
import top.nilaoda.apps.cms.bean.extend.CategoryExtend;
import top.nilaoda.apps.cms.mapper.CategoryMapper;
import top.nilaoda.apps.cms.mapper.extend.CategoryExtendMapper;
import top.nilaoda.apps.cms.service.CategoryService;
import top.nilaoda.apps.cms.util.CustomerException;
import top.nilaoda.apps.cms.util.PageVM;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private CategoryExtendMapper categoryExtendMapper;

    @Override
    public List<CategoryExtend> findAll() {
        return categoryExtendMapper.findAllWithParent();
    }

    @Override
    public List<Category> findAllParent() {
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andParentIdIsNull();
        return categoryMapper.selectByExample(categoryExample);
    }

    @Override
    public PageVM<CategoryExtend> pageQuery(int page, int pageSize) {
        List<CategoryExtend> data = categoryExtendMapper.pageQueryWithParent(page, pageSize);
        PageVM<CategoryExtend> pageVM = new PageVM<>();
        pageVM.setTotal(categoryExtendMapper.queryTotalCount());
        pageVM.setPageSize(pageSize);
        pageVM.setPage(page);
        pageVM.setList(data);
        return pageVM;
    }

    @Override
    public Category findById(long id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public long saveOrUpdate(Category category) throws CustomerException {
        if (category.getId() == null) {
            CategoryExample categoryExample = new CategoryExample();
            categoryExample.createCriteria().andNameEqualTo(category.getName());
            List<Category> categories = categoryMapper.selectByExample(categoryExample);
            if (categories.size() > 0)
                throw new CustomerException("栏目名已存在");
            return categoryMapper.insert(category);
        } else {
            return categoryMapper.updateByPrimaryKey(category);
        }
    }

    @Override
    public long deleteById(long id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }
}
