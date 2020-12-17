package com.yu.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 字典表
 * 
 * @author yu
 * @email 183213557@qq.com
 * @date 2020-12-17 21:53:41
 */
@Data
@TableName("pms_dic_info")
public class DicInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long dicCode;
	/**
	 * 名称
	 */
	private String dicName;
	/**
	 * 类型(01表示产品计量单位)
	 */
	private String dicType;

}
