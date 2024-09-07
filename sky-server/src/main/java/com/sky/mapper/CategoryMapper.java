package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {
    /**
     * 添加菜品分类
     * @param category
     */
    @Insert("insert into sky_take_out.category(type, name, sort, status," +
            " create_time, update_time, create_user, update_user) values " +
            "(#{type},#{name},#{sort},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    public void insert(Category category);

    /**
     * 查询菜品分类
     * @param categoryPageQueryDTO
     * @return
     */
    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 根据id修改菜品分类
     * @param category
     */
    void update(Category category);

    /**
     * 根据菜品分类id删除
     * @param id
     */
   @Delete("delete from sky_take_out.category where id=#{id}")
    void daleteCategory(Long id);

    /**
     * 根据类型查询分类
     * @param type
     * @return
     */

    List<Category> list(Integer type);
}
