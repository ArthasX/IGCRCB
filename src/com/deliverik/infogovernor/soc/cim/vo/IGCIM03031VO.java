/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0105Info;

/**
 * 概述: 审计控制台任务查看VO
 * 功能描述: 审计控制台任务查看VO
 * 创建记录: 2011/04/29
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGCIM03031VO extends BaseVO implements Serializable{
	
	/** 审计控制台任务列表 */
	protected SOC0105Info soc0105List;

	/**
	 * 审计控制台任务列表取得
	 *
	 * @return soc0105List 审计控制台任务列表
	 */
	public SOC0105Info getSoc0105List() {
		return soc0105List;
	}

	/**
	 * @param soc0105List
	 */
	public IGCIM03031VO(SOC0105Info soc0105List) {
		super();
		this.soc0105List = soc0105List;
	}

	/**
	 * 审计控制台任务列表设定
	 *
	 * @param soc0105List 审计控制台任务列表
	 */
	public void setSoc0105List(SOC0105Info soc0105List) {
		this.soc0105List = soc0105List;
	}
	

}


