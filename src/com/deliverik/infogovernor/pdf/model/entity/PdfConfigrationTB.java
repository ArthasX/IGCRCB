/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.pdf.model.PdfConfigrationInfo;

/**
  * ����: �����ӦBL��ģ���������ñ�ʵ��
  * ��������: �����ӦBL��ģ���������ñ�ʵ��
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="PdfConfigration")
public class PdfConfigrationTB extends BaseEntity implements Serializable,
		Cloneable, PdfConfigrationInfo {

	/** ���̶���ID */
	@Id
	protected String pdid;

	/** �������BL���� */
	protected String pdfbl;

	/** PDF����ģ������ */
	protected String templatename;
	
	/** PDF�������ļ����� */
	protected String exportname;
	
	/** PDF����XML�ļ����� */
	protected String xmlname;

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
	 * �������BL����ȡ��
	 *
	 * @return �������BL����
	 */
	public String getPdfbl() {
		return pdfbl;
	}

	/**
	 * �������BL�����趨
	 *
	 * @param pdfbl �������BL����
	 */
	public void setPdfbl(String pdfbl) {
		this.pdfbl = pdfbl;
	}

	/**
	 * PDF����ģ������ȡ��
	 *
	 * @return PDF����ģ������
	 */
	public String getTemplatename() {
		return templatename;
	}

	/**
	 * PDF����ģ�������趨
	 *
	 * @param templatename PDF����ģ������
	 */
	public void setTemplatename(String templatename) {
		this.templatename = templatename;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return pdid;
	}

    /**
     * @return the PDF�������ļ�����
     */
    public String getExportname() {
        return exportname;
    }

    /**
     * @param PDF�������ļ����� the exportname to set
     */
    public void setExportname(String exportname) {
        this.exportname = exportname;
    }

    /**
     * @return the PDF����XML�ļ�����
     */
    public String getXmlname() {
        return xmlname;
    }

    /**
     * @param PDF����XML�ļ����� the xmlname to set
     */
    public void setXmlname(String xmlname) {
        this.xmlname = xmlname;
    }

}