/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
 * ����״̬����ǰ����
 *
 */
public interface IG211Info  extends BaseModel {
	/**
	 * ����״̬����ǰ����IDȡ��
	 * @return ����״̬����ǰ����ID
	 */
	public String getPsidid();
	
	/**
	 * ����״̬IDȡ��
	 * @return ����״̬ID
	 */
	public String getPsdid();
	
	/**
	 * ���̱���IDȡ��
	 * @return ���̱���ID
	 */
	public String getPidid();

	/**
	 * ���̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPidname();
	
	/**
	 * ���̱�����ʾ����ȡ��
	 * @return ���̱�����ʾ����
	 */
	public String getPidlabel();
	
	/**
	 * ���̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPiddesc();
	
	/**
	 * ���̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPidtype();
	

	/**
	 * ���̱���ֵȡ��
	 * @return ���̱���ֵ
	 */
	public String getPidvalue();
	
	/**
	 * �ı���󶨸���
	 */
	public String getPidattkey();
}
