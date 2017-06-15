/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.dut.model.DutyPlan;

public class IGDUT0203Form extends BaseForm {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 检查项ID
	 */
	protected Integer dadid;

	/**
	 * 值班类型
	 */
	protected String dadcategory;
	
	/**
	 * 检查分类
	 */
	protected String dadtype;
	
	/**
	 * 检查名称
	 */
	protected String dadname;
	
	/**
	 * 填报时间限制
	 */
	protected String dadlimtime;
	
	/**
	 * 检查结果内容
	 */
	protected String dadcontent;
	
	/**
	 * 结果说明
	 */
	protected String dadinfo;
	
	/**
	 * 使用状态
	 */
	protected String dadstatus;
	
	/**
	 * 更新者ID
	 */
	protected String daduserid;
	
	/**
	 * 更新者姓名
	 */
	protected String dadusername;
	
	/**
	 * 更新时间
	 */
	protected String dadupdtime;


	/**检查时间ID */
	protected Integer datid;
	
	
	/**检查项时间 */
	protected String dattime;
	
	/**检查项时间数组 */
	protected String[] dattimes;
	
	/**限制时间 */
	protected String datlimtime;

	/**
	 * 页面标题显示标志0-新增,1-变更
	 */
	protected String mode = "0";
	
	
	
	/** 值班检查内容ID */
	protected Integer drid;

	/** 值班计划ID */
	protected Integer dpid;
	
	/** 检查名称 */
	protected String dptime;
	
	/** 检查名称 */
	protected String dptype;
	
	
	/** 检查结果 */
	protected String drcontent;
	
	/** 实际填报时间 */
	protected String drfilltime;
	
	/** 结果说明 */
	protected String drresult;
	
	/** 检查结果填写人ID */
	protected String druserid;
	
	/** 检查结果填写人姓名 */
	protected String drusername;
	
	/** 检查结果填写时间 */
	protected String drcretime;
	
	/** 结果说明 */
	protected String[] drresults;
	
	/** 实际填报时间 */
	protected String[] drfilltimes;
	
	/** 检查结果类型数组 */
	protected String[] dadcontenttypes;
	
	/** 检查结果类型数组 */
	protected String[] dadcontenttypes_hides;
	
	/** 检查项ID数组 */
	protected Integer[] dadids;
	
	/** 检查分类数组 */
	protected String[] dadtypes;
	
	/** 检查名称数组 */
	protected String[] dadnames;
	
	/** 填报时间限制数组 */
	protected String[] datlimtimes;
	
	/** 检查结果数组 */
	protected String[] dadcontents;
	
	/** 值班计划 */
	protected DutyPlan dutyPlan;
	
	/** 值班日报ID集合 */
	protected List<Integer> dridList;

	/** 填报日、时限制 */
	protected String[] drlimdtimes;
	
	
	/** 限制时间 */
	protected String[] dadlimtimes;
	
	/** 值班备注 */
	protected String dpremarks;

	

	/**
	 * 限制时间取得
	 * @return 限制时间
	 */
	public String[] getDadcontenttypes_hides() {
		return dadcontenttypes_hides;
	}

	/**
	 * 限制时间设定
	 *
	 * @param dadcontenttypes_hides 限制时间
	 */
	public void setDadcontenttypes_hides(String[] dadcontenttypes_hides) {
		this.dadcontenttypes_hides = dadcontenttypes_hides;
	}

	/**
	 * 限制时间取得
	 * @return 限制时间
	 */
	public String[] getDadlimtimes() {
		return dadlimtimes;
	}

	/**
	 * 限制时间设定
	 *
	 * @param dadlimtimes 限制时间
	 */
	public void setDadlimtimes(String[] dadlimtimes) {
		this.dadlimtimes = dadlimtimes;
	}

	/**
	 * 填报日、时限制取得
	 * @return 填报日、时限制
	 */
	public String[] getDrlimdtimes() {
		return drlimdtimes;
	}

	/**
	 * 填报日、时限制设定
	 *
	 * @param drlimdtime 填报日、时限制
	 */
	public void setDrlimdtimes(String[] drlimdtimes) {
		this.drlimdtimes = drlimdtimes;
	}

	/**
	 * 值班日报ID集合取得
	 * @return the dridList
	 */
	public List<Integer> getDridList() {
		return dridList;
	}

	/**
	 *  值班日报ID集合设定
	 */
	public void setDridList(List<Integer> dridList) {
		this.dridList = dridList;
	}
	
	
	/**
	 * 值班计划取得
	 * @return 值班计划
	 */
	public DutyPlan getDutyPlan() {
		return dutyPlan;
	}


	/**
	 * 值班计划设定
	 *
	 * @param dutyPlan 值班计划
	 */
	public void setDutyPlan(DutyPlan dutyPlan) {
		this.dutyPlan = dutyPlan;
	}


