/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �������ñ�ӿ�
  * ��������: �������ñ�ӿ�
  * ������¼: 2013/08/05
  * �޸ļ�¼: 
  */
public interface RemindConfigureInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getRcid();

	/**
	 * ��ȡ��
	 *
	 * @return ��
	 */
	public String getRcyear();

	/**
	 * ��ȡ��
	 *
	 * @return ��
	 */
	public String getRcmonth();

	/**
	 * ��ȡ��
	 *
	 * @return ��
	 */
	public String getRcday();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getRctype();

}