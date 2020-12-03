package com.yu.mall.member.dao;

import com.yu.mall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author yu
 * @email 183213557@qq.com
 * @date 2020-12-03 23:07:53
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
