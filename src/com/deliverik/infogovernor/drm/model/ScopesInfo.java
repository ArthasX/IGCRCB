/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �¼�Ӱ�췶Χ�ӿ�
  * ��������: �¼�Ӱ�췶Χ�ӿ�
  * ������¼: 2015/03/20
  * �޸ļ�¼: 
  */
public interface ScopesInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getScopeid();

	/**
	 * �¼�IDȡ��
	 *
	 * @return �¼�ID
	 */
	public Integer getEventid();

	/**
	 * Ӱ�췶Χȡ��
	 *
	 * @return Ӱ�췶Χ
	 */
	public String getImpscope();

	/**
	 * ҵ���ж�ȡ��
	 *
	 * @return ҵ���ж�
	 */
	public String getImpbus();

	/**
	 * �ж�ʱ��ȡ��
	 *
	 * @return �ж�ʱ��
	 */
	public String getImptime();

}