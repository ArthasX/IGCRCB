/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 
 * ��Ȩ����ӿ�
 * 
 * 
 */

public interface IG711Info extends BaseModel {
	/**
	 * ��Ȩ����IDȡ��
	 * 
	 * @return ��Ȩ����ID
	 */
	public Integer getPaid();
	
	/**
	 * ʹ����IDȡ��
	 * 
	 * @return ʹ����ID
	 */
	public String getPaiid();
	
	/**
	 * ��Ȩ��IDȡ��
	 * 
	 * @return ��Ȩ��ID
	 */
	public String getPauid();
	
	/**
	 * ��Ȩ��ʼ����ȡ��
	 * 
	 * @return ��Ȩ��ʼ����
	 */
	public String getPabegintime();
	
	/**
	 * ��Ȩ��������ȡ��
	 * 
	 * @return ��Ȩ��������
	 */
	public String getPaendtime();
	
	/**
	 * ��Ȩ��ʶλ(0.δ��Ȩ��1.����Ȩ)ȡ��
	 * 
	 * @return ��Ȩ��ʶλ
	 */
	public String getPaflag();

	/**
	 * ��Ȩ����(0.���й�����1.��һ����)ȡ��
	 * 
	 * @return ��Ȩ��ʶλ
	 */
	public String getPatype();
	
	/**
	 * ����(����)IDȡ��
	 * 
	 * @return ����(����)ID
	 */
	public Integer getPaprocessid();
	
	/**
	 * ����(����)���ȡ��
	 * 
	 * @return ����(����)���
	 */
	public String getPaprocessnum();
	
	/**
	 * ��Ȩ�Ǽ�ʱ��ȡ��
	 * 
	 * @return ��Ȩ�Ǽ�ʱ��
	 */
	public String getPalogintime();
	
	/**
	 * ��Ȩ˵��ȡ��
	 * @return ��Ȩ˵��
	 */
	public String getRemarks();
}