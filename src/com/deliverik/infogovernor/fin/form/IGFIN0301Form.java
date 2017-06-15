/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.fin.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.fin.model.condition.BudgetSearchCond;
import com.deliverik.infogovernor.fin.model.condition.ExpenseSearchCond;


/**
 * Ԥ��Ǽǻ���FORM IGFIN0101Form ActionForm
 */
public class IGFIN0301Form extends BaseForm implements BudgetSearchCond,ExpenseSearchCond {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String finxml;//ͼ����ʾ��Ϣxml

	

	protected Integer bid;

	protected String btype;

	protected String binittime;

	protected String bopentime;

	protected String bstatus = "O";

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

	protected Float bamount;//Ԥ����
	
	protected Double examount;//���ý��

	protected String battkey;
	
	protected String route = "0";
	
	protected String pcode;
	
	protected Integer pid;
	
	protected String pname;
	
	private String year;//ͼ�β�ѯ���
	
	private String selectMode;//ͼ����ʾ״̬�жϲ�ѯ������
	
	private String showType;//ʵ�ʽ����ʾ��ʽ   SΪ�ֶ���ʾ   TΪ������ʾ
	
	protected String bstatus_q;//��ѯ��
	
	protected String pquality;//Ԥ������
	
	protected String pstorecode;//����Ԥ����
	
	protected String pneeddispart;//������
	
	protected String pbuggetform;//Ԥ�����
	
	protected String remark;//��ע
	
	protected String btitle_q;
	
	protected String byear_q;
	
	protected String btype_q;
	
    protected String byear_before;//ǰ������
	
	protected String byear_now;//��������
	
	/**
	 * ǰ�������趨
	 * 
	 * @param byear_before
	 */
	public void setByear_before(String byear_before) {
		this.byear_before = byear_before;
	}
	/**
	 * ���������趨
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

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public String getFinxml() {
		return finxml;
	}

	public void setFinxml(String finxml) {
		this.finxml = finxml;
	}
	
	public Double getExamount() {
		return examount;
	}

	public void setExamount(Double examount) {
		this.examount = examount;
	}

	public String getSelectMode() {
		return selectMode;
	}

	public void setSelectMode(String selectMode) {
		this.selectMode = selectMode;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
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

	public Float getBamount() {
		return bamount;
	}

	public void setBamount(Float bamount) {
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
	
	//ExpenseSearch
	
	protected String exdesc;//

	protected String exstatus = "O";//

	protected String exopentime;//

	protected String exclosetime;//
	
	public String getExdesc() {
		return exdesc;
	}

	public void setExdesc(String exdesc) {
		this.exdesc = exdesc;
	}

	public String getExstatus() {
		return exstatus;
	}

	public void setExstatus(String exstatus) {
		this.exstatus = exstatus;
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

	public String getExapvname() {
		return null;
	}

	/**
	 * ǰ������ȡ��
	 * 
	 * @return byear_before
	 */
	public String getByear_before() {
		return byear_before;
	}

	/**
	 * ��������ȡ��
	 * 
	 * @return byear_now
	 */
	public String getByear_now() {
		return byear_now;
	}
}
