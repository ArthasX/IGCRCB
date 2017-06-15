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
import com.deliverik.infogovernor.pdf.model.PdfIg898MapVWInfo;

/**
  * ����: �����ֶ������̹��б�ֵӳ���ϵ��ͼʵ��
  * ��������: �����ֶ������̹��б�ֵӳ���ϵ��ͼʵ��
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(PdfIg898MapVWPK.class)
@Table(name="PdfIg898MapVW")
public class PdfIg898MapVWTB extends BaseEntity implements Serializable,
		Cloneable, PdfIg898MapVWInfo {

	/** ����id */
	@Id
	protected Integer prid;

	/** ������ID */
	@Id
	protected String pidid;

	/** ���ʽ����ID */
	@Id
	protected String pvcolpidid;

	/** ���ʽ��ֵ�к� */
	@Id
	protected String pvrownumber;

	/** ���ʽ��ֵ */
	protected String pvalue;

	/** ���ʽ�������� */
	protected String pvcolname;

	/** ���� */
	protected String attkey;

	/** ���ʽ���������� */
	protected String pidname;

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
	 * ���ʽ����IDȡ��
	 *
	 * @return ���ʽ����ID
	 */
	public String getPvcolpidid() {
		return pvcolpidid;
	}

	/**
	 * ���ʽ����ID�趨
	 *
	 * @param pvcolpidid ���ʽ����ID
	 */
	public void setPvcolpidid(String pvcolpidid) {
		this.pvcolpidid = pvcolpidid;
	}

	/**
	 * ���ʽ��ֵ�к�ȡ��
	 *
	 * @return ���ʽ��ֵ�к�
	 */
	public String getPvrownumber() {
		return pvrownumber;
	}

	/**
	 * ���ʽ��ֵ�к��趨
	 *
	 * @param pvrownumber ���ʽ��ֵ�к�
	 */
	public void setPvrownumber(String pvrownumber) {
		this.pvrownumber = pvrownumber;
	}

	/**
	 * ���ʽ��ֵȡ��
	 *
	 * @return ���ʽ��ֵ
	 */
	public String getPvalue() {
		return pvalue;
	}

	/**
	 * ���ʽ��ֵ�趨
	 *
	 * @param pvalue ���ʽ��ֵ
	 */
	public void setPvalue(String pvalue) {
		this.pvalue = pvalue;
	}

	/**
	 * ���ʽ��������ȡ��
	 *
	 * @return ���ʽ��������
	 */
	public String getPvcolname() {
		return pvcolname;
	}

	/**
	 * ���ʽ���������趨
	 *
	 * @param pvcolname ���ʽ��������
	 */
	public void setPvcolname(String pvcolname) {
		this.pvcolname = pvcolname;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getAttkey() {
		return attkey;
	}

	/**
	 * �����趨
	 *
	 * @param attkey ����
	 */
	public void setAttkey(String attkey) {
		this.attkey = attkey;
	}

	/**
	 * ���ʽ����������ȡ��
	 *
	 * @return ���ʽ����������
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * ���ʽ�����������趨
	 *
	 * @param pidname ���ʽ����������
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
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
		return new PdfIg898MapVWPK(prid, pidid, pvcolpidid, pvrownumber);
	}

}