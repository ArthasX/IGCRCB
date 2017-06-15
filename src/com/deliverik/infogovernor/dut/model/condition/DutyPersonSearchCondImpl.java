/**
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
 */
package com.deliverik.infogovernor.dut.model.condition;

import java.util.List;

/**
 * 
 * 值班人查询实现类
 *
 */
public class DutyPersonSearchCondImpl  implements DutyPersonSearchCond{
	
	/** 值班计划ID */
	protected Integer dpid;
	
	/** 值班人ID */
	protected String dperuserid;
	
	/** 白班夜班 */
	protected String dptype;
	
	/** 值班日期 */
	protected String dpertime;
	
	protected List<Integer> DpidList;
	/**
	 * 值班计划ID取得
	 * @return 值班计划ID
	 */
	public Integer getDpid() {
		return dpid;
	}

	/**
	 * 值班计划ID设定
	 *
	 * @param dpid 值班计划ID
	 */
	public void setDpid(Integer dpid) {
		this.dpid = dpid;
	}

	/**
	 * 值班人ID取得
	 * @return 值班人ID
	 */
	public String getDperuserid() {
		return dperuserid;
	}

	/**
	 * 值班人ID设定
	 *
	 * @param dperuserid 值班人ID
	 */
	public void setDperuserid(String dperuserid) {
		this.dperuserid = dperuserid;
	}

	public String getDptype() {
		return dptype;
	}

	public void setDptype(String dptype) {
		this.dptype = dptype;
	}

	public String getDpertime() {
		return dpertime;
	}

	public void setDpertime(String dpertime) {
		this.dpertime = dpertime;
	}

	public List<Integer> getDpidList() {
		return DpidList;
	}

	public void setDpidList(List<Integer> dpidList) {
		DpidList = dpidList;
	}
	
}
