package top.nilaoda.apps.cms.mapper;

import top.nilaoda.apps.cms.bean.Test;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TestMapper {
    @Select("select * from test")
    List<Test> findAll();

    @Select("select * from test where name = #{name}")
    Test findByName(String name);

    @Delete("delete from test where id = #{id}")
    int deleteById(long id);

    @Insert("insert into test values(null, #{name}, #{age})")
    int insert(Test test);

    @Update("update test set name = #{name}, age = #{age} where id = #{id}")
    int update(Test test);
}
