/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.condition;

/**
  * ����: CRM09��������ʵ��
  * ��������: CRM09��������ʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public class CRM09SearchCondImpl implements
		CRM09SearchCond {
	
	protected String serverid_eq;
	
	protected Integer ruletempid_eq;
	
	protected Integer[] ruletempids_notIn;
	

	public Integer[] getRuletempids_notIn() {
		return ruletempids_notIn;
	}

	public void setRuletempids_notIn(Integer[] ruletempids_notIn) {
		this.ruletempids_notIn = ruletempids_notIn;
	}

	public String getServerid_eq() {
		return serverid_eq;
	}

	public void setServerid_eq(String serverid_eq) {
		this.serverid_eq = serverid_eq;
	}

	public Integer getRuletempid_eq() {
		return ruletempid_eq;
	}

	public void setRuletempid_eq(Integer ruletempid_eq) {
		this.ruletempid_eq = ruletempid_eq;
	}

}