package com.deliverik.infogovernor.syslog.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.syslog.model.condition.Mss00008SearchCond;

public class IGLOG0101Form extends BaseForm implements Mss00008SearchCond{

	private static final long serialVersionUID = 1L;
	/** �澯���ȼ���ʶ */
	protected String[] priority;
	
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
	
	protected String isquery;
	
	/** Ҫ�޸��ĸ澯id���� */
	protected String[] ids;
	
	/** ģ����� */
	protected String exceltitle;
	
	protected String id;
	/** �澯�豸IP */
	protected String ip_eq;
	
	protected String priority_eq;
	
	protected String content;
	
	/** ����ʵʱ�澯��Ϣ��ʶ */
	protected String isRealTimeCollect;
	
	public String getIp_eq() {
		return ip_eq;
	}
	public void setIp_eq(String ip_eq) {
		this.ip_eq = ip_eq;
	}
	public String getPriority_eq() {
		return priority_eq;
	}
	public void setPriority_eq(String priority_eq) {
		this.priority_eq = priority_eq;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String[] getIds() {
		return ids;
	}
	public void setIds(String[] ids) {
		this.ids = ids;
	}
	public String getIsquery() {
		return isquery;
	}
	public void setIsquery(String isquery) {
		this.isquery = isquery;
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
	public String getIp_like() {
		return ip_like;
	}
	public void setIp_like(String ip_like) {
		this.ip_like = ip_like;
	}
	public String[] getPriority() {
		return priority;
	}
	public void setPriority(String[] priority) {
		this.priority = priority;
	}
	public String getExceltitle() {
		return exceltitle;
	}
	public void setExceltitle(String exceltitle) {
		this.exceltitle = exceltitle;
	}
	public String getIsalarm() {
		return null;
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
