package top.nilaoda.apps.cms.mapper.extend;

import top.nilaoda.apps.cms.bean.extend.CategoryExtend;

import java.util.List;

public interface CategoryExtendMapper {
    List<CategoryExtend> findAllWithParent();

    List<CategoryExtend> pageQueryWithParent(int page, int pageSize);

    long queryTotalCount();
}
