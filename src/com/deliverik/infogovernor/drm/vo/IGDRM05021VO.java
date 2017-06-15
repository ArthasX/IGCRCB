/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 应急资源登记VO
 * </p>
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM05021VO extends BaseVO{

protected List<SOC0118Info> entityItemList;
	
	/** 页面左侧树Json */
	protected String nodeMapJson;

	/**
	 * entityItemList   取得
	 * @return entityItemList entityItemList
	 */
	public List<SOC0118Info> getEntityItemList() {
		return entityItemList;
	}

	/**
	 * entityItemList   设定
	 * @param entityItemList entityItemList
	 */
	public void setEntityItemList(List<SOC0118Info> entityItemList) {
		this.entityItemList = entityItemList;
	}

	/**
	 * nodeMapJson   取得
	 * @return nodeMapJson nodeMapJson
	 */
	public String getNodeMapJson() {
		return nodeMapJson;
	}

	/**
	 * nodeMapJson   设定
	 * @param nodeMapJson nodeMapJson
	 */
	public void setNodeMapJson(String nodeMapJson) {
		this.nodeMapJson = nodeMapJson;
	}
	
	
	
}
