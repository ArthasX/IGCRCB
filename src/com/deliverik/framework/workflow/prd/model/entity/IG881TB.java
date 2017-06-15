/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG881Info;

/**
 * ���̲����߱���Ȩ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG881")
public class IG881TB extends BaseEntity implements Serializable, Cloneable, IG881Info {
	
	/** ���̲����߱���Ȩ��ID */
	@Id
	protected String pipdid;
	
	/**
	 * ���̱���ID
	 */
	protected String pidid;
	
	/**
	 * ����״̬��ID
	 */
	protected String psdid;
	
	/**
	 * ���̲����ߵ�ID
	 */
	protected String ppdid;
	
	/** ����Ϣ */
	@ManyToOne
	@JoinColumn(name="pidid", referencedColumnName="pidid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG007TB processInfoDef;
	
	/** ���̱���Ȩ�� */
	protected String pidaccess;
	
	/** ���̱����Ƿ���� */
	protected String pidrequired;

	/**
	 * ����״̬��IDȡ��
	 * @return ����״̬��ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ����״̬��ID�趨
	 * @param psdid ����״̬��ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}


	/**
	 * ���̲����ߵ�IDȡ��
	 * @return ���̲����ߵ�ID
	 */
	public String getPpdid() {
		return ppdid;
	}

	/**
	 * ���̲����ߵ�ID�趨
	 * @param ppdid ���̲����ߵ�ID
	 */
	public void setPpdid(String ppdid) {
		this.ppdid = ppdid;
	}

	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return pipdid;
	}

	/**
	 * ���̲����߱���Ȩ��IDȡ��
	 * @return ���̲����߱���Ȩ��ID
	 */
	public String getPipdid() {
		return pipdid;
	}

	/**
	 * ���̲����߱���Ȩ��ID�趨
	 * @param pipdid ���̲����߱���Ȩ��ID
	 */
	public void setPipdid(String pipdid) {
		this.pipdid = pipdid;
	}

	/**
	 * ���̱���IDȡ��
	 * @return ���̱���ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ���̱���ID�趨
	 * @param pidid ���̱���ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ����Ϣȡ��
	 * @return ����Ϣ
	 */
	public IG007Info getProcessInfoDef() {
		return processInfoDef;
	}
	
	/**
	 * ����ȱʡ�����߱���Ȩ��ȡ��
	 * @return ����ȱʡ�����߱���Ȩ��
	 */
	public String getPidaccess() {
		return pidaccess;
	}

	/**
	 * ����ȱʡ�����߱���Ȩ���趨
	 * @param pidaccess ����ȱʡ�����߱���Ȩ��
	 */
	public void setPidaccess(String pidaccess) {
		this.pidaccess = pidaccess;
	}

	/**
	 * ���̱����Ƿ����ȡ��
	 *
	 * @return ���̱����Ƿ����
	 */
	public String getPidrequired() {
		return pidrequired;
	}

	/**
	 * ���̱����Ƿ�����趨
	 *
	 * @param pidrequired ���̱����Ƿ����
	 */
	public void setPidrequired(String pidrequired) {
		this.pidrequired = pidrequired;
	}
	
}
