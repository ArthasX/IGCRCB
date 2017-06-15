/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG483Info;

/**
 * 概述: 流程组查询VO
 * 功能描述: 流程组查询VO
 * 创建记录: 2015/02/03
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGPRR05011VO extends BaseVO{

	/** 流程组列表 */
	protected List<IG483Info> lst_IG483Info;

	/**
	 * 流程组列表取得
	 * @return 流程组列表
	 */
	public List<IG483Info> getLst_IG483Info() {
		return lst_IG483Info;
	}

	/**
	 * 流程组列表设定
	 * @param lst_IG483Info 流程组列表
	 */
	public void setLst_IG483Info(List<IG483Info> lst_IG483Info) {
		this.lst_IG483Info = lst_IG483Info;
	}
	
}
