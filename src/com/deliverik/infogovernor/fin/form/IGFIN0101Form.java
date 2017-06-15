/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.fin.model.Budget;
import com.deliverik.infogovernor.fin.model.condition.BudgetSearchCond;


/**
 * 预算登记画面FORM IGFIN0101Form ActionForm
 */
public class IGFIN0101Form extends BaseForm implements Budget,BudgetSearchCond {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Integer bid;

	protected String btype;
	
	protected String btype_q;
	
	protected String binittime;

	protected String bopentime;

	protected String bstatus = "O";

	protected String breqid;

	protected String bapvid;

	protected String btitle;
	
	protected String btitle_q;

	protected String bclosetime;

	protected String bdesc;

	protected String binfo;

	protected String byear;
	
	protected String byear_q;

	protected String borgid;

	protected String borgname;

	protected String breqname;

	protected String bapvname;

	protected Double bamount;

	protected String battkey;
	
	protected String route = "0";
	
	protected String pcode;
	
	protected Integer pid;
	
	protected String pname;
	
	protected String bstatus_q;//查询用
	
	protected String pquality;//预算性质
	
	protected String puse;//预算用途
	
	protected String pstorecode;//储备预算编号
	
	protected String pneeddispart;//需求部门
	
	protected String pbuggetform;//预算组成
	
	protected String remark;//备注

	protected String byear_before;//前年的年份
	
	protected String byear_now;//今年的年份
	
	/** 预算 资本金 开发*/
	protected Double bzdevelop;
	
	/** 预算 资本金 硬件*/
	protected Double bzhardware;
	
	/** 预算 资本金 软件*/
	protected Double bzsoftware;
	
	/** 预算 资本金 工程*/
	protected Double bzproject;
	
	/** 预算 资本金 其他*/
	protected Double bzelse;
	
	/** 预算 成本金 实施*/
	protected Double bcimplement;
	
	/** 预算 成本金 其他*/
	protected Double bcelse;
	
	/**
	 * 获取预算资本金开发
	 * @return fbzdevelop 预算资本金开发
	 */
	public Double getBzdevelop() {
		return bzdevelop;
	}
	/**
	 * 设置预算资本金开发
	 * @param bzdevelop  预算资本金开发
	 */
	public void setBzdevelop(Double bzdevelop) {
		this.bzdevelop = bzdevelop;
	}
	/**
	 * 获取预算资本金硬件
	 * @return fbzhardware 预算资本金硬件
	 */
	public Double getBzhardware() {
		return bzhardware;
	}
	/**
	 * 设置预算资本金硬件
	 * @param bzhardware  预算资本金硬件
	 */
	public void setBzhardware(Double bzhardware) {
		this.bzhardware = bzhardware;
	}
	/**
	 * 获取预算资本金软件
	 * @return fbzsoftware 预算资本金软件
	 */
	public Double getBzsoftware() {
		return bzsoftware;
	}
	/**
	 * 设置预算资本金软件
	 * @param bzsoftware  预算资本金软件
	 */
	public void setBzsoftware(Double bzsoftware) {
		this.bzsoftware = bzsoftware;
	}
	/**
	 * 获取预算资本金工程
	 * @return fbzproject 预算资本金工程
	 */
	public Double getBzproject() {
		return bzproject;
	}
	/**
	 * 设置预算资本金工程
	 * @param bzproject  预算资本金工程
	 */
	public void setBzproject(Double bzproject) {
		this.bzproject = bzproject;
	}
	/**
	 * 获取预算资本金其他
	 * @return fbzelse 预算资本金其他
	 */
	public Double getBzelse() {
		return bzelse;
	}
	/**
	 * 设置预算资本金其他
	 * @param bzelse  预算资本金其他
	 */
	public void setBzelse(Double bzelse) {
		this.bzelse = bzelse;
	}
	/**
	 * 获取预算成本金实施
	 * @return fbcimplement 预算成本金实施
	 */
	public Double getBcimplement() {
		return bcimplement;
	}
	/**
	 * 设置预算成本金实施
	 * @param bcimplement  预算成本金实施
	 */
	public void setBcimplement(Double bcimplement) {
		this.bcimplement = bcimplement;
	}
	/**
	 * 获取预算成本金其他
	 * @return fbcelse 预算成本金其他
	 */
	public Double getBcelse() {
		return bcelse;
	}
	/**
	 * 设置预算成本金其他
	 * @param bcelse  预算成本金其他
	 */
	public void setBcelse(Double bcelse) {
		this.bcelse = bcelse;
	}
	/**
	 * 前年的年份设定
	 * 
	 * @param byear_before
	 */
	public void setByear_before(String byear_before) {
		this.byear_before = byear_before;
	}
	/**
	 * 今年的年份设定
	 * 
	 * @return byear_now
	 */
	public void setByear_now(String byear_now) {
		this.byear_now = byear_now;
	}

