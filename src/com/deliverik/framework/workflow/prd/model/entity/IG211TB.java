/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG211Info;

/**
 * <p>����:����״̬����ǰ����ʵ��</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG211")
public class IG211TB extends BaseEntity implements Serializable, Cloneable, IG211Info {
	
	/** ����״̬ID */
	@Id
	protected String psidid;
	
	/**
	 * ����״̬ID
	 */
	protected String psdid;
	
	/**
	 * ���̱���ID
	 */
	protected String pidid;

	/**
	 * ���̱�������
	 */
	protected String pidname;
	
	/**
	 * ���̱�����ʾ����
	 */
	protected String pidlabel;
	
	/**
	 * ���̱�������
	 */
	protected String piddesc;
	
	/**
	 * ���̱�������
	 */
	protected String pidtype;
	

	/**
	 * ���̱���ֵ
	 */
	protected String pidvalue;
	
	/**
	 * �ı���󶨸���
	 */
	protected String pidattkey;
	
	/**
	 * ����״̬ǰ�������
	 */
	@ManyToOne
	@JoinColumn(name = "psdid", insertable=false, updatable=false)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG333TB processStatusDef;

	/**
	 * ���ܣ�����ȡ��
	 * @return ����
	 */
	public Serializable getPK() {
		return psidid;
	}

	/**
	 * ���ܣ�����״̬����ǰ����IDȡ��
	 * @return ����״̬����ǰ����ID
	 */
	public String getPsidid() {
		return psidid;
	}

	/**
	 * ���ܣ�����״̬����ǰ����ID�趨
	 * @param psidid ����״̬����ǰ����ID
	 */
	public void setPsidid(String psidid) {
		this.psidid = psidid;
	}

	/**
	 * ���ܣ�����״̬IDȡ��
	 * @return ����״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ���ܣ�����״̬ID�趨
	 * @param psdid ����״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ���ܣ����̱���IDȡ��
	 * @return ���̱���ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ���ܣ����̱���ID�趨
	 * @param pidid ���̱���ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ���ܣ����̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * ���ܣ����̱��������趨
	 * @param pidname ���̱�������
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * ���ܣ����̱�����ʾ����ȡ��
	 * @return ���̱�����ʾ����
	 */
	public String getPidlabel() {
		return pidlabel;
	}

	/**
	 * ���ܣ����̱�����ʾ�����趨
	 * @param pidlabel ���̱�����ʾ����
	 */
	public void setPidlabel(String pidlabel) {
		this.pidlabel = pidlabel;
	}

	/**
	 * ���ܣ����̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPiddesc() {
		return piddesc;
	}

	/**
	 * ���ܣ����̱��������趨
	 * @param piddesc ���̱�������
	 */
	public void setPiddesc(String piddesc) {
		this.piddesc = piddesc;
	}

	/**
	 * ���ܣ����̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPidtype() {
		return pidtype;
	}

	/**
	 * ���ܣ����̱��������趨
	 * @param pidtype ���̱�������
	 */
	public void setPidtype(String pidtype) {
		this.pidtype = pidtype;
	}

	/**
	 * ���ܣ����̱���ֵȡ��
	 * @return ���̱���ֵ
	 */
	public String getPidvalue() {
		return pidvalue;
	}

	/**
	 * ���ܣ����̱���ֵ�趨
	 * @param pidvalue ���̱���ֵ
	 */
	public void setPidvalue(String pidvalue) {
		this.pidvalue = pidvalue;
	}

	/**
	 * ���ܣ�����״̬ǰ�������ȡ��
	 * @return ����״̬ǰ�������
	 */
	public IG333TB getProcessStatusDef() {
		return processStatusDef;
	}

	/**
	 * ���ܣ�����״̬ǰ��������趨
	 * @param IG333 ����״̬ǰ�������
	 */
	public void setProcessStatusDef(IG333TB processStatusDef) {
		this.processStatusDef = processStatusDef;
	}

	/**
	 * ���ܣ��ı���󶨸���ȡ��
	 * @return �ı���󶨸���
	 */
	public String getPidattkey() {
		return pidattkey;
	}

	/**
	 * ���ܣ��ı���󶨸����趨
	 * @param pidattkey �ı���󶨸���
	 */
	public void setPidattkey(String pidattkey) {
		this.pidattkey = pidattkey;
	}
}
