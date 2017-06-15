/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.entity;
import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.framework.workflow.prr.model.IG064Info;

/**
  * ����: ���̼�¼�ڵ�������ͼʵ��
  * ��������: ���̼�¼�ڵ�������ͼʵ��
  * ������¼: 2012/04/25
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class IG064VW implements Serializable,
		Cloneable, IG064Info {

	/** ����ID */
	protected Integer prid;
	
	protected String prtitle;

	protected String prserialnum;
	/** ����״̬ID */
	protected String psdid;

	/** ���̶���ID */
	protected String pdid;
	
	protected String psdname;

	/** ����״̬��ʾ */
	protected String psdcode;

	/** �Ƿ��ύ��0����1���ǣ� */
	protected String psdconfirm;

	/** ��ǰ�����ɫID */
	protected Integer pproleid;

	/** �����ɫ���� */
	protected String pprolename;

	/** ��ǰ������ԱID */
	protected String ppuserid;

	/** ��Ա���� */
	protected String ppusername;

	/** �ӵ����� */
	protected String ppsubstatus;
	
	protected String ppinittime;

	/** �ӵ�ʱ�� */
	protected String ppbacktime;

	/** ���Զ���״̬ID */
	protected String pnsdpsdid;

	/** ���Ա��ύ��ʾ */
	protected String pnsdconfirm;

	/** �Ƿ��Ͷ��� */
	protected String sms;

	/** �Ƿ���EMAIL */
	protected String email;

	/** ֪ͨʱ���� */
	protected Integer notifyd;

	/** ֪ͨСʱ */
	protected Integer notifyh;

	/** ֪ͨʱ��� */
	protected Integer notifym;

	/** �ϱ��� */
	protected Integer reportd;

	/** �ϱ�ʱ */
	protected Integer reporth;

	/** �ϱ��� */
	protected Integer reportm;

	/** ��ɫ������ */
	protected String rolemanager;
	
	//====>130225Begin
	/** ״̬ģʽ */
	protected String psdassign;
	
	/** ��������� */
	protected String pporgid;
	
	/** �������� */
	protected String pporgname;
	
	/**
	 * ״̬ģʽȡ��
	 *
	 * @return psdassign ״̬ģʽ
	 */
	public String getPsdassign() {
		return psdassign;
	}

	/**
	 * ״̬ģʽ�趨
	 *
	 * @param psdassign ״̬ģʽ
	 */
	public void setPsdassign(String psdassign) {
		this.psdassign = psdassign;
	}
	
	/**
	 * ���������ȡ��
	 *
	 * @return pporgid ���������
	 */
	public String getPporgid() {
		return pporgid;
	}

	/**
	 * ����������趨
	 *
	 * @param pporgid ���������
	 */
	public void setPporgid(String pporgid) {
		this.pporgid = pporgid;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return pporgname ��������
	 */
	public String getPporgname() {
		return pporgname;
	}

	/**
	 * ���������趨
	 *
	 * @param pporgname ��������
	 */
	public void setPporgname(String pporgname) {
		this.pporgname = pporgname;
	}
	//====>130225End
	
	public Integer getPpid() {
		return ppid;
	}

	public void setPpid(Integer ppid) {
		this.ppid = ppid;
	}

	@Id
	protected Integer ppid;
	
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
	 * ����״̬IDȡ��
	 *
	 * @return ����״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ����״̬ID�趨
	 *
	 * @param psdid ����״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ���̶���IDȡ��
	 *
	 * @return ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 *
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ����״̬��ʾȡ��
	 *
	 * @return ����״̬��ʾ
	 */
	public String getPsdcode() {
		return psdcode;
	}

	/**
	 * ����״̬��ʾ�趨
	 *
	 * @param psdcode ����״̬��ʾ
	 */
	public void setPsdcode(String psdcode) {
		this.psdcode = psdcode;
	}

	/**
	 * �Ƿ��ύ��0����1���ǣ�ȡ��
	 *
	 * @return �Ƿ��ύ��0����1���ǣ�
	 */
	public String getPsdconfirm() {
		return psdconfirm;
	}

	/**
	 * �Ƿ��ύ��0����1���ǣ��趨
	 *
	 * @param psdconfirm �Ƿ��ύ��0����1���ǣ�
	 */
	public void setPsdconfirm(String psdconfirm) {
		this.psdconfirm = psdconfirm;
	}

	/**
	 * ��ǰ�����ɫIDȡ��
	 *
	 * @return ��ǰ�����ɫID
	 */
	public Integer getPproleid() {
		return pproleid;
	}

	/**
	 * ��ǰ�����ɫID�趨
	 *
	 * @param pproleid ��ǰ�����ɫID
	 */
	public void setPproleid(Integer pproleid) {
		this.pproleid = pproleid;
	}

	/**
	 * �����ɫ����ȡ��
	 *
	 * @return �����ɫ����
	 */
	public String getPprolename() {
		return pprolename;
	}

	/**
	 * �����ɫ�����趨
	 *
	 * @param pprolename �����ɫ����
	 */
	public void setPprolename(String pprolename) {
		this.pprolename = pprolename;
	}

	/**
	 * ��ǰ������ԱIDȡ��
	 *
	 * @return ��ǰ������ԱID
	 */
	public String getPpuserid() {
		return ppuserid;
	}

	/**
	 * ��ǰ������ԱID�趨
	 *
	 * @param ppuserid ��ǰ������ԱID
	 */
	public void setPpuserid(String ppuserid) {
		this.ppuserid = ppuserid;
	}

	/**
	 * ��Ա����ȡ��
	 *
	 * @return ��Ա����
	 */
	public String getPpusername() {
		return ppusername;
	}

	/**
	 * ��Ա�����趨
	 *
	 * @param ppusername ��Ա����
	 */
	public void setPpusername(String ppusername) {
		this.ppusername = ppusername;
	}

	/**
	 * �ӵ�����ȡ��
	 *
	 * @return �ӵ�����
	 */
	public String getPpsubstatus() {
		return ppsubstatus;
	}

	/**
	 * �ӵ������趨
	 *
	 * @param ppsubstatus �ӵ�����
	 */
	public void setPpsubstatus(String ppsubstatus) {
		this.ppsubstatus = ppsubstatus;
	}

	/**
	 * �ӵ�ʱ��ȡ��
	 *
	 * @return �ӵ�ʱ��
	 */
	public String getPpbacktime() {
		return ppbacktime;
	}

	/**
	 * �ӵ�ʱ���趨
	 *
	 * @param ppbacktime �ӵ�ʱ��
	 */
	public void setPpbacktime(String ppbacktime) {
		this.ppbacktime = ppbacktime;
	}

	/**
	 * ���Զ���״̬IDȡ��
	 *
	 * @return ���Զ���״̬ID
	 */
	public String getPnsdpsdid() {
		return pnsdpsdid;
	}

	/**
	 * ���Զ���״̬ID�趨
	 *
	 * @param pnsdpsdid ���Զ���״̬ID
	 */
	public void setPnsdpsdid(String pnsdpsdid) {
		this.pnsdpsdid = pnsdpsdid;
	}

	/**
	 * ���Ա��ύ��ʾȡ��
	 *
	 * @return ���Ա��ύ��ʾ
	 */
	public String getPnsdconfirm() {
		return pnsdconfirm;
	}

	/**
	 * ���Ա��ύ��ʾ�趨
	 *
	 * @param pnsdconfirm ���Ա��ύ��ʾ
	 */
	public void setPnsdconfirm(String pnsdconfirm) {
		this.pnsdconfirm = pnsdconfirm;
	}

	/**
	 * �Ƿ��Ͷ���ȡ��
	 *
	 * @return �Ƿ��Ͷ���
	 */
	public String getSms() {
		return sms;
	}

	/**
	 * �Ƿ��Ͷ����趨
	 *
	 * @param sms �Ƿ��Ͷ���
	 */
	public void setSms(String sms) {
		this.sms = sms;
	}

	/**
	 * �Ƿ���EMAILȡ��
	 *
	 * @return �Ƿ���EMAIL
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * �Ƿ���EMAIL�趨
	 *
	 * @param email �Ƿ���EMAIL
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * ֪ͨʱ����ȡ��
	 *
	 * @return ֪ͨʱ����
	 */
	public Integer getNotifyd() {
		return notifyd;
	}

	/**
	 * ֪ͨʱ�����趨
	 *
	 * @param notifyd ֪ͨʱ����
	 */
	public void setNotifyd(Integer notifyd) {
		this.notifyd = notifyd;
	}

	/**
	 * ֪ͨСʱȡ��
	 *
	 * @return ֪ͨСʱ
	 */
	public Integer getNotifyh() {
		return notifyh;
	}

	/**
	 * ֪ͨСʱ�趨
	 *
	 * @param notify ֪ͨСʱ
	 */
	public void setNotifyh(Integer notifyh) {
		this.notifyh = notifyh;
	}

	/**
	 * ֪ͨʱ���ȡ��
	 *
	 * @return ֪ͨʱ���
	 */
	public Integer getNotifym() {
		return notifym;
	}

	/**
	 * ֪ͨʱ����趨
	 *
	 * @param notifym ֪ͨʱ���
	 */
	public void setNotifym(Integer notifym) {
		this.notifym = notifym;
	}

	/**
	 * �ϱ���ȡ��
	 *
	 * @return �ϱ���
	 */
	public Integer getReportd() {
		return reportd;
	}

	/**
	 * �ϱ����趨
	 *
	 * @param reportd �ϱ���
	 */
	public void setReportd(Integer reportd) {
		this.reportd = reportd;
	}

	/**
	 * �ϱ�ʱȡ��
	 *
	 * @return �ϱ�ʱ
	 */
	public Integer getReporth() {
		return reporth;
	}

	/**
	 * �ϱ�ʱ�趨
	 *
	 * @param reporth �ϱ�ʱ
	 */
	public void setReporth(Integer reporth) {
		this.reporth = reporth;
	}

	/**
	 * �ϱ���ȡ��
	 *
	 * @return �ϱ���
	 */
	public Integer getReportm() {
		return reportm;
	}

	/**
	 * �ϱ����趨
	 *
	 * @param reportm �ϱ���
	 */
	public void setReportm(Integer reportm) {
		this.reportm = reportm;
	}

	/**
	 * ��ɫ������ȡ��
	 *
	 * @return ��ɫ������
	 */
	public String getRolemanager() {
		return rolemanager;
	}

	/**
	 * ��ɫ�������趨
	 *
	 * @param rolemanager ��ɫ������
	 */
	public void setRolemanager(String rolemanager) {
		this.rolemanager = rolemanager;
	}

	public String getPsdname() {
		return psdname;
	}

	public void setPsdname(String psdname) {
		this.psdname = psdname;
	}

	public String getPpinittime() {
		return ppinittime;
	}

	public void setPpinittime(String ppinittime) {
		this.ppinittime = ppinittime;
	}

	public String getPrtitle() {
		return prtitle;
	}

	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	public String getPrserialnum() {
		return prserialnum;
	}

	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}
	
}