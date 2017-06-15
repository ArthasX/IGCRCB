/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ģ��ӳ���ӿ�
  * ��������: ģ��ӳ���ӿ�
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/09 ��ReportTemplateMappingInfo������ΪSOC0206Info
  */
public interface SOC0206Info extends BaseModel {

	/**
	 * ��ˮIDȡ��
	 *
	 * @return ��ˮID
	 */
	public Integer getRtmId();

	/**
	 * ģ��λ�����ȡ��
	 *
	 * @return ģ��λ�����
	 */
	public Integer getRtNumber();

	/**
	 * �洢���к�ȡ��
	 *
	 * @return �洢���к�
	 */
	public String getRtmSsn();

	/**
	 * KPIȡ��
	 *
	 * @return KPI
	 */
	public String getRtmKpi();

	/**
	 * Word�ĵ�����ͼƬλ��ȡ��
	 *
	 * @return Word�ĵ�����ͼƬλ��
	 */
	public Integer getRtmImgNumber();
	/**
	 * ��ʶȡ��
	 *
	 * @return rtmFlag ��ʶ
	 */
	public String getRtmFlag();
	/**
	 * �洢����ȡ��
	 *
	 * @return rtmSsnType �洢����
	 */
	public String getRtmSsnType();
}