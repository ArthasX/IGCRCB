package com.deliverik.infogovernor.syslog.form;

import com.deliverik.framework.base.BaseForm;
/**
 * 
 * ����ģ������form
 *
 * @���� zhaoyong
 *
 * 2013-4-2
 */
@SuppressWarnings("serial")
public class IGLOG0042Form extends BaseForm{

	/** ģ��id */
	protected Integer ruletempid;

	/** ģ������ */
	protected String ruletempname;

	/** ģ��״̬ */
	protected Integer tempstate;
	
	/** �豸����id */
	protected String typeid;
	
	/** ����ʱ�� */
	protected String createtime;
	
	/** ������������ */
	protected String[] alarmconditions;
	
	/** �������ݼ��� */
	protected String[] alarmmsgs;
	
	/** ���� */
	protected Integer rulecondition;
	
	/** ���� */
	protected String tempdesc;
	
	/** �澯���� */
	protected String[] priority;
	
	/** ����ʵʱ�澯��Ϣ��ʶ */
	protected String isRealTimeCollect;
	
	public String[] getPriority() {
		return priority;
	}

	public void setPriority(String[] priority) {
		this.priority = priority;
	}

	/**
	 * ģ��idȡ��
	 */
	public Integer getRuletempid() {
		return ruletempid;
	}

	/**
	 * ģ��id�趨
	 */
	public void setRuletempid(Integer ruletempid) {
		this.ruletempid = ruletempid;
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
	 * �豸����idȡ��
	 */
	public String getTypeid() {
		return typeid;
	}

	/**
	 * �豸����id�趨
	 */
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	/**
	 * ������������ȡ��
	 */
	public String[] getAlarmconditions() {
		return alarmconditions;
	}

	/**
	 * �������������趨
	 */
	public void setAlarmconditions(String[] alarmconditions) {
		this.alarmconditions = alarmconditions;
	}

	/**
	 * �������ݼ���ȡ��
	 */
	public String[] getAlarmmsgs() {
		return alarmmsgs;
	}

	/**
	 * �������ݼ����趨
	 */
	public void setAlarmmsgs(String[] alarmmsgs) {
		this.alarmmsgs = alarmmsgs;
	}

	/**
	 * ����ȡ��
	 */
	public Integer getRulecondition() {
		return rulecondition;
	}

	/**
	 * �����趨
	 */
	public void setRulecondition(Integer rulecondition) {
		this.rulecondition = rulecondition;
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
	 * ����ʵʱ�澯��Ϣ��ʶȡ��
	 *
	 * @return bname_like ����ʵʱ�澯��Ϣ��ʶ
	 */
	public String getIsRealTimeCollect() {
		return isRealTimeCollect;
	}
	
	/**
	 * ����ʵʱ�澯��Ϣ��ʶ�趨
	 *
	 * @param isRealTimeCollect ����ʵʱ�澯��Ϣ��ʶ
	 */
	public void setIsRealTimeCollect(String isRealTimeCollect) {
		this.isRealTimeCollect = isRealTimeCollect;
	}
	
}
