/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.form;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.condition.AttachmentSearchCond;
import com.deliverik.infogovernor.fin.model.Budget;
import com.deliverik.infogovernor.fin.model.Expense;
import com.deliverik.infogovernor.fin.model.condition.BudgetSearchCond;
import com.deliverik.infogovernor.fin.model.condition.ExpenseSearchCond;


/**
 * 费用查询画面FORM IGFIN0206Form ActionForm
 */
public class IGFIN0206Form extends BaseForm implements Expense,Attachment,Budget,BudgetSearchCond,ExpenseSearchCond,AttachmentSearchCond{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Integer exid;

	protected Integer bid;

	protected String exdesc;

	protected Double examount;
	
	protected String strExamount;

	protected String exinfo;

	protected String exstatus = "O";

	protected String exreqid;

	protected String exreqname;

	protected String exinittime;

	protected String exopentime;

	protected String exapvid;

	protected String exapvname;

	protected String exclosetime;

	protected String exattkey;

	protected String exeiinfo;

	protected String exprinfo;

	protected String expinfo;

	protected String exorginfo;
	
	protected Integer attid;

	protected String attkey;

	protected String attname;

	protected String attdesc;

	protected String atturl;
	
	protected String btitle;
	
	protected String route = "0";
	
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	protected String btype;

	protected String binittime;

	protected String bopentime;

	protected String bstatus = "O";

	protected String breqid;

	protected String bapvid;

	protected String bclosetime;

	protected String bdesc;

	protected String binfo;

	protected String byear;

	protected String borgid;

	protected String borgname;

	protected String breqname;

	protected String bapvname;

	protected Double bamount;

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

	public void setExamount(Double examount) {
		this.examount = examount;
	}

	public String getBstatus_q() {
		return bstatus_q;
	}

	public void setBstatus_q(String bstatus_q) {
		this.bstatus_q = bstatus_q;
	}

	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get( new Integer( index ) );
	}

	public void setAttachFile(int index, FormFile file) {
		fileMap.put( new Integer( index ), file );
	}

	public Integer getExid() {
		return exid;
	}

	public void setExid(Integer exid) {
		this.exid = exid;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getExdesc() {
		return exdesc;
	}

	public void setExdesc(String exdesc) {
		this.exdesc = exdesc;
	}
	
	public String getStrExamount() {
		return strExamount;
	}

	public void setStrExamount(String strExamount) {
		this.strExamount = strExamount;
	}

	public Double getExamount() {
		if(null == this.getStrExamount() || this.getStrExamount().trim().equals("")){
			return null;
		}
		return Double.valueOf(this.getStrExamount());
	}

//	public void setExamount(Float examount) {
//		this.examount = examount;
//	}

	public String getExinfo() {
		return exinfo;
	}

	public void setExinfo(String exinfo) {
		this.exinfo = exinfo;
	}

	public String getExstatus() {
		return exstatus;
	}

	public void setExstatus(String exstatus) {
		this.exstatus = exstatus;
	}

	public String getExreqid() {
		return exreqid;
	}

	public void setExreqid(String exreqid) {
		this.exreqid = exreqid;
	}

	public String getExreqname() {
		return exreqname;
	}

	public void setExreqname(String exreqname) {
		this.exreqname = exreqname;
	}

	public String getExinittime() {
		return exinittime;
	}

	public void setExinittime(String exinittime) {
		this.exinittime = exinittime;
	}

	public String getExopentime() {
		return exopentime;
	}

	public void setExopentime(String exopentime) {
		this.exopentime = exopentime;
	}

	public String getExapvid() {
		return exapvid;
	}

	public void setExapvid(String exapvid) {
		this.exapvid = exapvid;
	}

	public String getExapvname() {
		return exapvname;
	}

	public void setExapvname(String exapvname) {
		this.exapvname = exapvname;
	}

	public String getExclosetime() {
		return exclosetime;
	}

	public void setExclosetime(String exclosetime) {
		this.exclosetime = exclosetime;
	}

	public String getExattkey() {
		return exattkey;
	}

	public void setExattkey(String exattkey) {
		this.exattkey = exattkey;
	}

	public String getExeiinfo() {
		return exeiinfo;
	}

	public void setExeiinfo(String exeiinfo) {
		this.exeiinfo = exeiinfo;
	}

	public String getExprinfo() {
		return exprinfo;
	}

	public void setExprinfo(String exprinfo) {
		this.exprinfo = exprinfo;
	}

	public String getExpinfo() {
		return expinfo;
	}

	public void setExpinfo(String expinfo) {
		this.expinfo = expinfo;
	}

	public String getExorginfo() {
		return exorginfo;
	}

	public void setExorginfo(String exorginfo) {
		this.exorginfo = exorginfo;
	}

	public Integer getAttid() {
		return attid;
	}

	public void setAttid(Integer attid) {
		this.attid = attid;
	}

	public String getAttkey() {
		return attkey;
	}

	public void setAttkey(String attkey) {
		this.attkey = attkey;
	}

	public String getAttname() {
		return attname;
	}

	public void setAttname(String attname) {
		this.attname = attname;
	}

	public String getAttdesc() {
		return attdesc;
	}

	public void setAttdesc(String attdesc) {
		this.attdesc = attdesc;
	}

	public String getAtturl() {
		return atturl;
	}

	public void setAtturl(String atturl) {
		this.atturl = atturl;
	}

	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}

	public void setFileMap(Map<Integer, FormFile> fileMap) {
		this.fileMap = fileMap;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
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
	public Double getBzdevelop() {
		// TODO Auto-generated method stub
		return null;
	}
	public Double getBzhardware() {
		// TODO Auto-generated method stub
		return null;
	}
	public Double getBzsoftware() {
		// TODO Auto-generated method stub
		return null;
	}
	public Double getBzproject() {
		// TODO Auto-generated method stub
		return null;
	}
	public Double getBzelse() {
		// TODO Auto-generated method stub
		return null;
	}
	public Double getBcimplement() {
		// TODO Auto-generated method stub
		return null;
	}
	public Double getBcelse() {
		// TODO Auto-generated method stub
		return null;
	}

}
