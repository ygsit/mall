package com.yu.mall.coupon.dao;

import com.yu.mall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author yu
 * @email 183213557@qq.com
 * @date 2020-12-03 20:49:08
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
