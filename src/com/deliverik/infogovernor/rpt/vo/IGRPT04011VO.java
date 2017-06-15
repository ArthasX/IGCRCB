/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;

/**
 * 概述: 报表统计初始VO
 * 功能描述: 
 * 创建记录: 张楠 2012/10/26
 */
@SuppressWarnings("serial")
public class IGRPT04011VO extends BaseVO{
	
	protected List<CodeDetail> parCodeDetailList;
	protected List<CodeDetail> cldCodeDetailList;
	protected List<ReportFileDefinition> rfdList;
	protected Map<String, String> rfdtypeMap;

	public List<CodeDetail> getParCodeDetailList() {
		return parCodeDetailList;
	}

	public void setParCodeDetailList(List<CodeDetail> parCodeDetailList) {
		this.parCodeDetailList = parCodeDetailList;
	}

	public List<CodeDetail> getCldCodeDetailList() {
		return cldCodeDetailList;
	}

	public void setCldCodeDetailList(List<CodeDetail> cldCodeDetailList) {
		this.cldCodeDetailList = cldCodeDetailList;
	}

	public List<ReportFileDefinition> getRfdList() {
		return rfdList;
	}

	public void setRfdList(List<ReportFileDefinition> rfdList) {
		this.rfdList = rfdList;
	}

	public Map<String, String> getRfdtypeMap() {
		return rfdtypeMap;
	}

	public void setRfdtypeMap(Map<String, String> rfdtypeMap) {
		this.rfdtypeMap = rfdtypeMap;
	}
	
}
