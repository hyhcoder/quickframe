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
 * 后台用户表
 * </p>
 *
 * @author hyhcoder
 * @since 2020-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("oms_user")
public class OmsUserDO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	
	private String username;
	
	private String password;
	
	/**
	 * 头像
	 */
	private String icon;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 昵称
	 */
	private String nickName;
	
	/**
	 * 备注信息
	 */
	private String note;
	
	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;
	
	/**
	 * 最后登录时间
	 */
	private LocalDateTime loginTime;
	
	/**
	 * 帐号启用状态：0->禁用；1->启用
	 */
	private Integer status;
	
	
}
