/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �Զ����������ñ�ӿ�
  * ��������: �Զ����������ñ�ӿ�
  * ������¼: 2012/11/05
  * �޸ļ�¼: 
  */
public interface CustomConfigurationInfo extends BaseModel {

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getRfdid();

	/**
	 * ������IDȡ��
	 *
	 * @return ������ID
	 */
	public String getPdid();

	/**
	 * ͳ�Ƶ�״̬ȡ��
	 *
	 * @return ͳ�Ƶ�״̬
	 */
	public String getPrstatusInfo();

	/**
	 * ��IDȡ��
	 *
	 * @return ��ID
	 */
	public String getPidid();

	/**
	 * ��ֵȡ��
	 *
	 * @return ��ֵ
	 */
	public String getPidvalue();

	/**
	 * �Ǽ���IDȡ��
	 *
	 * @return �Ǽ���ID
	 */
	public String getUserid();
	
	
	public String getCreateTime();
	
	public String getUpdateTime();

}