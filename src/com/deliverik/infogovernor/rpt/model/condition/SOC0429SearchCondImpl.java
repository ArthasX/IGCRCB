/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: ����������ͼ��������ʵ��
  * ��������: ����������ͼ��������ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��HostCapacityRealTimeVWSearchCondImpl������ΪSOC0429SearchCondImpl
  */
public class SOC0429SearchCondImpl implements
		SOC0429SearchCond {
	protected Integer bcId_eq;
	protected String sName_eq;
	protected String bcName_eq;

	/**
	 * bcId_eqȡ��
	 *
	 * @return bcId_eq bcId_eq
	 */
	public Integer getBcId_eq() {
		return bcId_eq;
	}

	/**
	 * bcId_eq�趨
	 *
	 * @param bcId_eq bcId_eq
	 */
	public void setBcId_eq(Integer bcId_eq) {
		this.bcId_eq = bcId_eq;
	}

	/**
	 * sName_eqȡ��
	 *
	 * @return sName_eq sName_eq
	 */
	public String getSName_eq() {
		return sName_eq;
	}

	/**
	 * sName_eq�趨
	 *
	 * @param name_eq sName_eq
	 */
	public void setSName_eq(String name_eq) {
		sName_eq = name_eq;
	}

	/**
	 * bcName_eqȡ��
	 *
	 * @return bcName_eq bcName_eq
	 */
	public String getBcName_eq() {
		return bcName_eq;
	}

	/**
	 * bcName_eq�趨
	 *
	 * @param bcName_eq bcName_eq
	 */
	public void setBcName_eq(String bcName_eq) {
		this.bcName_eq = bcName_eq;
	}

}