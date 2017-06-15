/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;

/**
 * 概述: 设备详细信息检索结果ＶＯ
 * 功能描述: 设备详细信息检索结果ＶＯ
 * 创建记录: 2011/05/19
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM22091VO extends BaseVO implements Serializable{
	/** 设备信息 */
	protected IG688Info entityItemData;
	
	/** 设备所属机构名称 */
	protected String eiorgname;
	
	/** 权限标识 */
	protected Boolean flag;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<IG002Info>> configItemVWInfoMap;
	
	/** 资产版本列表 */
	protected List<IG887Info> configItemVersionTime;
	
	
	
	/**
	 * 构造函数
	 * @param entityItemData　资产项信息
	 * @param configItemVWInfoMap　资产项配置信息检索结果
	 */
	public IGASM22091VO(IG688Info entityItemData,Map<String,List<IG002Info>> configItemVWInfoMap) {
		this.entityItemData = entityItemData;
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	
	
	/**
	 * 设备信息取得
	 * @return 设备信息
	 */
	public IG688Info getEntityItemData() {
		return entityItemData;
	}


	/**
	 * 设备信息设定
	 * @param entityItemData设备信息
	 */
	public void setEntityItemData(IG688Info entityItemData) {
		this.entityItemData = entityItemData;
	}


	/**
	 * 资产版本列表取得
	 * @return 资产版本列表
	 */
	public List<IG887Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}


	/**
	 * 资产版本列表设定
	 * @param configItemVersionTime资产版本列表
	 */
	public void setConfigItemVersionTime(
			List<IG887Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}

	/**
	 * 资产项配置信息检索结果取得
	 * @return 资产项配置信息检索结果
	 */
	public Map<String, List<IG002Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

	/**
	 * 资产项配置信息检索结果设定
	 * @param configItemVWInfoMap资产项配置信息检索结果
	 */
	public void setConfigItemVWInfoMap(
			Map<String, List<IG002Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}

	/**
	 * 设备所属机构名称取得
	 * @return 设备所属机构名称
	 */
	public String getEiorgname() {
		return eiorgname;
	}

	/**
	 * 设备所属机构名称设定
	 * @param eiorgname设备所属机构名称
	 */
	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	/**
	 * 权限标识取得
	 * @return 权限标识
	 */
	public Boolean getFlag() {
		return flag;
	}

	/**
	 * 权限标识设定
	 * @param flag权限标识
	 */
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	
	

}
