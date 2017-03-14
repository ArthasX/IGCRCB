/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.svc.model.OrganizationServiceVWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ŷ���ͳ��ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@Entity
public class OrganizationServiceVW implements OrganizationServiceVWInfo{

	/** �������� */
	@Id
	protected String orgname;
	
	/** �¼����� */
	protected Integer incidentCount;
	
	/** ������������ */
	protected Integer serviceCount;
	
	/** �������� */
	protected Integer gdCount;
	
	/** ���� */
	protected Integer totalCount;

	/**
	 * ��������ȡ��
	 * @return orgname ��������
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * ���������趨
	 * @param orgname ��������
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * �¼�����ȡ��
	 * @return incidentCount �¼�����
	 */
	public Integer getIncidentCount() {
		return incidentCount;
	}

	/**
	 * �¼������趨
	 * @param incidentCount �¼�����
	 */
	public void setIncidentCount(Integer incidentCount) {
		this.incidentCount = incidentCount;
	}

	/**
	 * ������������ȡ��
	 * @return serviceCount ������������
	 */
	public Integer getServiceCount() {
		return serviceCount;
	}

	/**
	 * �������������趨
	 * @param serviceCount ������������
	 */
	public void setServiceCount(Integer serviceCount) {
		this.serviceCount = serviceCount;
	}

	/**
	 * ����ȡ��
	 * @return totalCount ����
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * �����趨
	 * @param totalCount ����
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getGdCount() {
		return gdCount;
	}

	public void setGdCount(Integer gdCount) {
		this.gdCount = gdCount;
	}
	
	
}
