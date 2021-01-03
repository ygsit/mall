package com.yu.mall.product.dao;

import com.yu.mall.product.entity.CategoryBrandRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 品牌分类关联
 * 
 * @author yu
 * @email 183213557@qq.com
 * @date 2020-12-02 22:25:22
 */
@Mapper
public interface CategoryBrandRelationDao extends BaseMapper<CategoryBrandRelationEntity> {

    //根据品牌id更新品牌名
    void updateBrand(@Param("brandId") Long brandId, @Param("brandName") String brandName);

    //根据分类id更新分裂名
    void updateCategory(@Param("catelogId") Long catelogId, @Param("catelogName") String catelogName);

}
