/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
 * ���̹�ϵʵ��ӿ�
 *
 */
public interface IG512Info extends BaseModel {
	
	/**
	 * ���̹�ϵIDȡ��
	 * 
	 * @return ���̹�ϵID
	 */
	public Integer getPrrid();

	/**
	 * ��������IDȡ��
	 * 
	 * @return ��������ID
	 */
	public Integer getParprid();
	
	/**
	 * ����������Ϣȡ��
	 * 
	 * @return ����������Ϣ
	 */
	public IG500Info getParProcess();

	/**
	 * ��������IDȡ��
	 * 
	 * @return ��������ID
	 */
	public Integer getCldprid();
	
	/**
	 * ����������Ϣȡ��
	 * 
	 * @return ����������Ϣ
	 */
	public IG500Info getCldProcess();

	/**
	 * ��ϵ����ʱ��ȡ��
	 * 
	 * @return ��ϵ����ʱ��
	 */
	public String getPrrinstime();

}