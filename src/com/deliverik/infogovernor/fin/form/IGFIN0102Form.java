/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.fin.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.fin.model.Budget;
import com.deliverik.infogovernor.fin.model.condition.BudgetSearchCond;


/**
 * Ԥ��Ǽǻ���FORM IGFIN0102Form ActionForm
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
	
	protected String bamount_show;//�����޸�ʱ��ʾ

	/** ԭʼԤ��ֵ*/
	protected String firstbamount;

	protected String battkey;
	
	protected String bstatus_q;//��ѯ��
	
	protected String pquality;//Ԥ������
	
	protected String puse;//Ԥ����;
	
	protected String pstorecode;//����Ԥ����
	
	protected String pneeddispart;//������
	
	protected String pbuggetform;//Ԥ�����
	
	protected String remark;//��ע
	
	protected String btitle_q;
	
	protected String byear_q;
	
	protected String btype_q;
	
    protected String byear_before;//ǰ������
	
	protected String byear_now;//��������
	
	/**ִ���޸ĺ�ť��ʾ��ʶ*/
	protected String updateShow;
	
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
	
	/** Ԥ�� �ʱ��� ���� ����Ԥ���޸�ʱЧ��*/
	protected String bzdevelop_check;
	
	/** Ԥ�� �ʱ��� Ӳ�� ����Ԥ���޸�ʱЧ��*/
	protected String bzhardware_check;
	
	/** Ԥ�� �ʱ��� ��� ����Ԥ���޸�ʱЧ��*/
	protected String bzsoftware_check;
	
	/** Ԥ�� �ʱ��� ���� ����Ԥ���޸�ʱЧ��*/
	protected String bzproject_check;
	
	/** Ԥ�� �ʱ��� ���� ����Ԥ���޸�ʱЧ��*/
	protected String bzelse_check;
	
	/** Ԥ�� �ɱ��� ʵʩ ����Ԥ���޸�ʱЧ��*/
	protected String bcimplement_check;
	
	/** Ԥ�� �ɱ��� ���� ����Ԥ���޸�ʱЧ��*/
	protected String bcelse_check;
	/** Ԥ��id */
	protected String bids;
	
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
	 * ��ȡԭʼԤ��ֵ
	 * @return ffirstbamount ԭʼԤ��ֵ
	 */
	public String getFirstbamount() {
		return firstbamount;
	}

	/**
	 * ����ԭʼԤ��ֵ
	 * @param firstbamount  ԭʼԤ��ֵ
	 */
	public void setFirstbamount(String firstbamount) {
		this.firstbamount = firstbamount;
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
	/**
	 * ִ���޸ĺ�ť��ʾ��ʶȡ��
	 * @return ִ���޸ĺ�ť��ʾ��ʶ
	 */
	public String getUpdateShow() {
		return updateShow;
	}
	/**
	 * ִ���޸ĺ�ť��ʾ��ʶ�趨
	 * @param updateShow ִ���޸ĺ�ť��ʾ��ʶ
	 */
	public void setUpdateShow(String updateShow) {
		this.updateShow = updateShow;
	}
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
	 * ��ȡԤ���ʱ��𿪷�����Ԥ���޸�ʱЧ��
	 * @return fbzdevelop_check Ԥ���ʱ��𿪷�����Ԥ���޸�ʱЧ��
	 */
	public String getBzdevelop_check() {
		return bzdevelop_check;
	}
	/**
	 * ����Ԥ���ʱ��𿪷�����Ԥ���޸�ʱЧ��
	 * @param bzdevelop_check  Ԥ���ʱ��𿪷�����Ԥ���޸�ʱЧ��
	 */
	public void setBzdevelop_check(String bzdevelop_check) {
		this.bzdevelop_check = bzdevelop_check;
	}
	/**
	 * ��ȡԤ���ʱ���Ӳ������Ԥ���޸�ʱЧ��
	 * @return fbzhardware_check Ԥ���ʱ���Ӳ������Ԥ���޸�ʱЧ��
	 */
	public String getBzhardware_check() {
		return bzhardware_check;
	}
	/**
	 * ����Ԥ���ʱ���Ӳ������Ԥ���޸�ʱЧ��
	 * @param bzhardware_check  Ԥ���ʱ���Ӳ������Ԥ���޸�ʱЧ��
	 */
	public void setBzhardware_check(String bzhardware_check) {
		this.bzhardware_check = bzhardware_check;
	}
	/**
	 * ��ȡԤ���ʱ����������Ԥ���޸�ʱЧ��
	 * @return fbzsoftware_check Ԥ���ʱ����������Ԥ���޸�ʱЧ��
	 */
	public String getBzsoftware_check() {
		return bzsoftware_check;
	}
	/**
	 * ����Ԥ���ʱ����������Ԥ���޸�ʱЧ��
	 * @param bzsoftware_check  Ԥ���ʱ����������Ԥ���޸�ʱЧ��
	 */
	public void setBzsoftware_check(String bzsoftware_check) {
		this.bzsoftware_check = bzsoftware_check;
	}
	/**
	 * ��ȡԤ���ʱ��𹤳�����Ԥ���޸�ʱЧ��
	 * @return fbzproject_check Ԥ���ʱ��𹤳�����Ԥ���޸�ʱЧ��
	 */
	public String getBzproject_check() {
		return bzproject_check;
	}
	/**
	 * ����Ԥ���ʱ��𹤳�����Ԥ���޸�ʱЧ��
	 * @param bzproject_check  Ԥ���ʱ��𹤳�����Ԥ���޸�ʱЧ��
	 */
	public void setBzproject_check(String bzproject_check) {
		this.bzproject_check = bzproject_check;
	}
	/**
	 * ��ȡԤ���ʱ�����������Ԥ���޸�ʱЧ��
	 * @return fbzelse_check Ԥ���ʱ�����������Ԥ���޸�ʱЧ��
	 */
	public String getBzelse_check() {
		return bzelse_check;
	}
	/**
	 * ����Ԥ���ʱ�����������Ԥ���޸�ʱЧ��
	 * @param bzelse_check  Ԥ���ʱ�����������Ԥ���޸�ʱЧ��
	 */
	public void setBzelse_check(String bzelse_check) {
		this.bzelse_check = bzelse_check;
	}
	/**
	 * ��ȡԤ��ɱ���ʵʩ����Ԥ���޸�ʱЧ��
	 * @return fbcimplement_check Ԥ��ɱ���ʵʩ����Ԥ���޸�ʱЧ��
	 */
	public String getBcimplement_check() {
		return bcimplement_check;
	}
	/**
	 * ����Ԥ��ɱ���ʵʩ����Ԥ���޸�ʱЧ��
	 * @param bcimplement_check  Ԥ��ɱ���ʵʩ����Ԥ���޸�ʱЧ��
	 */
	public void setBcimplement_check(String bcimplement_check) {
		this.bcimplement_check = bcimplement_check;
	}
	/**
	 * ��ȡԤ��ɱ�����������Ԥ���޸�ʱЧ��
	 * @return fbcelse_check Ԥ��ɱ�����������Ԥ���޸�ʱЧ��
	 */
	public String getBcelse_check() {
		return bcelse_check;
	}
	/**
	 * ����Ԥ��ɱ�����������Ԥ���޸�ʱЧ��
	 * @param bcelse_check  Ԥ��ɱ�����������Ԥ���޸�ʱЧ��
	 */
	public void setBcelse_check(String bcelse_check) {
		this.bcelse_check = bcelse_check;
	}
	/**
	 * Ԥ��idȡ��
	 * @return bids Ԥ��id
	 */
	public String getBids() {
		return bids;
	}
	/**
	 * Ԥ��id�趨
	 * @param bids Ԥ��id
	 */
	public void setBids(String bids) {
		this.bids = bids;
	}

}
