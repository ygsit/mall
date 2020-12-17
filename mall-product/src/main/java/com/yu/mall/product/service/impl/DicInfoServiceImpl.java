package com.yu.mall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yu.common.utils.PageUtils;
import com.yu.common.utils.Query;

import com.yu.mall.product.dao.DicInfoDao;
import com.yu.mall.product.entity.DicInfoEntity;
import com.yu.mall.product.service.DicInfoService;


@Service("dicInfoService")
public class DicInfoServiceImpl extends ServiceImpl<DicInfoDao, DicInfoEntity> implements DicInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DicInfoEntity> page = this.page(
                new Query<DicInfoEntity>().getPage(params),
                new QueryWrapper<DicInfoEntity>()
        );

        return new PageUtils(page);
    }

}