/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: MSGFILTER�ӿ�
  * ��������: MSGFILTER�ӿ�
  * ������¼: 2013/08/21
  * �޸ļ�¼: 
  */
public interface MSGFILTERInfo extends BaseModel {

	/**
	 * idȡ��
	 *
	 * @return id
	 */
	public Integer getId();

	/**
	 * deviceipȡ��
	 *
	 * @return deviceip
	 */
	public String getDeviceip();

	/**
	 * stateȡ��
	 *
	 * @return state
	 */
	public String getState();

}