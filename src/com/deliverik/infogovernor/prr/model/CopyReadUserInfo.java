/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �����˱�ӿ�
  * ��������: �����˱�ӿ�
  * ������¼: 2013/02/25
  * �޸ļ�¼: 
  */
public interface CopyReadUserInfo extends BaseModel{

	/**
	 * ��������������ȡ��
	 *
	 * @return ��������������
	 */
	public Integer getCruid();

	/**
	 * ����idȡ��
	 *
	 * @return ����id
	 */
	public Integer getPrid();

	/**
	 * ���̱��ȡ��
	 *
	 * @return ���̱��
	 */
	public String getPrserialnum();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPrtitle();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPrpdname ();

	/**
	 * �����˽�ɫȡ��
	 *
	 * @return �����˽�ɫ
	 */
	public String getPrrolename();

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getPrusername ();

	/**
	 * ����״̬ȡ��
	 *
	 * @return ����״̬
	 */
	public String getCrustatus ();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getPrassigntime();

	/**
	 * �鿴ʱ��ȡ��
	 *
	 * @return �鿴ʱ��
	 */
	public String getPrlooktime();

	/**
	 * �Ƿ�鿴��ʶȡ��
	 *
	 * @return �Ƿ�鿴��ʶ
	 */
	public String getIslook();

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getPruserid ();

	/**
	 * ���̿�ʼʱ��ȡ��
	 *
	 * @return ���̿�ʼʱ��
	 */
	public String getPrstarttime();
	
	/**
	 * ���̶���idȡ��
	 *
	 * @return ���̶���id
	 */
	public String getPrpdid();
	
	/**
	 * ������״̬ȡ��
	 *
	 * @return ������״̬
	 */
	public String getPrsubstatus();
}