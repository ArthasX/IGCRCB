/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: ����pvʵʱ���������ʵ��
  * ��������: ����pvʵʱ���������ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��PVHostRealTimeSearchCondImpl������ΪSOC0409SearchCondImpl
  */
public class SOC0409SearchCondImpl implements
		SOC0409SearchCond {
	protected String hostName_eq;
	protected String sName_eq;
	protected String[] hostName_notin;
	protected String[] sName_notin;

	/**
	 * hostName_eqȡ��
	 *
	 * @return hostName_eq hostName_eq
	 */
	public String getHostName_eq() {
		return hostName_eq;
	}

	/**
	 * hostName_eq�趨
	 *
	 * @param hostName_eq hostName_eq
	 */
	public void setHostName_eq(String hostName_eq) {
		this.hostName_eq = hostName_eq;
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
	 * hostName_notinȡ��
	 *
	 * @return hostName_notin hostName_notin
	 */
	public String[] getHostName_notin() {
		return hostName_notin;
	}

	/**
	 * sName_notinȡ��
	 *
	 * @return sName_notin sName_notin
	 */
	public String[] getSName_notin() {
		return sName_notin;
	}

	/**
	 * hostName_notin�趨
	 *
	 * @param hostName_notin hostName_notin
	 */
	public void setHostName_notin(String[] hostName_notin) {
		this.hostName_notin = hostName_notin;
	}

	/**
	 * sName_notin�趨
	 *
	 * @param name_notin sName_notin
	 */
	public void setSName_notin(String[] name_notin) {
		sName_notin = name_notin;
	}
}