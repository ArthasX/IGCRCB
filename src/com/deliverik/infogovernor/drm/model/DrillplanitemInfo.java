/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �����ƻ���Ŀ�ӿ�
  * ��������: �����ƻ���Ŀ�ӿ�
  * ������¼: 2015/03/02
  * �޸ļ�¼: 
  */
public interface DrillplanitemInfo extends BaseModel {

	/**
	 * �����ƻ���Ŀidȡ��
	 *
	 * @return �����ƻ���Ŀid
	 */
	public Integer getDiid();

	/**
	 * �����ƻ�idȡ��
	 *
	 * @return �����ƻ�id
	 */
	public Integer getDid();

	/**
	 * ��������pridȡ��
	 *
	 * @return ��������prid
	 */
	public Integer getPrid();

	/**
	 * ����״̬ ������/δ����ȡ��
	 *
	 * @return ����״̬ ������/δ����
	 */
	public String getStatus();

	/**
	 * ����Ԥ�ڿ�ʼʱ��ȡ��
	 *
	 * @return ����Ԥ�ڿ�ʼʱ��
	 */
	public String getExpecttime();

	/**
	 * ����ʵ�ʿ�ʼʱ��ȡ��
	 *
	 * @return ����ʵ�ʿ�ʼʱ��
	 */
	public String getActstarttime();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getDiname();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getDicontant();

	/**
	 * ����Ŀ��ȡ��
	 *
	 * @return ����Ŀ��
	 */
	public String getDidestination();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getDiscene();

	/**
	 * Ӱ�췶Χȡ��
	 *
	 * @return Ӱ�췶Χ
	 */
	public String getDiscope();

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getDidutyorg();

	/**
	 * ���벿��ȡ��
	 *
	 * @return ���벿��
	 */
	public String getPartorg();

}