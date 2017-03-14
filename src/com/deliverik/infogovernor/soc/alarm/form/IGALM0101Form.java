/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
	
	/** 性能指标脚本 */
	protected FormFile xmlFile;

	public FormFile getXmlFile() {
		return xmlFile;
	}

	public void setXmlFile(FormFile xmlFile) {
		this.xmlFile = xmlFile;
	}
	
}
