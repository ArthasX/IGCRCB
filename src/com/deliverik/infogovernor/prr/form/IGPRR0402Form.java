/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 一级菜单下的服务目录列表
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR0402Form extends BaseForm{

	/** 分类层次码 */
	protected String syscoding;
	
	/** 一级菜单名称 */
	protected String firstActlabel;

	/**
	 * 分类层次码取得
	 * @return syscoding 分类层次码
	 */
	public String getSyscoding() {
		return syscoding;
	}

	/**
	 * 分类层次码设定
	 * @param syscoding 分类层次码
	 */
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

	/**
	 * 一级菜单名称取得
	 * @return firstActlabel 一级菜单名称
	 */
	public String getFirstActlabel() {
		return firstActlabel;
	}

	/**
	 * 一级菜单名称设定
	 * @param firstActlabel 一级菜单名称
	 */
	public void setFirstActlabel(String firstActlabel) {
		this.firstActlabel = firstActlabel;
	}
}
