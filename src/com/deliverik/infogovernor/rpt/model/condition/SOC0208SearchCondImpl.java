/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: �¼��������Ч�ʼ�������ʵ��
  * ��������: �¼��������Ч�ʼ�������ʵ��
  * ������¼: 2011/11/23
  * �޸ļ�¼: 2012/0810 ��ServeEfficiencySearchCondImpl�����޸�ΪSOC0208SearchCondImpl
  */
public class SOC0208SearchCondImpl implements
		SOC0208SearchCond {
	
	/** �������� */
	protected String prtype;
	
	/** ���������·� */
	protected String isNotTime;
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * ���������趨
	 * @param prtype ��������
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * ���������·�ȡ��
	 * @return ���������·�
	 */
	public String getIsNotTime() {
		return isNotTime;
	}

	/**
	 * ���������·��趨
	 * @param isNotTime���������·�
	 */
	public void setIsNotTime(String isNotTime) {
		this.isNotTime = isNotTime;
	}

	

}