/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG373Info;

/**
 * 概述: 表单初始化配置查询VO
 * 功能描述: 表单初始化配置查询VO
 * 创建记录: 2012/04/11
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGPRD01651VO extends BaseVO implements Serializable{

	/** 表单初始化配置列表 */
	protected List<IG373Info> lst_IG373Info;
	
	/**
	 * 表单初始化配置列表取得
	 * 
	 * @return 表单初始化配置列表
	 */
	public List<IG373Info> getLst_IG373Info() {
		return lst_IG373Info;
	}

	/**
	 * 表单初始化配置列表设定
	 * 
	 * @param lst_IG373Info 表单初始化配置列表
	 */
	public void setLst_IG373Info(List<IG373Info> lst_IG373Info) {
		this.lst_IG373Info = lst_IG373Info;
	}
	
}


