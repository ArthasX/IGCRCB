package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0605Info;
import com.deliverik.framework.soc.asset.model.SOC0606Info;

/**
 * @Description: ������Ϣ�֣�
 * @History 2010-5-07     0000428: ���ӻ������Թ���
 * 
 */
@SuppressWarnings("serial")
public class IGASM11021VO extends BaseVO implements Serializable {
	
	protected List<SOC0109Info> configurationList;
	
	protected List<SOC0606Info> configItemVWInfoList;
	
	/** ������Ϣ */
	protected SOC0605Info entityItemData;
	

	/**
	 * ���캯��
	 * @param entityItemData���ʲ�����Ϣ
	 * @param configItemVWInfoMap���ʲ���������Ϣ�������
	 */
	public IGASM11021VO(SOC0605Info entityItemData) {
		this.entityItemData = entityItemData;
	}

	/**
	 * ������Ϣȡ��
	 * @return ������Ϣ
	 */
	public SOC0605Info getEntityItemData() {
		return entityItemData;
	}


	public List<SOC0109Info> getConfigurationList() {
		return configurationList;
	}

	public void setConfigurationList(List<SOC0109Info> configurationList) {
		this.configurationList = configurationList;
	}

	public List<SOC0606Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	public void setConfigItemVWInfoList(List<SOC0606Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

}
