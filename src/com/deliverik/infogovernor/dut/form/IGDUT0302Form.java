/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.dut.model.condition.DutyResultSearchCond;

/**
 * 
 * 值班情况汇总form
 *
 */
public class IGDUT0302Form extends BaseForm implements DutyResultSearchCond {
	

	private static final long serialVersionUID = 1L;

	/**
	 * 值班检查内容ID
	 */
	protected Integer drid;

	/**
	 * 值班计划ID
	 */
	protected Integer dpid;
	
	/**
	 * 检查项ID
	 */
	protected Integer dadid;
	
	/**
	 * 检查分类
	 */
	protected String dadtype;
	
	/**
	 * 检查名称
	 */
	protected String dadname;
	
	/**
	 * 检查名称
	 */
	protected String dadname_q;
	
	/**
	 * 检查时间
	 */
	protected String dattime;
	
	/**
	 * 填报时间限制
	 */
	protected String datlimtime;
	
	/**
	 * 检查结果类型
	 */
	protected String dadcontent;
	
	/**
	 * 检查结果
	 */
	protected String drcontent;
	
	/**
	 * 实际填报时间
	 */
	protected String drfilltime;
	
	/**
	 * 结果说明
	 */
	protected String drresult;
	
	/**
	 * 检查结果填写人ID
	 */
	protected String druserid;
	
	/**
	 * 检查结果填写人姓名
	 */
	protected String drusername;
	
	/**
	 * 检查结果填写时间
	 */
	protected String drcretime;
	
	/**
	 * 值班日期
	 */
	protected String dptime;
	
	/**
	 * 白班/夜班
	 */
	protected String dptype;
	
	/**
	 * 值班类型
	 */
	protected String dadcategory;

	/**
	 * 开始时间
	 */
	protected String dopentime;
	
	/**
	 * 结束时间
	 */
	protected String dclosetime;
	
	/**
	 * 值班检查内容ID取得
	 * @return 值班检查内容ID
	 */
	public Integer getDrid() {
		return drid;
	}

	/**
	 * 值班检查内容ID设置
	 * @param drid 值班检查内容ID
	 */
	public void setDrid(Integer drid) {
		this.drid = drid;
	}

	/**
	 * 值班计划ID取得
	 * @return 值班计划ID
	 */
	public Integer getDpid() {
		return dpid;
	}

	/**
	 * 值班计划ID设置
	 * @param dpid 值班计划ID
	 */
	public void setDpid(Integer dpid) {
		this.dpid = dpid;
	}

	/**
	 * 检查项ID取得
	 * @return 检查项ID
	 */
	public Integer getDadid() {
		return dadid;
	}

	/**
	 * 检查项ID设置
	 * @param dadid 检查项ID
	 */
	public void setDadid(Integer dadid) {
		this.dadid = dadid;
	}

	/**
	 * 检查分类取得
	 * @return 检查分类
	 */
	public String getDadtype() {
		return dadtype;
	}

	/**
	 * 检查分类设置
	 * @param dadtype 检查分类
	 */
	public void setDadtype(String dadtype) {
		this.dadtype = dadtype;
	}

	/**
	 * 检查名称取得
	 * @return 检查名称
	 */
	public String getDadname() {
		return dadname;
	}
	
	/**
	 * 检查名称设置
	 * @param dadname 检查名称
	 */
	public void setDadname(String dadname) {
		this.dadname = dadname;
	}
	
	/**
	 * 检查名称取得
	 * @return 检查名称
	 */
	public String getDadname_q() {
		return dadname_q;
	}

	/**
	 * 检查名称设置
	 * @param dadname_q 检查名称
	 */
	public void setDadname_q(String dadname_q) {
		this.dadname_q = dadname_q;
	}

	/**
	 * 检查时间取得
	 * @return 检查时间
	 */
	public String getDattime() {
		return dattime;
	}

	/**
	 * 检查时间设置
	 * @param dattime 检查时间
	 */
	public void setDattime(String dattime) {
		this.dattime = dattime;
	}

	/**
	 * 填报时间限制取得
	 * @return 填报时间限制
	 */
	public String getDatlimtime() {
		return datlimtime;
	}

