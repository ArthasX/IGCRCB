package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG545Info;
import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;

/**
 * 资产类型信息检索结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM04011VO extends BaseVO implements Serializable{
	
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
	
	/**数据信息树*/
	protected Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	protected String eidInSession;
	
	
	
	public String getEidInSession() {
		return eidInSession;
	}

	public void setEidInSession(String eidInSession) {
		this.eidInSession = eidInSession;
	}

	/**
	 * 构造函数
	 * @param entityData　资产类型信息检索结果
	 */
	public IGCIM04011VO(List<SOC0117Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	public IGCIM04011VO() {}
	
	
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}


	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
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


