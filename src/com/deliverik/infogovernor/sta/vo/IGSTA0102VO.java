/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sta.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.sta.model.RiskCheckProblemSuperviseVWInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_问题管理_查询VO
 * </p>
 * 
 * @author yangsn@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSTA0102VO extends BaseVO implements Serializable {

	/** 问题整改信息取得 */
	List<RiskCheckProblemSuperviseVWInfo> riskCheckProblemSuperviseVWList;

	/**
	 * 问题整改信息取得取得
	 * @return riskCheckProblemSuperviseVWList 问题整改信息取得
	 */
	public List<RiskCheckProblemSuperviseVWInfo> getRiskCheckProblemSuperviseVWList() {
		return riskCheckProblemSuperviseVWList;
	}

	/**
	 * 问题整改信息取得设定
	 * @param riskCheckProblemSuperviseVWList 问题整改信息取得
	 */
	public void setRiskCheckProblemSuperviseVWList(
			List<RiskCheckProblemSuperviseVWInfo> riskCheckProblemSuperviseVWList) {
		this.riskCheckProblemSuperviseVWList = riskCheckProblemSuperviseVWList;
	}
}
