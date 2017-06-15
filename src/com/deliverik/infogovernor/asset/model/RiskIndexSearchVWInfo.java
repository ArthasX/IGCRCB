/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ����ָ���ѯ�ӿ�
  * ��������: ����ָ���ѯ�ӿ�
  * ������¼: 2014/07/25
  * �޸ļ�¼: 
  */
public interface RiskIndexSearchVWInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getEiid();

	/**
	 * ���β���ȡ��
	 *
	 * @return ���β���
	 */
	public String getDutydepartment();

	/**
	 * ȡ��
	 *
	 * @return 
	 */
	public String getEsyscoding();

	/**
	 * ָ����ȡ��
	 *
	 * @return ָ����
	 */
	public String getEiname();

	/**
	 * �Ǽ�����ȡ��
	 *
	 * @return �Ǽ�����
	 */
	public String getEiinsdate();

	/**
	 * ���ȡ��
	 *
	 * @return ���
	 */
	public String getEilabel();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getEiupdtime();

	/**
	 * С�汾ȡ��
	 *
	 * @return С�汾
	 */
	public String getEismallversion();

	/**
	 * ��ֵȡ��
	 *
	 * @return ��ֵ
	 */
	public String getZbfz();

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getEistatus();

	/**
	 * �Ǽ���IDȡ��
	 *
	 * @return �Ǽ���ID
	 */
	public String getEiuserid();

	/**
	 * �Ǽ�������ȡ��
	 *
	 * @return �Ǽ�������
	 */
	public String getEiusername();

	/**
	 * eidȡ��
	 *
	 * @return eid
	 */
	public String getEid();

	/**
	 * ȡ��
	 *
	 * @return 
	 */
	public String getEirootmark();

	/**
	 * ������IDȡ��
	 *
	 * @return ������ID
	 */
	public String getMguserid();

	/**
	 * ��;ȡ��
	 *
	 * @return ��;
	 */
	public String getIndexused();

	/**
	 * �Ƿ�ؼ�ָ��ȡ��
	 *
	 * @return �Ƿ�ؼ�ָ��
	 */
	public String getKeyindex();

	/**
	 * ָ��˵��ȡ��
	 *
	 * @return ָ��˵��
	 */
	public String getEidesc();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getEiorgsyscoding();

	/**
	 * �汾��ȡ��
	 *
	 * @return �汾��
	 */
	public String getEiversion();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getDutyuser();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getRiskly();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getRiskarea();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getRiskitem();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getMgusername();

}