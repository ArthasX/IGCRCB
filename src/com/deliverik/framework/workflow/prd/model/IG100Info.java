/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model;


/**
 * ���̲����߱���Ȩ��
 * 
 */
public interface IG100Info {
	
	/**
	 * ���̲����߱���Ȩ��IDȡ��
	 * @return ���̲����߱���Ȩ��ID
	 */
	public String getPipdid();
	
	/**
	 * ���̱���IDȡ��
	 * @return ���̱���ID
	 */
	public String getPidid();
	
	/**
	 * ���̱�����ʾ����ȡ��
	 * @return ���̱�����ʾ����
	 */
	public String getPidlabel();
	
	/**
	 * ���̲����߱���Ȩ��ȡ��
	 * @return ���̲����߱���Ȩ��
	 */
	public String getPidaccess();
	
	/**
	 * ����Ϣ��ģʽȡ��
	 *
	 * @return ����Ϣ��ģʽ
	 */
	public String getPidmode();
	
	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getType();
	
	public String getPidrequired();
	
}
