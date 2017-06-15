/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0104Info;
import com.deliverik.framework.soc.asset.model.SOC0105Info;

/**
 * 概述: 审计控制台显示VO
 * 功能描述: 审计控制台显示VO
 * 创建记录: 2011/04/29
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGCIM03011VO extends BaseVO implements Serializable{
	
	/** 配置导入任务列表 */
	protected List<SOC0105Info> soc0105List;
	
	/** 审计任务 */
	protected SOC0104Info soc0104Info;

	/**
	 * 配置导入任务列表取得
	 *
	 * @return soc0105List 配置导入任务列表
	 */
	public List<SOC0105Info> getSoc0105List() {
		return soc0105List;
	}

	/**
	 * 配置导入任务列表设定
	 *
	 * @param soc0105List 配置导入任务列表
	 */
	public void setSoc0105List(List<SOC0105Info> soc0105List) {
		this.soc0105List = soc0105List;
	}

	/**
	 * 审计任务取得
	 *
	 * @return soc0104Info 审计任务
	 */
	public SOC0104Info getSoc0104Info() {
		return soc0104Info;
	}

	/**
	 * @param soc0105List
	 * @param soc0104Info
	 */
	public IGCIM03011VO(List<SOC0105Info> soc0105List, SOC0104Info soc0104Info) {
		super();
		this.soc0105List = soc0105List;
		this.soc0104Info = soc0104Info;
	}
	

	
}


