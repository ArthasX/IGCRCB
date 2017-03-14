/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.risk.model.CheckWorkResultInfo;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 检查工作执行查询VO
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGRIS02012VO extends BaseVO implements Serializable{
	/** 风险检查结果信息检索结果 */
	protected RiskCheckResult riskCheckResult;
	
	/** 附件id  */	
	protected Integer attid;
	/** 附件名  */	
	protected String attname;
	
	/** 计划结束时间*/
	protected String endDate;
	
	protected CheckWorkResultInfo checkWorkResultInfo;
	/**
	 * 风险检查结果信息检索结果取得
	 * @return riskCheckResult 风险检查结果信息检索结果
	 */
	public RiskCheckResult getRiskCheckResult() {
		return riskCheckResult;
	}
	/**
	 * 风险检查结果信息检索结果设定
	 * @param riskCheckResult 风险检查结果信息检索结果
	 */
	public void setRiskCheckResult(RiskCheckResult riskCheckResult) {
		this.riskCheckResult = riskCheckResult;
	}
	
	/**
	 * @return the checkWorkResultInfo
	 */
	public CheckWorkResultInfo getCheckWorkResultInfo() {
		return checkWorkResultInfo;
	}
	/**
	 * @param checkWorkResultInfo the checkWorkResultInfo to set
	 */
	public void setCheckWorkResultInfo(CheckWorkResultInfo checkWorkResultInfo) {
		this.checkWorkResultInfo = checkWorkResultInfo;
	}
	/**
	 * 计划结束时间取得
	 * @return endDate 计划结束时间
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * 计划结束时间设定
	 * @param endDate 计划结束时间
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	/**
	 * 附件id取得
	 * @return attid  附件id
	 */
	public Integer getAttid() {
		return attid;
	}
	/**
	 * 附件id设定
	 * @param attid  附件id
	 */
	public void setAttid(Integer attid) {
		this.attid = attid;
	}
	/**
	 * 附件名取得
	 * @return attname  附件名
	 */
	public String getAttname() {
		return attname;
	}
	/**
	 * 附件名设定
	 * @param attname  附件名
	 */
	public void setAttname(String attname) {
		this.attname = attname;
	}
}
