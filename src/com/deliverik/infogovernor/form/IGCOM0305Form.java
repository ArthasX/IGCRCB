/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.form;

import com.deliverik.framework.base.BaseForm;

/**
 * �ʲ���ϵͼ����FORM
 * 
 */
public class IGCOM0305Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** �ʲ�ID */
	protected String eiid;
	
	/** ��ϵͼXML */
	protected String relationXmlStr;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	/** ��ϵ�� */
	protected String eircount;
	
	/** ��ϵͼXML�ļ����� */
	protected String filename;
	
	/** ����� */
	protected String width;
	
	/** ����� */
	protected String height;
	
	/** ����x���� */
	protected String coordsize_x;
	
	/** ����y���� */
	protected String coordsize_y;
	
	/** �汾 */
	protected String eiversion;
	
	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�ID�趨
	 *
	 * @param eiid �ʲ�ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * ��ϵͼXMLȡ��
	 * @return ��ϵͼXML
	 */
	public String getRelationXmlStr() {
		return relationXmlStr;
	}

	/**
	 * ��ϵͼXML�趨
	 *
	 * @param relationXmlStr ��ϵͼXML
	 */
	public void setRelationXmlStr(String relationXmlStr) {
		this.relationXmlStr = relationXmlStr;
	}

	/**
	 * Ȩ�ޱ�ʶȡ��
	 * @return Ȩ�ޱ�ʶ
	 */
	public Boolean getFlag() {
		return flag;
	}

	/**
	 * Ȩ�ޱ�ʶ�趨
	 *
	 * @param flag Ȩ�ޱ�ʶ
	 */
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	/**
	 * ��ϵ��ȡ��
	 * @return ��ϵ��
	 */
	public String getEircount() {
		return eircount;
	}

	/**
	 * ��ϵ���趨
	 *
	 * @param eircount ��ϵ��
	 */
	public void setEircount(String eircount) {
		this.eircount = eircount;
	}

	/**
	 * ��ϵͼXML�ļ�����ȡ��
	 * @return ��ϵͼXML�ļ�����
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * ��ϵͼXML�ļ������趨
	 *
	 * @param filename ��ϵͼXML�ļ�����
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * �����ȡ��
	 * @return �����
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * ������趨
	 *
	 * @param width �����
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * �����ȡ��
	 * @return �����
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * ������趨
	 *
	 * @param height �����
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * ����x����ȡ��
	 * @return ����x����
	 */
	public String getCoordsize_x() {
		return coordsize_x;
	}

	/**
	 * ����x�����趨
	 *
	 * @param coordsize_x ����x����
	 */
	public void setCoordsize_x(String coordsize_x) {
		this.coordsize_x = coordsize_x;
	}

	/**
	 * ����y����ȡ��
	 * @return ����y����
	 */
	public String getCoordsize_y() {
		return coordsize_y;
	}

	/**
	 * ����y�����趨
	 *
	 * @param coordsize_y ����y����
	 */
	public void setCoordsize_y(String coordsize_y) {
		this.coordsize_y = coordsize_y;
	}

	public String getEiversion() {
		return eiversion;
	}

	public void setEiversion(String eiversion) {
		this.eiversion = eiversion;
	}
	
}
