/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rdp.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ExcuteResult�ӿ�
  * ��������: ExcuteResult�ӿ�
  * ������¼: 2014/04/16
  * �޸ļ�¼: 
  */
public interface ExcuteResultInfo extends BaseModel {

	/**
	 * hostidȡ��
	 *
	 * @return hostid
	 */
	public String getHostid();

	/**
	 * taskidȡ��
	 *
	 * @return taskid
	 */
	public Integer getTaskid();

	/**
	 * resultȡ��
	 *
	 * @return result
	 */
	public String getResult();

	/**
	 * resultDetailȡ��
	 *
	 * @return resultDetail
	 */
	public String getResultDetail();
	
	public Integer getState();
	
	public String getRealtimedetail();

}