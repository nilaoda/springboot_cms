package top.nilaoda.apps.cms.bean;

/**
* @author nilaoda
* @version 1.0
* @description 测试类
* @date 2019/12/19
* @time 11:43
*/
public class Test {
    private Long id;
    private String name;
    private Integer age;

    public Test(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Test() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
