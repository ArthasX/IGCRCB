/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.prj.form;

import com.deliverik.framework.base.BaseForm;

@SuppressWarnings("serial")
public class IGPRJ0109Form extends BaseForm {

	/** ��ĿID*/
	protected Integer pid;
	
	/** ��Ŀ��� */
	protected String pcode;
	
	/** ��Ŀ���� */
	protected String pname;

	/** ��Ŀ���� */
	protected String pdesc;
	
	/** ��Ŀ����ʱ�� */
	protected String popentime;
	
	/** ��Ŀ�ر�ʱ�� */
	protected String pclosetime;
	
	/** ��ĿԤ�㣬��ӦԤ����е�Ԥ������*/
	protected String pamount;
	
	/** ��Ŀ��;*/
	protected String ppurpose;
	
	/** ��ĿԤ����;*/
	protected String puse;
	
	/** ��ĿԤ����*/
	protected Double plimit;
	
	/** ������*/
	protected String pbranch;
	
	/** Ԥ������ID*/
	protected Integer pbid;
	
	/** Ԥ������Ԥ������*/
	protected String pbname;
	
	/** ʹ��Ԥ��*/
	protected String isUseBudget;
	
	/** ��ĿĿ��*/
	protected String paim;

	/** ��Ŀ����Ԥ���ʣ����*/
	protected Double bamount_show;
	
	/** �ƻ�����ʱ�� */
	protected String pplanclosetime;
	
	/** ��Ŀ���� */
	protected String ppquality;
	
	/** ��Ŀ��� */
	protected String ptype;
	
	/** Ԥ�� �ʱ��� ����*/
	protected Double[] bzdevelop;
	
	/** Ԥ�� �ʱ��� Ӳ��*/
	protected Double[] bzhardware;
	
	/** Ԥ�� �ʱ��� ���*/
	protected Double[] bzsoftware;
	
	/** Ԥ�� �ʱ��� ����*/
	protected Double[] bzproject;
	
	/** Ԥ�� �ʱ��� ����*/
	protected Double[] bzelse;
	
	/** Ԥ�� �ɱ��� ʵʩ*/
	protected Double[] bcimplement;
	
	/** Ԥ�� �ɱ��� ����*/
	protected Double[] bcelse;
	
	/** ��Ŀ �ʱ��� ����*/
	protected Double pbzdevelop;
	
	/** ��Ŀ �ʱ��� Ӳ��*/
	protected Double pbzhardware;
	
	/** ��Ŀ �ʱ��� ���*/
	protected Double pbzsoftware;
	
	/** ��Ŀ �ʱ��� ����*/
	protected Double pbzproject;
	
	/** ��Ŀ �ʱ��� ����*/
	protected Double pbzelse;
	
	/** ��Ŀ �ɱ��� ʵʩ*/
	protected Double pbcimplement;
	
	/** ��Ŀ �ɱ��� ����*/
	protected Double pbcelse;
	
	/** Ԥ������ */
	protected Integer[] bid;
	
	/** ��ʶ�Ƿ���ں�ͬ */
	protected String hasPc;
	
	public void setPopentime(String popentime) {
		this.popentime = popentime;
	}

	/**
	 * �ƻ�����ʱ��ȡ��
	 * @return pplanclosetime �ƻ�����ʱ��
	 */
	public String getPplanclosetime() {
		return pplanclosetime;
	}

	/**
	 * �ƻ�����ʱ���趨
	 * @param pplanclosetime �ƻ�����ʱ��
	 */
	public void setPplanclosetime(String pplanclosetime) {
		this.pplanclosetime = pplanclosetime;
	}

	public void setPclosetime(String pclosetime) {
		this.pclosetime = pclosetime;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}


	public String getPopentime() {
		return popentime;
	}

	public String getPclosetime() {
		return pclosetime;
	}

	public String getPamount() {
		return pamount;
	}

	public void setPamount(String pamount) {
		this.pamount = pamount;
	}

	public String getPuse() {
		return puse;
	}

	public void setPuse(String puse) {
		this.puse = puse;
	}

	public Double getPlimit() {
		return plimit;
	}

	public void setPlimit(Double plimit) {
		this.plimit = plimit;
	}

	public String getPbranch() {
		return pbranch;
	}

	public void setPbranch(String pbranch) {
		this.pbranch = pbranch;
	}

	public Integer getPbid() {
		return pbid;
	}

	public void setPbid(Integer pbid) {
		this.pbid = pbid;
	}

	public String getPaim() {
		return paim;
	}

	public void setPaim(String paim) {
		this.paim = paim;
	}

	/**
	 * ��ȡԤ������Ԥ������
	 * @return fpbname Ԥ������Ԥ������
	 */
	public String getPbname() {
		return pbname;
	}

