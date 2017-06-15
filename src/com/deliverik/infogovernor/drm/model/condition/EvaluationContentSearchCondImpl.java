/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

import java.io.Serializable;

/**
  * ����: ��Ŀ�ܱ���Ա��������������ʵ��
  * ��������: ��Ŀ�ܱ���Ա��������������ʵ��
  * ������¼: 2016/08/11
  * �޸ļ�¼: 
  */
public class EvaluationContentSearchCondImpl implements
		EvaluationContentSearchCond {
	protected Integer evid;

	/** ����ID */
	protected Integer prid;

	/** ��� */
	protected Integer sortId;

	/** �ڵ����� */
	protected String stepName;

	/** ������ */
	protected String peoples;

	/** ��ʼʱ�� */
	protected String startTime;

	/** ����ʱ�� */
	protected String stopTime;


	/** ��� */
	protected String suggestion;

	/** ������ */
	protected String evpeople;

	
	/**�ڵ�ID*/
	
	protected String psdid;
	
	/**����ʱ��*/
	
	protected String doTime;
	/**��������*/
	protected String flowType;
	
	
	
	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getEvid() {
		return evid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param evid ����ID
	 */
	public void setEvid(Integer evid) {
		this.evid = evid;
	}

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param prid ����ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ���ȡ��
	 *
	 * @return ���
	 */
	public Integer getSortId() {
		return sortId;
	}

	/**
	 * ����趨
	 *
	 * @param sortId ���
	 */
	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	}

	/**
	 * �ڵ�����ȡ��
	 *
	 * @return �ڵ�����
	 */
	public String getStepName() {
		return stepName;
	}

	/**
	 * �ڵ������趨
	 *
	 * @param stepName �ڵ�����
	 */
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getPeoples() {
		return peoples;
	}

	/**
	 * �������趨
	 *
	 * @param peoples ������
	 */
	public void setPeoples(String peoples) {
		this.peoples = peoples;
	}

	/**
	 * ��ʼʱ��ȡ��
	 *
	 * @return ��ʼʱ��
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * ��ʼʱ���趨
	 *
	 * @param startTime ��ʼʱ��
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getStopTime() {
		return stopTime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param stopTime ����ʱ��
	 */
	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}


	/**
	 * ���ȡ��
	 *
	 * @return ���
	 */
	public String getSuggestion() {
		return suggestion;
	}

	/**
	 * ����趨
	 *
	 * @param suggestion ���
	 */
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getEvpeople() {
		return evpeople;
	}

	/**
	 * �������趨
	 *
	 * @param evpeople ������
	 */
	public void setEvpeople(String evpeople) {
		this.evpeople = evpeople;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return evid;
	}

	/**  
	 * ��ȡpsdid  
	 * @return psdid 
	 */
	public String getPsdid() {
		return psdid;
	}

	/**  
	 * ����psdid  
	 * @param psdid
	 */
	
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**  
	 * ��ȡdoTime  
	 * @return doTime 
	 */
	public String getDoTime() {
		return doTime;
	}

	/**  
	 * ����doTime  
	 * @param doTime
	 */
	
	public void setDoTime(String doTime) {
		this.doTime = doTime;
	}

	/**  
	 * ��ȡflowType  
	 * @return flowType 
	 */
	public String getFlowType() {
		return flowType;
	}

	/**  
	 * ����flowType  
	 * @param flowType
	 */
	
	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}
	
}