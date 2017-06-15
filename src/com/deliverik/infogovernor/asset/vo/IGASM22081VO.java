/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG749Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;

/**
 * 概述: 设备详细信息检索结果ＶＯ
 * 功能描述: 设备详细信息检索结果ＶＯ
 * 创建记录: 2011/05/19
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM22081VO extends BaseVO implements Serializable{
	
	/** 设备信息检索结果 */
	protected List<IG688Info> entityDataList;
	
	/** 被影响的设备信息 */
	protected Map<String,List<IG749Info>> entityItemVWInfoMap;
	
	/**
	 * 构造函数
	 * @param entityData　设备信息检索结果
	 */
	public IGASM22081VO(List<IG688Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * 构造函数
	 */
	public IGASM22081VO() {
		super();
	}

	/**
	 * 设备信息检索结果取得
	 * @return 设备信息检索结果
	 */
	public List<IG688Info> getEntityDataList() {
		return entityDataList;
	}

	/**
	 * 设备信息检索结果设定
	 * @param entityDataList设备信息检索结果
	 */
	public void setEntityDataList(List<IG688Info> entityDataList) {
		this.entityDataList = entityDataList;
	}

	/**
	 * 被影响的设备信息取得
	 * @return entityItemVWInfoMap被影响的设备信息
	 */
	public Map<String, List<IG749Info>> getEntityItemVWInfoMap() {
		return entityItemVWInfoMap;
	}
	
	/**
	 * 被影响的设备信息设定
	 * @param entityItemVWInfoMap被影响的设备信息
	 */
	public void setEntityItemVWInfoMap(
			Map<String, List<IG749Info>> entityItemVWInfoMap) {
		this.entityItemVWInfoMap = entityItemVWInfoMap;
	}
	
}