	public String getBtype_q() {
		return btype_q;
	}

	public void setBtype_q(String btype_q) {
		this.btype_q = btype_q;
	}

	public String getBtitle_q() {
		return btitle_q;
	}

	public void setBtitle_q(String btitle_q) {
		this.btitle_q = btitle_q;
	}

	public String getByear_q() {
		return byear_q;
	}

	public void setByear_q(String byear_q) {
		this.byear_q = byear_q;
	}

	public String getPuse() {
		return puse;
	}

	public void setPuse(String puse) {
		this.puse = puse;
	}

	public String getBstatus_q() {
		return bstatus_q;
	}

	public String getPquality() {
		return pquality;
	}

	public void setPquality(String pquality) {
		this.pquality = pquality;
	}

	public String getPstorecode() {
		return pstorecode;
	}

	public void setPstorecode(String pstorecode) {
		this.pstorecode = pstorecode;
	}

	public String getPneeddispart() {
		return pneeddispart;
	}

	public void setPneeddispart(String pneeddispart) {
		this.pneeddispart = pneeddispart;
	}

	public String getPbuggetform() {
		return pbuggetform;
	}

	public void setPbuggetform(String pbuggetform) {
		this.pbuggetform = pbuggetform;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setBstatus_q(String bstatus_q) {
		this.bstatus_q = bstatus_q;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}


	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBtype() {
		return btype;
	}

	public void setBtype(String btype) {
		this.btype = btype;
	}

	public String getBinittime() {
		return binittime;
	}

	public void setBinittime(String binittime) {
		this.binittime = binittime;
	}

	public String getBopentime() {
		return bopentime;
	}

	public void setBopentime(String bopentime) {
		this.bopentime = bopentime;
	}

	public String getBstatus() {
		return bstatus;
	}

	public void setBstatus(String bstatus) {
		this.bstatus = bstatus;
	}

	public String getBreqid() {
		return breqid;
	}

	public void setBreqid(String breqid) {
		this.breqid = breqid;
	}

	public String getBapvid() {
		return bapvid;
	}

	public void setBapvid(String bapvid) {
		this.bapvid = bapvid;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBclosetime() {
		return bclosetime;
	}

	public void setBclosetime(String bclosetime) {
		this.bclosetime = bclosetime;
	}

	public String getBdesc() {
		return bdesc;
	}

	public void setBdesc(String bdesc) {
		this.bdesc = bdesc;
	}

	public String getBinfo() {
		return binfo;
	}

	public void setBinfo(String binfo) {
		this.binfo = binfo;
	}

	public String getByear() {
		return byear;
	}

	public void setByear(String byear) {
		this.byear = byear;
	}

	public String getBorgid() {
		return borgid;
	}

	public void setBorgid(String borgid) {
		this.borgid = borgid;
	}

	public String getBorgname() {
		return borgname;
	}

	public void setBorgname(String borgname) {
		this.borgname = borgname;
	}

	public String getBreqname() {
		return breqname;
	}

	public void setBreqname(String breqname) {
		this.breqname = breqname;
	}

	public String getBapvname() {
		return bapvname;
	}

	public void setBapvname(String bapvname) {
		this.bapvname = bapvname;
	}

	public Double getBamount() {
		return bamount;
	}

	public void setBamount(Double bamount) {
		this.bamount = bamount;
	}

	public String getBattkey() {
		return battkey;
	}

	public void setBattkey(String battkey) {
		this.battkey = battkey;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getSelectMode() {
		return null;
	}
	
	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	/**
	 * 前年的年份取得
	 * 
	 * @return byear_before
	 */
	public String getByear_before() {
		return byear_before;
	}

	/**
	 * 今年的年份取得
	 * 
	 * @return byear_now
	 */
	public String getByear_now() {
		return byear_now;
	}

}
