/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * 报表信息结果ＶＯ
 * 
 */
@SuppressWarnings("serial")
public class IGSYM14021VO extends BaseVO implements Serializable{
	
	protected List<IG333Info> prstatusList;

	public List<IG333Info> getPrstatusList() {
		return prstatusList;
	}

	public void setPrstatusList(List<IG333Info> prstatusList) {
		this.prstatusList = prstatusList;
	}
	
	

}
