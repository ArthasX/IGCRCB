/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: ������Դ��ͼ��������ʵ��
  * ��������: ������Դ��ͼ��������ʵ��
  * ������¼: 2011/11/24
  * �޸ļ�¼: 2012/08/09 ��ProcessRecordInfoVWSearchCondImpl������ΪSOC0209SearchCondImpl
  */
public class SOC0209SearchCondImpl implements
		SOC0209SearchCond {
	

	/** �������� */
	protected String prtype;
	
	/** ���̷���ʱ�� */
	protected String propentime;
	
	/**
	 * ���̷���ʱ��ȡ��
	 *
	 * @return ���̷���ʱ��
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * ���̷���ʱ���趨
	 *
	 * @param propentime ���̷���ʱ��
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}
	
	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * ���������趨
	 *
	 * @param prtype ��������
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

}