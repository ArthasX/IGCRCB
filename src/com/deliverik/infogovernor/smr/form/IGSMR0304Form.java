/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述:通用历史查询form 
 * 功能描述：通用历史查询form 
 * 创建人：赵梓廷
 * 创建记录： 2013-08-14
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSMR0304Form extends BaseForm {

	/** 类型 */
	protected String prtype;
	
	/** 报表名 */
	protected String prtitle;
	
	/** 发起时间开始 */
	protected String prstarttime;
	
	/** 发起时间结束 */
	protected String prclosetime;
	
	/** 流程主键集合 */
	private Integer[] prids;
	
	/** 流程定义ID集合 */
    private String[] prpdids;
	/**
	 * 类型取得
	 *
	 * @return 类型
	 */
	public String getPrtype() {
		return prtype;
	}
	/**
	 * 类型设定
	 *
	 * @param rctype 类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
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
	 * 发起时间开始取得
	 *
	 * @return 发起时间开始
	 */
	public String getPrstarttime() {
		return prstarttime;
	}
	/**
	 * 发起时间开始设定
	 *
	 * @param prstarttime 发起时间开始 
	 */
	public void setPrstarttime(String prstarttime) {
		this.prstarttime = prstarttime;
	}
	/**
	 * 发起时间结束取得
	 *
	 * @return 发起时间结束
	 */
	public String getPrclosetime() {
		return prclosetime;
	}
	/**
	 * 发起时间结束设定
	 *
	 * @param prclosetime 发起时间结束
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}
	/**
	 * 流程主键集合取得
	 * @return prids  流程主键集合
	 */
	public Integer[] getPrids() {
		return prids;
	}
	/**
	 * 流程主键集合设定
	 * @param prids  流程主键集合
	 */
	public void setPrids(Integer[] prids) {
		this.prids = prids;
	}
	/**
	 * 流程定义ID集合取得
	 * @return prpdids  流程定义ID集合
	 */
	public String[] getPrpdids() {
		return prpdids;
	}
	/**
	 * 流程定义ID集合设定
	 * @param prpdids  流程定义ID集合
	 */
	public void setPrpdids(String[] prpdids) {
		this.prpdids = prpdids;
	}
	
	
}
