/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>����:���̼�������ѯ�����ӿ�</p>
 * <p>��������:</p>
 * <p>������¼��</p>
 */
public interface IG286SearchCond {
	/**
	 * ���ܣ����̼�����IDȡ��
	 * @return ���̼�����ID
	 */
	public String getPlid();
	
	/**
	 * ���ܣ�������idȡ��
	 * @return ������id
	 */ 
	public String getInitiativepidid();
	
	/**
	 * ���ܣ�������idȡ��
	 * @return ������id
	 */
	public String getPassivitypidid();
	
	/**
	 * ���ܣ�������˵��ȡ��
	 * @return ������˵��
	 */
	public String getPldesc();
	
	/**
	 * ���ܣ�����BL����ȡ��
	 * @return ����BL����
	 */
	public String getPlblname();
	
	/**
	 * ���ܣ�����JSȡ��
	 * @return ����JS
	 */
	public String getPljsevent();
	
	/**
	 * ���ܣ���������ȡ��
	 * @return ��������
	 */
	public String getPljtype();
	
	/**
	 * ���ܣ�����IDȡ��
	 * @return ����ID
	 */
	public String getPldpdid();
	
	/**
	 * ���ܣ�����ActionIDȡ��
	 * @return ����ActionID
	 */
	public String getPldactionid();
	
	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getPlid_like();
}
