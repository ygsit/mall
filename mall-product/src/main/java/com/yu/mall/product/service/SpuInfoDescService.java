package com.yu.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yu.common.utils.PageUtils;
import com.yu.mall.product.entity.SpuInfoDescEntity;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author yu
 * @email 183213557@qq.com
 * @date 2020-12-02 22:25:22
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

