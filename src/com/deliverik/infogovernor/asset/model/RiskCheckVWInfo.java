/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��鹤��ͳ�Ʊ���ӿ�
  * ��������: ��鹤��ͳ�Ʊ���ӿ�
  * ������¼: 2014/07/22
  * �޸ļ�¼: 
  */
public interface RiskCheckVWInfo extends BaseModel {

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
	 * �Ǽ���idȡ��
	 *
	 * @return �Ǽ���id
	 */
	public String getEiuserid();

	/**
	 * �Ǽ�������ȡ��
	 *
	 * @return �Ǽ�������
	 */
	public String getEiusername();

	/**
	 * ���������ȡ��
	 *
	 * @return ���������
	 */
	public String getEiname();

	/**
	 * ���Ƶ��ȡ��
	 *
	 * @return ���Ƶ��
	 */
	public String getCheckpd();

	/**
	 * �����˵��ȡ��
	 *
	 * @return �����˵��
	 */
	public String getEidesc();

}