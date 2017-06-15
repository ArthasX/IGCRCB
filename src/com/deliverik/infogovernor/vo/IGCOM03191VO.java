/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.SOC0130Info;
import com.deliverik.framework.soc.asset.SOC0131Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;

/**
 * 概述: 设备关系信息VO
 * 功能描述: 设备关系信息VO
 * 创建记录: 2011/05/04
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGCOM03191VO extends BaseVO implements Serializable{
	
	/** 配置项信息 */
	protected IG688Info entityItemData;
	
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<IG002Info>> configItemVWInfoMap;
	
	/** 权限标识 */
	protected Boolean flag;
	
	/** 资产项配置信息检索结果(SOC) */
	protected Map<String,Map<String,List<IG002Info>>> configInfoMap;
	
	/** 设备关系（FS-LV-VG） */
	protected List<SOC0130Info> fsLvVgInfoList;
	
	/** 设备关系（VG-PV-META） */
	protected List<SOC0131Info> vgPvMetaInfoList;
	
	/** 资产模型名称 */
	protected String ename;
	
	/** 设备所属机构名称 */
	protected String eiorgname;
	
	/** 资产信息 */
	protected IG013Info entityItem;
	
	protected Map<String,List<String>> cname_map;
	
	protected Map<String,List<String>> einame_map;
	
	
	protected List<String> namelist;
	
	protected Map<String,Map<String,String>> eimap;
	
	private SOC0118Info soc0118Info;
	
	public SOC0118Info getSoc0118Info() {
		return soc0118Info;
	}

	public void setSoc0118Info(SOC0118Info soc0118Info) {
		this.soc0118Info = soc0118Info;
	}
	
	public Map<String, Map<String, String>> getEimap() {
		return eimap;
	}

	public void setEimap(Map<String, Map<String, String>> eimap) {
		this.eimap = eimap;
	}
	
	public List<String> getNamelist() {
		return namelist;
	}

	public void setNamelist(List<String> namelist) {
		this.namelist = namelist;
	}

	public Map<String, List<String>> getEiname_map() {
		return einame_map;
	}

	public void setEiname_map(Map<String, List<String>> einame_map) {
		this.einame_map = einame_map;
	}
	
	
	public Map<String, List<String>> getCname_map() {
		return cname_map;
	}

	public void setCname_map(Map<String, List<String>> cname_map) {
		this.cname_map = cname_map;
	}
	
	public IG688Info getEntityItemData() {
		return entityItemData;
	}

	public void setEntityItemData(IG688Info entityItemData) {
		this.entityItemData = entityItemData;
	}

	
	public IG013Info getEntityItem() {
		return entityItem;
	}

	public void setEntityItem(IG013Info entityItem) {
		this.entityItem = entityItem;
	}

	public Map<String, Map<String, List<IG002Info>>> getConfigInfoMap() {
		return configInfoMap;
	}

	public void setConfigInfoMap(
			Map<String, Map<String, List<IG002Info>>> configInfoMap) {
		this.configInfoMap = configInfoMap;
	}

	
	
	public Boolean getFlag() {
		return flag;
	}

//	public Map<String, List<ConfigItemVWInfo>> getConfigInfoMap() {
//		return configInfoMap;
//	}
//
//	public void setConfigInfoMap(Map<String, List<ConfigItemVWInfo>> configInfoMap) {
//		this.configInfoMap = configInfoMap;
//	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	

	/**
	 * 构造函数
	 * @param entityItemData　资产项信息
	 * @param configItemVWInfoMap　资产项配置信息检索结果
	 */
	public IGCOM03191VO(IG688Info entityItemData,Map<String,List<IG002Info>> configItemVWInfoMap) {
		this.entityItemData = entityItemData;
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	
	/**
	 * 构造函数
	 */
	public IGCOM03191VO(List<SOC0130Info> fsLvVgInfoList,
			List<SOC0131Info> vgPvMetaInfoList) {
		super();
		this.fsLvVgInfoList = fsLvVgInfoList;
		this.vgPvMetaInfoList = vgPvMetaInfoList;
	}

	
	/**
	 * 配置项信息取得
	 * @return 配置项信息
	 */
	public IG688Info getEntityData() {
		return entityItemData;
	}

	public Map<String, List<IG002Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

	/**
	 * 设备关系（FS-LV-VG）取得
	 * @return 设备关系（FS-LV-VG）
	 */
	public List<SOC0130Info> getFsLvVgInfoList() {
		return fsLvVgInfoList;
	}
	
	/**
	 * 设备关系（FS-LV-VG）设定
	 * @param igcom0319Form设备关系（FS-LV-VG）
	 */
	public void setFsLvVgInfoList(List<SOC0130Info> fsLvVgInfoList) {
		this.fsLvVgInfoList = fsLvVgInfoList;
	}
	
	/**
	 * 设备关系（VG-PV-META）取得
	 * @return 设备关系（VG-PV-META）
	 */
	public List<SOC0131Info> getVgPvMetaInfoList() {
		return vgPvMetaInfoList;
	}

	/**
	 * 设备关系（VG-PV-META）设定
	 * @param vgPvMetaBean设备关系（VG-PV-META）
	 */
	public void setVgPvMetaInfoList(List<SOC0131Info> vgPvMetaInfoList) {
		this.vgPvMetaInfoList = vgPvMetaInfoList;
	}
	
	/**
	 * 资产模型名称取得
	 * @return 资产模型名称
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * 资产模型名称设定
	 * @param ename资产模型名称
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * 设备所属机构名称
	 * @return 设备所属机构名称
	 */
	public String getEiorgname() {
		return eiorgname;
	}

	/**
	 * 设备所属机构名称
	 * @param eiorgname设备所属机构名称
	 */
	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	

	
	
	
	
	
}


