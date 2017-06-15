/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.smr.model.ReportHistorySearchVWInfo;

/**
 * 概述:通用查询视图
 * 功能描述：通用查询视图
 * 创建人：赵梓廷
 * 创建记录： 2013-08-13
 * 修改记录：
 */
@SuppressWarnings("serial")
@Entity
public class ReportHistorySearchVW implements ReportHistorySearchVWInfo{
	@Id
	protected Integer prid;
	
	/** 报表名 */
	protected String prtitle;
	
	/** 填报人*/
	protected String fillinname;
	
	/** 报表审批人*/
	protected String reportapprovename;
	
	/** 发起人*/
	protected String prusername;
	
	/** 发起时间*/
	protected String prstarttime;
	
	/** 流程类型*/
	protected String prpdid;
	
	/** 流程类型*/
	protected String prtype;
	
	
	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPrid() {
		return prid;
	}
	
	/**
	 * 主键设定
	 *
	 * @param prid 主键
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	/**
	 * 报表名 取得
	 *
	 * @return 报表名 
	 */
	public String getPrtitle() {
		return prtitle;
	}
	/**
	 * 报表名 设定
	 *
	 * @param prtitle 报表名 
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}
	/**
	 * 填报人 取得
	 *
	 * @return 填报人 
	 */
	public String getFillinname() {
		return fillinname;
	}
	/**
	 * 填报人 设定
	 *
	 * @param fillinusername 填报人 
	 */
	public void setFillinname(String fillinname) {
		this.fillinname = fillinname;
	}
	/**
	 * 报表审批人取得
	 *
	 * @return 报表审批人
	 */
	public String getReportapprovename() {
		return reportapprovename;
	}
	/**
	 * 报表审批人 设定
	 *
	 * @param reportapprovename 报表审批人
	 */
	public void setReportapprovename(String reportapprovename) {
		this.reportapprovename = reportapprovename;
	}
	/**
	 * 发起人取得
	 *
	 * @return 发起人
	 */
	public String getPrusername() {
		return prusername;
	}
	/**
	 * 发起人设定
	 *
	 * @param prusername 发起人
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}
	/**
	 *发起时间取得
	 *
	 * @return 发起时间
	 */
	public String getPrstarttime() {
		return prstarttime;
	}
	/**
	 * 发起时间设定
	 *
	 * @param prstarttime 发起时间
	 */
	public void setPrstarttime(String prstarttime) {
		this.prstarttime = prstarttime;
	}
	/**
	 *流程类型取得
	 *
	 * @return 流程类型
	 */
	public String getPrpdid() {
		return prpdid;
	}
	/**
	 * 流程类型设定
	 *
	 * @param prpdid 流程类型
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	public String getPrtype() {
		return prtype;
	}

	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}
	
	
	
	


}
