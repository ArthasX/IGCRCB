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
 * Description:
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM1502Form extends BaseForm {

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
	
	/** ��ѵ�γ� */
	protected String[] tmcourse;

	/** ��ѵ���� */
	protected String[] tmorg;

	/** ��ѵʱ�� */
	protected String[] tmtime;

	/** ��ѵ���� */
	protected String[] tmtarget;

	/** ���� */
	protected String[] tmatt;
	/**
	 * ����ʱ��
	 */
	private String startTime;

	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

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
	 * ��ѵ�γ�ȡ��
	 *
	 * @return ��ѵ�γ�
	 */
	public String[] getTmcourse() {
		return tmcourse;
	}

	/**
	 * ��ѵ�γ��趨
	 *
	 * @param tmcourse ��ѵ�γ�
	 */
	public void setTmcourse(String[] tmcourse) {
		this.tmcourse = tmcourse;
	}

	/**
	 * ��ѵ����ȡ��
	 *
	 * @return ��ѵ����
	 */
	public String[] getTmorg() {
		return tmorg;
	}

	/**
	 * ��ѵ�����趨
	 *
	 * @param tmorg ��ѵ����
	 */
	public void setTmorg(String[] tmorg) {
		this.tmorg = tmorg;
	}

	/**
	 * ��ѵʱ��ȡ��
	 *
	 * @return ��ѵʱ��
	 */
	public String[] getTmtime() {
		return tmtime;
	}

	/**
	 * ��ѵʱ���趨
	 *
	 * @param tmtime ��ѵʱ��
	 */
	public void setTmtime(String[] tmtime) {
		this.tmtime = tmtime;
	}

	/**
	 * ��ѵ����ȡ��
	 *
	 * @return ��ѵ����
	 */
	public String[] getTmtarget() {
		return tmtarget;
	}

	/**
	 * ��ѵ�����趨
	 *
	 * @param tmtarget ��ѵ����
	 */
	public void setTmtarget(String[] tmtarget) {
		this.tmtarget = tmtarget;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String[] getTmatt() {
		return tmatt;
	}

	/**
	 * �����趨
	 *
	 * @param tmatt ����
	 */
	public void setTmatt(String[] tmatt) {
		this.tmatt = tmatt;
	}
	
	
}
