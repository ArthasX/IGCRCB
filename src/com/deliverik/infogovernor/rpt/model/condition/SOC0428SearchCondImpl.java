/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: ҵ��ϵͳ��ͼ��������ʵ��
  * ��������: ҵ��ϵͳ��ͼ��������ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��BusinessCapacityRealTimeVWSearchCondImpl������ΪSOC0428SearchCondImpl
  */
public class SOC0428SearchCondImpl implements
		SOC0428SearchCond {
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