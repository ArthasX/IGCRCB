/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0123Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * 概述: 设备详细信息检索结果ＶＯ
 * 功能描述: 设备详细信息检索结果ＶＯ
 * 创建记录: 2011/05/19
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGCIM03081VO extends BaseVO implements Serializable{
	
	/**
	 * @param soc0124List
	 * @param entityItemVWInfoMap
	 */
	public IGCIM03081VO(List<SOC0124Info> soc0124List,
			Map<String, List<SOC0123Info>> entityItemVWInfoMap) {
		super();
		this.soc0124List = soc0124List;
		this.entityItemVWInfoMap = entityItemVWInfoMap;
	}

	/** 设备信息检索结果 */
	protected List<SOC0124Info> soc0124List;
	
	/** 被影响的设备信息 */
	protected Map<String,List<SOC0123Info>> entityItemVWInfoMap;
	




	/**
	 * @param soc0124List
	 * @param entityItemVWInfoMap
	 */
	public IGCIM03081VO() {
		super();
	}

	/**
	 * 被影响的设备信息取得
	 * @return entityItemVWInfoMap被影响的设备信息
	 */
	public Map<String, List<SOC0123Info>> getEntityItemVWInfoMap() {
		return entityItemVWInfoMap;
	}
	
	/**
	 * 被影响的设备信息设定
	 * @param entityItemVWInfoMap被影响的设备信息
	 */
	public void setEntityItemVWInfoMap(
			Map<String, List<SOC0123Info>> entityItemVWInfoMap) {
		this.entityItemVWInfoMap = entityItemVWInfoMap;
	}

	/**
	 * 设备信息检索结果取得
	 *
	 * @return soc0124List 设备信息检索结果
	 */
	public List<SOC0124Info> getSoc0124List() {
		return soc0124List;
	}

	/**
	 * 设备信息检索结果设定
	 *
	 * @param soc0124List 设备信息检索结果
	 */
	public void setSoc0124List(List<SOC0124Info> soc0124List) {
		this.soc0124List = soc0124List;
	}
	
}
