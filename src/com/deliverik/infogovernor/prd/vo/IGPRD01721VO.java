/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG701Info;

/**
 * 表单权限_授权VO
 * 
 */
@SuppressWarnings("serial")
public class IGPRD01721VO extends BaseVO implements Serializable {

	/** 未添加表单List */
	protected List<IG007Info> ig007InfoList;
	
	/** 已添加表单List  */
	protected List<IG701Info> ig701InfoList;
	
	
	public List<IG701Info> getIg701InfoList() {
		return ig701InfoList;
	}

	public void setIg701InfoList(List<IG701Info> ig701InfoList) {
		this.ig701InfoList = ig701InfoList;
	}

	public List<IG007Info> getIg007InfoList() {
		return ig007InfoList;
	}

	public void setIg007InfoList(List<IG007Info> ig007InfoList) {
		this.ig007InfoList = ig007InfoList;
	}


}
