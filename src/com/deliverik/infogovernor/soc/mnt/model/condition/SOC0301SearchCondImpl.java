/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * ����: DMXʵʱ������ܱ��������ʵ��
  * ��������: DMXʵʱ������ܱ��������ʵ��
  * ������¼: 2012/05/16
  * �޸ļ�¼: 
  */
public class SOC0301SearchCondImpl implements SOC0301SearchCond {
	
	/** ����������� */
	private Integer mtId_eq;
	/** ������������� */
	private String mtoName_eq;
	/** ����kpi��� */
	private String mtKpi_eq;
	/** ʱ��� */
	private String timestamp_ge;
	/**
	 * �������������ȡ��
	 *
	 * @return mtoName_eq �������������
	 */
	public String getMtoName_eq() {
		return mtoName_eq;
	}

	/**
	 * ��������������趨
	 *
	 * @param mtoName_eq �������������
	 */
	public void setMtoName_eq(String mtoName_eq) {
		this.mtoName_eq = mtoName_eq;
	}

	/**
	 * ����kpi���ȡ��
	 *
	 * @return mtKpi_eq ����kpi���
	 */
	public String getMtKpi_eq() {
		return mtKpi_eq;
	}

	/**
	 * ����kpi����趨
	 *
	 * @param mtKpi_eq ����kpi���
	 */
	public void setMtKpi_eq(String mtKpi_eq) {
		this.mtKpi_eq = mtKpi_eq;
	}

	/**
	 * �����������ȡ��
	 *
	 * @return mtId_eq �����������
	 */
	public Integer getMtId_eq() {
		return mtId_eq;
	}

	/**
	 * ������������趨
	 *
	 * @param mtId_eq �����������
	 */
	public void setMtId_eq(Integer mtId_eq) {
		this.mtId_eq = mtId_eq;
	}

	/**
	 * ʱ���ȡ��
	 *
	 * @return timestamp_ge ʱ���
	 */
	public String getTimestamp_ge() {
		return timestamp_ge;
	}

	/**
	 * ʱ����趨
	 *
	 * @param timestamp_ge ʱ���
	 */
	public void setTimestamp_ge(String timestamp_ge) {
		this.timestamp_ge = timestamp_ge;
	}
}