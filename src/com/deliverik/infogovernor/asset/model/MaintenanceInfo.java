/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ����ָ��ά���ӿ�
  * ��������: ����ָ��ά���ӿ�
  * ������¼: 2014/07/25
  * �޸ļ�¼: 
  */
public interface MaintenanceInfo extends BaseModel {

	/**
	 * ����ָ��ά��IDȡ��
	 *
	 * @return ����ָ��ά��ID
	 */
	public Integer getRIMID();

	/**
	 * ����ָ��IDȡ��
	 *
	 * @return ����ָ��ID
	 */
	public Integer getRIID();

	/**
	 * ����ָ�����ȡ��
	 *
	 * @return ����ָ�����
	 */
	public String getRIMTYPE();

	/**
	 * ����ָ��˵��ȡ��
	 *
	 * @return ����ָ��˵��
	 */
	public String getRIMDESC();

	/**
	 * ָ��ά�����ȡ��
	 *
	 * @return ָ��ά�����
	 */
	public String getRIMSQL();

}