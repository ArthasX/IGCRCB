/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG933TB;

/**
 * 
 * ���񹤵��������̽ӿ�
 * 
 * 
 */

public interface IG715Info extends BaseModel {
	
	/**
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getSprrid();

	/**
	 * ���񹤵�IDȡ��
	 * 
	 * @return ���񹤵�ID
	 */
	public Integer getSprrsfid();
	
	/**
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getSprrprid();
	
	/**
	 * ���ʱ��ȡ��
	 * 
	 * @return ���ʱ��
	 */
	public String getSprrinstime();

	/**
	 * ���񹤵�����ȡ��
	 * 
	 * @return �������
	 */
	public IG933TB getServiceFormTB();
	
	/**
	 * ���̶���ȡ��
	 * 
	 * @return ���̶���
	 */
	public IG500TB getProcessRecordTB();	
}