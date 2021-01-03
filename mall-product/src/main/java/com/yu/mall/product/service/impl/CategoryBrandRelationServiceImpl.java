package com.yu.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yu.common.utils.PageUtils;
import com.yu.common.utils.Query;
import com.yu.mall.product.dao.BrandDao;
import com.yu.mall.product.dao.CategoryBrandRelationDao;
import com.yu.mall.product.dao.CategoryDao;
import com.yu.mall.product.entity.BrandEntity;
import com.yu.mall.product.entity.CategoryBrandRelationEntity;
import com.yu.mall.product.entity.CategoryEntity;
import com.yu.mall.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("categoryBrandRelationService")
public class CategoryBrandRelationServiceImpl extends ServiceImpl<CategoryBrandRelationDao, CategoryBrandRelationEntity> implements CategoryBrandRelationService {

    @Autowired
    private BrandDao brandDao;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryBrandRelationEntity> page = this.page(
                new Query<CategoryBrandRelationEntity>().getPage(params),
                new QueryWrapper<CategoryBrandRelationEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveDetails(CategoryBrandRelationEntity categoryBrandRelation) {
        //根据品牌id查询品牌
        BrandEntity brandEntity = brandDao.selectById(categoryBrandRelation.getBrandId());
        //根据分类id查询分类
        CategoryEntity categoryEntity = categoryDao.selectById(categoryBrandRelation.getCatelogId());
        categoryBrandRelation.setBrandName(brandEntity.getName());
        categoryBrandRelation.setCatelogName(categoryEntity.getName());
        this.save(categoryBrandRelation);
    }

}