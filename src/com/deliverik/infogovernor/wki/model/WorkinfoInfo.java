/*
 * ��������������ɷ����޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wki.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ������Ϣ�ӿ�
  * ��������: ������Ϣ�ӿ�
  * ������¼: 2017/03/02
  * �޸ļ�¼: 
  */
public interface WorkinfoInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getWorkinfoid();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getWorkname();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getWorkperiod();

	/**
	 * Ԥ�����ʱ��ȡ��
	 *
	 * @return Ԥ�����ʱ��
	 */
	public String getEstFinDate();

	/**
	 * ʵ�����ʱ��ȡ��
	 *
	 * @return ʵ�����ʱ��
	 */
	public String getActFinDate();

	/**
	 * ��ʱ��������ȡ��
	 *
	 * @return ��ʱ��������
	 */
	public Integer getTimeOutPeriod();

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public Integer getInitid();

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getInitname();

	/**
	 * ִ����idȡ��
	 *
	 * @return ִ����id
	 */
	public Integer getExecid();

	/**
	 * ִ��������ȡ��
	 *
	 * @return ִ��������
	 */
	public String getExecname();

	/**
	 * ����״̬ȡ��
	 *
	 * @return ����״̬
	 */
	public Integer getWorkstatus();

	/**
	 * ��עȡ��
	 *
	 * @return ��ע
	 */
	public String getRemark();

}