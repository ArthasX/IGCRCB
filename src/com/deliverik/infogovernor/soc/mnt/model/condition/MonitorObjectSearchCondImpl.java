/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * ����: ��ض�����Ϣ��������ʵ��
  * ��������: ��ض�����Ϣ��������ʵ��
  * ������¼: 2012/02/08
  * �޸ļ�¼: 
  */
public class MonitorObjectSearchCondImpl implements
		MonitorObjectSearchCond {

	/**
	 * �����
	 */
	protected String mtSyscoding;
	
	/**
	 * ��ض�������
	 */
	protected String moName;
	
	/**
	 * ����ʱ���
	 */
	protected String moCreateTime_from;
	
	/**
	 * ����ʱ�䵽
	 */
	protected String moCreateTime_to;

	/**
	 * ��ض������ƻ�ȡ
	 * @return
	 */
	public String getMoName() {
		return moName;
	}

	/**
	 * ��ض��������趨
	 * @param moName
	 */
	public void setMoName(String moName) {
		this.moName = moName;
	}

	/**
	 * ����ʱ�䵽��ȡ
	 * @return
	 */
	public String getMoCreateTime_to() {
		return moCreateTime_to;
	}
	
	/**
	 * ����ʱ�䵽�趨
	 * @return
	 */
	public void setMoCreateTime_to(String moCreateTime_to) {
		this.moCreateTime_to = moCreateTime_to;
	}

	/**
	 * ����ʱ��ӻ�ȡ
	 * @return
	 */
	public String getMoCreateTime_from() {
		return moCreateTime_from;
	}

	/**
	 * ����ʱ����趨
	 * @return
	 */
	public void setMoCreateTime_from(String moCreateTime_from) {
		this.moCreateTime_from = moCreateTime_from;
	}

	/**
	 * ������ȡ
	 * @return
	 */
	public String getMtSyscoding() {
		return mtSyscoding;
	}

	/**
	 * ������趨
	 * @param mtSyscoding
	 */
	public void setMtSyscoding(String mtSyscoding) {
		this.mtSyscoding = mtSyscoding;
	}
	
}