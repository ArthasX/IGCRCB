/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.model.condition;

import java.util.List;

/**
  * ����: ���������������ʵ��
  * ��������: ���������������ʵ��
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
public class WorkDefinitionSearchCondImpl implements
		WorkDefinitionSearchCond {
	
	/**
	 * ����������
	 */
	protected String wdname;
	
	/**
	 * �����ˣ�userid��
	 */
	protected String initiatorId;
	
	/**
	 * ����������
	 */
	protected String leaderName;
	
	/**
	 * �����ˣ�useridƥ������
	 */
	protected List<String> initiatorId_in;
	
	/**
	 * ִ��������
	 */
	protected String excutorName;
	
	/**
	 * ����״̬��0��δ���ã�1�������ã�
	 */
	protected String wdstatus;
	
	/** 
	 * �����ˣ�userid��
	 */
	protected String leaderId;
	
	/**
	 * ��ʼ���ڴ�
	 */
	protected String beginDateStart;
	
	/**
	 * ��ʼ���ڵ�
	 */
	protected String beginDateOver;

	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getWdname() {
		return wdname;
	}

	/**
	 * �����������趨
	 * @param ����������
	 */
	public void setWdname(String wdname) {
		this.wdname = wdname;
	}

	/**
	 * �����ˣ�userid��ȡ��
	 * @return �����ˣ�userid��
	 */
	public String getInitiatorId() {
		return initiatorId;
	}

	/**
	 * �����ˣ�userid���趨
	 * @param �����ˣ�userid��
	 */
	public void setInitiatorId(String initiatorId) {
		this.initiatorId = initiatorId;
	}
	
	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getLeaderName() {
		return leaderName;
	}

	/**
	 * �����������趨
	 * @param ����������
	 */
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	/**
	 * �����ˣ�useridƥ������ȡ��
	 * @return �����ˣ�useridƥ������
	 */
	public List<String> getInitiatorId_in() {
		return initiatorId_in;
	}

	/**
	 * �����ˣ�useridƥ�������趨
	 * @param �����ˣ�useridƥ������
	 */
	public void setInitiatorId_in(List<String> initiatorId_in) {
		this.initiatorId_in = initiatorId_in;
	}

	/**
	 * ִ��������ȡ��
	 * @return ִ��������
	 */
	public String getExcutorName() {
		return excutorName;
	}

	/**
	 * ִ���������趨
	 * @param ִ��������
	 */
	public void setExcutorName(String excutorName) {
		this.excutorName = excutorName;
	}

	/**
	 * ����״̬��0��δ���ã�1�������ã�ȡ��
	 * @return ����״̬��0��δ���ã�1�������ã�
	 */
	public String getWdstatus() {
		return wdstatus;
	}

	/**
	 * ����״̬��0��δ���ã�1�������ã��趨
	 * @param ����״̬��0��δ���ã�1�������ã� 
	 */
	public void setWdstatus(String wdstatus) {
		this.wdstatus = wdstatus;
	}

	/**
	 * �����ˣ�userid��ȡ��
	 * @return �����ˣ�userid��
	 */
	public String getLeaderId() {
		return leaderId;
	}

	/**
	 * �����ˣ�userid���趨
	 * @param �����ˣ�userid��
	 */
	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}

	/**
	 * ��ʼ���ڴ�ȡ��
	 * @return ��ʼ���ڴ�
	 */
	public String getBeginDateStart() {
		return beginDateStart;
	}

	/**
	 * ��ʼ���ڴ��趨
	 * @param ��ʼ���ڴ�
	 */
	public void setBeginDateStart(String beginDateStart) {
		this.beginDateStart = beginDateStart;
	}

	/**
	 * ��ʼ���ڵ�ȡ��
	 * @return ��ʼ���ڵ�
	 */
	public String getBeginDateOver() {
		return beginDateOver;
	}

	/**
	 * ��ʼ���ڵ��趨
	 * @param ��ʼ���ڵ�
	 */
	public void setBeginDateOver(String beginDateOver) {
		this.beginDateOver = beginDateOver;
	}
	
}