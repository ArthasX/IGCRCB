/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.prj.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.prj.model.ProjectLog;

public class IGPRJ0102Form extends BaseForm implements ProjectLog {
	
	private static final long serialVersionUID = 1L;

	/** ��ĿID*/
	protected Integer pid;

	/** ��Ŀ���� */
	protected String ptype;
	protected String ptype_name;
	
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
	
	/** ��Ŀ״̬ */
	protected String pstatus;
	
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

	/** Ԥ����*/
	protected String pamount;
	
	/** ʹ��Ԥ��*/
	protected String isUseBudget;
	
	/** ��ĿĿ��*/
	protected String paim;
	protected String pinfo;
	protected String prole;
	protected String porg;
	protected String puser;
	
	protected Integer plroleid;
	protected String plrolename;
	protected String pluserid;
	protected String plusername;
	protected String plinfo;
	protected String pltype;
	protected String plattkey;
	protected String pltime;
	
	/** Ԥ������ */
	protected Integer[] bid;
	
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
	
	/** �ƻ�����ʱ�� */
	protected String pplanclosetime;
	
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
	
	/** ��ͬ��� */
	protected Integer plcid;
	
	/** ��Ŀ���� */
	protected String ppquality ;
	
	public void setPinfo(String pinfo) {
		this.pinfo = pinfo;
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

	public String getPtype_name() {
		return ptype_name;
	}

	public void setPtype_name(String ptype_name) {
		this.ptype_name = ptype_name;
	}

	public void setPopentime(String popentime) {
		this.popentime = popentime;
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

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
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

	public String getPstatus() {
		return pstatus;
	}

	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}

	public String getProle() {
		return prole;
	}

	public void setProle(String prole) {
		this.prole = prole;
	}

	public String getPorg() {
		return porg;
	}

	public void setPorg(String porg) {
		this.porg = porg;
	}

	public String getPuser() {
		return puser;
	}

	public void setPuser(String puser) {
		this.puser = puser;
	}
	
	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public Integer getPlroleid() {
		return plroleid;
	}

	/**
	 * ��ͬ���ȡ��
	 * @return plcid ��ͬ���
	 */
	public Integer getPlcid() {
		return plcid;
	}

	/**
	 * ��ͬ����趨
	 * @param plcid ��ͬ���
	 */
	public void setPlcid(Integer plcid) {
		this.plcid = plcid;
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

	public void setPlroleid(Integer plroleid) {
		this.plroleid = plroleid;
	}

	public String getPlrolename() {
		return plrolename;
	}

	public void setPlrolename(String plrolename) {
		this.plrolename = plrolename;
	}

	public String getPluserid() {
		return pluserid;
	}

	public void setPluserid(String pluserid) {
		this.pluserid = pluserid;
	}

	public String getPlusername() {
		return plusername;
	}

	public void setPlusername(String plusername) {
		this.plusername = plusername;
	}

	public String getPlinfo() {
		return plinfo;
	}

	public void setPlinfo(String plinfo) {
		this.plinfo = plinfo;
	}

	public String getPltype() {
		return pltype;
	}

	public void setPltype(String pltype) {
		this.pltype = pltype;
	}

	public String getPlattkey() {
		return plattkey;
	}

	public void setPlattkey(String plattkey) {
		this.plattkey = plattkey;
	}

	public String getPopentime() {
		return popentime;
	}

	public String getPclosetime() {
		return pclosetime;
	}

	public String getPinfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPlid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPltime() {
		return pltime;
	}

	public void setPltime(String pltime) {
		this.pltime = pltime;
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
}
