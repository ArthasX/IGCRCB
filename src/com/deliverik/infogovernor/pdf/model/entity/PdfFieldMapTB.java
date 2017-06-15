/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.pdf.model.PdfFieldMapInfo;

/**
  * ����: PDF���������̱�ӳ���ʵ��
  * ��������: PDF���������̱�ӳ���ʵ��
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(PdfFieldMapPK.class)
@Table(name="PdfFieldMap")
public class PdfFieldMapTB extends BaseEntity implements Serializable,
		Cloneable, PdfFieldMapInfo {

	/** ���̶���ID */
	@Id
	protected String pdid;

	/** ���̱�����ID */
	@Id
	protected String pidid;

	/** ���̱����� */
	protected String pidname;

	/** �������� */
	protected String pdatabinding;

	/** ������ */
	protected String databinding;

	/** ������ */
	protected String formtype;

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
	 * ���̱�����IDȡ��
	 *
	 * @return ���̱�����ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ���̱�����ID�趨
	 *
	 * @param pidid ���̱�����ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ���̱�����ȡ��
	 *
	 * @return ���̱�����
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * ���̱������趨
	 *
	 * @param pidname ���̱�����
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPdatabinding() {
		return pdatabinding;
	}

	/**
	 * ���������趨
	 *
	 * @param pdatabinding ��������
	 */
	public void setPdatabinding(String pdatabinding) {
		this.pdatabinding = pdatabinding;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getDatabinding() {
		return databinding;
	}

	/**
	 * �������趨
	 *
	 * @param databinding ������
	 */
	public void setDatabinding(String databinding) {
		this.databinding = databinding;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getFormtype() {
		return formtype;
	}

	/**
	 * �������趨
	 *
	 * @param formtype ������
	 */
	public void setFormtype(String formtype) {
		this.formtype = formtype;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return new PdfFieldMapPK(pdid, pidid);
	}

}