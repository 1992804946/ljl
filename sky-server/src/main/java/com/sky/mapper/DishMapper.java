package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DishMapper {
    /**
     * 根据id查询与id关联菜品数量
     * @param categoryId
     * @return
     */
    @Select("select count(id) from sky_take_out.dish where category_id =#{categoryId}")
    Integer countByCategoryId(Long categoryId);
}
