/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: ģ��ӳ����������ʵ��
  * ��������: ģ��ӳ����������ʵ��
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/10 ��ReportTemplateMappingSearchCondImpl�����޸�ΪSOC0206SearchCondImpl
  */
public class SOC0206SearchCondImpl implements
		SOC0206SearchCond {
	protected Integer rtId_eq;
	
	protected Integer rtNumber_eq;

	/**
	 * rtId_eqȡ��
	 *
	 * @return rtId_eq rtId_eq
	 */
	public Integer getRtId_eq() {
		return rtId_eq;
	}

	/**
	 * rtId_eq�趨
	 *
	 * @param rtId_eq rtId_eq
	 */
	public void setRtId_eq(Integer rtId_eq) {
		this.rtId_eq = rtId_eq;
	}

	/**
	 * rtNumber_eqȡ��
	 *
	 * @return rtNumber_eq rtNumber_eq
	 */
	public Integer getRtNumber_eq() {
		return rtNumber_eq;
	}

	/**
	 * rtNumber_eq�趨
	 *
	 * @param rtNumber_eq rtNumber_eq
	 */
	public void setRtNumber_eq(Integer rtNumber_eq) {
		this.rtNumber_eq = rtNumber_eq;
	}

}