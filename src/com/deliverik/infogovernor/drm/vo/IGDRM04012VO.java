/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0129Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: Ӧ����Դ�Ǽ�VO
 * </p>
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM04012VO extends BaseVO{

	protected List<SOC0109VWInfo> configurationList;
	
	protected SOC0118Info entityItemInfo;
	
	protected List<SOC0107Info> entityItemConfigurations;
	
	protected SOC0118VWInfo entityItemVW;
	
	protected List<SOC0129Info> configItemList;

	/**
	 * configurationList   ȡ��
	 * @return configurationList configurationList
	 */
	public List<SOC0109VWInfo> getConfigurationList() {
		return configurationList;
	}

	/**
	 * configurationList   �趨
	 * @param configurationList configurationList
	 */
	public void setConfigurationList(List<SOC0109VWInfo> configurationList) {
		this.configurationList = configurationList;
	}

	/**
	 * entityItemInfo   ȡ��
	 * @return entityItemInfo entityItemInfo
	 */
	public SOC0118Info getEntityItemInfo() {
		return entityItemInfo;
	}

	/**
	 * entityItemInfo   �趨
	 * @param entityItemInfo entityItemInfo
	 */
	public void setEntityItemInfo(SOC0118Info entityItemInfo) {
		this.entityItemInfo = entityItemInfo;
	}

	/**
	 * entityItemConfigurations   ȡ��
	 * @return entityItemConfigurations entityItemConfigurations
	 */
	public List<SOC0107Info> getEntityItemConfigurations() {
		return entityItemConfigurations;
	}

	/**
	 * entityItemConfigurations   �趨
	 * @param entityItemConfigurations entityItemConfigurations
	 */
	public void setEntityItemConfigurations(
			List<SOC0107Info> entityItemConfigurations) {
		this.entityItemConfigurations = entityItemConfigurations;
	}

	/**
	 * entityItemVW   ȡ��
	 * @return entityItemVW entityItemVW
	 */
	public SOC0118VWInfo getEntityItemVW() {
		return entityItemVW;
	}

	/**
	 * entityItemVW   �趨
	 * @param entityItemVW entityItemVW
	 */
	public void setEntityItemVW(SOC0118VWInfo entityItemVW) {
		this.entityItemVW = entityItemVW;
	}

	/**
	 * configItemList   ȡ��
	 * @return configItemList configItemList
	 */
	public List<SOC0129Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * configItemList   �趨
	 * @param configItemList configItemList
	 */
	public void setConfigItemList(List<SOC0129Info> configItemList) {
		this.configItemList = configItemList;
	}
	
	
	
}
