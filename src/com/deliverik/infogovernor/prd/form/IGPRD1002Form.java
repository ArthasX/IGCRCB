/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̶���Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD1002Form extends BaseForm{

	/** ���̶���ID */
	protected String pdid;
	
	/** �ڵ�ID */
	protected String psdid;
	
	/** ������Ϣ */
	protected String xml;
	
	/** ������Ϣ */
	protected String xmlValue;

	/** ������Ϣ */
	protected String isMask;
	
	/** �����ƵĽڵ�ID */
	protected String oldpdid;
	/** �����ƵĽڵ�ID */
	protected String contentH;
	
	protected String prid;
	/**  
	 * ��ȡprid  
	 * @return prid 
	 */
	public String getPrid() {
		return prid;
	}

	/**  
	 * ����prid  
	 * @param prid
	 */
	
	public void setPrid(String prid) {
		this.prid = prid;
	}

	/**
	 * @return the contentH
	 */
	public String getContentH() {
		return contentH;
	}

	/**
	 * @param contentH the contentH to set
	 */
	public void setContentH(String contentH) {
		this.contentH = contentH;
	}

	/**
	 * ���̶���IDȡ��
	 * @return pdid ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * �ڵ�IDȡ��
	 * @return psdid �ڵ�ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * �ڵ�ID�趨
	 * @param psdid �ڵ�ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

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
	 * ������Ϣȡ��
	 * @return xmlValue ������Ϣ
	 */
	public String getXmlValue() {
		return xmlValue;
	}

	/**
	 * ������Ϣ�趨
	 * @param xmlValue ������Ϣ
	 */
	public void setXmlValue(String xmlValue) {
		this.xmlValue = xmlValue;
	}

	public String getIsMask() {
		return isMask;
	}

	public void setIsMask(String isMask) {
		this.isMask = isMask;
	}

	public String getOldpdid() {
		return oldpdid;
	}

	public void setOldpdid(String oldpdid) {
		this.oldpdid = oldpdid;
	}
	
}
