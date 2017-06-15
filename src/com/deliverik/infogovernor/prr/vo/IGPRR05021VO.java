/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * 概述: 流程组成员查询VO
 * 功能描述: 流程组成员查询VO
 * 创建记录: 2015/02/03
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGPRR05021VO extends BaseVO {

	/** 流程组成员列表 */
	protected List<IG500Info> lst_IG500Info;

	/**
	 * 流程组成员列表取得
	 * @return 流程组成员列表
	 */
	public List<IG500Info> getLst_IG500Info() {
		return lst_IG500Info;
	}

	/**
	 * 流程组成员列表设定
	 * @param lst_IG500Info 流程组成员列表
	 */
	public void setLst_IG500Info(List<IG500Info> lst_IG500Info) {
		this.lst_IG500Info = lst_IG500Info;
	}
	
}
