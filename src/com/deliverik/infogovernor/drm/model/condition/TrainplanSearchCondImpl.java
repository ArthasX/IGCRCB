/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * ����: ��ѵ�ƻ����������ʵ��
  * ��������: ��ѵ�ƻ����������ʵ��
  * ������¼: 2015/04/10
  * �޸ļ�¼: 
  */
public class TrainplanSearchCondImpl implements
		TrainplanSearchCond {
	

	/** ���������� */
	protected String tpusername;

	/** ���������� */
	protected String tporgname;
	
	/** ����ʱ�俪ʼʱ�� */
	protected String startTimeBegin;
	
	/** ����ʱ�����ʱ�� */
	protected String startTimeEnd;
	
	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getTpusername() {
		return tpusername;
	}

	/**
	 * �����������趨
	 *
	 * @param tpusername ����������
	 */
	public void setTpusername(String tpusername) {
		this.tpusername = tpusername;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getTporgname() {
		return tporgname;
	}

	/**
	 * �����������趨
	 *
	 * @param tporgname ����������
	 */
	public void setTporgname(String tporgname) {
		this.tporgname = tporgname;
	}

	/**
	 * ����ʱ�俪ʼʱ��ȡ��
	 *
	 * @return ����ʱ�俪ʼʱ��
	 */
	public String getStartTimeBegin() {
		return startTimeBegin;
	}
 
	/**
	 * ����ʱ�俪ʼʱ���趨
	 *
	 * @return startTimeBegin ����ʱ�俪ʼʱ��
	 */
	public void setStartTimeBegin(String startTimeBegin) {
		this.startTimeBegin = startTimeBegin;
	}

	/**
	 * ����ʱ�����ʱ��ȡ��
	 *
	 * @return ����ʱ�����ʱ��
	 */
	public String getStartTimeEnd() {
		return startTimeEnd;
	}

	/**
	 * ����ʱ�����ʱ���趨
	 *
	 * @return startTimeEnd ����ʱ�����ʱ��
	 */
	public void setStartTimeEnd(String startTimeEnd) {
		this.startTimeEnd = startTimeEnd;
	}
	
	
}