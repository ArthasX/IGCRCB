/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.condition;

import java.io.Serializable;

/**
  * ����: ���Ѽ�¼���������ʵ��
  * ��������: ���Ѽ�¼���������ʵ��
  * ������¼: 2012/04/25
  * �޸ļ�¼: 
  */
public class IG394SearchCondImpl implements
		IG394SearchCond {
	protected Integer pnssid;

	/** ����id */
	protected Integer prid;

	/** ״̬ID */
	protected String psdid;

	/** �ӵ�״̬ */
	protected String psdconfirm;

	/** ��ɫID */
	protected Integer roleid;

	/** �������û�ID */
	protected String userid;

	/** ���Ͷ���ʱ�� */
	protected String notifysmstime;

	/** �����ʼ�ʱ�� */
	protected String notifyemailtime;
	
	protected String reportsmstime;
	
	protected String reportemailtime;
	
	protected String flag;
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPnssid() {
		return pnssid;
	}

	/**
	 * �����趨
	 *
	 * @param pnssid ����
	 */
	public void setPnssid(Integer pnssid) {
		this.pnssid = pnssid;
	}

	/**
	 * ����idȡ��
	 *
	 * @return ����id
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����id�趨
	 *
	 * @param prid ����id
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ״̬IDȡ��
	 *
	 * @return ״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ״̬ID�趨
	 *
	 * @param psdid ״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * �ӵ�״̬ȡ��
	 *
	 * @return �ӵ�״̬
	 */
	public String getPsdconfirm() {
		return psdconfirm;
	}

	/**
	 * �ӵ�״̬�趨
	 *
	 * @param psdconfirm �ӵ�״̬
	 */
	public void setPsdconfirm(String psdconfirm) {
		this.psdconfirm = psdconfirm;
	}

	/**
	 * ��ɫIDȡ��
	 *
	 * @return ��ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * ��ɫID�趨
	 *
	 * @param roleid ��ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * �������û�IDȡ��
	 *
	 * @return �������û�ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �������û�ID�趨
	 *
	 * @param userid �������û�ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return pnssid;
	}

	public String getNotifysmstime() {
		return notifysmstime;
	}

	public void setNotifysmstime(String notifysmstime) {
		this.notifysmstime = notifysmstime;
	}

	public String getNotifyemailtime() {
		return notifyemailtime;
	}

	public void setNotifyemailtime(String notifyemailtime) {
		this.notifyemailtime = notifyemailtime;
	}

	public String getReportsmstime() {
		return reportsmstime;
	}

	public void setReportsmstime(String reportsmstime) {
		this.reportsmstime = reportsmstime;
	}

	public String getReportemailtime() {
		return reportemailtime;
	}

	public void setReportemailtime(String reportemailtime) {
		this.reportemailtime = reportemailtime;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	
	
	

}