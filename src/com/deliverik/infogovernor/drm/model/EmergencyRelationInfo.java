/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
 * ���̹�ϵʵ��ӿ�
 *
 */
public interface EmergencyRelationInfo extends BaseModel {
	
	/**
	 * ���̹�ϵIDȡ��
	 * 
	 * @return ���̹�ϵID
	 */
	public Integer getErid();

	/**
	 * ��������IDȡ��
	 * 
	 * @return ��������ID
	 */
	public Integer getParprid();

	/**
	 * ��������IDȡ��
	 * 
	 * @return ��������ID
	 */
	public Integer getCldprid();
	

	/**
	 * ��ϵ����ʱ��ȡ��
	 * 
	 * @return ��ϵ����ʱ��
	 */
	public String getPrrinstime();
	/**Ӧ��������������(1:��һ����else��ϳ���)*/
	public String getCldType();
	
	/** ��ϵ����  0������-����   1 Ӧ��ָ��-����  2 ����-Ӧ��ָ�� */
	public String getRelatetype();
	

}