	/**
	 * 检查结果类型数组取得
	 * @return 检查结果类型数组
	 */
	public String[] getDadcontenttypes() {
		return dadcontenttypes;
	}


	/**
	 * 检查结果类型数组设定
	 *
	 * @param dadcontenttypes 检查结果类型数组
	 */
	public void setDadcontenttypes(String[] dadcontenttypes) {
		this.dadcontenttypes = dadcontenttypes;
	}


	/**
	 * 检查项ID数组取得
	 * @return 检查项ID数组
	 */
	public Integer[] getDadids() {
		return dadids;
	}


	/**
	 * 检查项ID数组设定
	 *
	 * @param dadids 检查项ID数组
	 */
	public void setDadids(Integer[] dadids) {
		this.dadids = dadids;
	}


	/**
	 * 检查分类数组取得
	 * @return 检查分类数组
	 */
	public String[] getDadtypes() {
		return dadtypes;
	}


	/**
	 * 检查分类数组设定
	 *
	 * @param dadtypes 检查分类数组
	 */
	public void setDadtypes(String[] dadtypes) {
		this.dadtypes = dadtypes;
	}


	/**
	 * 检查名称数组取得
	 * @return 检查名称数组
	 */
	public String[] getDadnames() {
		return dadnames;
	}


	/**
	 * 检查名称数组设定
	 *
	 * @param dadnames 检查名称数组
	 */
	public void setDadnames(String[] dadnames) {
		this.dadnames = dadnames;
	}


	/**
	 * 填报时间限制数组取得
	 * @return 填报时间限制数组
	 */
	public String[] getDatlimtimes() {
		return datlimtimes;
	}


	/**
	 * 填报时间限制数组设定
	 *
	 * @param datlimtimes 填报时间限制数组
	 */
	public void setDatlimtimes(String[] datlimtimes) {
		this.datlimtimes = datlimtimes;
	}


	/**
	 * 检查结果数组取得
	 * @return 检查结果数组
	 */
	public String[] getDadcontents() {
		return dadcontents;
	}


	/**
	 * 检查结果数组设定
	 *
	 * @param dadcontents 检查结果数组
	 */
	public void setDadcontents(String[] dadcontents) {
		this.dadcontents = dadcontents;
	}

	/**
	 * 结果说明取得
	 * @return 结果说明
	 */
	public String[] getDrresults() {
		return drresults;
	}

	/**
	 * 结果说明设定
	 *
	 * @param drresults 结果说明
	 */
	public void setDrresults(String[] drresults) {
		this.drresults = drresults;
	}

	/**
	 * 实际填报时间取得
	 * @return 实际填报时间
	 */
	public String[] getDrfilltimes() {
		return drfilltimes;
	}

	/**
	 * 实际填报时间设定
	 *
	 * @param drfilltimes 实际填报时间
	 */
	public void setDrfilltimes(String[] drfilltimes) {
		this.drfilltimes = drfilltimes;
	}

	/**
	 * 值班检查内容ID取得
	 * @return 值班检查内容ID
	 */
	public Integer getDrid() {
		return drid;
	}
	
