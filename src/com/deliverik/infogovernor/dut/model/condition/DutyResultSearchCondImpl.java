/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.model.condition;

/**
 * 值班检查内容查询条件接口实现
 */
public class DutyResultSearchCondImpl implements DutyResultSearchCond{
	
	/** 值班计划ID */
	protected Integer dpid;
	
	/** 值班检查项ID */
	protected Integer dadid;
	
	protected String dattime;
	
	public String getDattime() {
		return dattime;
	}

	public void setDattime(String dattime) {
		this.dattime = dattime;
	}

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
	 * 值班日期
	 */
	public String dptime;
	
	/**
	 * 值班开始日期
	 */
	public String dptime_ge;
	
	/**
	 * 值班结束日期
	 */
	public String dptime_le;
	
	/**
	 * 检查结果（空匹配）
	 */
	public String isNullDrcontent;
	
	public String dadcategory;

	/**
	 * 值班日期取得
	 * @return 值班日期
	 */
	public String getDptime() {
		return dptime;
	}
	
	/**
	 * 检查名称
	 */
	public String dadname;

	/**
	 * 检查名称取得
	 * @return
	 */
	public String getDadname(){
		return dadname;
	}
	/**
	 * 开始时间
	 */
	public String dopentime;
	
	/**
	 * 结束时间
	 */
	public String dclosetime;
	
	/**
	 * 开始时间取得
	 * @return 开始时间
	 */
	public String getDopentime(){
		return dopentime;
	}
	
	/**
	 * 结束时间取得
	 * @return 结束时间
	 */
	public String getDclosetime(){
		return dclosetime;
	}

	public String getDptime_ge() {
		return dptime_ge;
	}

	public void setDptime_ge(String dptime_ge) {
		this.dptime_ge = dptime_ge;
	}

	public String getDptime_le() {
		return dptime_le;
	}

	public void setDptime_le(String dptime_le) {
		this.dptime_le = dptime_le;
	}

	public String getDadcategory() {
		return dadcategory;
	}

	public void setDadcategory(String dadcategory) {
		this.dadcategory = dadcategory;
	}

	/**
	 * 检查结果（空匹配）取得
	 * @return 检查结果（空匹配）
	 */
	public String getIsNullDrcontent() {
		return isNullDrcontent;
	}
	
	/**
	 * 检查结果（空匹配）取得
	 * @return 检查结果（空匹配）
	 */
	public void setIsNullDrcontent(String isNullDrcontent) {
		this.isNullDrcontent = isNullDrcontent;
	}
	
	/**
	 * 值班检查项ID取得
	 * @return 值班检查项ID
	 */
	public Integer getDadid() {
		return dadid;
	}

	/**
	 * 值班检查项ID取得
	 * @return 值班检查项ID
	 */
	public void setDadid(Integer dadid) {
		this.dadid = dadid;
	}
	
}
