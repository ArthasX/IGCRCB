/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * ����: �澯ϵͳ��ʾ��Ϣ���������ʵ��
  * ��������: �澯ϵͳ��ʾ��Ϣ���������ʵ��
  * ������¼: 2014/03/05
  * �޸ļ�¼: 
  */
public class IndicatorLightsSystemSearchCondImpl implements
		IndicatorLightsSystemSearchCond {

	/** ϵͳ���� */
	protected String ilsname;

	/** ״̬ */
	protected String ilsstatus;

	/**
	 * ϵͳ����ȡ��
	 *
	 * @return ϵͳ����
	 */
	public String getIlsname() {
		return ilsname;
	}

	/**
	 * ϵͳ�����趨
	 *
	 * @param ilsname ϵͳ����
	 */
	public void setIlsname(String ilsname) {
		this.ilsname = ilsname;
	}

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getIlsstatus() {
		return ilsstatus;
	}

	/**
	 * ״̬�趨
	 *
	 * @param ilsstatus ״̬
	 */
	public void setIlsstatus(String ilsstatus) {
		this.ilsstatus = ilsstatus;
	}

}