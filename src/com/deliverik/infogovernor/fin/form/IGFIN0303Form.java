/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.fin.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.fin.model.condition.BudgetSearchCond;
import com.deliverik.infogovernor.fin.model.condition.ExpenseSearchCond;


@SuppressWarnings("serial")
public class IGFIN0303Form extends BaseForm implements BudgetSearchCond,ExpenseSearchCond
{
	protected String bopentime;
	
	protected String bclosetime;
	
	protected String btype;
	
	protected String searchtype;
	
	protected String flg;
	
	protected String exopentime;
	
	protected String exclosetime;
	
	protected String bstatus_q;//查询用
	
	protected String pquality;//预算性质
	
	protected String pstorecode;//储备预算编号
	
	protected String pneeddispart;//需求部门
	
	protected String pbuggetform;//预算组成
	
	protected String remark;//备注
	
	protected String btitle_q;
	
	protected String byear_q;
	
	protected String btype_q;
	
    protected String byear_before;//前年的年份
	
	protected String byear_now;//今年的年份
	
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

	public String getExopentime() {
		return exopentime;
	}

	public void setExopentime(String exopentime) {
		this.exopentime = exopentime;
	}

	public String getExclosetime() {
		return exclosetime;
	}

	public void setExclosetime(String exclosetime) {
		this.exclosetime = exclosetime;
	}

	public String getFlg() {
		return flg;
	}

	public void setFlg(String flg) {
		this.flg = flg;
	}

	public String getSearchtype() {
		return searchtype;
	}

	public void setSearchtype(String searchtype) {
		this.searchtype = searchtype;
	}

	public String getBtype() {
		return btype;
	}

	public void setBtype(String btype) {
		this.btype = btype;
	}


	public String getBopentime() {
		return bopentime;
	}

	public void setBopentime(String bopentime) {
		this.bopentime = bopentime;
	}

	public String getBclosetime() {
		return bclosetime;
	}

	public void setBclosetime(String bclosetime) {
		this.bclosetime = bclosetime;
	}

	public String getBinittime() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getBstatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getBtitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPcode() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSelectMode() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getBid() {
		// TODO Auto-generated method stub
		return null;
	}

	public Double getExamount() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getExapvname() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getExdesc() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getExstatus() {
		// TODO Auto-generated method stub
		return null;
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
