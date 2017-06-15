/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.model.condition;


/**
 * 概述:虚拟资源统计视图检索条件(按项目)
 * 功能描述:虚拟资源统计视图检索条件(按项目) 
 * 创建记录: 2014/02/19
 * 修改记录: 
 */
public class VIM03CountByProjVWSearchCondImpl implements
		VIM03CountByProjVWSearchCond {

	/**项目名  */
	protected String pname_like;

	/**
	 * 项目名取得
	 * @return pname_like 项目名
	 */
	public String getPname_like() {
		return pname_like;
	}

	/**
	 * 项目名设定
	 * @param pname_like 项目名
	 */
	public void setPname_like(String pname_like) {
		this.pname_like = pname_like;
	}
	
}
