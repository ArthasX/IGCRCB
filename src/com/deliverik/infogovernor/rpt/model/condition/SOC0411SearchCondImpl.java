/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: �洢����ʵʱ���������ʵ��
  * ��������: �洢����ʵʱ���������ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��StorageCapacityRealTimeSearchCondImpl������ΪSOC0411SearchCondImpl
  */
public class SOC0411SearchCondImpl implements
		SOC0411SearchCond {
	/**�洢id eq*/
	protected String sName;

	/**
	 * �洢ideqȡ��
	 *
	 * @return sName �洢ideq
	 */
	public String getSName() {
		return sName;
	}

	/**
	 * �洢ideq�趨
	 *
	 * @param name sName
	 */
	public void setSName(String name) {
		sName = name;
	}
}