/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��������ӿ�
  * ��������: ��������ӿ�
  * ������¼: 2016/04/19
  * �޸ļ�¼: 
  */
public interface WorkmanagerInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getWmid();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getWmname();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getWmdesc();

	/**
	 * ���״̬(0-δ���1-�����)ȡ��
	 *
	 * @return ���״̬(0-δ���1-�����)
	 */
	public String getWmstatus();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getWmstartdate();

	/**
	 * �����������ȡ��
	 *
	 * @return �����������
	 */
	public String getWmlimitdate();

	/**
	 * ʵ���������ȡ��
	 *
	 * @return ʵ���������
	 */
	public String getWmfactdate();

	/**
	 * Ƶ��ȡ��
	 *
	 * @return Ƶ��
	 */
	public String getWmfrequency();

	/**
	 * ����ִ�б��ʽ ȡ��
	 *
	 * @return ����ִ�б��ʽ 
	 */
	public String getWmcron();

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getWmuserid();

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getWmusername();

	/**
	 * �����˽�ɫidȡ��
	 *
	 * @return �����˽�ɫid
	 */
	public String getWmroleid();

	/**
	 * �����˽�ɫ����ȡ��
	 *
	 * @return �����˽�ɫ����
	 */
	public String getWmrolename();

	/**
	 * ѡ��ȡ��
	 *
	 * @return ѡ��
	 */
	public String getWmoption();

	/**
	 * ����ʱ�䣨Сʱ��ȡ��
	 *
	 * @return ����ʱ�䣨Сʱ��
	 */
	public String getWmremindh();

	/**
	 * ����ʱ�䣨���ӣ�ȡ��
	 *
	 * @return ����ʱ�䣨���ӣ�
	 */
	public String getWmremindm();

	/**
	 * ������Դ 0-�Ǽ�1-���� ȡ��
	 *
	 * @return ������Դ 0-�Ǽ�1-���� 
	 */
	public String getWmtype();

	/**
	 * �Ƿ�����0-����1-�������� ȡ��
	 *
	 * @return �Ƿ�����0-����1-�������� 
	 */
	public String getWmremind();

	/**
	 * @return the ��ע
	 */
	public String getWmremark();
	
	/**
	 * @return the ����Դwmid
	 */
	public String getRewmid();
	
	/**
	 * @return the Ƶ��(ÿ�����һ��)
	 */
	public String getWmfrequencymonthlastday();
	
	/**
	 * @return the ���ռ��Ƶ��(��)
	 */
	public String getWmfrequencyweeks();
	
	/**
	 * @return the ���ռ��Ƶ��(��)
	 */
	public String getWmfrequencymonths();
}