	/**
	 * ����Ԥ������Ԥ������
	 * @param pbname  Ԥ������Ԥ������
	 */
	public void setPbname(String pbname) {
		this.pbname = pbname;
	}

	/**
	 * ��ȡ��Ŀ��;
	 * @return fppurpose ��Ŀ��;
	 */
	public String getPpurpose() {
		return ppurpose;
	}

	/**
	 * ������Ŀ��;
	 * @param ppurpose  ��Ŀ��;
	 */
	public void setPpurpose(String ppurpose) {
		this.ppurpose = ppurpose;
	}

	/**
	 * ��ȡ��Ŀ����Ԥ���ʣ����
	 * @return fbamount_show ��Ŀ����Ԥ���ʣ����
	 */
	public Double getBamount_show() {
		return bamount_show;
	}

	/**
	 * ������Ŀ����Ԥ���ʣ����
	 * @param bamount_show  ��Ŀ����Ԥ���ʣ����
	 */
	public void setBamount_show(Double bamount_show) {
		this.bamount_show = bamount_show;
	}

	/**
	 * ��ȡʹ��Ԥ��
	 * @return fisUseBudget ʹ��Ԥ��
	 */
	public String getIsUseBudget() {
		return isUseBudget;
	}

	/**
	 * ����ʹ��Ԥ��
	 * @param isUseBudget  ʹ��Ԥ��
	 */
	public void setIsUseBudget(String isUseBudget) {
		this.isUseBudget = isUseBudget;
	}

	/**
	 * ��Ŀ����ȡ��
	 * @return ppquality ��Ŀ����
	 */
	public String getPpquality() {
		return ppquality;
	}

	/**
	 * ��Ŀ�����趨
	 * @param ppquality ��Ŀ����
	 */
	public void setPpquality(String ppquality) {
		this.ppquality = ppquality;
	}

	/**
	 * ��Ŀ���ȡ��
	 * @return ptype ��Ŀ���
	 */
	public String getPtype() {
		return ptype;
	}

	/**
	 * ��Ŀ����趨
	 * @param ptype ��Ŀ���
	 */
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	/**
	 * Ԥ���ʱ��𿪷�ȡ��
	 * @return bzdevelop Ԥ���ʱ��𿪷�
	 */
	public Double[] getBzdevelop() {
		return bzdevelop;
	}

	/**
	 * Ԥ���ʱ��𿪷��趨
	 * @param bzdevelop Ԥ���ʱ��𿪷�
	 */
	public void setBzdevelop(Double[] bzdevelop) {
		this.bzdevelop = bzdevelop;
	}

	/**
	 * Ԥ���ʱ���Ӳ��ȡ��
	 * @return bzhardware Ԥ���ʱ���Ӳ��
	 */
	public Double[] getBzhardware() {
		return bzhardware;
	}

	/**
	 * Ԥ���ʱ���Ӳ���趨
	 * @param bzhardware Ԥ���ʱ���Ӳ��
	 */
	public void setBzhardware(Double[] bzhardware) {
		this.bzhardware = bzhardware;
	}

	/**
	 * Ԥ���ʱ������ȡ��
	 * @return bzsoftware Ԥ���ʱ������
	 */
	public Double[] getBzsoftware() {
		return bzsoftware;
	}

	/**
	 * Ԥ���ʱ�������趨
	 * @param bzsoftware Ԥ���ʱ������
	 */
	public void setBzsoftware(Double[] bzsoftware) {
		this.bzsoftware = bzsoftware;
	}

	/**
	 * Ԥ���ʱ��𹤳�ȡ��
	 * @return bzproject Ԥ���ʱ��𹤳�
	 */
	public Double[] getBzproject() {
		return bzproject;
	}

	/**
	 * Ԥ���ʱ��𹤳��趨
	 * @param bzproject Ԥ���ʱ��𹤳�
	 */
	public void setBzproject(Double[] bzproject) {
		this.bzproject = bzproject;
	}

	/**
	 * Ԥ���ʱ�������ȡ��
	 * @return bzelse Ԥ���ʱ�������
	 */
	public Double[] getBzelse() {
		return bzelse;
	}

	/**
	 * Ԥ���ʱ��������趨
	 * @param bzelse Ԥ���ʱ�������
	 */
	public void setBzelse(Double[] bzelse) {
		this.bzelse = bzelse;
	}

	/**
	 * Ԥ��ɱ���ʵʩȡ��
	 * @return bcimplement Ԥ��ɱ���ʵʩ
	 */
	public Double[] getBcimplement() {
		return bcimplement;
	}

