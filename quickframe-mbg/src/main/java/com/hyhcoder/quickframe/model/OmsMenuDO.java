package com.hyhcoder.quickframe.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 后台菜单表
 * </p>
 *
 * @author hyhcoder
 * @since 2020-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("oms_menu")
public class OmsMenuDO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	
	/**
	 * 父级ID
	 */
	private Long parentId;
	
	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;
	
	/**
	 * 菜单名称
	 */
	private String title;
	
	/**
	 * 菜单级数
	 */
	private Integer level;
	
	/**
	 * 菜单排序
	 */
	private Integer sort;
	
	/**
	 * 前端名称
	 */
	private String name;
	
	/**
	 * 前端图标
	 */
	private String icon;
	
	/**
	 * 前端隐藏
	 */
	private Integer hidden;
	
	
}
