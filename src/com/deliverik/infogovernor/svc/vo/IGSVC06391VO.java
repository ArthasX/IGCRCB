/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG160Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 部门服务统计vo
 * </p>
 */
@SuppressWarnings("serial")
public class IGSVC06391VO extends BaseVO{

	/** 部门服务统计数据集合 */
	private List<IG160Info> summaryCountList;
	
	/**人员工作来那个统计Json格式  人员信息 */
	private String presonsJson;
	/**人员工作量统计 Json 格式统计数据*/
	private String acountJson;

	public List<IG160Info> getSummaryCountList() {
		return summaryCountList;
	}

	public void setSummaryCountList(List<IG160Info> summaryCountList) {
		this.summaryCountList = summaryCountList;
	}

	public String getPresonsJson() {
		return presonsJson;
	}

	public void setPresonsJson(String presonsJson) {
		this.presonsJson = presonsJson;
	}

	public String getAcountJson() {
		return acountJson;
	}

	public void setAcountJson(String acountJson) {
		this.acountJson = acountJson;
	}
	
	



}
