package com.yu.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yu.common.valid.AddGroup;
import com.yu.common.valid.UpdateGroup;
import com.yu.common.valid.UpdateStatusGroup;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * 品牌
 * 
 * @author yu
 * @email 183213557@qq.com
 * @date 2020-12-02 22:25:22
 *
 * @NotNull、@NotEmpty、@NotBlank区别：
 *  *  @NotNull：可以作用于属性，对象，集合，不能为null，但可以为empty,没有Size的约束(空串也可以)
 *  *  @NotEmpty：可以作用于属性，对象，集合，不能为null或者长度为0(" "可以)
 *  *  @NotBlank：只用于String,不能为null且trim()之后size>0
 *  若添加分组属性，没加分组的则不会执行
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@NotNull(message = "修改必须指定品牌id", groups = {UpdateGroup.class})
	@Null(message = "新增不能指定品牌id", groups = {AddGroup.class})
	@TableId
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌名不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotBlank(message = "品牌logo地址不能为空", groups = {AddGroup.class})
	@URL(message = "Logo必须是一个合法的url地址", groups = {AddGroup.class, UpdateGroup.class})
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	@NotNull(message = "显示状态不能为空", groups = UpdateStatusGroup.class)
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	//Pattern：自定义规则，必须填一个正则表达式
	@Pattern(regexp = "^[a-zA-Z]$", message = "检索首字母必须是一个字母", groups = {AddGroup.class, UpdateGroup.class})
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull
	@Min(value = 0, message = "排序必须大于等于0", groups = {AddGroup.class, UpdateGroup.class})
	private Integer sort;

}
