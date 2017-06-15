/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dbm.model.condition;

import java.util.List;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 科技运行统计分析查询条件实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class ScienceOperationReportSearchCondImpl implements
		ScienceOperationReportSearchCond {

	/** 表单名称 */
	protected String pivarname;
	
	/** 表单备选值 */
	protected String pidoptions;
	
	/** 流程发起时间 */
	protected String propentime_like;
	
	/** 流程类型范围 */
	protected List<String> prpdid_in;

	/**
	 * 表单名称取得
	 * @return pivarname 表单名称
	 */
	public String getPivarname() {
		return pivarname;
	}

	/**
	 * 表单名称设定
	 * @param pivarname 表单名称
	 */
	public void setPivarname(String pivarname) {
		this.pivarname = pivarname;
	}

	/**
	 * 表单备选值取得
	 * @return pidoptions 表单备选值
	 */
	public String getPidoptions() {
		return pidoptions;
	}

	/**
	 * 表单备选值设定
	 * @param pidoptions 表单备选值
	 */
	public void setPidoptions(String pidoptions) {
		this.pidoptions = pidoptions;
	}

	/**
	 * 流程发起时间取得
	 * @return propentime_like 流程发起时间
	 */
	public String getPropentime_like() {
		return propentime_like;
	}

	/**
	 * 流程发起时间设定
	 * @param propentime_like 流程发起时间
	 */
	public void setPropentime_like(String propentime_like) {
		this.propentime_like = propentime_like;
	}

	/**
	 * 流程类型范围取得
	 * @return prpdid_in 流程类型范围
	 */
	public List<String> getPrpdid_in() {
		return prpdid_in;
	}

	/**
	 * 流程类型范围设定
	 * @param prpdid_in 流程类型范围
	 */
	public void setPrpdid_in(List<String> prpdid_in) {
		this.prpdid_in = prpdid_in;
	}
}
