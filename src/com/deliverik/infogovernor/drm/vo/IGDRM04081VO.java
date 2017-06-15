/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;

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
public class IGDRM04081VO extends BaseVO{

	protected List<SOC0109Info> configurationList;
	
	protected SOC0118Info entityItemInfo;
	
	protected List<SOC0107Info> entityItemConfigurations;
	
	protected SOC0124Info entityItemVW;
	
	protected List<SOC0129Info> configItemList;

	/**
	 * configurationList   取得
	 * @return configurationList configurationList
	 */
	public List<SOC0109Info> getConfigurationList() {
		return configurationList;
	}

	/**
	 * configurationList   设定
	 * @param configurationList configurationList
	 */
	public void setConfigurationList(List<SOC0109Info> configurationList) {
		this.configurationList = configurationList;
	}

	/**
	 * entityItemInfo   取得
	 * @return entityItemInfo entityItemInfo
	 */
	public SOC0118Info getEntityItemInfo() {
		return entityItemInfo;
	}

	/**
	 * entityItemInfo   设定
	 * @param entityItemInfo entityItemInfo
	 */
	public void setEntityItemInfo(SOC0118Info entityItemInfo) {
		this.entityItemInfo = entityItemInfo;
	}

	/**
	 * entityItemConfigurations   取得
	 * @return entityItemConfigurations entityItemConfigurations
	 */
	public List<SOC0107Info> getEntityItemConfigurations() {
		return entityItemConfigurations;
	}

	/**
	 * entityItemConfigurations   设定
	 * @param entityItemConfigurations entityItemConfigurations
	 */
	public void setEntityItemConfigurations(
			List<SOC0107Info> entityItemConfigurations) {
		this.entityItemConfigurations = entityItemConfigurations;
	}

	/**
	 * entityItemVW   取得
	 * @return entityItemVW entityItemVW
	 */
	public SOC0124Info getEntityItemVW() {
		return entityItemVW;
	}

	/**
	 * entityItemVW   设定
	 * @param entityItemVW entityItemVW
	 */
	public void setEntityItemVW(SOC0124Info entityItemVW) {
		this.entityItemVW = entityItemVW;
	}

	/**
	 * configItemList   取得
	 * @return configItemList configItemList
	 */
	public List<SOC0129Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * configItemList   设定
	 * @param configItemList configItemList
	 */
	public void setConfigItemList(List<SOC0129Info> configItemList) {
		this.configItemList = configItemList;
	}
	
	
	
}
