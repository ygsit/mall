package com.yu.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yu.common.utils.PageUtils;
import com.yu.mall.product.entity.DicInfoEntity;

import java.util.Map;

/**
 * 字典表
 *
 * @author yu
 * @email 183213557@qq.com
 * @date 2020-12-17 21:53:41
 */
public interface DicInfoService extends IService<DicInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

