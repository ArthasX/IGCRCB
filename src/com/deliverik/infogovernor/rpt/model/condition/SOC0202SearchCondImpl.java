/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: ���ӱ����������ʵ��
  * ��������: ���ӱ����������ʵ��
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/09 ��ReportAnnexationSearchCondImpl������ΪSOC0202SearchCondImpl
  */
public class SOC0202SearchCondImpl implements
		SOC0202SearchCond {
	/**�û����ֵ���*/
	protected String raUserName_eq;

	/**
	 * �û����ֵ���ȡ��
	 *
	 * @return raUserName_eq �û����ֵ���
	 */
	public String getRaUserName_eq() {
		return raUserName_eq;
	}

	/**
	 * �û����ֵ����趨
	 *
	 * @param raUserName_eq �û����ֵ���
	 */
	public void setRaUserName_eq(String raUserName_eq) {
		this.raUserName_eq = raUserName_eq;
	}
	
	
}