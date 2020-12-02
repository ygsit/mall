package com.yu.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yu.common.utils.PageUtils;
import com.yu.mall.product.entity.SkuSaleAttrValueEntity;

import java.util.Map;

/**
 * sku销售属性&值
 *
 * @author yu
 * @email 183213557@qq.com
 * @date 2020-12-02 22:25:22
 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

