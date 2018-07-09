package com.dagemen.repo;

import com.dagemen.entity.PointUserDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 添加操作，返回新增元素的 ID
     *
     * @param personDO
     */
    @Insert("insert into point_user(id,phone,real_name) values(#{id},#{phone},#{realName})")
    void insert(PointUserDO personDO);

    /**
     * 更新操作
     *
     * @param personDO
     * @return 受影响的行数
     */
    @Update("update person set name=#{name},age=#{age} where id=#{id}")
    Long update(PointUserDO personDO);

    /**
     * 删除操作
     *
     * @param id
     * @return 受影响的行数
     */
    @Delete("delete from person where id=#{id}")
    Long delete(@Param("id") Long id);

    /**
     * 查询所有
     *
     * @return
     */
    @Select("select id,name,age from person")
    List<PointUserDO> selectAll();

    /**
     * 根据主键查询单个
     *
     * @param id
     * @return
     */
    @Select("select id,name,age from person where id=#{id}")
    PointUserDO selectById(@Param("id") Long id);



    @Select("select id,name,age from ${p} where id=#{id}")
    List<PointUserDO> selectPage(@Param("id") Long id,@Param("p") String person);
}
