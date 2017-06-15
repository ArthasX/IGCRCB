package com.deliverik.infogovernor.cic.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.infogovernor.cic.form.IGCIC0101Form;
import com.deliverik.infogovernor.cic.form.IGCIC0102Form;
import com.deliverik.infogovernor.cic.model.CompareroleInfo;

/**
 *  对比规则相关业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGCIC01DTO extends BaseDTO implements Serializable{

	/**igcic0101Form*/
	private IGCIC0101Form igcic0101Form;
	/**igcic0102Form*/
	private IGCIC0102Form igcic0102Form;
	/**对比规则 集合*/
	private List<CompareroleInfo> crList;
	/**对比规则*/
	private CompareroleInfo compareRoleInfo;
	/**业务系统结合*/
	private List<SOC0118Info> systemList;
	private List<Map<String,String>> sourceHostList;
	private List<Map<String,String>> targetHostList;
	
	
	/**对比对象结合 Json结构*/
	private String compareObjectListJson;

	public IGCIC0102Form getIgcic0102Form() {
		return igcic0102Form;
	}

	public void setIgcic0102Form(IGCIC0102Form igcic0102Form) {
		this.igcic0102Form = igcic0102Form;
	}

	public IGCIC0101Form getIgcic0101Form() {
		return igcic0101Form;
	}

	public void setIgcic0101Form(IGCIC0101Form igcic0101Form) {
		this.igcic0101Form = igcic0101Form;
	}

	public List<CompareroleInfo> getCrList() {
		return crList;
	}

	public void setCrList(List<CompareroleInfo> crList) {
		this.crList = crList;
	}

	public List<SOC0118Info> getSystemList() {
		return systemList;
	}

	public void setSystemList(List<SOC0118Info> systemList) {
		this.systemList = systemList;
	}

	

	public String getCompareObjectListJson() {
		return compareObjectListJson;
	}

	public void setCompareObjectListJson(String compareObjectListJson) {
		this.compareObjectListJson = compareObjectListJson;
	}

	public CompareroleInfo getCompareRoleInfo() {
		return compareRoleInfo;
	}

	public void setCompareRoleInfo(CompareroleInfo compareRoleInfo) {
		this.compareRoleInfo = compareRoleInfo;
	}

	public List<Map<String, String>> getSourceHostList() {
		return sourceHostList;
	}

	public void setSourceHostList(List<Map<String, String>> sourceHostList) {
		this.sourceHostList = sourceHostList;
	}

	public List<Map<String, String>> getTargetHostList() {
		return targetHostList;
	}

	public void setTargetHostList(List<Map<String, String>> targetHostList) {
		this.targetHostList = targetHostList;
	}
	
	
	
	
}


