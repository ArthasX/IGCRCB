/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.wim.dto;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.wim.form.IGWIM0101Form;

/**
 * @Description 工作项管理DTO
 * 
 * @date 2017年6月9日15:54:29
 * 
 * @author WangLiang
 *
 */
@SuppressWarnings("serial")
public class IGWIM01DTO extends BaseDTO{

	/** 工作项管理Form */
	protected IGWIM0101Form igwim0101Form;
	
	/** 当前登录用户 */
	protected User user;

	/**
	 * 工作项管理Form取得
	 * @return 工作项管理Form
	 */
	public IGWIM0101Form getIgwim0101Form() {
		return igwim0101Form;
	}

	/**
	 * 工作项管理Form设定
	 * @param 工作项管理Form
	 */
	public void setIgwim0101Form(IGWIM0101Form igwim0101Form) {
		this.igwim0101Form = igwim0101Form;
	}

	/**
	 * 当前登录用户取得
	 * @return 当前登录用户
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 当前登录用户设定
	 * @param 当前登录用户
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
