/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model;


/**
 * ���̲����߱���Ȩ����ͼ�ӿ�
 *
 */
public interface IG893Info {
	
	/**
	 * ���̱���IDȡ��
	 * @return ���̱���ID
	 */
	public String getPidid();
	
	/**
	 * ����״̬��IDȡ��
	 * @return ����״̬��ID
	 */
	public String getPsdid();
	
	/**
	 * ���̲����߽�ɫIDȡ��
	 * @return ���̲����߽�ɫID
	 */
	public Integer getRoleid();

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
	 * ���̲����߱���Ȩ��ȡ��
	 * @return ���̲����߱���Ȩ��
	 */
	public String getPidaccess();
	
	public String getPidrequired();
	
}
