package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 组合场景定义用FORM
 * IGDRM0201Form ActionForm
 */
public class IGDRM0201Form extends BaseForm {

	private static final long serialVersionUID = 1L;
	/**已选择的资产实例id*/
	private String eiids ; 
	/**场景资产码*/
	private String esyscoding ; 
	/** 保存的资产实例id*/
	private String[] addEiids ;
	/** 资产名称*/
	private String ename; 
	/** flex传过来的xml*/
	private String  XmlValue ;
	/** 流程实例主键 */
	private String prid ;
	/** 状态级表单 */
	private String stepPdid ;
	/** 流程信息 */
	protected String xml;
	/** 遮罩 */
	protected String isMask;
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
	 * @return the 已选择的资产实例id
	 */
	public String getEiids() {
		return eiids;
	}
	/**
	 * @param 已选择的资产实例id the eiids to set
	 */
	public void setEiids(String eiids) {
		this.eiids = eiids;
	}
	/**
	 * @return the 场景资产码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}
	/**
	 * @param 场景资产码 the esyscoding to set
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	/**
	 * @return the 保存的资产实例id
	 */
	public String[] getAddEiids() {
		return addEiids;
	}
	/**
	 * @param 保存的资产实例id the addEiids to set
	 */
	public void setAddEiids(String[] addEiids) {
		this.addEiids = addEiids;
	}
	/**
	 * @return the 资产名称
	 */
	public String getEname() {
		return ename;
	}
	/**
	 * @param 资产名称 the ename to set
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
	 * @return the 流程实例主键
	 */
	public String getPrid() {
		return prid;
	}
	/**
	 * @param 流程实例主键 the prid to set
	 */
	public void setPrid(String prid) {
		this.prid = prid;
	}
	/**
	 * @return the 状态级表单
	 */
	public String getStepPdid() {
		return stepPdid;
	}
	/**
	 * @param 状态级表单 the stepPdid to set
	 */
	public void setStepPdid(String stepPdid) {
		this.stepPdid = stepPdid;
	}

	/**
	 * @return the 遮罩
	 */
	public String getIsMask() {
		return isMask;
	}

	/**
	 * @param 遮罩 the isMask to set
	 */
	public void setIsMask(String isMask) {
		this.isMask = isMask;
	}
	
}
