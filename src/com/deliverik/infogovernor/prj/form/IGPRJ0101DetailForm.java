/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.prj.form;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.fin.model.entity.BudgetTB;
import com.deliverik.infogovernor.prj.model.Project;
import com.deliverik.infogovernor.prj.model.ProjectLog;
import com.deliverik.infogovernor.prj.model.condition.ProjectLogSearchCond;

public class IGPRJ0101DetailForm extends BaseForm implements Project,ProjectLog ,ProjectLogSearchCond{
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

	private static final long serialVersionUID = 1L;
	/** �������� */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	/** projectId */
	protected Integer pid;//FK
	
	/** projectLogId */
	protected Integer plid;//ID
	
	/** projectLog Info */
	protected String plinfo;
	
	/** ������Key */
	protected String siattkey;
	
	protected String ptype;
	protected String pcode;
	protected String pname;
	protected String pdesc;
	protected String pstatus;
	protected String popentime;
	protected String pclosetime;
	protected String userId;
	protected String plusername;
	protected String pltime;
	/**��־ʱ�����ڲ鿴��ʷҳ���ģ����ѯ*/
	protected String pltime_from;
	/**��־ʱ�����ڲ鿴��ʷҳ���ģ����ѯ*/
	protected String pltime_to;
	/**projectLog type*/
	protected String pltype;
	protected String porg;
	protected String prole;
	protected String puser;
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
	
	/** ʹ��Ԥ��*/
	protected String isUseBudget;
	
	/** ��ĿĿ��*/
	protected String paim;
	
	//��Ŀ��־��ͬ��
	/**��ͬ���*/
	protected String plcsum;
	/**��ͬ��������*/
	protected String plcsumterm;
	/**һ�ڸ�����*/
	protected String plcfirst;
	/**һ�ڸ�������*/
	protected String plcfirstterm;
	/**���ڸ�����*/
	protected String plcsecond;
	/**���ڸ�������*/
	protected String plcsecondterm;
	/**���ڸ�����*/
	protected String plcthird;
	/**���ڸ�������*/
	protected String plcthirdterm;
	/**���ڸ�����*/
	protected String plcfourth;
	/**���ڸ�������*/
	protected String plcfourthterm;
	/**���ڸ�����*/
	protected String plcfifth;
	/**���ڸ�������*/
	protected String plcfifthterm;
	/**��Ӧ��Ŀ��־id*/
	protected Integer plcplid;
	//��Ŀ��־�����
	/**��ͬ�ܶ�*/
	protected String plbplcsum;
	/**һ�ڸ�����*/
	protected String plbfirst;
	/**���ڸ�����*/
	protected String plbsecond;
	/**���ڸ�����*/
	protected String plbthird;
	/**���ڸ�����*/
	protected String plbfourth;
	/**���ڸ�����*/
	protected String plbfifth;
	/**��Ӧ��Ŀid*/
	protected Integer plbplid;
	/**�Ѹ����ܶ�*/
	protected String plbsum;
	/**�Ѹ������*/
	protected String plbscale;
	/**δ�����ܶ�*/
	protected String plbnotsum;
	/**δ�������*/
	protected String plbnotscale;
	/** ��ͬ���*/
	protected String plcnumber;
	/**���ذ�ť·��*/
	protected String backurl;
	/**��Ŀ�ƻ�ʱ��*/
	protected String pplanclosetime;
	
	/** �ʱ��𿪷�����Ԥ��ʹ�ö�*/
	protected String[] use1;

	/** �ʱ���Ӳ������Ԥ��ʹ�ö�*/
	protected String[] use2;

	/** �ʱ����������Ԥ��ʹ�ö�*/
	protected String[] use3;
	
	/** �ʱ��𹤳̵���Ԥ��ʹ�ö�*/
	protected String[] use4;
	
	/** �ʱ�����������Ԥ��ʹ�ö�*/
	protected String[] use5;

	/** �ɱ���ʵʩ����Ԥ��ʹ�ö�*/
	protected String[] use6;
	
	/** �ɱ�����������Ԥ��ʹ�ö�*/
	protected String[] use7;
	

	/** �ʱ��𿪷�����Ԥ��ʣ���*/
	protected String[] sub1;

	/** �ʱ���Ӳ������Ԥ��ʣ���*/
	protected String[] sub2;

	/** �ʱ����������Ԥ��ʣ���*/
	protected String[] sub3;
	
