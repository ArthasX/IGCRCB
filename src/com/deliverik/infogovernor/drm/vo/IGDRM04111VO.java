package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.drm.model.EmergencyResourceInfo;

/**
 * 资产类型信息检索结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGDRM04111VO extends BaseVO implements Serializable{
	
	/** 资产类型信息检索结果 */
	protected List<SOC0117Info> entityDataList;
	
	/** 机构信息检索结果集 */
	protected List<Organization> orglist;

	/** 资产一级模型信息检索结果集 */
	protected List<SOC0117Info> topEntityList;
	
	/** 资产配置信息检索结果集 */
	protected List<SOC0109Info> configurationList;
	
	/** 取值范围信息检索结果集 */
	protected List<SOC0151Info> ccdList;
	
	/** 用户信息检索结果集 */
	protected List<User> userlist;
	
	/** 取值范围信息检索结果集 */
	protected List<Map<String,List<SOC0109Info>>> configurationMapList;

	/** 应急资源信息检索结果集 */
	protected List<EmergencyResourceInfo> erEntityList;
	 
	/**
	 * @return the erEntityList
	 */
	public List<EmergencyResourceInfo> getErEntityList() {
		return erEntityList;
	}
	/**
	 * @param erEntityList the erEntityList to set
	 */
	public void setErEntityList(List<EmergencyResourceInfo> erEntityList) {
		this.erEntityList = erEntityList;
	}
	/**
	 * 构造函数
	 * @param entityData　资产类型信息检索结果
	 */
//	public IGDRM04111VO(List<SOC0117Info> entityDataList) {
//		this.entityDataList = entityDataList;
//	}
	/**
	 * 构造函数
	 * @param entityData　资产类型信息检索结果
	 */
	public IGDRM04111VO(List<SOC0117Info> entityDataList , List<EmergencyResourceInfo> erEntityList) {
		this.entityDataList = entityDataList;
		this.erEntityList = erEntityList;
	}
	
	



	public List<Map<String, List<SOC0109Info>>> getConfigurationMapList() {
		return configurationMapList;
	}





	public void setConfigurationMapList(
			List<Map<String, List<SOC0109Info>>> configurationMapList) {
		this.configurationMapList = configurationMapList;
	}





	public List<User> getUserlist() {
		return userlist;
	}



	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}



	/**
	 * 资产类型信息检索结果取得
	 * @return 资产类型信息检索结果
	 */
	public List<SOC0117Info> getEntityDataList() {
		return entityDataList;
	}

	/**
	 * @return the orglist
	 */
	public List<Organization> getOrglist() {
		return orglist;
	}

	/**
	 * @param orglist the orglist to set
	 */
	public void setOrglist(List<Organization> orglist) {
		this.orglist = orglist;
	}

	/**
	 * @return the topEntityList
	 */
	public List<SOC0117Info> getTopEntityList() {
		return topEntityList;
	}

	/**
	 * @param topEntityList the topEntityList to set
	 */
	public void setTopEntityList(List<SOC0117Info> topEntityList) {
		this.topEntityList = topEntityList;
	}

	/**
	 * @return the configurationList
	 */
	public List<SOC0109Info> getConfigurationList() {
		return configurationList;
	}

	/**
	 * @param configurationList the configurationList to set
	 */
	public void setConfigurationList(List<SOC0109Info> configurationList) {
		this.configurationList = configurationList;
	}

	/**
	 * @return the ccdList
	 */
	public List<SOC0151Info> getCcdList() {
		return ccdList;
	}

	/**
	 * @param ccdList the ccdList to set
	 */
	public void setCcdList(List<SOC0151Info> ccdList) {
		this.ccdList = ccdList;
	}

	
}


