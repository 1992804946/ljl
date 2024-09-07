package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;

import java.util.List;

public interface CategoryService {
    /**
     * 新增菜品分类
     * @param categoryDTO
     */
    public void save(CategoryDTO categoryDTO);

    /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 修改菜品分类
     * @param categoryDTO
     */
    void updateCategory(CategoryDTO categoryDTO);

    /**
     * 启用禁用菜品分类
     * @param status
     * @param id
     */

    void startOrStop(Integer status, Long id);

    /**
     * 根据id删除菜品
     * @param id
     */

    void deleteById(Long id);

    /**
     * 根据类型查询分类
     * @param type
     * @return
     */

    List<Category> list(Integer type);
}
