/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * ����: ����˽�б�������������ӿ�
  * ��������: ����˽�б�������������ӿ�
  * ������¼: 2012/03/27
  * �޸ļ�¼: 
  */
public interface IG899SearchCond {
	
	/**
	 * ���̱�������IDȡ��
	 *
	 * @return ���̱�������ID
	 */
	public String getPidid();

	/**
	 * ���̱���ֵIDȡ��
	 *
	 * @return ���̱���ֵID
	 */
	public Integer getPiid();

	/**
	 * ���̲����ߵĽ�ɫIDȡ��
	 *
	 * @return ���̲����ߵĽ�ɫID
	 */
	public Integer getRoleid();
	
	/**
	 * ���̲�����IDȡ��
	 * 
	 * @return ���̲�����ID
	 */
	public String getUserid();
	
	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getOrgid();
}