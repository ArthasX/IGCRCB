/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * ����: ������ͱ��������ʵ��
  * ��������: ������ͱ��������ʵ��
  * ������¼: 2012/02/07
  * �޸ļ�¼: 
  */
public class MonitorTypeSearchCondImpl implements
		MonitorTypeSearchCond {
	/**
	 * ���β����
	 */
	protected String mtSyscoding;

	/**
	 * ���β��������
	 */
	protected String mtSyscoding_like;
	
	/**
	 * ���β�������ƻ�ȡ
	 * @return
	 */
	public String getMtSyscoding_like() {
		return mtSyscoding_like;
	}

	/**
	 * ���β���������趨
	 * @param mtSyscoding_like
	 */
	public void setMtSyscoding_like(String mtSyscoding_like) {
		this.mtSyscoding_like = mtSyscoding_like;
	}

	/**
	 * ���β����ȡ��
	 * @return
	 */
	public String getMtSyscoding() {
		return mtSyscoding;
	}

	/**
	 * ���β�����趨
	 * @param mtSyscoding
	 */
	public void setMtSyscoding(String mtSyscoding) {
		this.mtSyscoding = mtSyscoding;
	}
}