	/** �ʱ��𹤳̵���Ԥ��ʣ���*/
	protected String[] sub4;
	
	/** �ʱ�����������Ԥ��ʣ���*/
	protected String[] sub5;

	/** �ɱ���ʵʩ����Ԥ��ʣ���*/
	protected String[] sub6;
	
	/** �ɱ�����������Ԥ��ʣ���*/
	protected String[] sub7;
	
	/** Ԥ����*/
	protected String[] btitle;
	
	/**Ԥ�㼰���̷�����Ϣ��ͼ���ݼ�������*/
	protected int pbsummaryListSize;
	
	
	/**
	 * Ԥ�㼰���̷�����Ϣ��ͼ���ݼ�������ȡ��
	 * @return Ԥ�㼰���̷�����Ϣ��ͼ���ݼ�������
	 */
	public int getPbsummaryListSize() {
		return pbsummaryListSize;
	}

	/**
	 * Ԥ�㼰���̷�����Ϣ��ͼ���ݼ��������趨
	 * @param pbsummaryListSize Ԥ�㼰���̷�����Ϣ��ͼ���ݼ�������
	 */
	public void setPbsummaryListSize(int pbsummaryListSize) {
		this.pbsummaryListSize = pbsummaryListSize;
	}

	/** Ԥ����Ŀ��ϵ��ID*/
	protected Integer[] pbrid;
	
	public String getPlcsum() {
		return plcsum;
	}

	public void setPlcsum(String plcsum) {
		this.plcsum = plcsum;
	}

	public String getPlcsumterm() {
		return plcsumterm;
	}

	public void setPlcsumterm(String plcsumterm) {
		this.plcsumterm = plcsumterm;
	}

	public String getPlcfirst() {
		return plcfirst;
	}

	public void setPlcfirst(String plcfirst) {
		this.plcfirst = plcfirst;
	}

	public String getPlcfirstterm() {
		return plcfirstterm;
	}

	public void setPlcfirstterm(String plcfirstterm) {
		this.plcfirstterm = plcfirstterm;
	}

	public String getPlcsecond() {
		return plcsecond;
	}

	public void setPlcsecond(String plcsecond) {
		this.plcsecond = plcsecond;
	}

	public String getPlcsecondterm() {
		return plcsecondterm;
	}

	public void setPlcsecondterm(String plcsecondterm) {
		this.plcsecondterm = plcsecondterm;
	}

	public String getPlcthird() {
		return plcthird;
	}

	public void setPlcthird(String plcthird) {
		this.plcthird = plcthird;
	}

	public String getPlcthirdterm() {
		return plcthirdterm;
	}

	public void setPlcthirdterm(String plcthirdterm) {
		this.plcthirdterm = plcthirdterm;
	}

	public String getPlcfourth() {
		return plcfourth;
	}

	public void setPlcfourth(String plcfourth) {
		this.plcfourth = plcfourth;
	}

	public String getPlcfourthterm() {
		return plcfourthterm;
	}

	public void setPlcfourthterm(String plcfourthterm) {
		this.plcfourthterm = plcfourthterm;
	}

	public String getPlcfifth() {
		return plcfifth;
	}

	public void setPlcfifth(String plcfifth) {
		this.plcfifth = plcfifth;
	}

	public String getPlcfifthterm() {
		return plcfifthterm;
	}

	public void setPlcfifthterm(String plcfifthterm) {
		this.plcfifthterm = plcfifthterm;
	}

	public Integer getPlcplid() {
		return plcplid;
	}

	public void setPlcplid(Integer plcplid) {
		this.plcplid = plcplid;
	}

	public String getPlbplcsum() {
		return plbplcsum;
	}

	public void setPlbplcsum(String plbplcsum) {
		this.plbplcsum = plbplcsum;
	}

	public String getPlbfirst() {
		return plbfirst;
	}

	public void setPlbfirst(String plbfirst) {
		this.plbfirst = plbfirst;
	}

	public String getPlbsecond() {
		return plbsecond;
	}

	public void setPlbsecond(String plbsecond) {
		this.plbsecond = plbsecond;
	}

	public String getPlbthird() {
		return plbthird;
	}

	public void setPlbthird(String plbthird) {
		this.plbthird = plbthird;
	}

	public String getPlbfourth() {
		return plbfourth;
	}

	public void setPlbfourth(String plbfourth) {
		this.plbfourth = plbfourth;
	}

