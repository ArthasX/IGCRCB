/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: PVVIO��������ʵ��
  * ��������: PVVIO��������ʵ��
  * ������¼: 2012/08/20
  * �޸ļ�¼: 
  */
public class SOC0434SearchCondImpl implements
		SOC0434SearchCond {
	protected String sName;
	protected String isUsed;
	protected String sN;
	/**
	 * sNameȡ��
	 *
	 * @return sName sName
	 */
	public String getSName() {
		return sName;
	}
	/**
	 * sName�趨
	 *
	 * @param name sName
	 */
	public void setSName(String name) {
		sName = name;
	}
	/**
	 * isUsedȡ��
	 *
	 * @return isUsed isUsed
	 */
	public String getIsUsed() {
		return isUsed;
	}
	/**
	 * isUsed�趨
	 *
	 * @param isUsed isUsed
	 */
	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}
	/**
	 * sNȡ��
	 *
	 * @return sN sN
	 */
	public String getSN() {
		return sN;
	}
	/**
	 * sN�趨
	 *
	 * @param sn sN
	 */
	public void setSN(String sn) {
		sN = sn;
	}
}