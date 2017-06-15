/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ���ӱ���ӿ�
  * ��������: ���ӱ���ӿ�
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/09 ��ReportAnnexationInfo������ΪSOC0202Info
  */
public interface SOC0202Info extends BaseModel {

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getRaId();

	/**
	 * ���ӱ�������ȡ��
	 *
	 * @return ���ӱ�������
	 */
	public String getRaName();

	/**
	 * �洢���к�ȡ��
	 *
	 * @return �洢���к�
	 */
	public String getRaSsn();

	/**
	 * kpiȡ��
	 *
	 * @return kpi
	 */
	public String getRaKpi();

	/**
	 * ��ʼʱ��ȡ��
	 *
	 * @return ��ʼʱ��
	 */
	public String getRaCreateDate();

	
	/**
	 * Word�ĵ�����ȡ��
	 *
	 * @return raRealName Word�ĵ�����
	 */
	public String getRaRealName();
	/**
	 * �û�����ȡ��
	 *
	 * @return raUserName �û�����
	 */
	public String getRaUserName();
	/**
	 * �Ƿ�ʹ��ȡ��
	 *
	 * @return isUsed �Ƿ�ʹ��
	 */
	public String getIsUsed();
}