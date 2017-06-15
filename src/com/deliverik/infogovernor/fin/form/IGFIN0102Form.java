/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.fin.model.Budget;
import com.deliverik.infogovernor.fin.model.condition.BudgetSearchCond;


/**
 * 预算登记画面FORM IGFIN0102Form ActionForm
 */
public class IGFIN0102Form extends BaseForm implements Budget,BudgetSearchCond{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Integer bid;

	protected String btype;

	protected String binittime;

	protected String bopentime;

	protected String bstatus;

	protected String breqid;

	protected String bapvid;

	protected String btitle;

	protected String bclosetime;

	protected String bdesc;

	protected String binfo;

	protected String byear;

	protected String borgid;

	protected String borgname;

	protected String breqname;

	protected String bapvname;

	protected Double bamount;
	
	protected String bamount_show;//用于修改时显示

	/** 原始预算值*/
	protected String firstbamount;

	protected String battkey;
	
	protected String bstatus_q;//查询用
	
	protected String pquality;//预算性质
	
	protected String puse;//预算用途
	
	protected String pstorecode;//储备预算编号
	
	protected String pneeddispart;//需求部门
	
	protected String pbuggetform;//预算组成
	
	protected String remark;//备注
	
	protected String btitle_q;
	
	protected String byear_q;
	
	protected String btype_q;
	
    protected String byear_before;//前年的年份
	
	protected String byear_now;//今年的年份
	
	/**执行修改后按钮显示标识*/
	protected String updateShow;
	
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
	
	/** 预算 资本金 开发 用于预算修改时效验*/
	protected String bzdevelop_check;
	
	/** 预算 资本金 硬件 用于预算修改时效验*/
	protected String bzhardware_check;
	
	/** 预算 资本金 软件 用于预算修改时效验*/
	protected String bzsoftware_check;
	
	/** 预算 资本金 工程 用于预算修改时效验*/
	protected String bzproject_check;
	
	/** 预算 资本金 其他 用于预算修改时效验*/
	protected String bzelse_check;
	
	/** 预算 成本金 实施 用于预算修改时效验*/
	protected String bcimplement_check;
	
	/** 预算 成本金 其他 用于预算修改时效验*/
	protected String bcelse_check;
	/** 预算id */
	protected String bids;
	
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

	public String getBamount_show() {
		return bamount_show;
	}

	public void setBamount_show(String bamount_show) {
		this.bamount_show = bamount_show;
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

	public String getBtype_q() {
		return btype_q;
	}

	public void setBtype_q(String btype_q) {
		this.btype_q = btype_q;
	}

	public String getPuse() {
		return puse;
	}

	public void setPuse(String puse) {
		this.puse = puse;
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

	public String getBstatus_q() {
		return bstatus_q;
	}

	public void setBstatus_q(String bstatus_q) {
		this.bstatus_q = bstatus_q;
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

	public String getPcode() {
		return null;
	}

	public Integer getPid() {
		return null;
	}

	public String getPname() {
		return null;
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
	 * 获取原始预算值
	 * @return ffirstbamount 原始预算值
	 */
	public String getFirstbamount() {
		return firstbamount;
	}

	/**
	 * 设置原始预算值
	 * @param firstbamount  原始预算值
	 */
	public void setFirstbamount(String firstbamount) {
		this.firstbamount = firstbamount;
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
	/**
	 * 执行修改后按钮显示标识取得
	 * @return 执行修改后按钮显示标识
	 */
	public String getUpdateShow() {
		return updateShow;
	}
	/**
	 * 执行修改后按钮显示标识设定
	 * @param updateShow 执行修改后按钮显示标识
	 */
	public void setUpdateShow(String updateShow) {
		this.updateShow = updateShow;
	}
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
	 * 获取预算资本金开发用于预算修改时效验
	 * @return fbzdevelop_check 预算资本金开发用于预算修改时效验
	 */
	public String getBzdevelop_check() {
		return bzdevelop_check;
	}
	/**
	 * 设置预算资本金开发用于预算修改时效验
	 * @param bzdevelop_check  预算资本金开发用于预算修改时效验
	 */
	public void setBzdevelop_check(String bzdevelop_check) {
		this.bzdevelop_check = bzdevelop_check;
	}
	/**
	 * 获取预算资本金硬件用于预算修改时效验
	 * @return fbzhardware_check 预算资本金硬件用于预算修改时效验
	 */
	public String getBzhardware_check() {
		return bzhardware_check;
	}
	/**
	 * 设置预算资本金硬件用于预算修改时效验
	 * @param bzhardware_check  预算资本金硬件用于预算修改时效验
	 */
	public void setBzhardware_check(String bzhardware_check) {
		this.bzhardware_check = bzhardware_check;
	}
	/**
	 * 获取预算资本金软件用于预算修改时效验
	 * @return fbzsoftware_check 预算资本金软件用于预算修改时效验
	 */
	public String getBzsoftware_check() {
		return bzsoftware_check;
	}
	/**
	 * 设置预算资本金软件用于预算修改时效验
	 * @param bzsoftware_check  预算资本金软件用于预算修改时效验
	 */
	public void setBzsoftware_check(String bzsoftware_check) {
		this.bzsoftware_check = bzsoftware_check;
	}
	/**
	 * 获取预算资本金工程用于预算修改时效验
	 * @return fbzproject_check 预算资本金工程用于预算修改时效验
	 */
	public String getBzproject_check() {
		return bzproject_check;
	}
	/**
	 * 设置预算资本金工程用于预算修改时效验
	 * @param bzproject_check  预算资本金工程用于预算修改时效验
	 */
	public void setBzproject_check(String bzproject_check) {
		this.bzproject_check = bzproject_check;
	}
	/**
	 * 获取预算资本金其他用于预算修改时效验
	 * @return fbzelse_check 预算资本金其他用于预算修改时效验
	 */
	public String getBzelse_check() {
		return bzelse_check;
	}
	/**
	 * 设置预算资本金其他用于预算修改时效验
	 * @param bzelse_check  预算资本金其他用于预算修改时效验
	 */
	public void setBzelse_check(String bzelse_check) {
		this.bzelse_check = bzelse_check;
	}
	/**
	 * 获取预算成本金实施用于预算修改时效验
	 * @return fbcimplement_check 预算成本金实施用于预算修改时效验
	 */
	public String getBcimplement_check() {
		return bcimplement_check;
	}
	/**
	 * 设置预算成本金实施用于预算修改时效验
	 * @param bcimplement_check  预算成本金实施用于预算修改时效验
	 */
	public void setBcimplement_check(String bcimplement_check) {
		this.bcimplement_check = bcimplement_check;
	}
	/**
	 * 获取预算成本金其他用于预算修改时效验
	 * @return fbcelse_check 预算成本金其他用于预算修改时效验
	 */
	public String getBcelse_check() {
		return bcelse_check;
	}
	/**
	 * 设置预算成本金其他用于预算修改时效验
	 * @param bcelse_check  预算成本金其他用于预算修改时效验
	 */
	public void setBcelse_check(String bcelse_check) {
		this.bcelse_check = bcelse_check;
	}
	/**
	 * 预算id取得
	 * @return bids 预算id
	 */
	public String getBids() {
		return bids;
	}
	/**
	 * 预算id设定
	 * @param bids 预算id
	 */
	public void setBids(String bids) {
		this.bids = bids;
	}

}
