package com.yu.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yu.common.utils.PageUtils;
import com.yu.mall.coupon.entity.CouponSpuCategoryRelationEntity;

import java.util.Map;

/**
 * 优惠券分类关联
 *
 * @author yu
 * @email 183213557@qq.com
 * @date 2020-12-03 20:49:08
 */
public interface CouponSpuCategoryRelationService extends IService<CouponSpuCategoryRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

