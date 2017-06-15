/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.IG622Info;
import com.deliverik.infogovernor.sym.form.IGSYM1802Form;

/**
 * 概述: 首页管理DTO
 * 功能描述：首页管理DTO
 * 创建记录：崔学志    2012/11/14
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSYM18DTO extends BaseDTO implements Serializable{
	
	/** 首页管理信息检索结果 */
	protected List<IG622Info> firstJspInfoList;
	/**首页管理新增form */
	protected IGSYM1802Form igSYM1802Form;
	
	/**
	 * 首页管理新增form获取
	 * @return the igSYM1802Form
	 */
	public IGSYM1802Form getIgSYM1802Form() {
		return igSYM1802Form;
	}
	/**
	 *首页管理新增form设定
	 *	
	 * @param igSYM1802Form the igSYM1802Form to set
	 */
	public void setIgSYM1802Form(IGSYM1802Form igSYM1802Form) {
		this.igSYM1802Form = igSYM1802Form;
	}
	/**
	 * 首页管理信息检索结果 取得
	 * @return the firstJspInfoList
	 */
	public List<IG622Info> getFirstJspInfoList() {
		return firstJspInfoList;
	}
	/**
	 *首页管理信息检索结果设置
	 *	
	 * @param firstJspInfoList the firstJspInfoList to set
	 */
	public void setFirstJspInfoList(List<IG622Info> firstJspInfoList) {
		this.firstJspInfoList = firstJspInfoList;
	}
}


