/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��ѵ�����ӿ�
  * ��������: ��ѵ�����ӿ�
  * ������¼: 2015/04/10
  * �޸ļ�¼: 
  */
public interface TrainmissionInfo extends BaseModel {

	/**
	 * tmidȡ��
	 *
	 * @return tmid
	 */
	public Integer getTmid();

	/**
	 * ���ȡ��
	 *
	 * @return ���
	 */
	public Integer  getTpid();

	/**
	 * ��ѵ�γ�ȡ��
	 *
	 * @return ��ѵ�γ�
	 */
	public String getTmcourse();

	/**
	 * ��ѵ����ȡ��
	 *
	 * @return ��ѵ����
	 */
	public String getTmorg();

	/**
	 * ��ѵʱ��ȡ��
	 *
	 * @return ��ѵʱ��
	 */
	public String getTmtime();

	/**
	 * ��ѵ����ȡ��
	 *
	 * @return ��ѵ����
	 */
	public String getTmtarget();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getTmatt();
}