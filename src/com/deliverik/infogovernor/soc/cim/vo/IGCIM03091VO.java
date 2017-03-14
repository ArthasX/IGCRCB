/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * 概述: 设备详细信息检索结果ＶＯ
 * 功能描述: 设备详细信息检索结果ＶＯ
 * 创建记录: 2011/05/19
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGCIM03091VO extends BaseVO implements Serializable{
	/** 设备信息 */
	protected SOC0124Info soc0124Info;
	
	/** 设备所属机构名称 */
	protected String eiorgname;
	
	/** 权限标识 */
	protected Boolean flag;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;
	
	/** 资产版本列表 */
	protected List<SOC0128Info> soc0128List;

	/**
	 * 设备信息取得
	 *
	 * @return soc0124Info 设备信息
	 */
	public SOC0124Info getSoc0124Info() {
		return soc0124Info;
	}

	/**
	 * 设备信息设定
	 *
	 * @param soc0124Info 设备信息
	 */
	public void setSoc0124Info(SOC0124Info soc0124Info) {
		this.soc0124Info = soc0124Info;
	}

	/**
	 * 设备所属机构名称取得
	 *
	 * @return eiorgname 设备所属机构名称
	 */
	public String getEiorgname() {
		return eiorgname;
	}

	/**
	 * 设备所属机构名称设定
	 *
	 * @param eiorgname 设备所属机构名称
	 */
	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	/**
	 * 权限标识取得
	 *
	 * @return flag 权限标识
	 */
	public Boolean getFlag() {
		return flag;
	}

	/**
	 * 权限标识设定
	 *
	 * @param flag 权限标识
	 */
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	/**
	 * 资产项配置信息检索结果取得
	 *
	 * @return configItemVWInfoMap 资产项配置信息检索结果
	 */
	public Map<String, List<SOC0129Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

	/**
	 * 资产项配置信息检索结果设定
	 *
	 * @param configItemVWInfoMap 资产项配置信息检索结果
	 */
	public void setConfigItemVWInfoMap(
			Map<String, List<SOC0129Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}

	/**
	 * 资产版本列表取得
	 *
	 * @return soc0128List 资产版本列表
	 */
	public List<SOC0128Info> getSoc0128List() {
		return soc0128List;
	}

	/**
	 * 资产版本列表设定
	 *
	 * @param soc0128List 资产版本列表
	 */
	public void setSoc0128List(List<SOC0128Info> soc0128List) {
		this.soc0128List = soc0128List;
	}

	/**
	 * @param soc0124Info
	 * @param configItemVWInfoMap
	 */
	public IGCIM03091VO(SOC0124Info soc0124Info, Map<String, List<SOC0129Info>> configItemVWInfoMap) {
		super();
		this.soc0124Info = soc0124Info;
		this.configItemVWInfoMap = configItemVWInfoMap;
	}

	
	

}
