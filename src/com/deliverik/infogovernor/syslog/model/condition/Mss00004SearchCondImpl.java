/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.condition;

import java.util.List;

/**
  * ����: �澯����ģ����������ʵ��
  * ��������: �澯����ģ����������ʵ��
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public class Mss00004SearchCondImpl implements
		Mss00004SearchCond {
	/** ����ģ��id */
	protected Integer ruletempid;

	/** �豸���� */
	protected String typeid;
	
	/** �������� */
	protected Integer rulecondition;
	
	/** ģ��״̬ */
	protected Integer tempstate;
	
	/** ����ʱ�� */
	protected String createtime;
	
	/** ģ������ */
	protected String ruletempname;
	
	protected String[] deleteId;
	
	/** ��ע */
	protected String tempdesc;
	
	/** ��ѯ����ģ��״̬ */
	protected Integer tempstates;
	
	/** ģ��id�б� */
	protected List<Integer> tempidList;
	
	/** ���� */
	protected String summary;
	
	
	/**
	 * ����ģ��idȡ��
	 */
	public Integer getRuletempid() {
		return ruletempid;
	}

	/**
	 * ����ģ��id�趨
	 */
	public void setRuletempid(Integer ruletempid) {
		this.ruletempid = ruletempid;
	}



	/**
	 * �豸����ȡ��
	 */
	public String getTypeid() {
		return typeid;
	}

	/**
	 * �豸�����趨
	 */
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	/**
	 * ��������ȡ��
	 */
	public Integer getRulecondition() {
		return rulecondition;
	}

	/**
	 * ���������趨
	 */
	public void setRulecondition(Integer rulecondition) {
		this.rulecondition = rulecondition;
	}

	/**
	 * ģ��״̬ȡ��
	 */
	public Integer getTempstate() {
		return tempstate;
	}

	/**
	 * ģ��״̬�趨
	 */
	public void setTempstate(Integer tempstate) {
		this.tempstate = tempstate;
	}

	/**
	 * ����ʱ��ȡ��
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * ����ʱ���趨
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	/**
	 * ģ������ȡ��
	 */
	public String getRuletempname() {
		return ruletempname;
	}

	/**
	 * ģ�������趨
	 */
	public void setRuletempname(String ruletempname) {
		this.ruletempname = ruletempname;
	}

	/**
	 * deleteIdȡ��
	 */
	public String[] getDeleteId() {
		return deleteId;
	}

	/**
	 * deleteId�趨
	 */
	public void setDeleteId(String[] deleteId) {
		this.deleteId = deleteId;
	}

	/**
	 * ����ȡ��
	 */
	public String getTempdesc() {
		return tempdesc;
	}

	/**
	 * �����趨
	 */
	public void setTempdesc(String tempdesc) {
		this.tempdesc = tempdesc;
	}

	/**
	 * ��ѯ����ģ��״̬ȡ��
	 */
	public Integer getTempstates() {
		return tempstates;
	}

	/**
	 * ��ѯ����ģ��״̬�趨
	 */
	public void setTempstates(Integer tempstates) {
		this.tempstates = tempstates;
	}

	public List<Integer> getTempidList() {
		return tempidList;
	}

	public void setTempidList(List<Integer> tempidList) {
		this.tempidList = tempidList;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
}