	/**
	 * 值班检查内容ID设定
	 *
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
	 * 值班计划ID设定
	 *
	 * @param dpid 值班计划ID
	 */
	public void setDpid(Integer dpid) {
		this.dpid = dpid;
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
	 *
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
	 *
	 * @param dptype 白班/夜班
	 */
	public void setDptype(String dptype) {
		this.dptype = dptype;
	}


	/**
	 * 检查结果取得
	 * @return 检查结果
	 */
	public String getDrcontent() {
		return drcontent;
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
	 * 实际填报时间取得
	 * @return 实际填报时间
	 */
	public String getDrfilltime() {
		return drfilltime;
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
	 * 结果说明取得
	 * @return 结果说明
	 */
	public String getDrresult() {
		return drresult;
	}
	
	/**
	 * 结果说明设定
	 *
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
	 * 检查结果填写人ID设定
	 *
	 * @param druserid 检查结果填写人ID
	 */
	public void setDruserid(String druserid) {
		this.druserid = druserid;
	}

	/**
	 * 检查结果填写人姓名取得
	 * @return 检查结果填写人姓名
	 */
	public String getDrusername() {
		return drusername;
	}
	
	/**
	 * 检查结果填写人姓名设定
	 *
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
	 * 检查结果填写时间设定
	 *
	 * @param drcretime 检查结果填写时间
	 */
	public void setDrcretime(String drcretime) {
		this.drcretime = drcretime;
	}
	
	
	
	/**
	 * 限制时间取得
	 * @return datlimtime
	 */
	public String getDatlimtime() {
		return datlimtime;
	}

	/**
	 * 限制时间设定
	 */
	public void setDatlimtime(String datlimtime) {
		this.datlimtime = datlimtime;
	}

	
	/**
	 * 检查项时间数组取得
	 * @return dattimes
	 */
	public String[] getDattimes() {
		return dattimes;
	}

	/**
	 * 检查项时间数组设定
	 */
	public void setDattimes(String[] dattimes) {
		this.dattimes = dattimes;
	}

	/**
	 * 新增、变更标识取得
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 新增、变更标识设定
	 * @return mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * 检查项ID
	 * @return 检查项ID
	 */
	public Integer getDadid() {
		return dadid;
	}

	/**
	 * 值班类型
	 * @param dadid 值班类型
	 */
	public void setDadid(Integer dadid) {
		this.dadid = dadid;
	}

	/**
	 * 值班类型
	 * @return 值班类型
	 */
	public String getDadcategory() {
		return dadcategory;
	}

	/**
	 * 值班类型
	 * @param dadcategory 值班类型
	 */
	public void setDadcategory(String dadcategory) {
		this.dadcategory = dadcategory;
	}

	/**
	 * 检查分类
	 * @return 检查分类
	 */
	public String getDadtype() {
		return dadtype;
	}

	/**
	 * 检查分类
	 * @param dadtype 检查分类
	 */
	public void setDadtype(String dadtype) {
		this.dadtype = dadtype;
	}

	/**
	 * 检查名称
	 * @return 检查名称
	 */
	public String getDadname() {
		return dadname;
	}

	/**
	 * 检查名称
	 * @param dadname 检查名称
	 */
	public void setDadname(String dadname) {
		this.dadname = dadname;
	}

	/**
	 * 填报时间限制
	 * @return 填报时间限制
	 */
	public String getDadlimtime() {
		return dadlimtime;
	}

	/**
	 * 填报时间限制
	 * @param dadlimtime 填报时间限制
	 */
	public void setDadlimtime(String dadlimtime) {
		this.dadlimtime = dadlimtime;
	}

	/**
	 * 检查结果内容
	 * @return 检查结果内容
	 */
	public String getDadcontent() {
		return dadcontent;
	}

	/**
	 * 检查结果内容
	 * @param dadcontent 检查结果内容
	 */
	public void setDadcontent(String dadcontent) {
		this.dadcontent = dadcontent;
	}

	/**
	 * 结果说明
	 * @return 结果说明
	 */
	public String getDadinfo() {
		return dadinfo;
	}

	/**
	 * 结果说明
	 * @param dadinfo 结果说明
	 */
	public void setDadinfo(String dadinfo) {
		this.dadinfo = dadinfo;
	}

	/**
	 * 使用状态
	 * @return 使用状态
	 */
	public String getDadstatus() {
		return dadstatus;
	}

	/**
	 * 使用状态
	 * @param dadstatus 使用状态
	 */
	public void setDadstatus(String dadstatus) {
		this.dadstatus = dadstatus;
	}

	/**
	 * 更新者ID
	 * @return 更新者ID
	 */
	public String getDaduserid() {
		return daduserid;
	}

	/**
	 * 更新者ID
	 * @param daduserid 更新者ID
	 */
	public void setDaduserid(String daduserid) {
		this.daduserid = daduserid;
	}

	/**
	 * 更新者姓名
	 * @return 更新者姓名
	 */
	public String getDadusername() {
		return dadusername;
	}

	/**
	 * 更新者姓名
	 * @param dadusername 更新者姓名
	 */
	public void setDadusername(String dadusername) {
		this.dadusername = dadusername;
	}

	/**
	 * 更新时间
	 * @return 更新时间
	 */
	public String getDadupdtime() {
		return dadupdtime;
	}

	/**
	 * 更新时间
	 * @param dadupdtime 更新时间
	 */
	public void setDadupdtime(String dadupdtime) {
		this.dadupdtime = dadupdtime;
	}



	 /**
     * 
	 *检查时间ID取得
	 * @return 检查时间ID
	 */
	public Integer getDatid() {
		return datid;
	}
    
	/**
	 * 
	 * 检查时间ID设定
	 * @param datid 检查时间ID
	 */
	public void setDatid(Integer datid) {
		this.datid = datid;
	}
    
    
	/**
	 * 检查时间取得
	 * @return 检查时间
	 */
	public String getDattime() {
		return dattime;
	}
	
    /**
	 * 值班备注取得
	 *
	 * @return dpremarks 值班备注
	 */
	public String getDpremarks() {
		return dpremarks;
	}

	/**
	 * 值班备注设定
	 *
	 * @param dpremarks 值班备注
	 */
	public void setDpremarks(String dpremarks) {
		this.dpremarks = dpremarks;
	}

	/**
     * 检查时间设置
     * @param dattime 检查时间
     */
	public void setDattime(String dattime) {
		this.dattime = dattime;
	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}
	



}
