/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * ����: ������ѯ���������ӿ�
  * ��������: ������ѯ���������ӿ�
  * ������¼: 2014/07/01
  * �޸ļ�¼: 
  */
public interface CheckItemVWSearchCond {
	/**
	 * ��������ȡ��
	 * @return einame ��������
	 */
	public String getEiname();

	/**
	 * ���ϵ���ȡ��
	 * @return datady ���ϵ���
	 */
	public String getDatady();

	/**
	 * ��̸����ȡ��
	 * @return viewobj ��̸����
	 */
	public String getViewobj();

	/**
	 * ������ȡ��
	 * @return managername ������
	 */
	public String getManagername();

	/**
	 * eIINSDATEȡ��
	 * @return eIINSDATE eIINSDATE
	 */
	public String getEIINSDATE();

	/**
	 * �����ȡ��
	 * @return syscoding �����
	 */
	public String getSyscoding();
	
	/**���*/
	public String getBh();
	/**
	 * ��ʼ����ȡ��
	 * @return startdate ��ʼ����
	 */
	public String getStartdate();
	/**
	 * ��������ȡ��
	 * @return enddate ��������
	 */
	public String getEnddate();
	
	/**
	 * ���Ƶ��ȡ��
	 * @return checkfrequency ���Ƶ��
	 */
	public String getCheckfrequency();
	
	/**
	 * �����������IDȡ��
	 * @return eiid �����������ID
	 */
	public String getEiid();
	
	public String getEiid_NotIn();
	
}