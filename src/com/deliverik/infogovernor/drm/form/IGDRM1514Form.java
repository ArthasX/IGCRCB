/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ѵ�����ѯ������
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM1514Form extends BaseForm {

	/** ���� */
	protected  Integer tpid;

	/** �ƻ����� */
	protected String tpname;

	/** ������id */
	protected String tpuserid;

	/** ���������� */
	protected String tpusername;

	/** ������id */
	protected String tporgid;

	/** ���������� */
	protected String tporgname;

	/** �������� */
	protected String tptime;

	/** �ƻ�״̬ */
	protected String tpstatus;
	
	/** ����ʱ�俪ʼʱ�� */
	protected String startTimeBegin;
	
	/** ����ʱ�����ʱ�� */
	protected String startTimeEnd;
	

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getTpid() {
		return tpid;
	}

	/**
	 * �����趨
	 *
	 * @param tpid ����
	 */
	public void setTpid(Integer tpid) {
		this.tpid = tpid;
	}

	/**
	 * �ƻ�����ȡ��
	 *
	 * @return �ƻ�����
	 */
	public String getTpname() {
		return tpname;
	}

	/**
	 * �ƻ������趨
	 *
	 * @param tpname �ƻ�����
	 */
	public void setTpname(String tpname) {
		this.tpname = tpname;
	}

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getTpuserid() {
		return tpuserid;
	}

	/**
	 * ������id�趨
	 *
	 * @param tpuserid ������id
	 */
	public void setTpuserid(String tpuserid) {
		this.tpuserid = tpuserid;
	}

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
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getTporgid() {
		return tporgid;
	}

	/**
	 * ������id�趨
	 *
	 * @param tporgid ������id
	 */
	public void setTporgid(String tporgid) {
		this.tporgid = tporgid;
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
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getTptime() {
		return tptime;
	}

	/**
	 * ���������趨
	 *
	 * @param tptime ��������
	 */
	public void setTptime(String tptime) {
		this.tptime = tptime;
	}

	/**
	 * �ƻ�״̬ȡ��
	 *
	 * @return �ƻ�״̬
	 */
	public String getTpstatus() {
		return tpstatus;
	}

	/**
	 * �ƻ�״̬�趨
	 *
	 * @param tpstatus �ƻ�״̬
	 */
	public void setTpstatus(String tpstatus) {
		this.tpstatus = tpstatus;
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
