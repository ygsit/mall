package com.yu.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yu.common.utils.PageUtils;
import com.yu.common.utils.Query;
import com.yu.mall.product.dao.BrandDao;
import com.yu.mall.product.dao.CategoryBrandRelationDao;
import com.yu.mall.product.entity.BrandEntity;
import com.yu.mall.product.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Map;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {
    @Autowired
    private CategoryBrandRelationDao categoryBrandRelationDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String) params.get("key");
        QueryWrapper<BrandEntity> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(key)) {
            wrapper.eq("brand_id", key).or().like("name", key);
        }
        IPage<BrandEntity> page = this.page(new Query<BrandEntity>().getPage(params), wrapper);

        return new PageUtils(page);
    }

    @Transactional
    @Override
    public void updateCascade(BrandEntity brand) {
        this.updateById(brand);
        if(!StringUtils.isEmpty(brand.getName())){
            //更新关联表的信息
            categoryBrandRelationDao.updateBrand(brand.getBrandId(), brand.getName());
        }
    }

}