/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.dbm.dto;

import com.deliverik.framework.base.BaseDTO;

public class IGDBM03DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/*����һ����Ҫxml�����ַ���*/
	protected String resultXML;
	
	/*�¼������⡢�������*/
	protected String processCount;
	
	/*����ƻ�������*/
	protected String valueOfDate;
	
	/*����ƻ�����xml*/
	protected String changePlanCalender;
	
	/*�����¼�����*/
	protected int currentMouthEventCount;
	
	/*������ҳ������������*/
	protected int currentMouthProblemCount;
	
	/*��������������͹�������*/
	protected String allTypeWorkCount;
	
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
	public String getChangePlanCalender() {
		return changePlanCalender;
	}
	public void setChangePlanCalender(String changePlanCalender) {
		this.changePlanCalender = changePlanCalender;
	}
	public int getCurrentMouthEventCount() {
		return currentMouthEventCount;
	}
	public void setCurrentMouthEventCount(int currentMouthEventCount) {
		this.currentMouthEventCount = currentMouthEventCount;
	}
	public int getCurrentMouthProblemCount() {
		return currentMouthProblemCount;
	}
	public void setCurrentMouthProblemCount(int currentMouthProblemCount) {
		this.currentMouthProblemCount = currentMouthProblemCount;
	}
	public String getAllTypeWorkCount() {
		return allTypeWorkCount;
	}
	public void setAllTypeWorkCount(String allTypeWorkCount) {
		this.allTypeWorkCount = allTypeWorkCount;
	}
	
	
}