package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ��ϳ���������FORM
 * IGDRM0201Form ActionForm
 */
public class IGDRM0201Form extends BaseForm {

	private static final long serialVersionUID = 1L;
	/**��ѡ����ʲ�ʵ��id*/
	private String eiids ; 
	/**�����ʲ���*/
	private String esyscoding ; 
	/** ������ʲ�ʵ��id*/
	private String[] addEiids ;
	/** �ʲ�����*/
	private String ename; 
	/** flex��������xml*/
	private String  XmlValue ;
	/** ����ʵ������ */
	private String prid ;
	/** ״̬���� */
	private String stepPdid ;
	/** ������Ϣ */
	protected String xml;
	/** ���� */
	protected String isMask;
	/**
	 * ������Ϣȡ��
	 * @return xml ������Ϣ
	 */
	public String getXml() {
		return xml;
	}

	/**
	 * ������Ϣ�趨
	 * @param xml ������Ϣ
	 */
	public void setXml(String xml) {
		this.xml = xml;
	}
	/**
	 * @return the ��ѡ����ʲ�ʵ��id
	 */
	public String getEiids() {
		return eiids;
	}
	/**
	 * @param ��ѡ����ʲ�ʵ��id the eiids to set
	 */
	public void setEiids(String eiids) {
		this.eiids = eiids;
	}
	/**
	 * @return the �����ʲ���
	 */
	public String getEsyscoding() {
		return esyscoding;
	}
	/**
	 * @param �����ʲ��� the esyscoding to set
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	/**
	 * @return the ������ʲ�ʵ��id
	 */
	public String[] getAddEiids() {
		return addEiids;
	}
	/**
	 * @param ������ʲ�ʵ��id the addEiids to set
	 */
	public void setAddEiids(String[] addEiids) {
		this.addEiids = addEiids;
	}
	/**
	 * @return the �ʲ�����
	 */
	public String getEname() {
		return ename;
	}
	/**
	 * @param �ʲ����� the ename to set
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}
	/**
	 * @return the xmlValue
	 */
	public String getXmlValue() {
		return XmlValue;
	}
	/**
	 * @param xmlValue the xmlValue to set
	 */
	public void setXmlValue(String xmlValue) {
		XmlValue = xmlValue;
	}
	/**
	 * @return the ����ʵ������
	 */
	public String getPrid() {
		return prid;
	}
	/**
	 * @param ����ʵ������ the prid to set
	 */
	public void setPrid(String prid) {
		this.prid = prid;
	}
	/**
	 * @return the ״̬����
	 */
	public String getStepPdid() {
		return stepPdid;
	}
	/**
	 * @param ״̬���� the stepPdid to set
	 */
	public void setStepPdid(String stepPdid) {
		this.stepPdid = stepPdid;
	}

	/**
	 * @return the ����
	 */
	public String getIsMask() {
		return isMask;
	}

	/**
	 * @param ���� the isMask to set
	 */
	public void setIsMask(String isMask) {
		this.isMask = isMask;
	}
	
}
