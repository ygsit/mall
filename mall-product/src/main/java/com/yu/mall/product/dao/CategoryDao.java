package com.yu.mall.product.dao;

import com.yu.mall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author yu
 * @email 183213557@qq.com
 * @date 2020-12-02 22:25:22
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
