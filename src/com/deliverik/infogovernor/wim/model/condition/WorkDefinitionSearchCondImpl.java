/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.model.condition;

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
	 * ����״̬��0��δ���ã�1�������ã�
	 */
	protected String wdstatus;
	
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
	 * ��ʼ���ڴ�ȡ��
	 * @return ��ʼ���ڴ�
	 */
	public String getBeginDateStart() {
		return beginDateStart;
	}

	/**
	 * ��ʼ���ڵ�
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