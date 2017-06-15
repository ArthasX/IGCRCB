/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.workflow.prd.model.IG213Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * 流程定义_授权VO
 * 
 */
@SuppressWarnings("serial")
public class IGPRD01241VO extends BaseVO implements Serializable {

	/** 流程状态信息 */
	protected IG333Info processStatusDef;
	
	/** 可选角色类型List */
	protected List<CodeDetail> codeDetailList;
	
	/** 已添加角色类型List  */
	protected List<IG213Info> processRoleTypeDefList;

	public List<IG213Info> getProcessRoleTypeDefList() {
		return processRoleTypeDefList;
	}

	public void setProcessRoleTypeDefList(
			List<IG213Info> processRoleTypeDefList) {
		this.processRoleTypeDefList = processRoleTypeDefList;
	}

	public IG333Info getProcessStatusDef() {
		return processStatusDef;
	}

	public void setProcessStatusDef(IG333Info processStatusDef) {
		this.processStatusDef = processStatusDef;
	}

	public List<CodeDetail> getCodeDetailList() {
		return codeDetailList;
	}

	public void setCodeDetailList(List<CodeDetail> codeDetailList) {
		this.codeDetailList = codeDetailList;
	}

}
