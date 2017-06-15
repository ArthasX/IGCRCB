/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.model;

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
public interface OrganizationServiceVWInfo {

	/**
	 * ��������ȡ��
	 * @return orgname ��������
	 */
	public String getOrgname();

	/**
	 * incidentCountȡ��
	 * @return incidentCount incidentCount
	 */
	public Integer getIncidentCount();

	/**
	 * ������������ȡ��
	 * @return serviceCount ������������
	 */
	public Integer getServiceCount();

	/**
	 * ����ȡ��
	 * @return totalCount ����
	 */
	public Integer getTotalCount();
	
	/**
	 * ��������ȡ��
	 * @return
	 */
	public Integer getGdCount();
}
