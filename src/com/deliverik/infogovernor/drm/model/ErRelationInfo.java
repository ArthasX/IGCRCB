/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ErRelation�ӿ�
  * ��������: ErRelation�ӿ�
  * ������¼: 2016/06/14
  * �޸ļ�¼: 
  */
public interface ErRelationInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getErrid();

	/**
	 * Ӧ����Դ����ȡ��
	 *
	 * @return Ӧ����Դ����
	 */
	public Integer getErid();

	/**
	 * ��Դ����ȡ��
	 *
	 * @return ��Դ����
	 */
	public String getErcode();

	/**
	 * �ʲ�idȡ��
	 *
	 * @return �ʲ�id
	 */
	public String getEiid();

	/**
	 * ɾ����־ȡ��
	 *
	 * @return ɾ����־
	 */
	public String getDeleteflag();

}