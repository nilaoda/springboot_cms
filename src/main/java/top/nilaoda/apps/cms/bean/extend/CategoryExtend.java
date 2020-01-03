package top.nilaoda.apps.cms.bean.extend;

import top.nilaoda.apps.cms.bean.Category;

public class CategoryExtend extends Category {
    private Category parent;

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }
}
