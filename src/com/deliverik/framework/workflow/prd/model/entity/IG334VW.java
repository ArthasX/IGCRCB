/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.deliverik.framework.workflow.prd.model.IG334VWInfo;

/**
 * ����: ���̲����趨��Ϣ
 * ��������: ���̲����趨��Ϣ
 * ������¼: 2013/09/04
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
@Entity
@IdClass(IG334VWPK.class)
public class IG334VW implements Serializable,Cloneable, IG334VWInfo {
	
	/** ���̲��Զ�Ӧ״̬���� */
	@Id
	protected String psdid;
	
	/** ������ID */
	@Id
	protected String pidid;
	
	/** ���̲�����ر�ֵ */
	@Id
	protected String pivalue;
	
	/** ��������ID */
	protected String pdid;
	
	/** ���̲��Է��Ͷ��ű�ʶ */
	protected String sms;
	
	/** ���̲��Է����ʼ���ʶ */
	protected String email;
	
	/** ���̲��Զ�Ӧ״̬��ʶ */
	protected String psdcode;
	
	/** ���̲��Զ�Ӧ״̬���� */
	protected String psdname;
	
	/** ���̲�����ر����� */
	protected String pidname;
	
	/** ���̲��Գ�ʱ�������� */
	protected Integer notifyd;
	
	/** ���̲��Գ�ʱ����Сʱ */
	protected Integer notifyh;
	
	/** ���̲��Գ�ʱ���ѷ��� */
	protected Integer notifym;
	
	/** ���̲��Ա����ϼ����� */
	protected Integer reportd;
	
	/** ���̲��Ա����ϼ�Сʱ */
	protected Integer reporth;
	
	/** ���̲��Ա����ϼ����� */
	protected Integer reportm;
	
	/** ���̲������ѽ�ɫID */
	protected Integer roleid;
	
	/** ���̲������ѵ���BL */
	protected String processbl;
	
	/** ���̲��������Ƿ��ϱ���ɫ������ */
	protected String rolemanager;
	
	/** �Ƿ�ȷ�� */
	protected String psdconfirm;

	/**
	 * ������IDȡ��
	 *
	 * @return pidid ������ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ������ID�趨
	 *
	 * @param pidid ������ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ��������IDȡ��
	 *
	 * @return pdid ��������ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ��������ID�趨
	 *
	 * @param pdid ��������ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ���̲��Է��Ͷ��ű�ʶȡ��
	 *
	 * @return sms ���̲��Է��Ͷ��ű�ʶ
	 */
	public String getSms() {
		return sms;
	}

	/**
	 * ���̲��Է��Ͷ��ű�ʶ�趨
	 *
	 * @param sms ���̲��Է��Ͷ��ű�ʶ
	 */
	public void setSms(String sms) {
		this.sms = sms;
	}

	/**
	 * ���̲��Է����ʼ���ʶȡ��
	 *
	 * @return email ���̲��Է����ʼ���ʶ
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * ���̲��Է����ʼ���ʶ�趨
	 *
	 * @param email ���̲��Է����ʼ���ʶ
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * ���̲��Զ�Ӧ״̬����ȡ��
	 *
	 * @return psdid ���̲��Զ�Ӧ״̬����
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ���̲��Զ�Ӧ״̬�����趨
	 *
	 * @param psdid ���̲��Զ�Ӧ״̬����
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ���̲��Զ�Ӧ״̬��ʶȡ��
	 *
	 * @return psdcode ���̲��Զ�Ӧ״̬��ʶ
	 */
	public String getPsdcode() {
		return psdcode;
	}

	/**
	 * ���̲��Զ�Ӧ״̬��ʶ�趨
	 *
	 * @param psdcode ���̲��Զ�Ӧ״̬��ʶ
	 */
	public void setPsdcode(String psdcode) {
		this.psdcode = psdcode;
	}

	/**
	 * ���̲��Զ�Ӧ״̬����ȡ��
	 *
	 * @return psdname ���̲��Զ�Ӧ״̬����
	 */
	public String getPsdname() {
		return psdname;
	}

	/**
	 * ���̲��Զ�Ӧ״̬�����趨
	 *
	 * @param psdname ���̲��Զ�Ӧ״̬����
	 */
	public void setPsdname(String psdname) {
		this.psdname = psdname;
	}

	/**
	 * ���̲�����ر�����ȡ��
	 *
	 * @return pidname ���̲�����ر�����
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * ���̲�����ر������趨
	 *
	 * @param pidname ���̲�����ر�����
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * ���̲�����ر�ֵȡ��
	 *
	 * @return pivalue ���̲�����ر�ֵ
	 */
	public String getPivalue() {
		return pivalue;
	}

	/**
	 * ���̲�����ر�ֵ�趨
	 *
	 * @param pivalue ���̲�����ر�ֵ
	 */
	public void setPivalue(String pivalue) {
		this.pivalue = pivalue;
	}

	/**
	 * ���̲��Գ�ʱ��������ȡ��
	 *
	 * @return notifyd ���̲��Գ�ʱ��������
	 */
	public Integer getNotifyd() {
		return notifyd;
	}

	/**
	 * ���̲��Գ�ʱ���������趨
	 *
	 * @param notifyd ���̲��Գ�ʱ��������
	 */
	public void setNotifyd(Integer notifyd) {
		this.notifyd = notifyd;
	}

	/**
	 * ���̲��Գ�ʱ����Сʱȡ��
	 *
	 * @return notifyh ���̲��Գ�ʱ����Сʱ
	 */
	public Integer getNotifyh() {
		return notifyh;
	}

	/**
	 * ���̲��Գ�ʱ����Сʱ�趨
	 *
	 * @param notifyh ���̲��Գ�ʱ����Сʱ
	 */
	public void setNotifyh(Integer notifyh) {
		this.notifyh = notifyh;
	}

	/**
	 * ���̲��Գ�ʱ���ѷ���ȡ��
	 *
	 * @return notifym ���̲��Գ�ʱ���ѷ���
	 */
	public Integer getNotifym() {
		return notifym;
	}

	/**
	 * ���̲��Գ�ʱ���ѷ����趨
	 *
	 * @param notifym ���̲��Գ�ʱ���ѷ���
	 */
	public void setNotifym(Integer notifym) {
		this.notifym = notifym;
	}

	/**
	 * ���̲��Ա����ϼ�����ȡ��
	 *
	 * @return reportd ���̲��Ա����ϼ�����
	 */
	public Integer getReportd() {
		return reportd;
	}

	/**
	 * ���̲��Ա����ϼ������趨
	 *
	 * @param reportd ���̲��Ա����ϼ�����
	 */
	public void setReportd(Integer reportd) {
		this.reportd = reportd;
	}

	/**
	 * ���̲��Ա����ϼ�Сʱȡ��
	 *
	 * @return reporth ���̲��Ա����ϼ�Сʱ
	 */
	public Integer getReporth() {
		return reporth;
	}

	/**
	 * ���̲��Ա����ϼ�Сʱ�趨
	 *
	 * @param reporth ���̲��Ա����ϼ�Сʱ
	 */
	public void setReporth(Integer reporth) {
		this.reporth = reporth;
	}

	/**
	 * ���̲��Ա����ϼ�����ȡ��
	 *
	 * @return reportm ���̲��Ա����ϼ�����
	 */
	public Integer getReportm() {
		return reportm;
	}

	/**
	 * ���̲��Ա����ϼ������趨
	 *
	 * @param reportm ���̲��Ա����ϼ�����
	 */
	public void setReportm(Integer reportm) {
		this.reportm = reportm;
	}

	/**
	 * ���̲������ѽ�ɫIDȡ��
	 *
	 * @return roleid ���̲������ѽ�ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * ���̲������ѽ�ɫID�趨
	 *
	 * @param roleid ���̲������ѽ�ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * ���̲������ѵ���BLȡ��
	 *
	 * @return processbl ���̲������ѵ���BL
	 */
	public String getProcessbl() {
		return processbl;
	}

	/**
	 * ���̲������ѵ���BL�趨
	 *
	 * @param processbl ���̲������ѵ���BL
	 */
	public void setProcessbl(String processbl) {
		this.processbl = processbl;
	}

	/**
	 * ���̲��������Ƿ��ϱ���ɫ������ȡ��
	 *
	 * @return rolemanager ���̲��������Ƿ��ϱ���ɫ������
	 */
	public String getRolemanager() {
		return rolemanager;
	}

	/**
	 * ���̲��������Ƿ��ϱ���ɫ�������趨
	 *
	 * @param rolemanager ���̲��������Ƿ��ϱ���ɫ������
	 */
	public void setRolemanager(String rolemanager) {
		this.rolemanager = rolemanager;
	}

	/**
	 * �Ƿ�ȷ��ȡ��
	 *
	 * @return psdconfirm �Ƿ�ȷ��
	 */
	public String getPsdconfirm() {
		return psdconfirm;
	}

	/**
	 * �Ƿ�ȷ���趨
	 *
	 * @param psdconfirm �Ƿ�ȷ��
	 */
	public void setPsdconfirm(String psdconfirm) {
		this.psdconfirm = psdconfirm;
	}
	
	
}
