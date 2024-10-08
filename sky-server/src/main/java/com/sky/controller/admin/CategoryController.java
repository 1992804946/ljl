package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api(tags = "分类相关接口")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 新增菜品分类
     * @param categoryDTO
     * @return
     */
    @PostMapping
    @ApiOperation("添加新分类")
    public Result saveCategory(@RequestBody CategoryDTO categoryDTO) {
        log.info("新增分类{}", categoryDTO);
        categoryService.save(categoryDTO);
        return Result.success();
    }

    /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("菜品的分页查询")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO) {
        PageResult pageResult=categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 修改菜品分类
     * @param categoryDTO
     * @return
     */
    @PutMapping
    @ApiOperation("修改菜品分类")
    public Result updateCategory(@RequestBody CategoryDTO categoryDTO) {
        log.info("修改菜品分类{}", categoryDTO);
        categoryService.updateCategory(categoryDTO);
        return Result.success();
    }

    /**
     * 启用禁用菜品分类
     * @param status
     * @param id
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("启用禁用菜品分类")
    public Result startOrStop(@PathVariable("status") Integer status,Long id) {
        categoryService.startOrStop(status,id);
        return Result.success();
    }

    /**
     * 根据id删除菜品分类
     * @param id
     * @return
     */
    @DeleteMapping
    @ApiOperation("根据id删除菜品分类")
   public Result<String> deleteById(Long id) {
        log.info("根据id删除菜品{}",id);
        categoryService.deleteById(id);
        return Result.success();
    }

    /**
     * 根据类型查询分类
     * @param type
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("根据类型查询分类")
   public Result<List<Category>> list(Integer type) {
       List<Category> list=categoryService.list(type);
        return Result.success(list);
    }


}
