/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0305Info;
import com.deliverik.framework.soc.asset.model.SOC0307Info;
import com.deliverik.infogovernor.kgm.model.Knowledge;

/**
 * 概述: 应用管理首页显示Action处理
 * 功能描述: 应用管理首页显示Action处理
 * 创建记录: 2012/03/01
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGCOM02181VO extends BaseVO implements Serializable{
	
	/** 告警信息 */
	protected List<SOC0305Info> soc0305List;
	
	/** 告警视图信息 */
	protected List<SOC0307Info> soc0307List;

	/** 知识信息 */
	protected List<Knowledge> knowledgeList;

	/**
	 * 告警信息取得
	 *
	 * @return soc0305List 告警信息
	 */
	public List<SOC0305Info> getSoc0305List() {
		return soc0305List;
	}

	/**
	 * 告警信息设定
	 *
	 * @param soc0305List 告警信息
	 */
	public void setSoc0305List(List<SOC0305Info> soc0305List) {
		this.soc0305List = soc0305List;
	}

	

	/**
	 * 知识信息取得
	 *
	 * @return knowledgeList 知识信息
	 */
	public List<Knowledge> getKnowledgeList() {
		return knowledgeList;
	}

	/**
	 * 知识信息设定
	 *
	 * @param knowledgeList 知识信息
	 */
	public void setKnowledgeList(List<Knowledge> knowledgeList) {
		this.knowledgeList = knowledgeList;
	}

	/**
	 * 告警视图信息取得
	 *
	 * @return soc0307List 告警视图信息
	 */
	public List<SOC0307Info> getSoc0307List() {
		return soc0307List;
	}

	/**
	 * 告警视图信息设定
	 *
	 * @param soc0307List 告警视图信息
	 */
	public void setSoc0307List(List<SOC0307Info> soc0307List) {
		this.soc0307List = soc0307List;
	}



	
	
}


