/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.workflow.prd.model.IG123Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:机构范围选择vo 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD01311VO extends BaseVO{

	/** 已选机构集合 */
	protected List<IG123Info> pordList;
	
	/** 可选机构集合 */
	protected Map<Organization, List<Organization>> orgTreeMap;
	
	/**
	 * 已选机构集合取得
	 * @return 已选机构集合
	 */
	public List<IG123Info> getPordList() {
		return pordList;
	}

	/**
	 * 已选机构集合设定
	 * @param pordList 已选机构集合
	 */
	public void setPordList(List<IG123Info> pordList) {
		this.pordList = pordList;
	}

	/**
	 * 可选机构集合取得
	 * @return 可选机构集合
	 */
	public Map<Organization, List<Organization>> getOrgTreeMap() {
		return orgTreeMap;
	}

	/**
	 * 可选机构集合设定
	 * @param orgTreeMap 可选机构集合
	 */
	public void setOrgTreeMap(Map<Organization, List<Organization>> orgTreeMap) {
		this.orgTreeMap = orgTreeMap;
	}
}
