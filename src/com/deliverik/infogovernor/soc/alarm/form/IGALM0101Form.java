/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.alarm.form;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;

/**
 * 
 * @author wangxing@deliverik.com
 */
@SuppressWarnings("serial")
public class IGALM0101Form extends BaseForm {
	
	/** ����ָ��ű� */
	protected FormFile xmlFile;

	public FormFile getXmlFile() {
		return xmlFile;
	}

	public void setXmlFile(FormFile xmlFile) {
		this.xmlFile = xmlFile;
	}
	
}
