/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.smr.model.ReportHistoryVWInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 报表历史填报记录视图实体实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@Entity
public class ReportHistoryVW implements ReportHistoryVWInfo{

	/** 流程主键 */
	@Id
	protected Integer prid;
	
	/** 组标识 */
	protected String key;
	
	/** 组类型 */
	protected String prtype;
	
	/** 说明 */
	protected String reportdesc;

	/**
	 * 流程主键取得
	 * @return prid 流程主键
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程主键设定
	 * @param prid 流程主键
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 组标识取得
	 * @return key 组标识
	 */
	public String getKey() {
		return key;
	}

	/**
	 * 组标识设定
	 * @param key 组标识
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * 组类型取得
	 * @return prtype 组类型
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 组类型设定
	 * @param prtype 组类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * 说明取得
	 * @return reportdesc 说明
	 */
	public String getReportdesc() {
		return reportdesc;
	}

	/**
	 * 说明设定
	 * @param reportdesc 说明
	 */
	public void setReportdesc(String reportdesc) {
		this.reportdesc = reportdesc;
	}
	
	
}
