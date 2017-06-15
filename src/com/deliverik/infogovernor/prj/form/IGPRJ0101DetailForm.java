/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
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
	/** 附件数据 */
	protected Map<Integer, FormFile> fileMap = new HashMap<Integer, FormFile>();
	
	/** projectId */
	protected Integer pid;//FK
	
	/** projectLogId */
	protected Integer plid;//ID
	
	/** projectLog Info */
	protected String plinfo;
	
	/** 附件的Key */
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
	/**日志时间用于查看历史页面的模糊查询*/
	protected String pltime_from;
	/**日志时间用于查看历史页面的模糊查询*/
	protected String pltime_to;
	/**projectLog type*/
	protected String pltype;
	protected String porg;
	protected String prole;
	protected String puser;
	/** 项目预算，对应预算表中的预算名称*/
	protected String pamount;
	
	/** 项目用途*/
	protected String ppurpose;
	
	/** 项目预算用途*/
	protected String puse;
	
	/** 项目预算额度*/
	protected Double plimit;
	
	/** 需求部门*/
	protected String pbranch;
	
	/** 预算主表ID*/
	protected Integer pbid;
	
	/** 使用预算*/
	protected String isUseBudget;
	
	/** 项目目的*/
	protected String paim;
	
	//项目日志合同表
	/**合同金额*/
	protected String plcsum;
	/**合同付款条件*/
	protected String plcsumterm;
	/**一期付款金额*/
	protected String plcfirst;
	/**一期付款条件*/
	protected String plcfirstterm;
	/**二期付款金额*/
	protected String plcsecond;
	/**二期付款条件*/
	protected String plcsecondterm;
	/**三期付款金额*/
	protected String plcthird;
	/**三期付款条件*/
	protected String plcthirdterm;
	/**四期付款金额*/
	protected String plcfourth;
	/**四期付款条件*/
	protected String plcfourthterm;
	/**五期付款金额*/
	protected String plcfifth;
	/**五期付款条件*/
	protected String plcfifthterm;
	/**对应项目日志id*/
	protected Integer plcplid;
	//项目日志付款表
	/**合同总额*/
	protected String plbplcsum;
	/**一期付款金额*/
	protected String plbfirst;
	/**二期付款金额*/
	protected String plbsecond;
	/**三期付款金额*/
	protected String plbthird;
	/**四期付款金额*/
	protected String plbfourth;
	/**五期付款金额*/
	protected String plbfifth;
	/**对应项目id*/
	protected Integer plbplid;
	/**已付款总额*/
	protected String plbsum;
	/**已付款比例*/
	protected String plbscale;
	/**未付款总额*/
	protected String plbnotsum;
	/**未付款比例*/
	protected String plbnotscale;
	/** 合同编号*/
	protected String plcnumber;
	/**返回按钮路径*/
	protected String backurl;
	/**项目计划时间*/
	protected String pplanclosetime;
	
	/** 资本金开发单笔预算使用额*/
	protected String[] use1;

	/** 资本金硬件单笔预算使用额*/
	protected String[] use2;

	/** 资本金软件单笔预算使用额*/
	protected String[] use3;
	
	/** 资本金工程单笔预算使用额*/
	protected String[] use4;
	
	/** 资本金其他单笔预算使用额*/
	protected String[] use5;

	/** 成本金实施单笔预算使用额*/
	protected String[] use6;
	
	/** 成本金其他单笔预算使用额*/
	protected String[] use7;
	

	/** 资本金开发单笔预算剩余额*/
	protected String[] sub1;

	/** 资本金硬件单笔预算剩余额*/
	protected String[] sub2;

	/** 资本金软件单笔预算剩余额*/
	protected String[] sub3;
	
	/** 资本金工程单笔预算剩余额*/
	protected String[] sub4;
	
	/** 资本金其他单笔预算剩余额*/
	protected String[] sub5;

	/** 成本金实施单笔预算剩余额*/
	protected String[] sub6;
	
	/** 成本金其他单笔预算剩余额*/
	protected String[] sub7;
	
	/** 预算名*/
	protected String[] btitle;
	
	/**预算及工程分类信息视图数据集合数量*/
	protected int pbsummaryListSize;
	
	
	/**
	 * 预算及工程分类信息视图数据集合数量取得
	 * @return 预算及工程分类信息视图数据集合数量
	 */
	public int getPbsummaryListSize() {
		return pbsummaryListSize;
	}

	/**
	 * 预算及工程分类信息视图数据集合数量设定
	 * @param pbsummaryListSize 预算及工程分类信息视图数据集合数量
	 */
	public void setPbsummaryListSize(int pbsummaryListSize) {
		this.pbsummaryListSize = pbsummaryListSize;
	}

	/** 预算项目关系表ID*/
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
     * 日志类型取得
     * 
     * @return pltype
     */
	public String getPltype() {
		return pltype;
	}
	
	/**
     * 日志类型设定
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
	 * 附件数据取得
	 * @return 附件数据
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get( new Integer( index ) );
	}

	/**
	 * 附件数据
	 *
	 * @param index 附件数组索引
	 * @param file 附件数据
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put( new Integer( index ), file );
	}
	/**
	 * 日志内容取得
	 *
	 *@return plinfo
	 */
	public String getPlinfo() {
		return plinfo;
	}
	/**
	 * 日志内容设定
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
	 * 日志时间pltime_from取得
	 * @return pltime_from
	 */
	public String getPltime_from() {
		return pltime_from;
	}
	
	/**
	 * 日志时间pltime_from设定
	 * @param pltime_from
	 */
	public void setPltime_from(String pltime_from) {
		this.pltime_from = pltime_from;
	}
	
	/**
	 * 日志时间pltime_to取得
	 * @return pltime_to
	 */
	public String getPltime_to() {
		return pltime_to;
	}
	
	/**
	 * 获取项目用途
	 * @return fppurpose 项目用途
	 */
	public String getPpurpose() {
		return ppurpose;
	}

	/**
	 * 设置项目用途
	 * @param ppurpose  项目用途
	 */
	public void setPpurpose(String ppurpose) {
		this.ppurpose = ppurpose;
	}

	/**
	 * 日志时间pltime_to设定
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
	 * 获取使用预算
	 * @return fisUseBudget 使用预算
	 */
	public String getIsUseBudget() {
		return isUseBudget;
	}

	/**
	 * 设置使用预算
	 * @param isUseBudget  使用预算
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
	 * 资本金开发单笔预算使用额取得
	 * @return 资本金开发单笔预算使用额
	 */
	public String[] getUse1() {
		return use1;
	}

	/**
	 * 资本金开发单笔预算使用额设定
	 * @param use1 资本金开发单笔预算使用额
	 */
	public void setUse1(String[] use1) {
		this.use1 = use1;
	}

	/**
	 * 资本金硬件单笔预算使用额取得
	 * @return 资本金硬件单笔预算使用额
	 */
	public String[] getUse2() {
		return use2;
	}

	/**
	 * 资本金硬件单笔预算使用额设定
	 * @param use2 资本金硬件单笔预算使用额
	 */
	public void setUse2(String[] use2) {
		this.use2 = use2;
	}

	/**
	 * 资本金软件单笔预算使用额取得
	 * @return 资本金软件单笔预算使用额
	 */
	public String[] getUse3() {
		return use3;
	}

	/**
	 * 资本金软件单笔预算使用额设定
	 * @param use3 资本金软件单笔预算使用额
	 */
	public void setUse3(String[] use3) {
		this.use3 = use3;
	}

	/**
	 * 资本金工程单笔预算使用额取得
	 * @return 资本金工程单笔预算使用额
	 */
	public String[] getUse4() {
		return use4;
	}

	/**
	 * 资本金工程单笔预算使用额设定
	 * @param use4 资本金工程单笔预算使用额
	 */
	public void setUse4(String[] use4) {
		this.use4 = use4;
	}

	/**
	 * 资本金其他单笔预算使用额取得
	 * @return 资本金其他单笔预算使用额
	 */
	public String[] getUse5() {
		return use5;
	}

	/**
	 * 资本金其他单笔预算使用额设定
	 * @param use5 资本金其他单笔预算使用额
	 */
	public void setUse5(String[] use5) {
		this.use5 = use5;
	}

	/**
	 * 成本金实施单笔预算使用额取得
	 * @return 成本金实施单笔预算使用额
	 */
	public String[] getUse6() {
		return use6;
	}

	/**
	 * 成本金实施单笔预算使用额设定
	 * @param use6 成本金实施单笔预算使用额
	 */
	public void setUse6(String[] use6) {
		this.use6 = use6;
	}

	/**
	 * 成本金其他单笔预算使用额取得
	 * @return 成本金其他单笔预算使用额
	 */
	public String[] getUse7() {
		return use7;
	}

	/**
	 * 成本金其他单笔预算使用额设定
	 * @param use7 成本金其他单笔预算使用额
	 */
	public void setUse7(String[] use7) {
		this.use7 = use7;
	}

	/**
	 * 预算项目关系表ID取得
	 * @return 预算项目关系表ID
	 */
	public Integer[] getPbrid() {
		return pbrid;
	}

	/**
	 * 预算项目关系表ID设定
	 * @param pbrid 预算项目关系表ID
	 */
	public void setPbrid(Integer[] pbrid) {
		this.pbrid = pbrid;
	}

	/**
	 * 资本金开发单笔预算剩余额取得
	 * @return 资本金开发单笔预算剩余额
	 */
	public String[] getSub1() {
		return sub1;
	}

	/**
	 * 资本金开发单笔预算剩余额设定
	 * @param sub1 资本金开发单笔预算剩余额
	 */
	public void setSub1(String[] sub1) {
		this.sub1 = sub1;
	}

	/**
	 * 资本金硬件单笔预算剩余额取得
	 * @return 资本金硬件单笔预算剩余额
	 */
	public String[] getSub2() {
		return sub2;
	}

	/**
	 * 资本金硬件单笔预算剩余额设定
	 * @param sub2 资本金硬件单笔预算剩余额
	 */
	public void setSub2(String[] sub2) {
		this.sub2 = sub2;
	}

	/**
	 * 资本金软件单笔预算剩余额取得
	 * @return 资本金软件单笔预算剩余额
	 */
	public String[] getSub3() {
		return sub3;
	}

	/**
	 * 资本金软件单笔预算剩余额设定
	 * @param sub3 资本金软件单笔预算剩余额
	 */
	public void setSub3(String[] sub3) {
		this.sub3 = sub3;
	}

	/**
	 * 资本金工程单笔预算剩余额取得
	 * @return 资本金工程单笔预算剩余额
	 */
	public String[] getSub4() {
		return sub4;
	}

	/**
	 * 资本金工程单笔预算剩余额设定
	 * @param sub4 资本金工程单笔预算剩余额
	 */
	public void setSub4(String[] sub4) {
		this.sub4 = sub4;
	}

	/**
	 * 资本金其他单笔预算剩余额取得
	 * @return 资本金其他单笔预算剩余额
	 */
	public String[] getSub5() {
		return sub5;
	}

	/**
	 * 资本金其他单笔预算剩余额设定
	 * @param sub5 资本金其他单笔预算剩余额
	 */
	public void setSub5(String[] sub5) {
		this.sub5 = sub5;
	}

	/**
	 * 成本金实施单笔预算剩余额取得
	 * @return 成本金实施单笔预算剩余额
	 */
	public String[] getSub6() {
		return sub6;
	}

	/**
	 * 成本金实施单笔预算剩余额设定
	 * @param sub6 成本金实施单笔预算剩余额
	 */
	public void setSub6(String[] sub6) {
		this.sub6 = sub6;
	}

	/**
	 * 成本金其他单笔预算剩余额取得
	 * @return 成本金其他单笔预算剩余额
	 */
	public String[] getSub7() {
		return sub7;
	}

	/**
	 * 成本金其他单笔预算剩余额设定
	 * @param sub7 成本金其他单笔预算剩余额
	 */
	public void setSub7(String[] sub7) {
		this.sub7 = sub7;
	}

	/**
	 * 预算名取得
	 * @return 预算名
	 */
	public String[] getBtitle() {
		return btitle;
	}

	/**
	 * 预算名设定
	 * @param btitle 预算名
	 */
	public void setBtitle(String[] btitle) {
		this.btitle = btitle;
	}

	/**
	 * 合同编号取得
	 * @return 合同编号
	 */
	public String getPlcnumber() {
		return plcnumber;
	}

	/**
	 * 合同编号设定
	 * @param plcnumber 合同编号
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
