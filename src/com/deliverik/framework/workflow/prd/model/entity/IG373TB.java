/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG373Info;

/**
  * ����: ���̱���ʼ���¼������ʵ��
  * ��������: ���̱���ʼ���¼������ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG373")
public class IG373TB extends BaseEntity implements Serializable,
		Cloneable, IG373Info {

	/** ���� */
	@Id
	protected String piidid;

	/** ���̶���ID */
	protected String pdid;

	/** ״̬ID */
	protected String psdid;

	/** BL���� */
	protected String piidblid;

	/** ���� */
	protected String piiddec;

	/** ����״̬��Ϣ */
	@ManyToOne
	@JoinColumn(name="psdid", referencedColumnName="psdid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG333TB ig333Info;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPiidid() {
		return piidid;
	}

	/**
	 * �����趨
	 *
	 * @param piidid ����
	 */
	public void setPiidid(String piidid) {
		this.piidid = piidid;
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
	 * BL����ȡ��
	 *
	 * @return BL����
	 */
	public String getPiidblid() {
		return piidblid;
	}

	/**
	 * BL�����趨
	 *
	 * @param piidblid BL����
	 */
	public void setPiidblid(String piidblid) {
		this.piidblid = piidblid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPiiddec() {
		return piiddec;
	}

	/**
	 * �����趨
	 *
	 * @param piiddec ����
	 */
	public void setPiiddec(String piiddec) {
		this.piiddec = piiddec;
	}
	
	/**
	 * ����״̬��Ϣȡ��
	 * 
	 * @return ����״̬��Ϣ
	 */
	public IG333TB getIg333Info() {
		return ig333Info;
	}

	/**
	 * ����״̬��Ϣ�趨
	 * 
	 * @param ig333Info ����״̬��Ϣ
	 */
	public void setIg333Info(IG333TB ig333Info) {
		this.ig333Info = ig333Info;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return piidid;
	}

}