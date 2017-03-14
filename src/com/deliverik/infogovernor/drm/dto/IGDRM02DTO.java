package com.deliverik.infogovernor.drm.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.infogovernor.drm.form.IGDRM0201Form;


/**
 * 组合场景定义流程用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGDRM02DTO extends BaseDTO implements Serializable{

	/** 资产项检索结果 */
	protected List<SOC0124Info> soc0124List;
	
	/** 选择的资产eiid */
	private String[] addEiids ;
	
	/** 组合场景定义 */
	private String pgdid;
	
	/** 组合场景form */
	protected IGDRM0201Form igdrm0201Form ;
	
	/** flex传过来的xml*/
	private String  XmlValue ;
	
	/** 流程实例主键 */
	private Integer prid ;
	
	/** 场景定义id拼串 */
	private String flowIdStr;
	
	/** 状态表单flag*/
	private String flag;
	
	/** 场景定义pdid */
	private String pdidStr;

	/** 场景修订标识 */
	private String isUpdate;
	
	/** 原pgdid */
	protected String oldpdid;
	/**
	 * @return the 场景修订标识
	 */
	public String getIsUpdate() {
		return isUpdate;
	}

	/**
	 * @param 场景修订标识 the isUpdate to set
	 */
	public void setIsUpdate(String isUpdate) {
		this.isUpdate = isUpdate;
	}

	/**
	 * @return the 资产项检索结果
	 */
	public List<SOC0124Info> getSoc0124List() {
		return soc0124List;
	}

	/**
	 * @param 资产项检索结果 the soc0124List to set
	 */
	public void setSoc0124List(List<SOC0124Info> soc0124List) {
		this.soc0124List = soc0124List;
	}

	/**
	 * @return the 选择的资产eiid
	 */
	public String[] getAddEiids() {
		return addEiids;
	}

	/**
	 * @param 选择的资产eiid the addEiids to set
	 */
	public void setAddEiids(String[] addEiids) {
		this.addEiids = addEiids;
	}

	/**
	 * @return the 组合场景定义
	 */
	public String getPgdid() {
		return pgdid;
	}

	/**
	 * @param 组合场景定义 the pgdid to set
	 */
	public void setPgdid(String pgdid) {
		this.pgdid = pgdid;
	}

	/**
	 * @return the 组合场景form
	 */
	public IGDRM0201Form getIgdrm0201Form() {
		return igdrm0201Form;
	}

	/**
	 * @param 组合场景form the igdrm0201Form to set
	 */
	public void setIgdrm0201Form(IGDRM0201Form igdrm0201Form) {
		this.igdrm0201Form = igdrm0201Form;
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
	public Integer getPrid() {
		return prid;
	}

	/**
	 * @param 流程实例主键 the prid to set
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * @return the 场景定义id拼串
	 */
	public String getFlowIdStr() {
		return flowIdStr;
	}

	/**
	 * @param 场景定义id拼串 the flowIdStr to set
	 */
	public void setFlowIdStr(String flowIdStr) {
		this.flowIdStr = flowIdStr;
	}

	/**
	 * @return the 状态表单flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * @param 状态表单flag the 状态表单flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * @return the 场景定义pdid
	 */
	public String getPdidStr() {
		return pdidStr;
	}

	/**
	 * @param 场景定义pdid the pdidStr to set
	 */
	public void setPdidStr(String pdidStr) {
		this.pdidStr = pdidStr;
	}

	/**
	 * @return the 原pgdid
	 */
	public String getOldpdid() {
		return oldpdid;
	}

	/**
	 * @param 原pgdid the oldpdid to set
	 */
	public void setOldpdid(String oldpdid) {
		this.oldpdid = oldpdid;
	}
	
	
}