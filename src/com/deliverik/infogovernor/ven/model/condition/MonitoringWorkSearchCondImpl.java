/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.model.condition;

/**
  * ����: ��⹤������������ʵ��
  * ��������: ��⹤������������ʵ��
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
public class MonitoringWorkSearchCondImpl implements MonitoringWorkSearchCond {

	/** ���ղ�������id */
	protected Integer rmid;

	/** ����� null */
	protected String result_isNotNull;
	
	/** ָ������  */	
	protected String einame;
	
	/** ָ����  */	
	protected String eilabel;
	
	/**
	 * ���ղ�������idȡ��
	 * @return rmid  ���ղ�������id
	 */
	public Integer getRmid() {
		return rmid;
	}

	/**
	 * ���ղ�������id�趨
	 * @param rmid  ���ղ�������id
	 */
	public void setRmid(Integer rmid) {
		this.rmid = rmid;
	}

	/**
	 * �����nullȡ��
	 * @return result_isNotNull  �����null
	 */
	public String getResult_isNotNull() {
		return result_isNotNull;
	}

	/**
	 * �����null�趨
	 * @param result_isNotNull  �����null
	 */
	public void setResult_isNotNull(String result_isNotNull) {
		this.result_isNotNull = result_isNotNull;
	}

	/**
	 * ָ������ȡ��
	 * @return einame  ָ������
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ָ�������趨
	 * @param einame  ָ������
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * ָ����ȡ��
	 * @return eilabel  ָ����
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * ָ�����趨
	 * @param eilabel  ָ����
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}


}