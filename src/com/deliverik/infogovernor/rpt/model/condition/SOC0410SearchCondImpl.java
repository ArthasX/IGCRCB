/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: �洢lunʵʱ���������ʵ��
  * ��������: �洢lunʵʱ���������ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��PVStorageRealTimeSearchCondImpl������ΪSOC0410SearchCondImpl
  */
public class SOC0410SearchCondImpl implements
		SOC0410SearchCond {
	protected String isUsed_eq;
	protected String sName_eq;
	/**
	 * isUsed_eqȡ��
	 *
	 * @return isUsed_eq isUsed_eq
	 */
	public String getIsUsed_eq() {
		return isUsed_eq;
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
	 * isUsed_eq�趨
	 *
	 * @param isUsed_eq isUsed_eq
	 */
	public void setIsUsed_eq(String isUsed_eq) {
		this.isUsed_eq = isUsed_eq;
	}
	/**
	 * sName_eq�趨
	 *
	 * @param name_eq sName_eq
	 */
	public void setSName_eq(String name_eq) {
		sName_eq = name_eq;
	}

}