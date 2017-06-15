/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0104Info;

/**
 * 概述: 审计任务信息检索结果ＶＯ
 * 功能描述: 审计任务信息检索结果ＶＯ
 * 创建记录: 2011/05/19
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGCIM03071VO extends BaseVO implements Serializable {
	
	/** 审计任务检索结果 */
	protected List<SOC0104Info> soc0104List;

	/**
	 * 审计任务检索结果取得
	 *
	 * @return soc0104List 审计任务检索结果
	 */
	public List<SOC0104Info> getSoc0104List() {
		return soc0104List;
	}

	/**
	 * 审计任务检索结果设定
	 *
	 * @param soc0104List 审计任务检索结果
	 */
	public void setSoc0104List(List<SOC0104Info> soc0104List) {
		this.soc0104List = soc0104List;
	}

	/**
	 * @param soc0104List
	 */
	public IGCIM03071VO(List<SOC0104Info> soc0104List) {
		super();
		this.soc0104List = soc0104List;
	}

	
	
	
	
	
	
}
