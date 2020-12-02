package com.yu.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yu.common.utils.PageUtils;
import com.yu.mall.product.entity.CommentReplayEntity;

import java.util.Map;

/**
 * 商品评价回复关系
 *
 * @author yu
 * @email 183213557@qq.com
 * @date 2020-12-02 22:25:22
 */
public interface CommentReplayService extends IService<CommentReplayEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

