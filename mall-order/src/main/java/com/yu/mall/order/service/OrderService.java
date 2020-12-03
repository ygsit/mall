package com.yu.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yu.common.utils.PageUtils;
import com.yu.mall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author yu
 * @email 183213557@qq.com
 * @date 2020-12-03 22:59:16
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

