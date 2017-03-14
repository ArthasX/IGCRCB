package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;

/**
 * �ʲ�������Ϣ��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM01011VO extends BaseVO implements Serializable{
	
	/** �ʲ�������Ϣ������� */
	protected List<SOC0117Info> entityDataList;
	
	/** ������Ϣ��������� */
	protected List<Organization> orglist;

	/** �ʲ�һ��ģ����Ϣ��������� */
	protected List<SOC0117Info> topEntityList;
	
	/** �ʲ�������Ϣ��������� */
	protected List<SOC0109Info> configurationList;
	
	/** ȡֵ��Χ��Ϣ��������� */
	protected List<SOC0151Info> ccdList;
	
	/** �û���Ϣ��������� */
	protected List<User> userlist;
	
	/** ȡֵ��Χ��Ϣ��������� */
	protected List<Map<String,List<SOC0109Info>>> configurationMapList;
	
	/**
	 * ���캯��
	 * @param entityData���ʲ�������Ϣ�������
	 */
	public IGASM01011VO(List<SOC0117Info> entityDataList) {
		this.entityDataList = entityDataList;
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
	 * �ʲ�������Ϣ�������ȡ��
	 * @return �ʲ�������Ϣ�������
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

