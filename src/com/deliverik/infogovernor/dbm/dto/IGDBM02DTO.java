/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.dbm.dto;

import com.deliverik.framework.base.BaseDTO;

public class IGDBM02DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/*����һ����Ҫxml�����ַ���*/
	protected String resultXML;
	
	/*������ҳ�¼������⡢�������*/
	protected String processCount;
	
	/*������ҳ������������*/
	protected int currentMouthProblemCount;
	
	/*������ҳ�����¼�����*/
	protected int currentMouthEventCount;
	
	/*������ҳ����ƻ�������*/
	protected String valueOfDate;
	
	/*������ҳ�����Ĺ�������*/
	protected String workCount;
	
	/*�������ؼ�*/
	protected String monitor;
	
	/*����ƻ�����xml*/
	protected String changePlanCalender;
	
	/*�����ɹ����Ǳ�*/
	protected int meter;
	
	/**
	 * ������ҳ�����Ĺ�������ȡ��
	 * @return workCount
	 */
	public String getWorkCount() {
		return workCount;
	}
	/**
	 * ������ҳ�����Ĺ�����������
	 * @param  workCount ������ҳ�����Ĺ�������
	 */
	public void setWorkCount(String workCount) {
		this.workCount = workCount;
	}
	/**
	 * ������ҳ����ƻ�������ȡ��
	 * @return valueOfDate
	 */
	public String getValueOfDate() {
		return valueOfDate;
	}
	/**
	 * ������ҳ����ƻ�����������
	 * @param  valueOfDate ������ҳ����ƻ�������
	 */
	public void setValueOfDate(String valueOfDate) {
		this.valueOfDate = valueOfDate;
	}
	/**
	 * ������ҳ������������ȡ��
	 * @return currentMouthProblemCount
	 */
	public int getCurrentMouthProblemCount() {
		return currentMouthProblemCount;
	}
	/**
	 * ������ҳ����������������
	 * @param  processCount ������ҳ�¼������⡢�������
	 */
	public void setCurrentMouthProblemCount(int currentMouthProblemCount) {
		this.currentMouthProblemCount = currentMouthProblemCount;
	}
	/**
	 * ������ҳ�����¼�����ȡ��
	 * @return currentMouthEventCount
	 */
	public int getCurrentMouthEventCount() {
		return currentMouthEventCount;
	}
	/**
	 * ������ҳ�����¼���������
	 * @param  processCount ������ҳ�����¼�����
	 */
	public void setCurrentMouthEventCount(int currentMouthEventCount) {
		this.currentMouthEventCount = currentMouthEventCount;
	}
	/**
	 * ������ҳ�¼������⡢�������ȡ��
	 * @return processCount
	 */
	public String getProcessCount() {
		return processCount;
	}
	/**
	 * ������ҳ�¼������⡢�����������
	 * @param  processCount ������ҳ�¼������⡢�������
	 */
	public void setProcessCount(String processCount) {
		this.processCount = processCount;
	}

	public String getResultXML() {
		return resultXML;
	}
	public void setResultXML(String resultXML) {
		this.resultXML = resultXML;
	}
	public String getMonitor() {
		return monitor;
	}
	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}
	public String getChangePlanCalender() {
		return changePlanCalender;
	}
	public void setChangePlanCalender(String changePlanCalender) {
		this.changePlanCalender = changePlanCalender;
	}
	public int getMeter() {
		return meter;
	}
	public void setMeter(int meter) {
		this.meter = meter;
	}
	
}