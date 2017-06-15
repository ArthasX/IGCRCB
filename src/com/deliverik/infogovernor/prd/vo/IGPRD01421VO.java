/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.entity.IG333TB;

/**
 * 概述: 流程状态参与角色定义VO
 * 功能描述: 流程状态参与角色定义VO
 * 创建记录: 2012/04/11
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGPRD01421VO extends BaseVO implements Serializable {
	protected List<IG333TB> psdTBList;

	public List<IG333TB> getPsdTBList() {
		return psdTBList;
	}

	public void setPsdTBList(List<IG333TB> psdTBList) {
		this.psdTBList = psdTBList;
	}
	
}
