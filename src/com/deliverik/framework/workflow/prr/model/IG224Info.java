/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model;

import java.util.Date;

import com.deliverik.framework.base.BaseModel;

/**
 * ����״̬��־ʵ��ӿ�
 *
 */
public interface IG224Info extends BaseModel {
	
	/**
	 * ����״̬��־IDȡ��
	 * 
	 * @return ����״̬��־ID
	 */
	public Integer getRslid();

	/**
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getPrid();
	
	/**
	 * �Զ�����������IDȡ��
	 * 
	 * @return �Զ�����������ID
	 */
	public String getPrpdid();
	
	/**
	 * ��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getPrtype();

	/**
	 * ����״̬ȡ��
	 * 
	 * @return ����״̬
	 */
	public String getPrstatus();
	
	/**
	 * ��ʼʱ��ȡ��
	 * 
	 * @return ��ʼʱ��
	 */
	public Date getRslOpenTime();
	
	/**
	 * ����ʱ��ȡ��
	 * 
	 * @return ����ʱ��
	 */
	public Date getRslCloseTime();
	
	/**
	 * �Ƿ�ʱȡ��
	 * 
	 * @return �Ƿ�ʱ
	 */
	public String getRslExpect();
	
	/**
	 * ����״̬����IDȡ��
	 * @return ����״̬����ID
	 */
	public String getPsdid();
	

	/**
	 * �ϼ�����״̬����IDȡ��
	 * @return �ϼ�����״̬����ID
	 */
	public String getPpsdid();
	

	/**
	 * ����ڵ�״̬ȡ��
	 * @return ����ڵ�״̬
	 */
	public String getVirtualstatus();
	

	/**
	 * ��̬��֧���ȡ��
	 * @return ��̬��֧���
	 */
	public Integer getPsdnum();
}