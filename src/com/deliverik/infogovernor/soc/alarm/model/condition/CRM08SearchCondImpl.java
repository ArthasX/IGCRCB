/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.condition;

import java.util.List;

/**
  * ����: CRM08��������ʵ��
  * ��������: CRM08��������ʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public class CRM08SearchCondImpl implements
		CRM08SearchCond {
		/** ģ������ */
	protected String ruletempname;
	
	/** ģ��״̬ */
	protected Integer tempstate;
	
	/** ģ������ccid */
	protected String typeccid_eq;
	
	/** ģ������cid */
	protected String typecid_eq;
	
	protected List<Integer> ruletempids;


	public List<Integer> getRuletempids() {
		return ruletempids;
	}

	public void setRuletempids(List<Integer> ruletempids) {
		this.ruletempids = ruletempids;
	}
	
	public String getRuletempname() {
		return ruletempname;
	}

	public void setRuletempname(String ruletempname) {
		this.ruletempname = ruletempname;
	}

	public Integer getTempstate() {
		return tempstate;
	}

	public void setTempstate(Integer tempstate) {
		this.tempstate = tempstate;
	}

	public String getTypeccid_eq() {
		return typeccid_eq;
	}

	public void setTypeccid_eq(String typeccid_eq) {
		this.typeccid_eq = typeccid_eq;
	}

	public String getTypecid_eq() {
		return typecid_eq;
	}

	public void setTypecid_eq(String typecid_eq) {
		this.typecid_eq = typecid_eq;
	}

}