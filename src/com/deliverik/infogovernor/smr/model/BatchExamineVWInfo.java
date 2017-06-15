/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.model;

import java.io.Serializable;

/**
 * ����:�������� 
 * ������������������ 
 * �����ˣ�����͢
 * ������¼�� 2013-07-31
 * �޸ļ�¼��
 */
public interface BatchExamineVWInfo extends Serializable{

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPrid();
	
	/**
	 * ������ ȡ��
	 *
	 * @return ������ 
	 */
	public String getPrtitle();
	
	/**
	 * ����ʱ�� ȡ��
	 *
	 * @return ����ʱ�� 
	 */
	public String getFillintime();
	
	/**
	 * �����������ʱ�� ȡ��
	 *
	 * @return �����������ʱ�� 
	 */
	public String getExaminetime();
	
	/**
	 * ��� ȡ��
	 *
	 * @return ��� 
	 */
	public String getFillinusername();
	
	/**
	 * ���������� ȡ��
	 *
	 * @return ���������� 
	 */
	public String getExanimeusername();
	
	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getPrstatus();
	
	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getRejecttime();
	/**
	 * ��������idȡ��
	 *
	 * @return ��������id
	 */
	public String getPrpdid();
	
	
	public String getFlag();
	
}
