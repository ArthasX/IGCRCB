/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.fxk.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ���ռƻ���ѯ
  * ��������: ���ռƻ���ѯ
  * ������¼: 2014/07/24
  * �޸ļ�¼: 
  */
public interface RiskprojectvwInfo extends BaseModel {

	/**
	 * ���̼�¼IDȡ��
	 *
	 * @return ���̼�¼ID
	 */
	public Integer getPrid ();

	/**
	 * ���̼�¼״̬ȡ��
	 *
	 * @return ���̼�¼״̬
	 */
	public String getPrstatus();

	/**
	 * ���̼�¼��Ŀȡ��
	 *
	 * @return ���̼�¼��Ŀ
	 */
	public String getPrtitle ();

	/**
	 * ���̼�¼����ʱ��ȡ��
	 *
	 * @return ���̼�¼����ʱ��
	 */
	public String getPropentime();

	/**
	 * ���̼�¼�ƻ�ִ��ʱ��ȡ��
	 *
	 * @return ���̼�¼�ƻ�ִ��ʱ��
	 */
	public String getPrplantime();

	/**
	 * ���̼�¼�����߽�ɫ����ȡ��
	 *
	 * @return ���̼�¼�����߽�ɫ����
	 */
	public String getPrrolename();

	/**
	 * ���̼�¼������ȡ��
	 *
	 * @return ���̼�¼������
	 */
	public String getPrserialnum();

	/**
	 * ���ռƻ�����ȡ��
	 *
	 * @return ���ռƻ�����
	 */
	public String getRisktype();

	/**
	 * ���̼�¼������������������ȡ��
	 *
	 * @return ���̼�¼������������������
	 */
	public String getProrgname();

	/**
	 * �ƻ�������ȡ��
	 *
	 * @return �ƻ�������
	 */
	public String getRiskcompletion();

//	/**
//	 * ���ռƻ�״̬ȡ��
//	 *
//	 * @return ���ռƻ�״̬
//	 */
//	public String getRiskstatus();

	/**
	 * ���̼�¼�������������������ȡ��
	 *
	 * @return ���̼�¼�������������������
	 */
	public String getProrgid();

	/**
	 * ���̼�¼����ȡ��
	 *
	 * @return ���̼�¼����
	 */
	public String getPrdesc();

	/**
	 * ���ձ��ȡ��
	 *
	 * @return ���ձ��
	 */
	public String getRisknum();

	/**
	 * ���̼�¼������������ȡ��
	 *
	 * @return ���̼�¼������������
	 */
	public String getPrpdname();

	/**
	 * ���̼�¼��������IDȡ��
	 *
	 * @return ���̼�¼��������ID
	 */
	public String getPrpdid();

	/**
	 * ���̼�¼�����߽�ɫIDȡ��
	 *
	 * @return ���̼�¼�����߽�ɫID
	 */
	public String getPrroleid();

	/**
	 * ���̼�¼�������û�����ȡ��
	 *
	 * @return ���̼�¼�������û�����
	 */
	public String getPrusername();

	/**
	 * ���̼�¼�������û�IDȡ��
	 *
	 * @return ���̼�¼�������û�ID
	 */
	public String getPruserid();

	/**
	 * ���̼�¼�ر�ʱ��ȡ��
	 *
	 * @return ���̼�¼�ر�ʱ��
	 */
	public String getPrclosetime();
	
	public String getRiskstart();
	public String getRiskend();

}