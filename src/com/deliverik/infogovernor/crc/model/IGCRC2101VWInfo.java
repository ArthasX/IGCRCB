/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.crc.model;

import com.deliverik.framework.base.BaseModel;

/**
 * ���ܣ� ��Ա����ͳ��
 * @author yukexin 2014-8-7 16:19:26
 */
public interface IGCRC2101VWInfo extends BaseModel{
	/**
	 * ����ȡ��
	 * @return userID  ����
	 */
	public String getUserID();
	/**
	 * ��Ա����ȡ��
	 * @return userName  ��Ա����
	 */
	public String getUserName();
	/**
	 * �¼�����ȡ��
	 * @return incidentNum  �¼�����
	 */
	public Integer getIncidentNum();
	/**
	 * �������ȡ��
	 * @return problemNum  �������
	 */
	public Integer getProblemNum();
	/**
	 * �������ȡ��
	 * @return changeNum  �������
	 */
	public Integer getChangeNum();
	/**
	 * �����������ȡ��
	 * @return serviceNum  �����������
	 */
	public Integer getServiceNum();
	/**
	 * �����������ȡ��
	 * @return developNum  �����������
	 */
	public Integer getDevelopNum();
	
}
