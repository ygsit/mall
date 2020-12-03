package com.yu.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yu.common.utils.PageUtils;
import com.yu.mall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author yu
 * @email 183213557@qq.com
 * @date 2020-12-03 23:07:53
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

