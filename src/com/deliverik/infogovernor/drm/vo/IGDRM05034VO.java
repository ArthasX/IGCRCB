/*
 * ������������Ϣ�������޹�˾��Ȩ����,��������Ȩ��.
 */
package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;

/**
 * ��������ϢVO
 */
@SuppressWarnings("serial")
public class IGDRM05034VO extends BaseVO implements Serializable {
	
	
	/**
	 * ������Ϣ
	 */
	protected SOC0109Info configuration;
	
	/**
	 * ��������Ϣ�������
	 */
	protected List<SOC0107Info> configItemList;
	
	/**
	 * ���캯��
	 * 
	 * @param ci ��������Ϣ
	 */
	public IGDRM05034VO(SOC0107Info ci) {
		setConfiguration(ci.getConfiguration());
		addConfigItem(ci);
	}

	/**
	 * ��������Ϣ�������ȡ��
	 * @return ��������Ϣ�������
	 */
	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * ��������Ϣ��������趨
	 * @param configItemList ��������Ϣ�������
	 */
	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * ������Ϣȡ��
	 * @return ������Ϣ
	 */
	public SOC0109Info getConfiguration() {
		return configuration;
	}

	/**
	 * ������Ϣ�趨
	 * @param info ������Ϣ
	 */
	public void setConfiguration(SOC0109Info info) {
		this.configuration = info;
	}

	/**
	 * �����������Ϣ
	 * 
	 * @param ci ��������Ϣ
	 */
	public void addConfigItem(SOC0107Info ci) {
		if(this.configItemList == null) {
			this.configItemList = new ArrayList<SOC0107Info>();
		} 
		this.configItemList.add(ci);
	}
	
}
