package com.deliverik.infogovernor.syslog.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.syslog.model.condition.Mss00008SearchCond;

public class IGLOG0101Form extends BaseForm implements Mss00008SearchCond{

	private static final long serialVersionUID = 1L;
	/** 告警优先级标识 */
	protected String[] priority;
	
	/** 开始的告警触发时间 */
	protected String alarmtime_from;
	
	/** 结束的告警触发时间 */
	protected String alarmtime_to;
	
	/** 告警设备IP */
	protected String ip_like;
	
	/** 设备类型 */
	protected String ename;
	
	/** 关键字 */
	protected String word_like;
	
	/** */
	protected String esyscoding;
	
	protected String isquery;
	
	/** 要修复的告警id数组 */
	protected String[] ids;
	
	/** 模板标题 */
	protected String exceltitle;
	
	protected String id;
	/** 告警设备IP */
	protected String ip_eq;
	
	protected String priority_eq;
	
	protected String content;
	
	/** 汇总实时告警信息标识 */
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
	 * 汇总实时告警信息标识取得
	 *
	 * @return bname_like 汇总实时告警信息标识
	 */
	public String getIsRealTimeCollect() {
		return isRealTimeCollect;
	}
	
	/**
	 * 汇总实时告警信息标识设定
	 *
	 * @param isRealTimeCollect 汇总实时告警信息标识
	 */
	public void setIsRealTimeCollect(String isRealTimeCollect) {
		this.isRealTimeCollect = isRealTimeCollect;
	}
}