	/**
	 * Ԥ��ɱ���ʵʩ�趨
	 * @param bcimplement Ԥ��ɱ���ʵʩ
	 */
	public void setBcimplement(Double[] bcimplement) {
		this.bcimplement = bcimplement;
	}

	/**
	 * Ԥ��ɱ�������ȡ��
	 * @return bcelse Ԥ��ɱ�������
	 */
	public Double[] getBcelse() {
		return bcelse;
	}

	/**
	 * Ԥ��ɱ��������趨
	 * @param bcelse Ԥ��ɱ�������
	 */
	public void setBcelse(Double[] bcelse) {
		this.bcelse = bcelse;
	}

	/**
	 * ��Ŀ�ʱ��𿪷�ȡ��
	 * @return pbzdevelop ��Ŀ�ʱ��𿪷�
	 */
	public Double getPbzdevelop() {
		return pbzdevelop;
	}

	/**
	 * ��Ŀ�ʱ��𿪷��趨
	 * @param pbzdevelop ��Ŀ�ʱ��𿪷�
	 */
	public void setPbzdevelop(Double pbzdevelop) {
		this.pbzdevelop = pbzdevelop;
	}

	/**
	 * ��Ŀ�ʱ���Ӳ��ȡ��
	 * @return pbzhardware ��Ŀ�ʱ���Ӳ��
	 */
	public Double getPbzhardware() {
		return pbzhardware;
	}

	/**
	 * ��Ŀ�ʱ���Ӳ���趨
	 * @param pbzhardware ��Ŀ�ʱ���Ӳ��
	 */
	public void setPbzhardware(Double pbzhardware) {
		this.pbzhardware = pbzhardware;
	}

	/**
	 * ��Ŀ�ʱ������ȡ��
	 * @return pbzsoftware ��Ŀ�ʱ������
	 */
	public Double getPbzsoftware() {
		return pbzsoftware;
	}

	/**
	 * ��Ŀ�ʱ�������趨
	 * @param pbzsoftware ��Ŀ�ʱ������
	 */
	public void setPbzsoftware(Double pbzsoftware) {
		this.pbzsoftware = pbzsoftware;
	}

	/**
	 * ��Ŀ�ʱ��𹤳�ȡ��
	 * @return pbzproject ��Ŀ�ʱ��𹤳�
	 */
	public Double getPbzproject() {
		return pbzproject;
	}

	/**
	 * ��Ŀ�ʱ��𹤳��趨
	 * @param pbzproject ��Ŀ�ʱ��𹤳�
	 */
	public void setPbzproject(Double pbzproject) {
		this.pbzproject = pbzproject;
	}

	/**
	 * ��Ŀ�ʱ�������ȡ��
	 * @return pbzelse ��Ŀ�ʱ�������
	 */
	public Double getPbzelse() {
		return pbzelse;
	}

	/**
	 * ��Ŀ�ʱ��������趨
	 * @param pbzelse ��Ŀ�ʱ�������
	 */
	public void setPbzelse(Double pbzelse) {
		this.pbzelse = pbzelse;
	}

	/**
	 * ��Ŀ�ɱ���ʵʩȡ��
	 * @return pbcimplement ��Ŀ�ɱ���ʵʩ
	 */
	public Double getPbcimplement() {
		return pbcimplement;
	}

	/**
	 * ��Ŀ�ɱ���ʵʩ�趨
	 * @param pbcimplement ��Ŀ�ɱ���ʵʩ
	 */
	public void setPbcimplement(Double pbcimplement) {
		this.pbcimplement = pbcimplement;
	}

	/**
	 * ��Ŀ�ɱ�������ȡ��
	 * @return pbcelse ��Ŀ�ɱ�������
	 */
	public Double getPbcelse() {
		return pbcelse;
	}

	/**
	 * ��Ŀ�ɱ��������趨
	 * @param pbcelse ��Ŀ�ɱ�������
	 */
	public void setPbcelse(Double pbcelse) {
		this.pbcelse = pbcelse;
	}

	/**
	 * Ԥ������ȡ��
	 * @return bid Ԥ������
	 */
	public Integer[] getBid() {
		return bid;
	}

	/**
	 * Ԥ�������趨
	 * @param bid Ԥ������
	 */
	public void setBid(Integer[] bid) {
		this.bid = bid;
	}

	/**
	 * ��ʶ�Ƿ���ں�ͬȡ��
	 * @return hasPc ��ʶ�Ƿ���ں�ͬ
	 */
	public String getHasPc() {
		return hasPc;
	}

	/**
	 * ��ʶ�Ƿ���ں�ͬ�趨
	 * @param hasPc ��ʶ�Ƿ���ں�ͬ
	 */
	public void setHasPc(String hasPc) {
		this.hasPc = hasPc;
	}


}
