/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG335Info;

/**
  * ����: �����Ա�ʵ��
  * ��������: �����Ա�ʵ��
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(IG335PK.class)
@Table(name="IG335")
public class IG335TB extends BaseEntity implements Serializable,
		Cloneable, IG335Info {

	/** ״̬����ID */
	@Id
	protected String psdid;

	/** ������ID */
	@Id
	protected String pidid;

	/** ��ֵ */
	@Id
	protected String pivalue;

	/** ȷ�Ͻڵ��Ƿ�  */
	@Id
	protected String psdconfirm;

	/** ���̶���ID */
	@Id
	protected String pdid;
	
	/** �� */
	protected Integer notifyd;

	/** Сʱ */
	protected Integer notifyh;

	/** �� */
	protected Integer notifym;
	
	/** �ϱ�_�� */
	protected Integer reportd;
	
	/** �ϱ�_Сʱ */
	protected Integer reporth;
	
	/** �ϱ�_�� */
	protected Integer reportm;

	/** ��ɫID */
	protected Integer roleid;
	
	/** ��ɫ���� */
	protected String rolename;
	
	/** �ϱ���ɫ������ */
	protected String rolemanager;

	/** ����BL */
	protected String processbl;

	/** ֪ͨ��ID */
	@Transient
	protected String notifierids;
	
	/** ֪ͨ������ */
	@Transient
	protected String notifiernames;
	
	/**
	 * ״̬����IDȡ��
	 *
	 * @return ״̬����ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ״̬����ID�趨
	 *
	 * @param psdid ״̬����ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ������IDȡ��
	 *
	 * @return ������ID
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
	 * ��ֵȡ��
	 * @return pivalue ��ֵ
	 */
	public String getPivalue() {
		return pivalue;
	}

	/**
	 * ��ֵ�趨
	 * @param pivalue ��ֵ
	 */
	public void setPivalue(String pivalue) {
		this.pivalue = pivalue;
	}

	/**
	 * ȷ�Ͻڵ��Ƿ�ȡ��
	 * @return psdconfirm ȷ�Ͻڵ��Ƿ�
	 */
	public String getPsdconfirm() {
		return psdconfirm;
	}

	/**
	 * ȷ�Ͻڵ��Ƿ��趨
	 * @param psdconfirm ȷ�Ͻڵ��Ƿ�
	 */
	public void setPsdconfirm(String psdconfirm) {
		this.psdconfirm = psdconfirm;
	}

	/**
	 * ���̶���IDȡ��
	 * @return pdid
	 */
	public String getPdid() {
		return pdid;
	}
	/**
	 * ���̶���ID�趨
	 * @param pdid
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ��ȡ��
	 *
	 * @return ��
	 */
	public Integer getNotifyd() {
		return notifyd;
	}

	/**
	 * ���趨
	 *
	 * @param notifyd ��
	 */
	public void setNotifyd(Integer notifyd) {
		this.notifyd = notifyd;
	}

	/**
	 * Сʱȡ��
	 *
	 * @return Сʱ
	 */
	public Integer getNotifyh() {
		return notifyh;
	}

	/**
	 * Сʱ�趨
	 *
	 * @param notifyh Сʱ
	 */
	public void setNotifyh(Integer notifyh) {
		this.notifyh = notifyh;
	}

	/**
	 * ��ȡ��
	 *
	 * @return ��
	 */
	public Integer getNotifym() {
		return notifym;
	}

	/**
	 * ���趨
	 *
	 * @param notifym ��
	 */
	public void setNotifym(Integer notifym) {
		this.notifym = notifym;
	}

	/**
	 * �ϱ�_��ȡ��
	 * @return reportd �ϱ�_��
	 */
	public Integer getReportd() {
		return reportd;
	}

	/**
	 * �ϱ�_���趨
	 * @param reportd �ϱ�_��
	 */
	public void setReportd(Integer reportd) {
		this.reportd = reportd;
	}

	/**
	 * �ϱ�_Сʱȡ��
	 * @return reporth �ϱ�_Сʱ
	 */
	public Integer getReporth() {
		return reporth;
	}

	/**
	 * �ϱ�_Сʱ�趨
	 * @param reporth �ϱ�_Сʱ
	 */
	public void setReporth(Integer reporth) {
		this.reporth = reporth;
	}

	/**
	 * �ϱ�_��ȡ��
	 * @return reportm �ϱ�_��
	 */
	public Integer getReportm() {
		return reportm;
	}

	/**
	 * �ϱ�_���趨
	 * @param reportm �ϱ�_��
	 */
	public void setReportm(Integer reportm) {
		this.reportm = reportm;
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
	 * ��ɫ����ȡ��
	 * @return rolename ��ɫ����
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * ��ɫ�����趨
	 * @param rolename ��ɫ����
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * �ϱ���ɫ������ȡ��
	 * @return rolemanager �ϱ���ɫ������
	 */
	public String getRolemanager() {
		return rolemanager;
	}

	/**
	 * �ϱ���ɫ�������趨
	 * @param rolemanager �ϱ���ɫ������
	 */
	public void setRolemanager(String rolemanager) {
		this.rolemanager = rolemanager;
	}

	/**
	 * ����BLȡ��
	 *
	 * @return ����BL
	 */
	public String getProcessbl() {
		return processbl;
	}

	/**
	 * ����BL�趨
	 *
	 * @param processbl ����BL
	 */
	public void setProcessbl(String processbl) {
		this.processbl = processbl;
	}

	/**
	 * ֪ͨ��IDȡ��
	 * @return notifierids ֪ͨ��ID
	 */
	public String getNotifierids() {
		return notifierids;
	}

	/**
	 * ֪ͨ��ID�趨
	 * @param notifierids ֪ͨ��ID
	 */
	public void setNotifierids(String notifierids) {
		this.notifierids = notifierids;
	}

	/**
	 * ֪ͨ������ȡ��
	 * @return notifiernames ֪ͨ������
	 */
	public String getNotifiernames() {
		return notifiernames;
	}

	/**
	 * ֪ͨ�������趨
	 * @param notifiernames ֪ͨ������
	 */
	public void setNotifiernames(String notifiernames) {
		this.notifiernames = notifiernames;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return new IG335PK(psdid, pdid, pidid, pivalue, psdconfirm);
	}

}