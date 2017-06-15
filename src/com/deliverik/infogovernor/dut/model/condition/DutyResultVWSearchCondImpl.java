/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.model.condition;


/**
 * 值班日报视图查询条件接口实现
 */
public class DutyResultVWSearchCondImpl implements DutyResultVWSearchCond{
	
	/** 检查项ID */
	protected Integer dadid;
	
	/** 值班日报ID */
	protected Integer drid;
	
	/** 检查分类 */
	protected String dadtype;
	
	/** 检查名称 */
	protected String dadname;
	
	/** 检查时间 */
	protected String dattime;
	
	/** 填报时间限制 */
	protected String datlimtime;
	
	/** 检查结果类型 */
	protected String dadcontent;
	
	/** 结果说明 */
	protected String dadinfo;
	
	/** 使用状态 */
	protected String dadstatus;
	
	/** 检查结果 */
	protected String drcontent;
	
	/** 实际填报时间 */
	protected String drfilltime;
	
	/** 结果说明 */
	protected String drresult;

	/** 值班计划ID */
	protected Integer dpid;
	
	/** 值班类型 */
	protected String dadcategory;
	
	/** 检查时间从 */
	protected String dattime_form;
	
	/** 检查时间到 */
	protected String dattime_to;
	
	/** 检查时间查询条件 */
	protected String dattime_q;

	
	
	/**
	 * 检查时间查询条件取得
	 * @return 检查时间查询条件
	 */
	public String getDattime_q() {
		return dattime_q;
	}




	/**
	 * 检查时间查询条件设定
	 *
	 * @param dattime_q 检查时间查询条件
	 */
	public void setDattime_q(String dattime_q) {
		this.dattime_q = dattime_q;
	}




	/**
	 * 检查时间(从)取得
	 * @return 检查时间从
	 */
	public String getDattime_form() {
		return dattime_form;
	}




	/**
	 * 检查时间(从)设定
	 *
	 * @param dattime_form 检查时间(从)
	 */
	public void setDattime_form(String dattime_form) {
		this.dattime_form = dattime_form;
	}




	/**
	 * 检查时间(到)取得
	 * @return 检查时间(到)
	 */
	public String getDattime_to() {
		return dattime_to;
	}




	/**
	 * 检查时间(到)设定
	 *
	 * @param dattime_to 检查时间(到)
	 */
	public void setDattime_to(String dattime_to) {
		this.dattime_to = dattime_to;
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
	 *
	 * @param dadcategory 值班类型
	 */
	public void setDadcategory(String dadcategory) {
		this.dadcategory = dadcategory;
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
	 * 检查项ID取得
	 * @return 检查项ID
	 */
	public Integer getDadid() {
		return dadid;
	}



	/**
	 * 值班日报ID取得
	 * @return 值班日报ID
	 */
	public Integer getDrid() {
		return drid;
	}



	/**
	 * 检查分类取得
	 * @return 检查分类
	 */
	public String getDadtype() {
		return dadtype;
	}



	/**
	 * 检查名称取得
	 * @return 检查名称
	 */
	public String getDadname() {
		return dadname;
	}



	/**
	 * 检查时间取得
	 * @return 检查时间
	 */
	public String getDattime() {
		return dattime;
	}



	/**
	 * 填报时间限制取得
	 * @return 填报时间限制
	 */
	public String getDatlimtime() {
		return datlimtime;
	}



	/**
	 * 检查结果类型取得
	 * @return 检查结果类型
	 */
	public String getDadcontent() {
		return dadcontent;
	}



	/**
	 * 结果说明取得
	 * @return 结果说明
	 */
	public String getDadinfo() {
		return dadinfo;
	}



	/**
	 * 使用状态取得
	 * @return 使用状态
	 */
	public String getDadstatus() {
		return dadstatus;
	}



	/**
	 * 检查结果取得
	 * @return 检查结果
	 */
	public String getDrcontent() {
		return drcontent;
	}



	/**
	 * 实际填报时间取得
	 * @return 实际填报时间
	 */
	public String getDrfilltime() {
		return drfilltime;
	}



	/**
	 * 结果说明取得
	 * @return 结果说明
	 */
	public String getDrresult() {
		return drresult;
	}



	/**
	 * 检查项ID设定
	 *
	 * @param dadid 检查项ID
	 */
	public void setDadid(Integer dadid) {
		this.dadid = dadid;
	}



	/**
	 * 值班日报ID设定
	 *
	 * @param drid 值班日报ID
	 */
	public void setDrid(Integer drid) {
		this.drid = drid;
	}



	/**
	 * 检查分类 设定
	 *
	 * @param dadtype 检查分类 
	 */
	public void setDadtype(String dadtype) {
		this.dadtype = dadtype;
	}



	/**
	 * 检查名称设定
	 *
	 * @param dadname 检查名称
	 */
	public void setDadname(String dadname) {
		this.dadname = dadname;
	}



	/**
	 * 检查时间设定
	 *
	 * @param dattime 检查时间
	 */
	public void setDattime(String dattime) {
		this.dattime = dattime;
	}



	/**
	 * 填报时间限制设定
	 *
	 * @param datlimtime 填报时间限制
	 */
	public void setDatlimtime(String datlimtime) {
		this.datlimtime = datlimtime;
	}



	/**
	 * 检查结果类型设定
	 *
	 * @param dadcontent 检查结果类型
	 */
	public void setDadcontent(String dadcontent) {
		this.dadcontent = dadcontent;
	}



	/**
	 * 结果说明设定
	 *
	 * @param dadinfo 结果说明
	 */
	public void setDadinfo(String dadinfo) {
		this.dadinfo = dadinfo;
	}



	/**
	 * 使用状态设定
	 *
	 * @param dadstatus 使用状态
	 */
	public void setDadstatus(String dadstatus) {
		this.dadstatus = dadstatus;
	}



	/**
	 * 检查结果设定
	 *
	 * @param drcontent 检查结果
	 */
	public void setDrcontent(String drcontent) {
		this.drcontent = drcontent;
	}



	/**
	 * 实际填报时间设定
	 *
	 * @param drfilltime 实际填报时间
	 */
	public void setDrfilltime(String drfilltime) {
		this.drfilltime = drfilltime;
	}



	/**
	 * 结果说明设定
	 *
	 * @param drresult 结果说明
	 */
	public void setDrresult(String drresult) {
		this.drresult = drresult;
	}
	

}