	public String getPlbfifth() {
		return plbfifth;
	}

	public void setPlbfifth(String plbfifth) {
		this.plbfifth = plbfifth;
	}

	public Integer getPlbplid() {
		return plbplid;
	}

	public void setPlbplid(Integer plbplid) {
		this.plbplid = plbplid;
	}

	public String getPlbsum() {
		return plbsum;
	}

	public void setPlbsum(String plbsum) {
		this.plbsum = plbsum;
	}

	public String getPlbscale() {
		return plbscale;
	}

	public void setPlbscale(String plbscale) {
		this.plbscale = plbscale;
	}

	public String getPlbnotsum() {
		return plbnotsum;
	}

	public void setPlbnotsum(String plbnotsum) {
		this.plbnotsum = plbnotsum;
	}

	public String getPlbnotscale() {
		return plbnotscale;
	}

	public void setPlbnotscale(String plbnotscale) {
		this.plbnotscale = plbnotscale;
	}
	
    /**
     * ��־����ȡ��
     * 
     * @return pltype
     */
	public String getPltype() {
		return pltype;
	}
	
	/**
     * ��־�����趨
     * 
     * @param pltype
     */
	public void setPltype(String pltype) {
		this.pltype = pltype;
	}
	
	public String getPlusername() {
		return plusername;
	}

