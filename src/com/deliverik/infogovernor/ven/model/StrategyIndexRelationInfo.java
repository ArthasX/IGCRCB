/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ���ղ���ָ���ϵ��ӿ�
  * ��������: ���ղ���ָ���ϵ��ӿ�
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
public interface StrategyIndexRelationInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getSirid();

	/**
	 * ���ղ���idȡ��
	 *
	 * @return ���ղ���id
	 */
	public Integer getRsid();

	/**
	 * ����ָ��idȡ��
	 *
	 * @return ����ָ��id
	 */
	public Integer getRiid();

}