package com.deliverik.infogovernor.prm.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG007Info;

public class IGPRM03011VO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private IG007Info processInfoDef;
	
	private List<IG007Info> processInfoDefList;
	
	private Map<String,String> typeMap;
	
	/**是否可以增加缺省审批人 1是0否*/
	private String addDefaultApprover;
	
	/**是否可以增加缺省审批分派人 1是0否*/
	private String addDefaultApproveDispatcher;

	public Map<String, String> getTypeMap() {
		return typeMap;
	}

	public void setTypeMap(Map<String, String> typeMap) {
		this.typeMap = typeMap;
	}

	public IG007Info getProcessInfoDef() {
		return processInfoDef;
	}

	public List<IG007Info> getProcessInfoDefList() {
		return processInfoDefList;
	}

	public void setProcessInfoDefList(List<IG007Info> processInfoDefList) {
		this.processInfoDefList = processInfoDefList;
	}

	public void setProcessInfoDef(IG007Info processInfoDef) {
		this.processInfoDef = processInfoDef;
	}

	public String getAddDefaultApprover() {
		return addDefaultApprover;
	}

	public void setAddDefaultApprover(String addDefaultApprover) {
		this.addDefaultApprover = addDefaultApprover;
	}

	public String getAddDefaultApproveDispatcher() {
		return addDefaultApproveDispatcher;
	}

	public void setAddDefaultApproveDispatcher(String addDefaultApproveDispatcher) {
		this.addDefaultApproveDispatcher = addDefaultApproveDispatcher;
	}

}
