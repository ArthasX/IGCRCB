/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.fxk.model.condition;

/**
  * ����: ���չ�����ʾ���ݱ���������ӿ�
  * ��������: ���չ�����ʾ���ݱ���������ӿ�
  * ������¼: 2014/06/17
  * �޸ļ�¼: 
  */
public interface RiskmanagerwaringSearchCond {

	/**
	 * ������ʾ����ȡ��
	 * @return rwname ������ʾ����
	 */
	
	public String getRwname();

	/**
	 * �·�����idȡ��
	 * @return nuserid �·�����id
	 */
	
	public String getNuserid();

	/**
	 * �·���������ȡ��
	 * @return nusername �·���������
	 */
	
	public String getNusername();

	/**
	 * �·��߻�����ȡ��
	 * @return norgname �·��߻�����
	 */
	
	public String getNorgname();

	/**
	 * �·��߻�����ȡ��
	 * @return norgid �·��߻�����
	 */
	
	public String getNorgid();

	/**
	 * �·�ʱ��ȡ��
	 * @return ntime �·�ʱ��
	 */
	
	public String getNtime();
	
	/**
	 * ���·��û��û�IDȡ��
	 * @return userid ���·��û��û�ID
	 */
	public String getUserid();
	public String getUsername_s();

}