/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model;


/**
 * ����ȱʡ����Ȩ��
 * 
 */
public interface IG909Info {
	
	/**
	 * ����ȱʡ����Ȩ��IDȡ��
	 * @return ����ȱʡ����Ȩ��ID
	 */
	public String getPdvid();
	
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
	 * ����ȱʡ����Ȩ��ȡ��
	 * @return ����ȱʡ����Ȩ��
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
