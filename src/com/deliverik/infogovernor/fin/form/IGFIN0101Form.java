/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.fin.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.fin.model.Budget;
import com.deliverik.infogovernor.fin.model.condition.BudgetSearchCond;


/**
 * Ԥ��Ǽǻ���FORM IGFIN0101Form ActionForm
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
	
	protected String bstatus_q;//��ѯ��
	
	protected String pquality;//Ԥ������
	
	protected String puse;//Ԥ����;
	
	protected String pstorecode;//����Ԥ����
	
	protected String pneeddispart;//������
	
	protected String pbuggetform;//Ԥ�����
	
	protected String remark;//��ע

	protected String byear_before;//ǰ������
	
	protected String byear_now;//��������
	
	/** Ԥ�� �ʱ��� ����*/
	protected Double bzdevelop;
	
	/** Ԥ�� �ʱ��� Ӳ��*/
	protected Double bzhardware;
	
	/** Ԥ�� �ʱ��� ���*/
	protected Double bzsoftware;
	
	/** Ԥ�� �ʱ��� ����*/
	protected Double bzproject;
	
	/** Ԥ�� �ʱ��� ����*/
	protected Double bzelse;
	
	/** Ԥ�� �ɱ��� ʵʩ*/
	protected Double bcimplement;
	
	/** Ԥ�� �ɱ��� ����*/
	protected Double bcelse;
	
	/**
	 * ��ȡԤ���ʱ��𿪷�
	 * @return fbzdevelop Ԥ���ʱ��𿪷�
	 */
	public Double getBzdevelop() {
		return bzdevelop;
	}
	/**
	 * ����Ԥ���ʱ��𿪷�
	 * @param bzdevelop  Ԥ���ʱ��𿪷�
	 */
	public void setBzdevelop(Double bzdevelop) {
		this.bzdevelop = bzdevelop;
	}
	/**
	 * ��ȡԤ���ʱ���Ӳ��
	 * @return fbzhardware Ԥ���ʱ���Ӳ��
	 */
	public Double getBzhardware() {
		return bzhardware;
	}
	/**
	 * ����Ԥ���ʱ���Ӳ��
	 * @param bzhardware  Ԥ���ʱ���Ӳ��
	 */
	public void setBzhardware(Double bzhardware) {
		this.bzhardware = bzhardware;
	}
	/**
	 * ��ȡԤ���ʱ������
	 * @return fbzsoftware Ԥ���ʱ������
	 */
	public Double getBzsoftware() {
		return bzsoftware;
	}
	/**
	 * ����Ԥ���ʱ������
	 * @param bzsoftware  Ԥ���ʱ������
	 */
	public void setBzsoftware(Double bzsoftware) {
		this.bzsoftware = bzsoftware;
	}
	/**
	 * ��ȡԤ���ʱ��𹤳�
	 * @return fbzproject Ԥ���ʱ��𹤳�
	 */
	public Double getBzproject() {
		return bzproject;
	}
	/**
	 * ����Ԥ���ʱ��𹤳�
	 * @param bzproject  Ԥ���ʱ��𹤳�
	 */
	public void setBzproject(Double bzproject) {
		this.bzproject = bzproject;
	}
	/**
	 * ��ȡԤ���ʱ�������
	 * @return fbzelse Ԥ���ʱ�������
	 */
	public Double getBzelse() {
		return bzelse;
	}
	/**
	 * ����Ԥ���ʱ�������
	 * @param bzelse  Ԥ���ʱ�������
	 */
	public void setBzelse(Double bzelse) {
		this.bzelse = bzelse;
	}
	/**
	 * ��ȡԤ��ɱ���ʵʩ
	 * @return fbcimplement Ԥ��ɱ���ʵʩ
	 */
	public Double getBcimplement() {
		return bcimplement;
	}
	/**
	 * ����Ԥ��ɱ���ʵʩ
	 * @param bcimplement  Ԥ��ɱ���ʵʩ
	 */
	public void setBcimplement(Double bcimplement) {
		this.bcimplement = bcimplement;
	}
	/**
	 * ��ȡԤ��ɱ�������
	 * @return fbcelse Ԥ��ɱ�������
	 */
	public Double getBcelse() {
		return bcelse;
	}
	/**
	 * ����Ԥ��ɱ�������
	 * @param bcelse  Ԥ��ɱ�������
	 */
	public void setBcelse(Double bcelse) {
		this.bcelse = bcelse;
	}
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
