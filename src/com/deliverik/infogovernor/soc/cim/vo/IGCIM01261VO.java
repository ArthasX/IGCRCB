package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * 应用关系信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM01261VO extends BaseVO implements Serializable{
	
	/** 设备信息 */
	protected SOC0124Info entityItemData;
	
	/** 资产项关系管理信息检索结果1 */
	protected Map<String,List<SOC0119Info>> parEntityItemRelationMap;
	
	/** 资产项关系管理信息检索结果2 */
	protected Map<String,List<SOC0119Info>> cldEntityItemRelationMap;
	
	/** 资产项关系信息1件数 */
	protected int parCount;
	
	/** 资产项关系信息2件数 */
	protected int cldCount;
	/** 应用所属机构名称 */
	protected String eiorgname;
	
	/** 权限标识 */
	protected Boolean flag;
	
	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	
	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}
	/**
	 * 构造函数
	 * @param entityItemData　设备信息
	 * @param parEntityItemRelationMap　资产项关系信息1
	 * @param cldEntityItemRelationList　资产项关系信息2
	 * @param parCount　资产项关系信息1件数
	 * @param cldCount　资产项关系信息2件数
	 */
	public IGCIM01261VO(SOC0124Info entityItemData,
			Map<String,List<SOC0119Info>> parEntityItemRelationMap,
			Map<String,List<SOC0119Info>> cldEntityItemRelationMap,
			int parCount,
			int cldCount) {
		this.entityItemData = entityItemData;
		this.parEntityItemRelationMap = parEntityItemRelationMap;
		this.cldEntityItemRelationMap = cldEntityItemRelationMap;
		this.parCount = parCount;
		this.cldCount = cldCount;
		
	}
	
	/**
	 * 设备信息取得
	 * @return 设备信息
	 */
	public SOC0124Info getEntityData() {
		return entityItemData;
	}

	/**
	 * 资产项关系管理信息检索结果1取得
	 * @return 资产项关系管理信息检索结果1
	 */
	public Map<String, List<SOC0119Info>> getParEntityItemRelationMap() {
		return parEntityItemRelationMap;
	}

	/**
	 * 资产项关系管理信息检索结果1设定
	 *
	 * @param username 资产项关系管理信息检索结果1
	 */
	public void setParEntityItemRelationMap(
			Map<String, List<SOC0119Info>> parEntityItemRelationMap) {
		this.parEntityItemRelationMap = parEntityItemRelationMap;
	}

	/**
	 * 资产项关系管理信息检索结果2取得
	 * @return 资产项关系管理信息检索结果2
	 */
	public Map<String, List<SOC0119Info>> getCldEntityItemRelationMap() {
		return cldEntityItemRelationMap;
	}

	/**
	 * 资产项关系管理信息检索结果2设定
	 *
	 * @param cldEntityItemRelationMap 资产项关系管理信息检索结果2
	 */
	public void setCldEntityItemRelationMap(
			Map<String, List<SOC0119Info>> cldEntityItemRelationMap) {
		this.cldEntityItemRelationMap = cldEntityItemRelationMap;
	}

	/**
	 * 资产项关系信息1件数取得
	 * @return 资产项关系信息1件数
	 */
	public int getParCount() {
		return parCount;
	}

	/**
	 * 资产项关系信息2件数设定
	 *
	 * @param parCount 资产项关系信息2件数
	 */
	public void setParCount(int parCount) {
		this.parCount = parCount;
	}

	/**
	 * 资产项关系信息1件数取得
	 * @return 资产项关系信息1件数
	 */
	public int getCldCount() {
		return cldCount;
	}

	/**
	 * 资产项关系信息2件数设定
	 *
	 * @param cldCount 资产项关系信息2件数
	 */
	public void setCldCount(int cldCount) {
		this.cldCount = cldCount;
	}
}


