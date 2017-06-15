/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG156Info;

/**
  * ����: ����״̬��ť�����ʵ��
  * ��������: ����״̬��ť�����ʵ��
  * ������¼: 2012/04/13
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG156")
public class IG156TB extends BaseEntity implements Serializable,
		Cloneable, IG156Info {

	/** ���� */
	@Id
	protected String pseid;

	/** ���̶���ID */
	protected String pdid;

	/** ����״̬ */
	protected String psdid;

	/** ��ťID */
	protected String psebuttonid;
	
	/** ����ID */
	protected String pseactionid;

	/** ����ID */
	protected Integer pseorder;

	/** ���� */
	protected String psedec;
	
	/** ��ť���� */
	protected String psbdname;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPseid() {
		return pseid;
	}

	/**
	 * �����趨
	 *
	 * @param pseid ����
	 */
	public void setPseid(String pseid) {
		this.pseid = pseid;
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
	 * ����״̬ȡ��
	 *
	 * @return ����״̬
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ����״̬�趨
	 *
	 * @param psdid ����״̬
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public String getPseactionid() {
		return pseactionid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param pseactionid ����ID
	 */
	public void setPseactionid(String pseactionid) {
		this.pseactionid = pseactionid;
	}

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getPseorder() {
		return pseorder;
	}

	/**
	 * ����ID�趨
	 *
	 * @param pseorder ����ID
	 */
	public void setPseorder(Integer pseorder) {
		this.pseorder = pseorder;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPsedec() {
		return psedec;
	}

	/**
	 * �����趨
	 *
	 * @param psedec ����
	 */
	public void setPsedec(String psedec) {
		this.psedec = psedec;
	}
	
	/**
	 * ��ťID�趨
	 *
	 * @param psebuttonid ��ťID
	 */
	public void setPsebuttonid(String psebuttonid) {
		this.psebuttonid = psebuttonid;
	}
	
	/**
	 * ��ťIDȡ��
	 *
	 * @return ��ťID
	 */
	public String getPsebuttonid() {
		return psebuttonid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return pseid;
	}

	/**
     * ��ť����ȡ��
     *
     * @return ��ť����
     */
    public String getPsbdname() {
        return psbdname;
    }

    /**
     * ��ť�����趨
     *
     * @param psbdname ��ť����
     */
    public void setPsbdname(String psbdname) {
        this.psbdname = psbdname;
    }
}