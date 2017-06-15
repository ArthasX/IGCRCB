/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程定义Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD1002Form extends BaseForm{

	/** 流程定义ID */
	protected String pdid;
	
	/** 节点ID */
	protected String psdid;
	
	/** 流程信息 */
	protected String xml;
	
	/** 流程信息 */
	protected String xmlValue;

	/** 流程信息 */
	protected String isMask;
	
	/** 被复制的节点ID */
	protected String oldpdid;
	/** 被复制的节点ID */
	protected String contentH;
	
	protected String prid;
	/**  
	 * 获取prid  
	 * @return prid 
	 */
	public String getPrid() {
		return prid;
	}

	/**  
	 * 设置prid  
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
	 * 流程定义ID取得
	 * @return pdid 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 节点ID取得
	 * @return psdid 节点ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 节点ID设定
	 * @param psdid 节点ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 流程信息取得
	 * @return xml 流程信息
	 */
	public String getXml() {
		return xml;
	}

	/**
	 * 流程信息设定
	 * @param xml 流程信息
	 */
	public void setXml(String xml) {
		this.xml = xml;
	}

	/**
	 * 流程信息取得
	 * @return xmlValue 流程信息
	 */
	public String getXmlValue() {
		return xmlValue;
	}

	/**
	 * 流程信息设定
	 * @param xmlValue 流程信息
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