	public void setPlusername(String plusername) {
		this.plusername = plusername;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setPlid(Integer plid) {
		this.plid = plid;
	}
	
	public String getSiattkey() {
		return siattkey;
	}
	
	public String getPltime() {
		return pltime;
	}

	public void setPltime(String pltime) {
		this.pltime = pltime;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}

	public void setPopentime(String popentime) {
		this.popentime = popentime;
	}

	public void setPclosetime(String pclosetime) {
		this.pclosetime = pclosetime;
	}

	public void setSiattkey(String siattkey) {
		this.siattkey = siattkey;
	}

	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}

//	public void setFileMap(Map<Integer, FormFile> fileMap) {
//		this.fileMap = fileMap;
//	}
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get( new Integer( index ) );
	}

	/**
	 * ��������
	 *
	 * @param index ������������
	 * @param file ��������
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put( new Integer( index ), file );
	}
	/**
	 * ��־����ȡ��
	 *
	 *@return plinfo
	 */
	public String getPlinfo() {
		return plinfo;
	}
	/**
	 * ��־�����趨
	 *
	 *@param plinfo
	 */
	public void setPlinfo(String plinfo) {
		this.plinfo = plinfo;
	}

	public Integer getPid() {
		return pid;
	}

	public String getPlattkey() {
		return siattkey;
	}
	public Integer getPlid() {
		return plid;
	}
	public Integer getPlroleid() {
		return null;
	}
	public String getPlrolename() {
		return null;
	}
	public String getPluserid() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPclosetime() {
		return pclosetime;
	}

	public String getPcode() {
		return pcode;
	}

	public String getPdesc() {
		return pdesc;
	}

	public String getPinfo() {
		return null;
	}

	public String getPname() {
		return pname;
	}

	public String getPopentime() {
		return popentime;
	}

	public String getPstatus() {
		return pstatus;
	}

	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public String getPorg() {
		return porg;
	}

	public void setPorg(String porg) {
		this.porg = porg;
	}

	public String getProle() {
		return prole;
	}

	public void setProle(String prole) {
		this.prole = prole;
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
	 * ��־ʱ��pltime_fromȡ��
	 * @return pltime_from
	 */
	public String getPltime_from() {
		return pltime_from;
	}
	
	/**
	 * ��־ʱ��pltime_from�趨
	 * @param pltime_from
	 */
	public void setPltime_from(String pltime_from) {
		this.pltime_from = pltime_from;
	}
	
	/**
	 * ��־ʱ��pltime_toȡ��
	 * @return pltime_to
	 */
	public String getPltime_to() {
		return pltime_to;
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
	 * ��־ʱ��pltime_to�趨
	 * @param pltime_to
	 */
	public void setPltime_to(String pltime_to) {
		this.pltime_to = pltime_to;
	}

	public String getPltype_ne() {
		return null;
	}

	public String getBackurl() {
		return backurl;
	}

	public void setBackurl(String backurl) {
		this.backurl = backurl;
	}

	public BudgetTB getBudgetTB() {
		return null;
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

	public String getPplanclosetime() {
		return pplanclosetime;
	}

	public void setPplanclosetime(String pplanclosetime) {
		this.pplanclosetime = pplanclosetime;
	}
	
	/**
	 * �ʱ��𿪷�����Ԥ��ʹ�ö�ȡ��
	 * @return �ʱ��𿪷�����Ԥ��ʹ�ö�
	 */
	public String[] getUse1() {
		return use1;
	}

	/**
	 * �ʱ��𿪷�����Ԥ��ʹ�ö��趨
	 * @param use1 �ʱ��𿪷�����Ԥ��ʹ�ö�
	 */
	public void setUse1(String[] use1) {
		this.use1 = use1;
	}

	/**
	 * �ʱ���Ӳ������Ԥ��ʹ�ö�ȡ��
	 * @return �ʱ���Ӳ������Ԥ��ʹ�ö�
	 */
	public String[] getUse2() {
		return use2;
	}

	/**
	 * �ʱ���Ӳ������Ԥ��ʹ�ö��趨
	 * @param use2 �ʱ���Ӳ������Ԥ��ʹ�ö�
	 */
	public void setUse2(String[] use2) {
		this.use2 = use2;
	}

	/**
	 * �ʱ����������Ԥ��ʹ�ö�ȡ��
	 * @return �ʱ����������Ԥ��ʹ�ö�
	 */
	public String[] getUse3() {
		return use3;
	}

	/**
	 * �ʱ����������Ԥ��ʹ�ö��趨
	 * @param use3 �ʱ����������Ԥ��ʹ�ö�
	 */
	public void setUse3(String[] use3) {
		this.use3 = use3;
	}

	/**
	 * �ʱ��𹤳̵���Ԥ��ʹ�ö�ȡ��
	 * @return �ʱ��𹤳̵���Ԥ��ʹ�ö�
	 */
	public String[] getUse4() {
		return use4;
	}

	/**
	 * �ʱ��𹤳̵���Ԥ��ʹ�ö��趨
	 * @param use4 �ʱ��𹤳̵���Ԥ��ʹ�ö�
	 */
	public void setUse4(String[] use4) {
		this.use4 = use4;
	}

	/**
	 * �ʱ�����������Ԥ��ʹ�ö�ȡ��
	 * @return �ʱ�����������Ԥ��ʹ�ö�
	 */
	public String[] getUse5() {
		return use5;
	}

	/**
	 * �ʱ�����������Ԥ��ʹ�ö��趨
	 * @param use5 �ʱ�����������Ԥ��ʹ�ö�
	 */
	public void setUse5(String[] use5) {
		this.use5 = use5;
	}

	/**
	 * �ɱ���ʵʩ����Ԥ��ʹ�ö�ȡ��
	 * @return �ɱ���ʵʩ����Ԥ��ʹ�ö�
	 */
	public String[] getUse6() {
		return use6;
	}

	/**
	 * �ɱ���ʵʩ����Ԥ��ʹ�ö��趨
	 * @param use6 �ɱ���ʵʩ����Ԥ��ʹ�ö�
	 */
	public void setUse6(String[] use6) {
		this.use6 = use6;
	}

	/**
	 * �ɱ�����������Ԥ��ʹ�ö�ȡ��
	 * @return �ɱ�����������Ԥ��ʹ�ö�
	 */
	public String[] getUse7() {
		return use7;
	}

	/**
	 * �ɱ�����������Ԥ��ʹ�ö��趨
	 * @param use7 �ɱ�����������Ԥ��ʹ�ö�
	 */
	public void setUse7(String[] use7) {
		this.use7 = use7;
	}

	/**
	 * Ԥ����Ŀ��ϵ��IDȡ��
	 * @return Ԥ����Ŀ��ϵ��ID
	 */
	public Integer[] getPbrid() {
		return pbrid;
	}

	/**
	 * Ԥ����Ŀ��ϵ��ID�趨
	 * @param pbrid Ԥ����Ŀ��ϵ��ID
	 */
	public void setPbrid(Integer[] pbrid) {
		this.pbrid = pbrid;
	}

	/**
	 * �ʱ��𿪷�����Ԥ��ʣ���ȡ��
	 * @return �ʱ��𿪷�����Ԥ��ʣ���
	 */
	public String[] getSub1() {
		return sub1;
	}

	/**
	 * �ʱ��𿪷�����Ԥ��ʣ����趨
	 * @param sub1 �ʱ��𿪷�����Ԥ��ʣ���
	 */
	public void setSub1(String[] sub1) {
		this.sub1 = sub1;
	}

	/**
	 * �ʱ���Ӳ������Ԥ��ʣ���ȡ��
	 * @return �ʱ���Ӳ������Ԥ��ʣ���
	 */
	public String[] getSub2() {
		return sub2;
	}

	/**
	 * �ʱ���Ӳ������Ԥ��ʣ����趨
	 * @param sub2 �ʱ���Ӳ������Ԥ��ʣ���
	 */
	public void setSub2(String[] sub2) {
		this.sub2 = sub2;
	}

	/**
	 * �ʱ����������Ԥ��ʣ���ȡ��
	 * @return �ʱ����������Ԥ��ʣ���
	 */
	public String[] getSub3() {
		return sub3;
	}

	/**
	 * �ʱ����������Ԥ��ʣ����趨
	 * @param sub3 �ʱ����������Ԥ��ʣ���
	 */
	public void setSub3(String[] sub3) {
		this.sub3 = sub3;
	}

	/**
	 * �ʱ��𹤳̵���Ԥ��ʣ���ȡ��
	 * @return �ʱ��𹤳̵���Ԥ��ʣ���
	 */
	public String[] getSub4() {
		return sub4;
	}

	/**
	 * �ʱ��𹤳̵���Ԥ��ʣ����趨
	 * @param sub4 �ʱ��𹤳̵���Ԥ��ʣ���
	 */
	public void setSub4(String[] sub4) {
		this.sub4 = sub4;
	}

	/**
	 * �ʱ�����������Ԥ��ʣ���ȡ��
	 * @return �ʱ�����������Ԥ��ʣ���
	 */
	public String[] getSub5() {
		return sub5;
	}

	/**
	 * �ʱ�����������Ԥ��ʣ����趨
	 * @param sub5 �ʱ�����������Ԥ��ʣ���
	 */
	public void setSub5(String[] sub5) {
		this.sub5 = sub5;
	}

	/**
	 * �ɱ���ʵʩ����Ԥ��ʣ���ȡ��
	 * @return �ɱ���ʵʩ����Ԥ��ʣ���
	 */
	public String[] getSub6() {
		return sub6;
	}

	/**
	 * �ɱ���ʵʩ����Ԥ��ʣ����趨
	 * @param sub6 �ɱ���ʵʩ����Ԥ��ʣ���
	 */
	public void setSub6(String[] sub6) {
		this.sub6 = sub6;
	}

	/**
	 * �ɱ�����������Ԥ��ʣ���ȡ��
	 * @return �ɱ�����������Ԥ��ʣ���
	 */
	public String[] getSub7() {
		return sub7;
	}

	/**
	 * �ɱ�����������Ԥ��ʣ����趨
	 * @param sub7 �ɱ�����������Ԥ��ʣ���
	 */
	public void setSub7(String[] sub7) {
		this.sub7 = sub7;
	}

	/**
	 * Ԥ����ȡ��
	 * @return Ԥ����
	 */
	public String[] getBtitle() {
		return btitle;
	}

	/**
	 * Ԥ�����趨
	 * @param btitle Ԥ����
	 */
	public void setBtitle(String[] btitle) {
		this.btitle = btitle;
	}

	/**
	 * ��ͬ���ȡ��
	 * @return ��ͬ���
	 */
	public String getPlcnumber() {
		return plcnumber;
	}

	/**
	 * ��ͬ����趨
	 * @param plcnumber ��ͬ���
	 */
	public void setPlcnumber(String plcnumber) {
		this.plcnumber = plcnumber;
	}

	public Double getPzdevelop() {
		// TODO Auto-generated method stub
		return null;
	}

	public Double getPzhardware() {
		// TODO Auto-generated method stub
		return null;
	}

	public Double getPzsoftware() {
		// TODO Auto-generated method stub
		return null;
	}

	public Double getPzproject() {
		// TODO Auto-generated method stub
		return null;
	}

	public Double getPzelse() {
		// TODO Auto-generated method stub
		return null;
	}

	public Double getPcimplement() {
		// TODO Auto-generated method stub
		return null;
	}

	public Double getPcelse() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPlcid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpquality() {
		// TODO Auto-generated method stub
		return null;
	}

}
