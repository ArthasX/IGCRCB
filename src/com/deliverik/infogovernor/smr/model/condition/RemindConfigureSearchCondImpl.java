/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.model.condition;

/**
  * ����: �������ñ��������ʵ��
  * ��������: �������ñ��������ʵ��
  * ������¼: 2013/08/05
  * �޸ļ�¼: 
  */
public class RemindConfigureSearchCondImpl implements
		RemindConfigureSearchCond {

	/** �� */
	protected String rcyear;
	
	/** ���� */
	protected String rctype;
	
	/**
	 * ��ȡ��
	 *
	 * @return ��
	 */
	public String getRcyear() {
		return rcyear;
	}

	/**
	 * ���趨
	 *
	 * @param rcyear ��
	 */
	public void setRcyear(String rcyear) {
		this.rcyear = rcyear;
	}
	
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getRctype() {
		return rctype;
	}

	/**
	 * �����趨
	 *
	 * @param rctype ����
	 */
	public void setRctype(String rctype) {
		this.rctype = rctype;
	}
}