	/**
	 * 填报时间限制设置
	 * @param datlimtime 填报时间限制
	 */
	public void setDatlimtime(String datlimtime) {
		this.datlimtime = datlimtime;
	}

	/**
	 * 检查结果类型取得
	 * @return 检查结果类型
	 */
	public String getDadcontent() {
		return dadcontent;
	}

	/**
	 * 检查结果类型设置
	 * @param dadcontent 检查结果类型
	 */
	public void setDadcontent(String dadcontent) {
		this.dadcontent = dadcontent;
	}

	/**
	 * 检查结果取得
	 * @return 检查结果
	 */
	public String getDrcontent() {
		return drcontent;
	}

	/**
	 * 检查结果设置
	 * @param drcontent检查结果
	 */
	public void setDrcontent(String drcontent) {
		this.drcontent = drcontent;
	}

	/**
	 * 实际填报时间取得
	 * @return 实际填报时间
	 */
	public String getDrfilltime() {
		return drfilltime;
	}

	/**
	 * 实际填报时间设置
	 * @param drfilltime 实际填报时间
	 */
	public void setDrfilltime(String drfilltime) {
		this.drfilltime = drfilltime;
	}

	/**
	 * 结果说明 取得
	 * @return 结果说明
	 */
	public String getDrresult() {
		return drresult;
	}

	/**
	 * 结果说明设置
	 * @param drresult 结果说明
	 */
	public void setDrresult(String drresult) {
		this.drresult = drresult;
	}

	/**
	 * 检查结果填写人ID取得
	 * @return 检查结果填写人ID
	 */
	public String getDruserid() {
		return druserid;
	}

	/**
	 * 检查结果填写人ID设置
	 * @param druserid 检查结果填写人ID
	 */
	public void setDruserid(String druserid) {
		this.druserid = druserid;
	}

	/**
	 * 检查结果填写人姓名
	 * @return 检查结果填写人姓名
	 */
	public String getDrusername() {
		return drusername;
	}

	/**
	 * 检查结果填写人姓名设置
	 * @param drusername 检查结果填写人姓名
	 */
	public void setDrusername(String drusername) {
		this.drusername = drusername;
	}

	/**
	 * 检查结果填写时间取得
	 * @return 检查结果填写时间
	 */
	public String getDrcretime() {
		return drcretime;
	}

	/**
	 * 检查结果填写时间设置
	 * @param 检查结果填写时间
	 */
	public void setDrcretime(String drcretime) {
		this.drcretime = drcretime;
	}

	/**
	 * 值班日期取得
	 * @return 值班日期
	 */
	public String getDptime() {
		return dptime;
	}

	/**
	 * 值班日期设定
	 * @param dptime 值班日期
	 */
	public void setDptime(String dptime) {
		this.dptime = dptime;
	}

	/**
	 * 白班/夜班取得
	 * @return 白班/夜班
	 */
	public String getDptype() {
		return dptype;
	}

	/**
	 * 白班/夜班设定
	 * @param dptype 白班/夜班
	 */
	public void setDptype(String dptype) {
		this.dptype = dptype;
	}

	/**
	 * 值班类型取得
	 * @return 值班类型
	 */
	public String getDadcategory() {
		return dadcategory;
	}

	/**
	 * 值班类型设定
	 * @param dadcategory 值班类型
	 */
	public void setDadcategory(String dadcategory) {
		this.dadcategory = dadcategory;
	}

	/**
	 * 开始时间
	 * @return 开始时间
	 */
	public String getDopentime() {
		return dopentime;
	}

	/**
	 * 开始时间
	 * @param dopentime 开始时间
	 */
	public void setDopentime(String dopentime) {
		this.dopentime = dopentime;
	}

	/**
	 * 结束时间
	 * @return 结束时间
	 */
	public String getDclosetime() {
		return dclosetime;
	}

	/**
	 * 结束时间
	 * @param dclosetime 结束时间
	 */
	public void setDclosetime(String dclosetime) {
		this.dclosetime = dclosetime;
	}

	public String getDptime_ge() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDptime_le() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getIsNullDrcontent() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
