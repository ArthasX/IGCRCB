/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��ѵ�ƻ���ӿ�
  * ��������: ��ѵ�ƻ���ӿ�
  * ������¼: 2015/04/10
  * �޸ļ�¼: 
  */
public interface TrainplanInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getTpid();

	/**
	 * �ƻ�����ȡ��
	 *
	 * @return �ƻ�����
	 */
	public String getTpname();

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getTpuserid();

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getTpusername();

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getPtorgid();

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getTporgname();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getTptime();

	/**
	 * �ƻ�״̬ȡ��
	 *
	 * @return �ƻ�״̬
	 */
	public String getTpstatus();

}