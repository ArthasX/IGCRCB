/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: knowLog�ӿ�
  * ��������: knowLog�ӿ�
  * ������¼: 2011/05/30
  * �޸ļ�¼: 
  */
public interface KnowLogInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getKlid();

	/**
	 * ֪ʶIDȡ��
	 *
	 * @return ֪ʶID
	 */
	public Integer getKlkid();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getKltime();

	/**
	 * ������־��ɫIDȡ��
	 *
	 * @return ������־��ɫID
	 */
	public String getKlroleid();

	/**
	 * �������ӽ�ɫ����ȡ��
	 *
	 * @return �������ӽ�ɫ����
	 */
	public String getKlrolename();

	/**
	 * �û�IDȡ��
	 *
	 * @return �û�ID
	 */
	public String getKluserid();

	/**
	 * �û�����ȡ��
	 *
	 * @return �û�����
	 */
	public String getKlusername();

	/**
	 * ��־����ȡ��
	 *
	 * @return ��־����
	 */
	public String getKldesc();

	/**
	 * ��ע��Ϣȡ��
	 *
	 * @return ��ע��Ϣ
	 */
	public String getKlcommend();

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public String getKlorgid();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getKlorgname();

}