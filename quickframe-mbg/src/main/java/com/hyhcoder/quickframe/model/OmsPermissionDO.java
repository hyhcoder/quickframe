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
 * 后台用户权限表
 * </p>
 *
 * @author hyhcoder
 * @since 2020-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("oms_permission")
public class OmsPermissionDO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	
	/**
	 * 父级权限id
	 */
	private Long pid;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 权限值
	 */
	private String value;
	
	/**
	 * 图标
	 */
	private String icon;
	
	/**
	 * 权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）
	 */
	private Integer type;
	
	/**
	 * 前端资源路径
	 */
	private String uri;
	
	/**
	 * 启用状态；0->禁用；1->启用
	 */
	private Integer status;
	
	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;
	
	/**
	 * 排序
	 */
	private Integer sort;
	
	
}
