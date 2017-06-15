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
import com.deliverik.infogovernor.pdf.model.PdfIg599MapVWInfo;

/**
  * ����: �����ֶ������̹��б�ֵӳ���ϵ��ͼʵ��
  * ��������: �����ֶ������̹��б�ֵӳ���ϵ��ͼʵ��
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(PdfIg599MapVWPK.class)
@Table(name="PdfIg599MapVW")
public class PdfIg599MapVWTB extends BaseEntity implements Serializable,
		Cloneable, PdfIg599MapVWInfo {

	/** ����ID */
	@Id
	protected Integer prid;

	/** ������ID */
	@Id
	protected String pidid;

	/** ��ֵ */
	protected String pivarvalue;

	/** ���������� */
	protected String pivarname;

	/** ���̶���ID */
	protected String pdid;

	/** �����ֶ����� */
	protected String pdfpidname;

	/** ��������Ϣ */
	protected String pdatabinding;

	/** ������Ϣ */
	protected String databinding;

	/** ������ */
	protected String formtype;

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
	 *
	 * @return ��ֵ
	 */
	public String getPivarvalue() {
		return pivarvalue;
	}

	/**
	 * ��ֵ�趨
	 *
	 * @param pivarvalue ��ֵ
	 */
	public void setPivarvalue(String pivarvalue) {
		this.pivarvalue = pivarvalue;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getPivarname() {
		return pivarname;
	}

	/**
	 * �����������趨
	 *
	 * @param pivarname ����������
	 */
	public void setPivarname(String pivarname) {
		this.pivarname = pivarname;
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
	 * �����ֶ�����ȡ��
	 *
	 * @return �����ֶ�����
	 */
	public String getPdfpidname() {
		return pdfpidname;
	}

	/**
	 * �����ֶ������趨
	 *
	 * @param pdfpidname �����ֶ�����
	 */
	public void setPdfpidname(String pdfpidname) {
		this.pdfpidname = pdfpidname;
	}

	/**
	 * ��������Ϣȡ��
	 *
	 * @return ��������Ϣ
	 */
	public String getPdatabinding() {
		return pdatabinding;
	}

	/**
	 * ��������Ϣ�趨
	 *
	 * @param pdatabinding ��������Ϣ
	 */
	public void setPdatabinding(String pdatabinding) {
		this.pdatabinding = pdatabinding;
	}

	/**
	 * ������Ϣȡ��
	 *
	 * @return ������Ϣ
	 */
	public String getDatabinding() {
		return databinding;
	}

	/**
	 * ������Ϣ�趨
	 *
	 * @param databinding ������Ϣ
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
		return new PdfIg599MapVWPK(prid, pidid);
	}

}