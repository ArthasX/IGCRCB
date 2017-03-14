/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;

/**
  * ����: ��⹤�����ӿ�
  * ��������: ��⹤�����ӿ�
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
public interface MonitoringWorkInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getMwid();

	/**
	 * ���ռ������idȡ��
	 *
	 * @return ���ռ������id
	 */
	public Integer getRmid();

	/**
	 * ����ָ��idȡ��
	 *
	 * @return ����ָ��id
	 */
	public Integer getRiid();

	/**
	 * �����ȡ��
	 *
	 * @return �����
	 */
	public String getResult();

	/**
	 * ���˵��ȡ��
	 *
	 * @return ���˵��
	 */
	public String getResultdesc();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getMwattachkey();

	/**
	 * ����ָ����Ϣȡ��
	 * @return riskIndexSearchVWInfo  ����ָ����Ϣ
	 */
	public RiskIndexSearchVWInfo getRiskIndexSearchVWInfo();
	
	/**
	 * ָ�ɹ�������idȡ��
	 * @return the assignprid
	 */
	public Integer getAssignprid();
}