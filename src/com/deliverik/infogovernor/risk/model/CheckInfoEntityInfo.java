/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �����Թ����ʲ���ӿ�
  * ��������: �����Թ����ʲ���ӿ�
  * ������¼: 2014/09/02
  * �޸ļ�¼: 
  */
public interface CheckInfoEntityInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getCieid();

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public Integer getCsid();

	/**
	 * �ʲ�idȡ��
	 *
	 * @return �ʲ�id
	 */
	public Integer getEiid();

	/**
	 * �ʲ��汾ȡ��
	 *
	 * @return �ʲ��汾
	 */
	public Integer getEiversion();

}