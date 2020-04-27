package com.hyhcoder.quickframe.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 后台角色菜单关系表
 * </p>
 *
 * @author hyhcoder
 * @since 2020-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("oms_role_menu_relation")
public class OmsRoleMenuRelationDO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	
	/**
	 * 角色ID
	 */
	private Long roleId;
	
	/**
	 * 菜单ID
	 */
	private Long menuId;
	
	
}
