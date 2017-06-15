package com.deliverik.infogovernor.syslog.form;


import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.syslog.model.condition.Mss00012SearchCond;
import com.deliverik.infogovernor.syslog.model.condition.Mss00009SearchCond;

/**
 * @author Administrator
 *
 */
public class IGLOG0102Form extends BaseForm implements Mss00009SearchCond,Mss00012SearchCond{

	private static final long serialVersionUID = 1L;
	/** �澯���ȼ���ʶ */
	protected String priority_eq;
	
	protected String state;
	
	/** ����ʵʱ�澯��Ϣ��ʶ */
	protected String isRealTimeCollect;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	/** ��ʼ�ĸ澯����ʱ�� */
	protected String alarmtime_from;
	
	/** �����ĸ澯����ʱ�� */
	protected String alarmtime_to;
	
	/** �澯�豸IP */
	protected String ip_like;
	
	/** �豸���� */
	protected String ename;
	
	/** �ؼ��� */
	protected String word_like;
	
	/** */
	protected String esyscoding;
	
	/** ģ����� */
	protected String exceltitle;
	/** �澯״̬ */
	protected String alarmstate;
	protected String endtime_from;
	protected String endtime_to;
	protected String starttime_from;
	protected String starttime_to;
	protected List<CodeDetail> ruleli=null;
	protected  String[]cvalue;
	protected Integer[]id;
	
	public Integer[] getId() {
		return id;
	}
	public void setId(Integer[] id) {
		this.id = id;
	}
	public String[] getCvalue() {
		return cvalue;
	}
	public void setCvalue(String[] cvalue) {
		this.cvalue = cvalue;
	}
	public List<CodeDetail> getRuleli() {
		return ruleli;
	}
	public void setRuleli(List<CodeDetail> ruleli) {
		this.ruleli = ruleli;
	}
	

	public String getAlarmstate() {
		return alarmstate;
	}
	public void setAlarmstate(String alarmstate) {
		this.alarmstate = alarmstate;
	}

	
	public String getEndtime_from() {
		return endtime_from;
	}
	public void setEndtime_from(String endtime_from) {
		this.endtime_from = endtime_from;
	}
	public String getEndtime_to() {
		return endtime_to;
	}
	public void setEndtime_to(String endtime_to) {
		this.endtime_to = endtime_to;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/** �澯���ȼ���ʶ */
	protected String[] priority;
	
	public String[] getPriority() {
		return priority;
	}
	public void setPriority(String[] priority) {
		this.priority = priority;
	}
	public String getEsyscoding() {
		return esyscoding;
	}
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	public String getWord_like() {
		return word_like;
	}
	public void setWord_like(String word_like) {
		this.word_like = word_like;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	
	public String getStarttime_from() {
		return starttime_from;
	}
	public void setStarttime_from(String starttime_from) {
		this.starttime_from = starttime_from;
	}
	public String getStarttime_to() {
		return starttime_to;
	}
	public void setStarttime_to(String starttime_to) {
		this.starttime_to = starttime_to;
	}
	public String getIp_like() {
		return ip_like;
	}
	public void setIp_like(String ip_like) {
		this.ip_like = ip_like;
	}
	public String getPriority_eq() {
		return priority_eq;
	}
	public void setPriority_eq(String priority_eq) {
		this.priority_eq = priority_eq;
	}
	public String getExceltitle() {
		return exceltitle;
	}
	public String getAlarmtime_from() {
		return alarmtime_from;
	}
	public void setAlarmtime_from(String alarmtime_from) {
		this.alarmtime_from = alarmtime_from;
	}
	public String getAlarmtime_to() {
		return alarmtime_to;
	}
	public void setAlarmtime_to(String alarmtime_to) {
		this.alarmtime_to = alarmtime_to;
	}
	public void setExceltitle(String exceltitle) {
		this.exceltitle = exceltitle;
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
