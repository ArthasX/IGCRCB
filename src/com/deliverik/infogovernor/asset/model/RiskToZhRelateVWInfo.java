/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ���յ�ָ���ϵ�ӿ�
  * ��������: ���յ�ָ���ϵ�ӿ�
  * ������¼: 2014/07/24
  * �޸ļ�¼: 
  */
public interface RiskToZhRelateVWInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getEiid();

	/**
	 * eidȡ��
	 *
	 * @return eid
	 */
	public String getEid();

	/**
	 * ���ȡ��
	 *
	 * @return ���
	 */
	public String getEilabel();

	/**
	 * ��ֵȡ��
	 *
	 * @return ��ֵ
	 */
	public String getThreshold();

	/**
	 * ����ָ������ȡ��
	 *
	 * @return ����ָ������
	 */
	public String getEiname();

	/**
	 * �Ƿ�ؼ�ָ��ȡ��
	 *
	 * @return �Ƿ�ؼ�ָ��
	 */
	public String getKeyindex();

	/**
	 * ����ָ��˵��ȡ��
	 *
	 * @return ����ָ��˵��
	 */
	public String getEidesc();

}