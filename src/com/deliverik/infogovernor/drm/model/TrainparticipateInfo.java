/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��ѵ�����˽ӿ�
  * ��������: ��ѵ�����˽ӿ�
  * ������¼: 2015/04/13
  * �޸ļ�¼: 
  */
public interface TrainparticipateInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getTpaid();

	/**
	 * ��ѵ������ȡ��
	 *
	 * @return ��ѵ������
	 */
	public String getTpaname();

	/**
	 * ��ѵ����ϵ�绰ȡ��
	 *
	 * @return ��ѵ����ϵ�绰
	 */
	public String getTpatel();

	/**
	 * ��ѵ��¼idȡ��
	 *
	 * @return ��ѵ��¼id
	 */
	public Integer getTrid();

}